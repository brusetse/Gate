--匿名块，作用：开发人员在终端与数据库进行交互
declare
  v_num number(10) := 10 ;
  v_name varchar(20) := '张三';
  v_date date := to_date('1981-9-1','yyyy-mm-dd');
  --常量 
  c_aa constant number(10) := 30;
  --not null声明是必须初始化
  v_cs number(10) not null :=10;
  --行类型
  v_dd emp%rowtype;

begin
  v_num := 20+30;
  v_cs :=40;
  v_dd.ename := '张三';
  v_dd.sal := 100;
  
  dbms_output.put_line('v_num:'||v_num);
  dbms_output.put_line('v_name:'||v_name);
  dbms_output.put_line('v_date:'||v_date);
  dbms_output.put_line('v_cs:'||v_cs);
  dbms_output.put_line('v_dd.ename:'||v_dd.ename);
  dbms_output.put_line('v_dd.sal:'||v_dd.sal);

--exception
  
end;

------------------------------------------
declare
  --table类型 自定义索引
  type v_tb_table is table of emp%rowtype index by binary_integer;
  v_table v_tb_table;
  
  type v_tb_dept is table of dept%rowtype index by binary_integer;
  v_dept v_tb_dept;
  --varray类型
  type varray_type is varray(5) of v_tb_table;
  v_varray_type varray_type;
  
  --record类型
  type record_type is record(
       --数据类型
       emp v_tb_table,
       dept v_tb_dept
  );
  v_record_type record_type;
  
begin
  
  v_table(1).ename:='张三';
  v_dept(1).dname:='dema';
  
  
  v_varray_type := varray_type(v_table);
  v_record_type.emp := v_table;
  v_record_type.dept := v_dept;
  
  dbms_output.put_line(v_table(1).ename);
  dbms_output.put_line(v_varray_type(1)(1).ename);
  dbms_output.put_line(v_record_type.emp(1).ename);
  
end;
-------------------------------------------
declare 
  type my_table_emp is table of emp3%rowtype index by varchar2(10);
  v_table my_table_emp;
  type my_varray_type is varray(5) of emp3%rowtype;
  v_varray my_varray_type;
  type my_record_type is record(
       emp emp3%rowtype
  );
  v_record my_record_type;
begin
  v_table('1').ename:='张三';
  dbms_output.put_line(v_table('1').ename);
  v_varray:=my_varray_type(v_table('1'));
  dbms_output.put_line(v_varray(1).ename);
  v_record.emp:=v_table('1');
  dbms_output.put_line(v_record.emp.ename);
end;
-------------------------------------------
declare
  type my_varray_type is varray(5) of number(10);
  v_varray my_varray_type;
  type my_record_type is record(
       ename varchar2(20),
       sal number(10)
  );
  v_record my_record_type;
  type my_table_type1 is table of my_varray_type index by binary_integer;
  v_table1 my_table_type1;
  type my_table_type2 is table of my_record_type index by binary_integer;
  v_table2 my_table_type2;
begin
  v_varray:=my_varray_type(10,20,30);
  dbms_output.put_line(v_varray(1));
  v_record.ename:='张三';
  v_record.sal:=100;
  dbms_output.put_line(v_record.ename||'的工资是'||v_record.sal);
  v_table1(1):=v_varray;
  v_table2(1):=v_record;
  dbms_output.put_line(v_table1(1)(1));
  dbms_output.put_line(v_table2(1).ename||'的工资是'||v_table2(1).sal);
end;
-------------------------------------------
declare 
  
  type my_table is table of varchar2(100) index by binary_integer;
  v_mt my_table;
  
begin
  
  v_mt(1) := '张三';
  v_mt(2) := '李四';
  v_mt(3) := '王五';
  
  if v_mt.exists(1) then
    dbms_output.put_line('该元素存在');
  end if;  
  --成员数量
  dbms_output.put_line(v_mt.count);
  --第一个成员下标
  dbms_output.put_line(v_mt(v_mt.first));
  --最后一个成员下标
  dbms_output.put_line(v_mt(v_mt.last));
  --前一个成员下标
  dbms_output.put_line(v_mt(v_mt.prior(v_mt.last)));
  --后一个成员下标
  dbms_output.put_line(v_mt(v_mt.next(v_mt.first)));
  

