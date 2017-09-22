package com.wangcc.ssm.frame.aspect.aop;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.UUID;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSON;
import com.wangcc.ssm.frame.aspect.annotation.MyLog;
import com.wangcc.ssm.frame.aspect.service.SysLogService;
import com.wangcc.ssm.frame.entity.SysLog;
import com.wangcc.ssm.util.ClassLoaderWrapper;

//@Aspect
@Component
public class SysLogAspect {
	private static Logger logger = LoggerFactory.getLogger(SysLogAspect.class);
	@Autowired
	private SysLogService sysLogService;
	private static ClassLoaderWrapper classLoaderWrapper = new ClassLoaderWrapper();

	/*
	 * 1、execution(): 表达式主体。
	 * 
	 * 2、第一个*号：表示返回类型，*号表示所有的类型。
	 * 
	 * 3、包名：表示需要拦截的包名，后面的两个句点表示当前包和当前包的所有子包，com.sample.service.impl包、子孙包下所有类的方法。
	 * 
	 * 4、第二个*号：表示类名，*号表示所有的类。
	 * 
	 * 5、*(..):最后这个星号表示方法名，*号表示所有的方法，后面括弧里面表示方法的参数，两个句点表示任何参数。
	 */
	@Pointcut("execution  (* com.wangcc.ssm.service.*.*(..)) ")
	public void serviceAspect() {
	}

	@Before("serviceAspect()")
	public void doBefore(JoinPoint joinPoint) {
		logger.info("==========执行service前置通知===============");
		if (logger.isInfoEnabled()) {
			logger.info("before " + joinPoint);
		}
	}

	@Around("serviceAspect()")
	public void around(JoinPoint joinPoint) {
		logger.info("==========开始执行service环绕通知===============");
		long start = System.currentTimeMillis();
		try {
			((ProceedingJoinPoint) joinPoint).proceed();
			long end = System.currentTimeMillis();
			if (logger.isInfoEnabled()) {
				logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms!");
			}
			System.out.println("==========结束执行controller环绕通知===============");
		} catch (Throwable e) {
			long end = System.currentTimeMillis();
			if (logger.isInfoEnabled()) {
				logger.info("around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : "
						+ e.getMessage());
			}
		}
	}

