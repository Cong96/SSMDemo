
---Oracle 目前VARCHAR是VARCHAR2的同义词。工业标准的VARCHAR类型可以存储空字符串，但是oracle不这样做，尽管它保留以后这样做的权利。Oracle自己开发了一个数据类型VARCHAR2，这个类型不是一个标准的VARCHAR，它将在数据库中varchar列可以存储空字符串的特性改为存储NULL值。如果你想有向后兼容的能力，Oracle建议使用VARCHAR2而不是VARCHAR。

-----mysql
create table sys_log(
	log_id varchar(50),
	description varchar(100),
	method varchar(20),
	logtype varchar(50),
	requestip varchar(50),
	execption_code varchar(30),
	exception_detail text,
	params varchar(100),
	create_user varchar(30),

	create_date datetime
);



----datetime Mysql中使用，Oracle中只有Date数据类型，
---它可以存储月，年，日，世纪，时，分和秒。它典型地用来表示什么时候事情已经发生或将要发生。
-----Date数据类型精确到秒