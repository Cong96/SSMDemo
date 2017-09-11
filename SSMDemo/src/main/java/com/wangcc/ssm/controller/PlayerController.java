package com.wangcc.ssm.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.wangcc.ssm.entity.Player;
import com.wangcc.ssm.service.PlayerService;

@Controller
public class PlayerController {
	@Autowired
	private PlayerService playerService;
	@RequestMapping("/player")
	public ModelAndView getPlayer(@RequestParam Integer id) {
		ModelAndView mv=new ModelAndView();
		Player player=playerService.selectById(id);
		mv.addObject(player);
		mv.setViewName("hello");
		return mv;
	}
	
}
