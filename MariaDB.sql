SHOW DATABASES;

USE dlgnlwo3;

SHOW TABLES;

create table picuser(
    id varchar(20) primary key,
    pw varchar(20) not null,
    name varchar(20) not null,
    tel varchar(20) not null,
    email varchar(30) not null,
    birth smallint not null
);

SELECT * FROM picuser;
-------------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM buy;

create table buy(
    buy_no INT NOT NULL auto_increment primary key,
    buy_title varchar(50) not null,
    id varchar(20) not null,
    buy_count bigint default 0 not null,
    buy_date datetime default now() not null,
    buy_deadline datetime default now() not null,
    buy_image varchar(1000),
    buy_content varchar(4000) not null,
    constraint buy_fk FOREIGN KEY (id) REFERENCES picuser(id) on delete cascade
);


SELECT * FROM buy ORDER BY buy_no DESC LIMIT 0, 10;


SELECT * FROM buy WHERE buy_title LIKE '%제목%' ORDER BY buy_no DESC LIMIT 0, 10;

insert into buy (buy_title, id, buy_count, buy_deadline, buy_image, buy_content) VALUES ('제목입니다.', 'asdf', DEFAULT, DEFAULT, '이미지입니다.', '내용입니다.');

SELECT * FROM buy;

COMMIT;
----------------------------------------------------------------------------------------------------------------------------------------

create table buy_reply(
    buy_no int not null,              
    br_no INT NOT NULL auto_increment primary key,
    id varchar(20) not null,               
    br_date datetime default now() not null,
    br_content varchar(1000) not null,
    constraint fk_buy_no foreign key(buy_no) REFERENCES buy(buy_no) on delete cascade,
    constraint fk_id foreign key(id) REFERENCES picuser(id) on delete cascade
);



SELECT * FROM buy_reply;

-----------------------------------------------------------------------------------------------------------------------------------------
SELECT * FROM sell;

create table sell(
    sell_no int NOT NULL auto_increment primary key,
    sell_title varchar(50) not null,
    sell_genre varchar(50) not null,
    id varchar(20) not null,
    sell_count bigint default 0 not null,
    tel varchar(20) not null,
    email varchar(30) not null,
    sell_content varchar(4000) not null,
    sell_image1 varchar(1000) not null,
    sell_image2 varchar(1000),
    sell_image3 varchar(1000),
    constraint sell_fk FOREIGN KEY (id) REFERENCES picuser(id) on delete cascade
);


create table sell_reply(
    sell_no int not null,              
    sr_no INT NOT NULL auto_increment primary key,
    id varchar(20) not null,               
    sr_date datetime default now() not null,
    sr_content varchar(1000) not null,
    constraint fk_sell_no foreign key(sell_no) REFERENCES sell(sell_no) on delete cascade,
    constraint fk_id2 foreign key(id) REFERENCES picuser(id) on delete cascade
);


COMMIT;

------------------------------------------------------------------------------------



