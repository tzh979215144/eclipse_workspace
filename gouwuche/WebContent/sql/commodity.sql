-- commodity表 储存商品信息 --
create table commodity
(
    commodity_number int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
    commodity_name   varchar(255) not null,
    commodity_made   varchar(255),
    commodity_price  int(255) not null,
    commodity_balance int(255) not null,
    commodity_pic    varchar(255) not null,
    commodity_id int not null,
    Foreign Key (commodity_id) references classify(gid)
);
--上面这是为了保证表的完整性，确保每个商品都在分类表中有对应分类
    --下面这条语句就是将commodity_id（需要先定义了） 指向 classify的gid的外来键
-- 为commodity表主键gid生成唯一 序列--
create sequence commodity_seq
       start with   1
       increment by 1
       minvalue     1
       maxvalue     100000
       nocycle
       cache        10
       
--创建触发器
create trigger commodity_trigger
       before insert on commodity
       for each row 
         begin
           select commodity_seq.nextval into :new.commodity_number from dual;
         end;

         
