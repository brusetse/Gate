-- || 字符串连接

select 'hi' || 'girl ' from dual;
select concat('hi','girl') from dual;

select initcap('aaaaabbb') from dual;

select lower(e.ename)  from emp e;
select concat(e.ename,e.job)  from emp e;


select lpad('test',10,'*') from dual;
select rpad('test',10,'*') from dual;


select trim('i' from trim('h' from 'hitesthi')) from dual;
select rtrim('testtest','t') from dual;
select substr('abcde',1,3) from dual;

select instr('test','e') from dual;

select length(e.ename) from emp e;

--查看当前时间日期

select  sysdate from dual;

select  current_date from dual;
--????
select  to_char(current_timestamp,'yyyy-mm-dd') from dual;




select round(888.999) from dual;

select round(888.666,2) from dual;
select round(888.666,-2) from dual;
select trunc(888.666,-2) from dual;

select mod(13,5) from dual;

select ceil(19.2) from dual;
select floor(3.1) from dual;


select add_months(sysdate,1) from dual;

select sysdate-e.hiredate  from emp e;

--员工工作年限

select round((sysdate-e.hiredate)/365),e.ename  from emp e where round((sysdate-e.hiredate)/365)>25;
--2012-6-9 
select last_day

select sysdate,last_day(sysdate)  hz from dual;

select sysdate,last_day(to_date('2012-02-09','yyyy-mm-dd'))  hz from dual;


--to_date

select to_date('20080808','yyyymmdd') from dual;

select to_date('2008/08/08 09:10:58','yyyy/mm/dd hh24:mi:ss') from dual;


select round(months_between(sysdate,e.hiredate)/12) from emp e;

--to_char  当前使用 2016-8-30 11:44:58

select to_char(sysdate,'yyyy/mm/dd hh12:mi:ss') from dual;

select to_char(234.82736422,'99999.99') from dual;
select to_char(234.82736422,'000000.00') from dual;

--控制符必须和数字字符长度一样
select to_number('$23.2332423','$00.0000000') from dual;

select * from emp;


select e.ename, nvl(to_char(e.mgr),'boss') from emp e where e.mgr is null;
select e.ename, nvl2(to_char(e.mgr),'屌丝','高富帅') from emp e ;

--为所有人长工资，标准是：10部门长10%；20部门长15%；30部门长20%其他部门长18%

select decode(e.deptno,
              10,
              e.sal * 1.1,
              20,
              e.sal * 1.15,
              30,
              e.sal * 1.2,
              e.sal * 1.18),e.ename,e.empno,e.sal,e.deptno
  from emp e;
  
  --  500-1500  真屌丝
  --1500-2000  屌丝
  --2000-2500  精英
  --2000以上 土豪

select case 
when e.sal > 500 and e.sal < 1500 then '真屌丝' 
when e.sal >= 1500 and e.sal < 2000 then '好屌丝'
when e.sal >= 2000 and e.sal < 2500 then '好经纪人'
  else '土豪' end "身份",e.ename,e.sal
  from emp e;
  
  
/*  
  1、查询82年员工
2、查询32年工龄的人员
3、显示员工雇佣期 6 个月后下一个星期一的日期
4、找没有上级的员工，把mgr的字段信息输出为 "boss"
5、为所有人长工资，标准是：10部门长10%；20部门长15%；30部门长20%其他部门长18%

*/

select e.* from emp e where to_char(e.hiredate,'yyyy')='1982';
select e.* from emp e where to_char(e.hiredate,'yy')  like '82'

--显示员工雇佣期 6 个月后下一个星期一的日期

select add_months(e.hiredate,6) from emp e;
select next_day(add_months(e.hiredate,6),'星期一') from emp e;
select next_day(add_months(e.hiredate,6),2) from emp e;

select next_day(sysdate,2)from dual;

--找没有上级的员工，把mgr的字段信息输出为 "boss"

select decode(e.mgr,null,'boss','中国好经纪人') from emp e;

--case when 作业




