/*T_Order（订单）
字段  名称  类型  说明
Order_ID  订单ID  NUMBER  主键
Order_No  订单号  VARCHAR2  唯一
Customer  客户  VARCHAR2 
Sales_ID  销售员ID  VARCHAR2 
Approval_Status  审批状态  VARCHAR2  “通过/驳回”*/

create table T_order(
       Order_ID NUMBER(20) primary key,
       Order_No VARCHAR2(20) unique,
       Customer VARCHAR2(20),
       Sales_ID NUMBER(20),
       Approval_Status  VARCHAR2(20),
       foreign key(Sales_ID) references T_Sales(Sales_ID)
);

/*T_OrderDetail（订单明细）
字段  名称  类型  说明
OrderDetail_ID  订单明细ID  NUMBER  主键
Order_ID  订单ID  NUMBER  外键，关联T_Order的
Order_ID字段
Product  产品  VARCHAR2 
Price  单价  NUMBER 
Quantity  订货数量  NUMBER*/

create table T_OrderDetail(
       OrderDetail_ID NUMBER(20) primary key,
       Order_No NUMBER(20),
       Product VARCHAR2(20),
       Price NUMBER(20),
       Quantity NUMBER(20),
       foreign key(Order_No) references T_order(Order_ID)
);

/*T_Sales（员工）
字段  名称  类型  说明
Sales_ID  销售员ID  NUMBER  主键
Team  销售小组  VARCHAR2 
Name  姓名  VARCHAR2 
Sex  性别  VARCHAR2 
Birthday  出生日期  DATE 
StartDate  入职日期  DATE 
Sale_Under_Limit  销售额下限  NUMBER */

create table T_Sales(
       Sales_ID NUMBER(20) primary key,
       Team VARCHAR2(20),
       Name VARCHAR2(20),
       Sex VARCHAR2(20),
       Birthday DATE,
       StartDate DATE,
       Sale_Under_Limit NUMBER(20)
);
--------------------------------------------


/*要求：请创建一张视图，显示特定销售员信息，要求98年进入公司，年龄在20--30
岁男性销售员。视图的列包括：员工ID、姓名、性别、出生日期、入职日期、销售
额下限。
注：要求日期显示格式如“2006-8-18”。*/

create view v$T_Sales as 
select t.sales_id 员工ID,t.name 姓名,t.sex 性别,to_char(t.birthday,'yyyy-mm-dd') 出生日期,
to_char(t.startdate,'yyyy-mm-dd') 入职日期,t.sale_under_limit 销售额下限 from T_Sales t
where to_char(t.startdate,'yyyy') = '1998' and ((sysdate-t.birthday)/365 between 20 and 30) 
and t.sex = 'man';

/*要求：请写出一条Select语句，按当前日期计算所有销售员的工龄（精确到月份）。
结果的列包括：员工ID 、姓名、性别、出生日期、入职日期、销售额下限、工龄。
*/

select  t.sales_id 员工ID,t.name 姓名,t.sex 性别,to_char(t.birthday,'yyyy-mm-dd') 出生日期,
to_char(t.startdate,'yyyy-mm-dd') 入职日期,t.sale_under_limit 销售额下限,
trunc((sysdate-t.startdate)/365)||'年'||trunc(mod((sysdate-t.startdate),365)/30)||'月' 工龄
from T_Sales t

/*要求：请写出一条Select语句，计算每个销售小组内部销售员的平均销售额下限。
结果的列包括：销售小组、平均销售额下限。
注：平均销售额下限以“$12,912.01”形式显示*/

select t.team 销售小组,'$'||round(avg(t.sale_under_limit),2) 平均销售额下限 from T_Sales t group by t.Team

/*要求：请创建一个存储过程。在存储过程中分别根据每位销售员自身的销售下限，
对所有销售员的订单进行审批（审批的规则见上文“业务简述”）。若存储过程在
执行时抛异常就返回数字0，否则，执行完毕就返回数字1。
注：在存储过程中必须使用游标实现数据处理。*/

--订单
select t3.order_no sno,max(t1.name) sname,sum(t3.price*t3.quantity) sprice,max(t1.sale_under_limit) slimit from 
t_sales t1 join t_order t2 on t1.sales_id=t2.sales_id 
join t_orderdetail t3 on t2.order_id = t3.order_no group by t3.order_no
--存储过程
create or replace procedure setApproval(v_sta out number) is
  cursor my_cursor is (select t3.order_no sno,max(t1.name) sname,sum(t3.price*t3.quantity) sprice,
                      max(t1.sale_under_limit) slimit from 
                      t_sales t1 join t_order t2 on t1.sales_id=t2.sales_id 
                      join t_orderdetail t3 on t2.order_id = t3.order_no group by t3.order_no);
begin
  for v in my_cursor loop
    if v.sprice>=v.slimit then 
      update t_order set Approval_Status = '通过' where Order_ID=v.sno;
    elsif v.sprice<v.slimit then 
      update t_order set Approval_Status = '驳回' where Order_ID=v.sno;
    end if;
    commit;
  end loop;
  v_sta:=1;
exception
  when others then
    dbms_output.put_line('有错误');
    rollback;
    v_sta:=0;
end;
--测试
declare
  sta number(10):=0;
begin
  setApproval(sta);
  dbms_output.put_line(sta);
end;



