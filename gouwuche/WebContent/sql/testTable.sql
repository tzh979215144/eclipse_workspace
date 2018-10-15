

-- insert into classify
insert into classify(gname) values('A级车');
insert into classify(gname) values('B级运动旅行车');
insert into classify(gname) values('长轴距C级轿车');
insert into classify(gname) values('长轴距E级轿车');
insert into classify(gname) values('S级轿车');
insert into classify(gname) values('迈巴赫S级轿车');
insert into classify(gname) values('CLA运动轿车');
insert into classify(gname) values('GLA SUV');
insert into classify(gname) values('GLC SUV');
insert into classify(gname) values('GLE SUV');
insert into classify(gname) values('GLS SUV');
insert into classify(gname) values('G级越野车');
insert into classify(gname) values('R级大型旅行车臻藏版');
insert into classify(gname) values('全新GLS四门轿跑车');
insert into classify(gname) values('SL敞篷跑车');
insert into classify(gname) values('SLC敞篷跑车');
insert into classify(gname) values('梅赛德斯-AMG GT');
insert into classify(gname) values('V级豪华多功能车');
insert into classify(gname) values('威霆高端商务车');
commit;

drop trigger classify_tigger
-- insert into commodity

INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('A 180', '福建', 219800, 500, '001.jpg',1);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('A 200 动感型', '福建', 238800, 800, '002.jpg',1);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('A 200 时尚型', '福建', 263800, 100, '003.jpg',1);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('A 200 运动型', '福建', 278800, 300, '004.jpg',1);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('A 260 运动型', '福建', 336800, 400, '005.jpg',1);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('B 180', '福建', 225800, 500, '006.jpg',2);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('B 200 动感型', '福建', 243800 , 1000, '007.jpg',2);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('B 200 时尚型', '福建', 262800, 1000, '008.jpg',2);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('B 200 豪华型', '福建', 283800 ,600,'009.jpg',2);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('B 260 运动型', '福建', 339800, 900, '010.jpg',2);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('C 180 L 时尚型轿车', '福建', 323800 , 500, '011.jpg',3);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('C 200 L 轿车', '福建', 120, 350800 , '012.jpg',3);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('C 200 L 4MATIC 轿车', '福建', 396800 , 1000, '013.jpg',3);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('C 300 L 轿车', '福建', 485000 ,600,'014.jpg',3);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('E 200 L 轿车', '福建', 435800 , 800, '015.jpg',4);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('E 200 L 4MATIC 轿车', '福建', 458000 , 1000, '016.jpg',4);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('E 300 L 时尚型轿车', '福建', 475800 ,600,'017.jpg',4);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('E 300 L 豪华型轿车', '福建', 502800 ,600,'018.jpg',4);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('E 320 L 4MATIC 轿车', '福建', 629800 , 1000, '019.jpg',4);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('S 320 L', '福建', 876800 , 500, '020.jpg',5);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('S 350 L ', '福建', 1028800 , 800, '021.jpg',5);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('S 450 L ', '福建', 1139800 , 1000, '022.jpg',5);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('S 450 L 4MATIC 卓越特别版', '福建', 1228800 ,600,'023.jpg',5);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('S 500 L 4MATIC', '福建', 1732800 , 900, '024.jpg',5);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('S 450 4MATIC', '福建', 1398800 , 500, '025.jpg',6);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('S 560 4MATIC', '福建',2138800 , 800, '026.jpg',6);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('S 680', '福建', 2888800 , 1000, '027.jpg',6);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('CLA 180', '福建', 237800 , 500, '028.jpg',7);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('CLA 200 动感型', '福建', 256800 , 800, '029.jpg',7);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('CLA 200 时尚型', '福建', 274800 , 1000, '030.jpg',7);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('CLA 220 4MATIC', '上海', 306800 ,600,'031.jpg',7);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('CLA 260 4MATIC', '广州', 359800 , 900, '032.jpg',7);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLA 200 动感型', '福州', 269800 , 800, '033.jpg',8);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLA 200 时尚型', '广州', 288800 , 1000, '034.jpg',8);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLA 220 4MATIC 运动型', '上海', 324800 ,600,'035.jpg',8);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLA 260 4MATIC 运动型', '广州', 395800 , 900, '036.jpg',8);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLC 200 4MATIC', '佛山', 394800 , 500, '037.jpg',9);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLC 260 4MATIC 动感型', '福州', 429800 , 800, '038.jpg',9);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLC 260 4MATIC 豪华型', '广州', 445000 , 100, '039.jpg',9);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLC 300 4MATIC 动感型', '上海', 489800 ,600,'040.jpg',9);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLC 300 4MATIC 豪华型', '广州', 576000 , 900, '041.jpg',9);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLE 300 d 4MATIC', '佛山', 711800 , 500, '042.jpg',10);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLE 320 4MATIC 动感型臻藏版', '福州', 719800 , 800, '043.jpg',10);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLE 320 4MATIC 豪华型臻藏版', '广州', 762800 , 100, '044.jpg',10);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLE 350 d 4MATIC', '上海', 795800 ,600,'045.jpg',10);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLE 400 4MATIC 臻藏版 ', '广州', 862800 , 600, '046.jpg',10);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLS 320 4MATIC', '佛山', 956800 , 500, '047.jpg',11);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLS 350 d 4MATIC', '福州', 998800 , 800, '048.jpg',11);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLS 400 4MATIC 动感型', '广州', 1075800 , 100, '049.jpg',11);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLS 400 4MATIC 豪华型', '上海', 1249800 ,600,'050.jpg',11);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('GLS 500 4MATIC ', '广州', 1481800 , 900, '051.jpg',11);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('G 350 d ', '佛山', 1228800 , 500, '052.jpg',12);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('G 500 ', '福州', 1568800 , 800, '053.jpg',12);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('G 500 designo 匠心典藏版 ', '广州', 1698800 , 100, '054.jpg',12);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('R 320 4MATIC 商务型 臻藏版', '佛山', 548800 , 500, '055.jpg',13);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('R 320 4MATIC 豪华型 臻藏版', '福州', 632800 , 800, '056.jpg',13);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES (' R 400 4MATIC 臻藏版 ', '广州', 726800 , 100, '057.jpg',13);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('CLS 350 4MATIC 四门轿跑车 ', '佛山', 808800 , 500, '058.jpg',14);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('SL 400 ', '佛山', 1016800 , 500, '059.jpg',15);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('SLC 260 动感型', '福州', 518800 , 800, '060.jpg',16);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('SLC 300 豪华运动型 ', '广州', 638800 , 100, '061.jpg',16);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('梅赛德斯-AMG GT ', '佛山', 1321800 , 500, '062.jpg',17);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('梅赛德斯-AMG GT S', '福州', 1595800 , 300, '063.jpg',17);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('全新梅赛德斯-AMG GT C 中国特别版  ', '广州', 1858800 , 1000, '064.jpg',17);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('V 260 领航版 ', '佛山', 485000 , 500, '065.jpg',18);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('V 260 尊贵版', '福州', 593000 , 300, '066.jpg',18);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES (' V 260 L 尊贵加长版   ', '广州', 613000 , 100, '067.jpg',18);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('Vito 精英版 ', '佛山', 296000 , 500, '068.jpg',19);
INSERT INTO commodity(commodity_name,commodity_made,commodity_price,commodity_balance,commodity_pic,commodity_id) VALUES ('Vito 商务版', '福州', 336000 , 800, '069.jpg',19);

--Drop all table 注意删除顺序--
drop trigger commodity_trigger;
commit;
drop sequence commodity_seq;
commit;
drop table commodity;
commit;

drop trigger classify_trigger;
commit;
drop sequence classify_seq;
commit;
drop table classify;
commit;

drop trigger orderForm_trigger;
commit;
drop sequence orderForm_seq;
commit;
drop table orderForm ;
commit;

 