	@After("serviceAspect()")
	public void after(JoinPoint joinPoint) {

		// 通过RequestContextHolder来获取request，怎么获取的呢
		// http://blog.csdn.net/zzy7075/article/details/53559902
		// // HttpServletRequest request =
		// RequestContextHolder.getRequestAttributes().getRequest();
		// RequestAttributes requestAttributes =
		// RequestContextHolder.currentRequestAttributes();
		//// RequestContextHolder.getRequestAttributes();
		// HttpServletRequest request =
		// ((ServletRequestAttributes)requestAttributes).getRequest();
		// //从session里面获取对应的值
		// HttpSession session = request.getSession();
		// String str = (String)
		// requestAttributes.getAttribute("name",RequestAttributes.SCOPE_SESSION);
		// AOP通过动态代理,将实际要执行的方法的相关信息封装到JoinPoint对象中
		// 通过InvocationHandler中的invoke(Object proxy, Method method, Object[] args)
		// 在InvocationHandler中我们有实际业务对象，通过这个实际对象，我们就可以得到target相关信息
		// method，不用说，可以得到Method相关对象

		// 使用loadClass比较干净，知识得到Class对象，没有进行初始化工作，比Class.forName()好
		try {
			// args也不用说 最后一个参数 Object[] args
			String methodName = joinPoint.getSignature().getName();
			String targetName = joinPoint.getTarget().getClass().getName();
			Object[] arguments = joinPoint.getArgs();
			Class clazz = classLoaderWrapper.loadClass(targetName);
			Method[] methods = clazz.getMethods();
			String operationType = "";
			String operationName = "";
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					// 这里还没有考虑参数类型不同，但是参数个数相同的情况
					Class[] clazzs = method.getParameterTypes();
					if (clazzs.length == arguments.length) {
						operationType = method.getAnnotation(MyLog.class).operationType();
						operationName = method.getAnnotation(MyLog.class).operationName();
						break;
					}
				}
			}
			SysLog log = new SysLog();
			String ip = "";
			log.setId(UUID.randomUUID().toString());
			log.setDescription(operationName);
			log.setMethod((joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")
					+ "." + operationType);
			log.setLogType(operationType);
			log.setRequestIp(ip);
			log.setExceptionCode(null);
			log.setExceptionDetail(null);
			log.setParams(null);
			// 项目中应该是只有IP记录
			log.setCreateBy("");
			log.setCreateDate(new Date());
			// 保存数据库
			sysLogService.insertLog(log);
			System.out.println("=====service后置通知结束=====");
		} catch (Exception e) {

			logger.error("==后置通知异常==");
			logger.error("异常信息:{}", e);
		}

	}

	// 配置后置返回通知,使用在方法aspect()上注册的切入点
	@AfterReturning("serviceAspect()")
	public void afterReturn(JoinPoint joinPoint) {
		logger.info("=====执行service后置返回通知=====");
		if (logger.isInfoEnabled()) {
			logger.info("afterReturn " + joinPoint);
		}
	}

	/**
	 * 异常通知 用于拦截记录异常日志
	 * 
	 * @param joinPoint
	 * @param e
	 */
	@AfterThrowing(pointcut = "serviceAspect()", throwing = "e")
	public void doAfterThrowing(JoinPoint joinPoint, Throwable e) {
		/*
		 * HttpServletRequest request = ((ServletRequestAttributes)
		 * RequestContextHolder.getRequestAttributes()).getRequest(); HttpSession
		 * session = request.getSession(); //读取session中的用户 User user = (User)
		 * session.getAttribute(WebConstants.CURRENT_USER); //获取请求ip String ip =
		 * request.getRemoteAddr();
		 */
		// 获取用户请求方法的参数并序列化为JSON格式字符串

		// User user = new User();
		// user.setId(1);
		// user.setName("张三");
		String ip = "127.0.0.1";

		String params = "";
		if (joinPoint.getArgs() != null && joinPoint.getArgs().length > 0) {
			for (int i = 0; i < joinPoint.getArgs().length; i++) {
				params += JSON.toJSONString(joinPoint.getArgs()[i]) + ";";
			}
		}
		try {

			String targetName = joinPoint.getTarget().getClass().getName();
			String methodName = joinPoint.getSignature().getName();
			Object[] arguments = joinPoint.getArgs();
			Class targetClass = Class.forName(targetName);
			Method[] methods = targetClass.getMethods();
			String operationType = "";
			String operationName = "";
			for (Method method : methods) {
				if (method.getName().equals(methodName)) {
					Class[] clazzs = method.getParameterTypes();
					if (clazzs.length == arguments.length) {
						operationType = method.getAnnotation(MyLog.class).operationType();
						operationName = method.getAnnotation(MyLog.class).operationName();
						break;
					}
				}
			}
			/* ========控制台输出========= */
			System.out.println("=====异常通知开始=====");
			System.out.println("异常代码:" + e.getClass().getName());
			System.out.println("异常信息:" + e.getMessage());
			System.out.println("异常方法:"
					+ (joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()")
					+ "." + operationType);
			System.out.println("方法描述:" + operationName);
			System.out.println("请求人:" + "");
			System.out.println("请求IP:" + ip);
			System.out.println("请求参数:" + params);
			/* ==========数据库日志========= */
			SysLog log = new SysLog();
			log.setId(UUID.randomUUID().toString());
			log.setDescription(operationName);
			log.setExceptionCode(e.getClass().getName());
			log.setLogType(operationType);

			log.setExceptionDetail(e.getMessage());
			log.setMethod(
					(joinPoint.getTarget().getClass().getName() + "." + joinPoint.getSignature().getName() + "()"));
			log.setParams(params);
			log.setCreateBy("");
			log.setCreateDate(new Date());
			log.setRequestIp(ip);
			// 保存数据库
			sysLogService.insertLog(log);
			System.out.println("=====异常通知结束=====");
		} catch (Exception ex) {
			// 记录本地异常日志
			logger.error("==异常通知异常==");
			logger.error("异常信息:{}", ex);
		}
		/* ==========记录本地异常日志========== */
		logger.error("异常方法:{}异常代码:{}异常信息:{}参数:{}",
				joinPoint.getTarget().getClass().getName() + joinPoint.getSignature().getName(), e.getClass().getName(),
				e.getMessage(), params);

	}
}
