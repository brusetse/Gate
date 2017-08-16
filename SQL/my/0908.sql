--隐式游标属性
declare
  v_ename emp3.ename%type;
begin
  select ename into v_ename from emp3 where empno=7900;
  dbms_output.put_line(sql%rowcount);
  if not sql%isopen then
    dbms_output.put_line('隐式游标自动关闭');
  end if;  
  if not sql%found then
    dbms_output.put_line('没有找到数据');
  end if;
  if sql%found then
    dbms_output.put_line('找到数据');
  end if;
end;
--------------------------------------------
--循环updata
declare
  cursor cursor_emp is select * from emp3;
  v_emp emp3%rowtype;
begin
  open cursor_emp;
  loop
  fetch cursor_emp into v_emp;
  if v_emp.sal<2000 then
     update emp3 set sal=sal*2 where empno = v_emp.empno;
  end if;
  dbms_output.put_line(v_emp.ename||'   的薪水是   '||v_emp.sal);
  exit when cursor_emp%notfound;
  end loop;
  close cursor_emp;
end;
-----------------------------------------------
--do while循环
declare
  cursor cursor_emp is select * from emp3;
  v_emp emp3%rowtype;
begin
  open cursor_emp;
  loop
    fetch cursor_emp into v_emp;
    if v_emp.sal>8000 then
      update emp3 set sal=sal*2 where empno = v_emp.empno;
      end if;
    dbms_output.put_line(v_emp.ename||'   的薪水是   '||v_emp.sal);
  exit when cursor_emp%notfound;
  end loop;
  close cursor_emp;  
end;
-----------------------------------------------
--for循环
declare
  cursor cursor_emp is select * from emp3 ;
begin
  for v in cursor_emp loop
    dbms_output.put_line(v.ename||'   的薪水是   '||v.sal);
  end loop;
end;
------------------------------------------------
--带参数游标
declare
  cursor cursor_emp(v_sal emp3.sal%type) is select * from emp3 where sal>v_sal;
begin
  for v in cursor_emp(3500) loop
    dbms_output.put_line(v.ename||'   的薪水是   '||v.sal);
  end loop;
end;
-------------------------------------------------
--参数默认值
declare
  cursor cursor_emp(v_sal emp3.sal%type default 3000) is select * from emp3 where sal>v_sal;
  v_emp emp%rowtype;
begin
  open cursor_emp;
  fetch cursor_emp into v_emp;
  while cursor_emp%found loop
       dbms_output.put_line(v_emp.ename||'   的薪水是   '||v_emp.sal);
       fetch cursor_emp into v_emp;
  end loop;
end;
--------------------------------------------------
--有返回类型游标
declare
  type record_emp_type is record(
       rname emp3.ename%type,
       rdate emp3.hiredate%type
  );
  v_emp record_emp_type;
  cursor cursor_emp return record_emp_type
  is select ename,hiredate from emp3;
begin
  for v in cursor_emp loop
    dbms_output.put_line(v.rname||'   入职时间   '||v.rdate);
  end loop;
end;
---------------------------------------------------
declare
  cursor cursor_emp is select ename,hiredate from emp3;
  v_emp cursor_emp%rowtype;
begin
  open cursor_emp;
  loop 
    fetch cursor_emp into v_emp;
  exit when(cursor_emp%notfound);
    dbms_output.put_line(v_emp.ename||'   入职时间   '||v_emp.hiredate);
  end loop;
end;
----------------------------------------------------
--多种判断
declare
  cursor cursor_emp is select * from emp3 for update;
begin
  for v in cursor_emp loop
    if v.sal<-3 then
      update emp3 set sal=sal*2 where current of cursor_emp;
      end if;
    if v.ename='zhangsan1' then
      delete from emp3 where current of cursor_emp;
      end if;
  end loop;
  commit;
exception  
  when others then
    rollback;
end;
-----------------------------------------------------
--动态游标 ref 
declare
  type my_ref_cursor is ref cursor;
  my_cursor my_ref_cursor;
  v_emp emp%rowtype;
  v_dept dept%rowtype;
  v_sql varchar2(200):='select * from dept';
begin
  open my_cursor for select * from emp;
  fetch my_cursor into v_emp;
  while my_cursor%found loop
    dbms_output.put_line(v_emp.ename);
    fetch my_cursor into v_emp;
  end loop;
  close my_cursor;
  --弱类型游标 支持调用v_sql
  open my_cursor for v_sql;
  fetch my_cursor into v_dept;
  while my_cursor%found loop
    dbms_output.put_line(v_dept.dname);
    fetch my_cursor into v_dept;
  end loop;
  close my_cursor;
end;
-----------------------------------------------------
declare
  type my_ref_cursor is ref cursor return emp%rowtype;
  my_cursor my_ref_cursor;
  v_emp emp%rowtype;
begin
  --open cur_01 for v_sql1;--在强类型游标的时候不支持
  open my_cursor for select * from emp;
  fetch my_cursor into v_emp;
  while my_cursor%found loop
    dbms_output.put_line(v_emp.ename);
    fetch my_cursor into v_emp;
  end loop;
  close my_cursor;
end;
-----------------------------------------------------
--存储过程 输入参数
create or replace procedure addUser(vname in varchar2,vpwd in varchar2) is
  v_sql varchar2(300):='insert into sxt_user(id,username,password) 
  values(seq_id.nextval,'''||vname||''','''||vpwd||''')';
begin
  execute immediate v_sql;
  commit;
end;
-----------------------------------------------------
--测试
declare
v_name varchar2(20):='zhangsan';
v_pwd varchar2(20):='sagj';
begin
  addUser(v_name,v_pwd);
end;
-----------------------------------------------------
--命令窗口执行
exec addUser('gaga01','haha');
--------------------------------------------------------
delete from sxt_user where rowid not in
(select min(rowid) from sxt_user group by username having count(1)>1);
create table emp5 as select * from emp3
------------------------------------------------------
--删除指定表中指定行重复数据
create or replace procedure delRepateData(tablename in varchar2,columnname in varchar2,v_row out number) is
	v_sql varchar2(300):='delete from '||tablename||' where rowid not in
(select min(rowid) from '||tablename||' group by '||columnname||' having count(1)>=1)';
begin
  execute immediate v_sql;
  v_row:=sql%rowcount;
  commit;
end;
-------------------------------------------------------
declare
  v_row number(10);
begin
  delRepateData('sxt_user','username',v_row);
  dbms_output.put_line('删除的行数：'||v_row);
end;
--------------------------------------------------------
--测试函数
create or replace function isDate(v_str varchar2) return number is
  v_result number(1):=0;
  v_date date;
begin
  v_date := to_date(v_str,'yyyy-mm-dd');
  v_result := case when v_date is not null then 1 else 0 end;
  return v_result;
exception  
  when others then
    dbms_output.put_line('有错误');
    return 0;
end;

select isDate('2900-1-28') from dual;
