--删除从表 再删除主表
 drop table tb_score cascade constraints ;
 drop table tb_course cascade constraints ;
 drop table tb_student cascade constraints ;

/*创建表的格式
create table 表名(
  字段名 类型(精度) 约束[,..其他字段]
  [其他约束]
)*/
/**
学生成绩表tb_student
列名         中文说明    数据类型    唯一  空/非空  默认值  
id           主键       number(3)     是   非             
no           学号       varchar2(10)  是   空    
name         姓名       varchar2(10)  否   空    
gender       性别       number(1)     否   空        1   
age          年龄       number(3)     否   空        18  
email        邮箱       varchar2(20)  是    空    
attendtime  入学时间     date          否    空    
@author  北京尚学堂
@time 2013-01-20
@project 学习
*/
create table tb_student(
   id number(3), 
   no varchar2(10) CONSTRAINT nn_stu_no NOT NULL,
   name varchar2(10) CONSTRAINT nn_stu_name NOT NULL,
   gender number(1) default(1),
   age number(3)default(18),
   email varchar2(20),
   attendtime date,
   constraint pk_stu_id  primary key (id),
   constraint uq_stu_no unique(no),
   constraint uq_stu_email unique(email)
);
/**
课程表tb_course
列名       中文说明    数据类型       唯一  空/非空  默认值  
id         主键         number(3)     是    非              
name       课程名      varchar2(10)  是     非    
describe  课程描述      varchar2(200)否    空      
@author  北京尚学堂
@time 2013-01-20
@project 学习
*/
create table tb_course(
   id number(3), 
   name varchar2(10) CONSTRAINT nn_cour_name NOT NULL,
   describe varchar2(200),    
   constraint pk_cour_id  primary key (id),  
   constraint uq_cour_name unique(name)
);

/**
课程表tb_score
列名       中文说明          数据类型       唯一  空/非空  默认值  
id          主键            number(3)       是    非    
stuid        外键 学生       number(3)       否    空    
couid        外键 课程       number(3)       否    空      
score        成绩            float          否    非      0  成绩0-300之间
@author  北京尚学堂
@time 2013-01-20
@project 学习
*/
create table tb_score(
   id number(3),     
   stuid number(3),
   couid number(3),    
   score float default(1) CONSTRAINT nn_socre_score NOT NULL,  
   constraint pk_score_id  primary key (id),
   constraint fk_score_ref_stu_id foreign key(stuid) references tb_student(id),
   constraint fk_score_ref_cour_id foreign key(couid) references tb_course(id),
   constraint ck_score_score  check(score>=0 and score <=300) 
);

--现在修改 score 的主键类型
alter table tb_score modify(id number(20));
--表注释
comment on table TB_STUDENT  is '学生信息表';
--字段注释
comment on column TB_STUDENT.id  is '主键';

--添加记录
--添加 学生信息记录
insert into tb_student values(1,1,
'bjsxt001',0,30,'bjsxt001@qq.com',to_date('2012-10-08','yyyy-MM-dd'));
insert into tb_student values(2,2,
'bjsxt002',1,20,'bjsxt002@qq.com',to_date('2012-11-08','yyyy-MM-dd'));
insert into tb_student values(3,3,
'bjsxt003',0,40,'bjsxt0031@qq.com',to_date('2012-12-08','yyyy-MM-dd'));
insert into tb_student values(4,4,
'bjsxt004',1,20,'bjsxt004@qq.com',to_date('2012-09-08','yyyy-MM-dd'));
--添加课程信息
insert into tb_course values(1,'javase','javase');
insert into tb_course values(2,'oracle','oracle');
insert into tb_course values(3,'html','html');
--添加成绩信息
insert into tb_score values(1,1,1,80);
insert into tb_score values(2,2,1,85);
insert into tb_score values(3,2,2,90);
commit;

/*写一个存储过程 行转列

姓名  数学  语文  英语  化学
Zs  89  90  99  59
        
Jdbc 把这些结果都打印出来
 游标知识点肯定会用到？？？

Rowtocol
*/
select t01.sname,
       sum(case when t01.cname = 'javase' then t01.score end) javase,
       sum(case when t01.cname = 'oracle' then t01.score end) oracle,
       sum(case when t01.cname = 'html' then t01.score end) html
from (select t2.name sname,t3.name cname,t1.score from 
tb_score t1 join tb_student t2 on t1.stuid = t2.id join tb_course t3 on t1.couid = t3.id)t01 
where t01.sname = 'bjsxt001' group by t01.sname 
---------------------------------------------------------
create or replace procedure queryScore(my_rname out tb_student.name%type,my_javase out tb_score.score%type,
my_oracle out tb_score.score%type,my_html out tb_score.score%type) is
  type record_score_type is record(
       rname tb_student.name%type,
       javase  tb_score.score%type,
       oracle tb_score.score%type,
       html tb_score.score%type
  );
  cursor v_cursor return record_score_type is (select t01.sname,
       sum(case when t01.cname = 'javase' then t01.score end) javase,
       sum(case when t01.cname = 'oracle' then t01.score end) oracle,
       sum(case when t01.cname = 'html' then t01.score end) html
       from (select t2.name sname,t3.name cname,t1.score from 
       tb_score t1 join tb_student t2 on t1.stuid = t2.id join tb_course t3 on t1.couid = t3.id)t01 
       group by t01.sname);
begin
  for v in v_cursor loop
    --dbms_output.put_line(v.rname||'  '||v.javase||'  '||v.oracle||'  '||v.html);
    my_rname:=v.rname;
    my_javase:=v.javase;
    my_oracle:=v.oracle;
    my_html:=v.html;
  end loop;
end;
---------------------------------------------------------
--存储过程
create or replace procedure queryScore(sys_cursor out sys_refcursor) is
  v_sql varchar2(1000):= 'select t01.sname,
       sum(case when t01.cname = ''javase'' then t01.score end) javase,
       sum(case when t01.cname = ''oracle'' then t01.score end) oracle,
       sum(case when t01.cname = ''html'' then t01.score end) html
       from (select t2.name sname,t3.name cname,t1.score from 
       tb_score t1 join tb_student t2 on t1.stuid = t2.id join tb_course t3 on t1.couid = t3.id)t01 
       group by t01.sname';
begin
  open sys_cursor for v_sql;
end;
-------------------------------
--拼接字符串方式输出
create or replace procedure queryScore(sys_cursor out sys_refcursor) is
  v_sql varchar2(1000):= 'select t001.sname||''  ''||t001.javase||''  ''||t001.oracle||''  ''|| t001.html
       from(select t01.sname,
       sum(case when t01.cname = ''javase'' then t01.score end) javase,
       sum(case when t01.cname = ''oracle'' then t01.score end) oracle,
       sum(case when t01.cname = ''html'' then t01.score end) html
       from (select t2.name sname,t3.name cname,t1.score from 
       tb_score t1 join tb_student t2 on t1.stuid = t2.id join tb_course t3 on t1.couid = t3.id)t01 
       group by t01.sname)t001';
begin
  open sys_cursor for v_sql;
end;
-------------------------------
--测试
declare
  sys_cursor sys_refcursor;
begin
  queryScore(sys_cursor);
end;

