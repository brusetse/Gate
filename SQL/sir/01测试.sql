declare
  v_num number(10):=123;
  v_ename varchar2(10):='gaga';
  v_dname constant varchar2(20):='sales';
  --在声明的时候就要必须初始化值
  c_dd constant number(10) not null := 888;
  v_dd1  number(10)   := 8+88;
  
  v_birthday date := to_date('1988-08-08','yyyy-mm-dd');
  v_dd02 v_birthday%type :=to_date('1998-08-08','yyyy-mm-dd');
  -- v_dd03 number(2)
  --%type 只能用于 变量，列类型
  v_dd03  emp.deptno%type :=22;
  -- c_cc01  c_dd%type:=123;--报错 
   --想取到表里面所有的
   --行类型
   
   v_row01  emp%rowtype;
  
  
begin
  --syso
  --这里不能赋值了，因为是常量
  --v_dname:='test';
  --c_dd:=123;
  /*
  dbms_output.put_line('用户编号：'||v_num);
  dbms_output.put_line('用户名：'||v_ename);
  dbms_output.put_line('v_dname：'||v_dname);
  dbms_output.put_line('c_dd：'||c_dd);
  dbms_output.put_line('v_dd1：'||v_dd1);
  dbms_output.put_line('v_birthday：'||to_char(v_birthday,'yyyy-mm-dd'));
  dbms_output.put_line('v_dd02：'||to_char(v_dd02,'yyyy-mm-dd'));
  dbms_output.put_line('v_dd03：'||v_dd03);
  */
  
  ---行类型初始化
  
  v_row01.ename:='cai10';
  v_row01.sal:=123;
  
  dbms_output.put_line('v_row01：'||v_row01.ename);
  
--exception
  

end;
