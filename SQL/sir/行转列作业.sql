select * from tb_student;
select * from tb_course;
select * from tb_score;


--
select * from tb_student ts ,tb_course tc;

select * from tb_student ts cross join tb_course tc;

select tsc.stuname,tsc.crsname,ts1.score from (
select  ts.id stuid,ts.no stuno,ts.name stuname,tc.id crsid, tc.name crsname from tb_student ts cross join tb_course tc
) tsc left  join tb_score ts1 on tsc.stuid=ts1.stuid and tsc.crsid=ts1.couid;

--换转列  decode,case when
select tsc2.stuname,
sum(decode(tsc2.crsname,'javase',tsc2.score,0)) javase,
sum(decode(tsc2.crsname,'oracle',tsc2.score,0)) oracle,
sum(decode(tsc2.crsname,'html',tsc2.score,0)) html
 from
(
  select tsc.stuname,tsc.crsname,ts1.score from (
  select  ts.id stuid,ts.no stuno,ts.name stuname,tc.id crsid, tc.name crsname from tb_student ts cross join tb_course tc
  ) tsc left  join tb_score ts1 on tsc.stuid=ts1.stuid and tsc.crsid=ts1.couid
)tsc2 group by tsc2.stuname;

create or replace view v$_tsc as
 select tsc.stuname,tsc.crsname,ts1.score from (
  select  ts.id stuid,ts.no stuno,ts.name stuname,tc.id crsid, tc.name crsname from tb_student ts cross join tb_course tc
  ) tsc left  join tb_score ts1 on tsc.stuid=ts1.stuid and tsc.crsid=ts1.couid

select * from v$_tsc;


select tsc2.stuname,
sum(decode(tsc2.crsname,'javase',tsc2.score,0)) javase,
sum(decode(tsc2.crsname,'oracle',tsc2.score,0)) oracle,
sum(decode(tsc2.crsname,'html',tsc2.score,0)) html
 from v$_tsc tsc2 group by tsc2.stuname;
 
 
--存储过程
--思路：将上面的行转列语句拼接

--利用匿名块实现
declare 
 v_sql varchar2(5000):= 'select tsc2.stuname,';
 v_temp varchar2(300);          --用来拼接select语句中会变化的那一部分，如：sum(decode(tsc2.crsname,'javase',tsc2.score,0)) javase,
 cursor cur_course is select * from tb_course;--利用游标来获取课程表 表的行类型
 --cursor cur_course is select distinct name from tb_course; --也可以写成这样

begin
 for v_cour in cur_course loop   --在for循环中，c_cour 可以不应定义
   v_temp :=v_temp || 'sum(decode(tsc2.crsname,'''||v_cour.name||''',tsc2.score,0)) '||v_cour.name||',';
   end loop;
   dbms_output.put_line(v_temp);--打印一下看看拼接成什么样子了，最后发现在末尾多了一个逗号，接下来删除（截取字符串）
   v_temp := substr(v_temp,1,length(v_temp) -1);
   v_sql := v_sql || v_temp || ' from v$_tsc tsc2 group by tsc2.stuname;' ;
   dbms_output.put_line(v_sql);--打印看看最终结果拼对了没有
   
end;
--最终拼接结果
select tsc2.stuname,sum(decode(tsc2.crsname,'javase',tsc2.score,0)) javase,sum(decode(tsc2.crsname,'oracle',tsc2.score,0)) oracle,sum(decode(tsc2.crsname,'html',tsc2.score,0)) html from v$_tsc tsc2 group by tsc2.stuname;

--将上面的匿名块写成存储过程
create or replace procedure rowtocol(sc_cur out sys_refcursor) is
   v_sql varchar2(5000):= 'select tsc2.stuname,';
   v_temp varchar2(300);          --用来拼接select语句中会变化的那一部分，如：sum(decode(tsc2.crsname,'javase',tsc2.score,0)) javase,
   cursor cur_course is select * from tb_course;--利用游标来获取课程表 表的行类型
   --cursor cur_course is select distinct name from tb_course; --也可以写成这样

begin
      for v_cour in cur_course loop   --在for循环中，c_cour 可以不应定义
         v_temp :=v_temp || 'sum(decode(tsc2.crsname,'''||v_cour.name||''',tsc2.score,0)) '||v_cour.name||',';
         end loop;
         dbms_output.put_line(v_temp);--打印一下看看拼接成什么样子了，最后发现在末尾多了一个逗号，接下来删除（截取字符串）
         v_temp := substr(v_temp,1,length(v_temp) -1);
         v_sql := v_sql || v_temp || ' from v$_tsc tsc2 group by tsc2.stuname';
         dbms_output.put_line(v_sql);--打印看看最终结果拼对了没有
         
         open sc_cur for v_sql;--打开游标
   
end;

declare
  sys_cursor sys_refcursor;
begin
  rowtocol(sys_cursor);
end;

select tsc2.stuname,
       sum(decode(tsc2.crsname, 'javase', tsc2.score, 0)) javase,
       sum(decode(tsc2.crsname, 'oracle', tsc2.score, 0)) oracle,
       sum(decode(tsc2.crsname, 'html', tsc2.score, 0)) html
  from v$_tsc tsc2
 group by tsc2.stuname;
