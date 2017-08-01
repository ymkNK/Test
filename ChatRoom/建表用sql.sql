use homework;
drop table chat_user;
create table chat_user(u_name varchar(30) primary key);
drop table chat_log;
create table chat_log(u_name varchar(30),u_time datetime,u_content varchar(120) not null);

delimiter ;;
create procedure insert_user(in uname varchar(30))
begin
	insert into chat_user(u_name) value(uname);
end;;

create procedure insert_log(in uname varchar(30),in utime datetime,in ucontent varchar(120))
begin
	insert into chat_log(u_name,u_time,u_content)value(uname,utime,ucontent);
end;;

create procedure sort_user(in uname varchar(30),out res int)
begin
	select count(*) into res from chat_user where u_name=uname;
end;;

create procedure get_log()
begin
	select * from chat_log order by u_time;
end;;

delimiter ;

call insert_log("asd","2017-10-2 12:23:13","e2323");
call insert_log("sdasd","2017-10-2 12:22:13","e2sa323");
call insert_log("agsd","2017-10-2 12:21:13","e232dsfs3");



select * from chat_user;
select count(*) from chat_user;

delete from chat_user;
call get_log();
select * from chat_user;
select * from chat_log;
delete from chat_log;