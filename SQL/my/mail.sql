drop table tb_user cascade constraints;

/*==============================================================*/
/* Table: "user"                                                */
/*==============================================================*/
create table tb_user  (
   user_id                 number(20)                      not null,
   qq                 varchar(20),
   password           varchar(20),
   username           varchar(20),
   regtime            date,
   addr               varchar(20),
   constraint PK_USER primary key (user_id)
);

alter table sendbox
   drop constraint FK_SENDMAIL_REFERENCE_USER;




drop table sendbox cascade constraints;

/*==============================================================*/
/* Table: "sendmailbox"                                         */
/*==============================================================*/
create table sendbox  (
   sendbox_id                 number(10)                      not null,
   sendtime           date,
   title              varchar(200),
   content            clob,
   send_userid        number(20),
   status             number(3),
   constraint PK_SENDMAILBOX primary key (sendbox_id)
);

alter table sendbox
   add constraint FK_SENDMAIL_REFERENCE_USER foreign key (send_userid)
      references tb_user (user_id);



alter table receivebox
   drop constraint FK_RECEIVEM_REFERENCE_USER;

alter table receivebox
   drop constraint FK_RECEIVEM_REFERENCE_SENDMAIL;

drop table receivebox cascade constraints;

/*==============================================================*/
/* Table: "receivemailbox"                                      */
/*==============================================================*/
create table receivebox  (
   recievebox_id                 number(20)                      not null,
   recieve_id          number(20),
   mail_id            number(20),
   delstatus          number(3),
   constraint PK_RECEIVEMAILBOX primary key (recievebox_id)
);

alter table receivebox
   add constraint FK_RECEIVEM_REFERENCE_USER foreign key (recieve_id)
      references tb_user (user_id);

alter table receivebox
   add constraint FK_RECEIVEM_REFERENCE_SENDMAIL foreign key (mail_id)
      references sendbox (sendbox_id);
      
------------------------------------------------------------------
--查询出来你的发件箱信息(sql)

select s1.*,t1.* from sendbox s1 join tb_user t1 on s1.sendbox_id = t1.user_id

--查询出来收件箱信息（sql）
--(思路 ：1.根据用户id查询出来收件箱里面邮件的id.2根据邮件id连表查询出来详细邮件信息)

select t2.username 发送用户,
       t2.qq       发送者qq,
       t1.username 接收用户,
       t1.qq       接收者qq,
       s1.title    内容,
       s1.sendtime 发送时间,
       s1.status   状态
  from receivebox r1
  join tb_user t1
    on r1.recieve_id = t1.user_id
  join sendbox s1
    on r1.mail_id = s1.sendbox_id
  join tb_user t2
    on s1.send_userid = t2.user_id
    
select t1.qq,
  from receivebox r1
  join tb_user t1
    on r1.recieve_id = t1.user_id
  join sendbox s1
    on r1.mail_id = s1.sendbox_id
  join tb_user t2
    on s1.send_userid = t2.user_id where t1.user_id = 1
    
select * from tb_user
select * from sendbox
select * from receivebox

Insert into sendbox values(10,'1-9月-2016','噶都是','fah',1,1)
drop sequence seq_sendbox_id

create sequence seq_user_id increment by 100 start with 1;
create sequence seq_sendbox_id increment by 1 start with 10;
create sequence seq_receivebox_id increment by 100 start with 1;

insert into sendbox(sendbox_id,sendtime,title,content,send_userid,status) 
values(seq_sendbox_id.nextval,sysdate,'afs','saas',1,1)

select seq_sendbox_id.currval from dual