end;
----------------------------------------------------
declare

  --v_ename varchar2(20);
  --v_sal number(10);
  v_ename emp1.ename%type;
  v_sal emp1.sal%type;
  
  v_row emp1%rowtype;

begin
  
  v_sql:=select ename,sal into v_ename,v_sal  from emp1 where empno=&empno;
  execute immediate v_sql
  --dbms_output.put_line(v_ename||'的薪水是：'||v_sal);
  select * into v_row from emp1 where deptno=&deptno;
  dbms_output.put_line(v_row.ename||'的薪水是：'||v_row.sal);

exception
  when No_data_found then
    dbms_output.put_line('没有查询到相应的数据');
  when Too_many_rows then
    dbms_output.put_line('查询行数过多 ');  

end;


DECLARE
   v_empno emp.empno%TYPE :=&empno;
   no_result  EXCEPTION;
BEGIN
   UPDATE emp SET sal = sal+100 WHERE empno = v_empno;
   IF SQL%NOTFOUND THEN
      dbms_output.put_line('testtttttt');
       rollback;
      RAISE no_result;
      else
        commit;
   END IF;
EXCEPTION
   WHEN no_result THEN 
      DBMS_OUTPUT.PUT_LINE('你的数据更新语句失败了!');
   WHEN OTHERS THEN
      DBMS_OUTPUT.PUT_LINE(SQLCODE||'---'||SQLERRM);
END;
---------------------------------------------
declare
  v_empno emp3.empno%type;     
  no_result exception;
begin
  update emp3 set sal = sal+100 where empno=&empno;
  if sql%notfound then
    dbms_output.put_line('salkhdgkal');
    rollback;
    raise no_result;
    else
      commit;
  end if;    
exception
  when no_result then
    dbms_output.put_line('数据更新失败 ');
  when others then
    dbms_output.put_line(SQLCODE||'---'||SQLERRM);
end;

------------------------------------------------
declare
  type v_tb_table is table of emp%rowtype index by binary_integer;
  v_table v_tb_table;
  v_num number(3);
begin
  v_table(1).ename:='张三';
  v_table(2).ename:='李四';
  v_table(3).ename:='王五';
/*  v_num:=v_table.first;
  while v_num<=v_table.last loop
    dbms_output.put_line(v_table(v_num).ename);
    v_num := v_num+1;
  end loop;*/
  
/*  for v_num in v_table.first..v_table.last loop
    dbms_output.put_line(v_table(v_num).ename);
  end loop;*/  
  
  v_num:=v_table.first;
  while v_num<=v_table.last loop
    dbms_output.put_line(v_table(v_num).ename);
    v_num := v_table.next(v_num);
  end loop;
end;
---------------------------------------
declare
  v_sql varchar2(300);
  v_ename emp1.ename%type;
  v_sal emp1.sal%type;
begin
  v_sql:='select ename,sal into' ||v_ename||','||v_sal||  'from emp1 where empno=7900';
  execute immediate v_sql;
end;
--------------------------------------------
declare
  v_empno emp3.empno%type;
  v_ename emp3.ename%type:='zhangsan1';
  v_sal emp3.sal%type;
  v_sql varchar2(300);
begin
/*  v_sql := 'select empno,ename,sal from emp3 where empno=8888';
  execute immediate v_sql into v_empno,v_ename,v_sal; 
  dbms_output.put_line(v_empno);
  dbms_output.put_line(v_ename);
  dbms_output.put_line(v_sal);*/
  
  v_sql:='update emp3 set ename = '''||v_ename||'''where ename = ''lisi''';
  execute immediate v_sql;
  commit;
end;
