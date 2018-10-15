-- orderForm订单表 --

create table orderForm 
(
     id int(255) NOT NULL PRIMARY KEY AUTO_INCREMENT,
     username varchar(255) not null,
     orderDate timestamp not null  default CURRENT_TIMESTAMP,
     commodity_name varchar(255) not null,
     commodity_price int(255) not null,
     sum int(255) 
);

--生成序列

CREATE SEQUENCE orderForm_seq
       START WITH      1
       INCREMENT BY    1
       MINVALUE        1
       MAXVALUE     100000
       NOCYCLE
       CACHE           10;
       
--触发器

CREATE TRIGGER  orderForm_trigger
       BEFORE INSERT ON orderForm
       FOR EACH ROW 
       BEGIN
           SELECT orderForm_seq.nextval into :new.id FROM dual;
       END;
commit;