create table picuser(
    id varchar2(20) primary key,
    pw varchar2(20) not null,
    name varchar2(20) not null,
    tel varchar2(20) not null,
    email varchar2(30) not null,
    birth number(4) not null
);

commit;
-----------------------------------------------------------------------------
create table buy(
    buy_no number(7) primary key,
    buy_title varchar2(50) not null,
    id varchar2(20) not null,
    buy_count number(10) default 0 not null,
    buy_date date default sysdate not null,
    buy_deadline date default sysdate not null,
    buy_image varchar2(1000),
    buy_content varchar2(4000) not null,
    constraint buy_fk FOREIGN KEY (id) REFERENCES picuser(id) on delete cascade
);

create SEQUENCE buy_seq
start with 1
increment by 1
NOMAXVALUE
minvalue 1;

commit;
-----------------------------------------------------------------------------------
create table buy_reply(
    buy_no number(7) not null,              --(buy)
    br_no number(7) primary key,
    id varchar2(20) not null,               --(picuser)
    br_date date default sysdate not null,
    br_content varchar2(1000) not null,
    constraint fk_buy_no foreign key(buy_no) REFERENCES buy(buy_no) on delete cascade,
    constraint fk_id foreign key(id) REFERENCES picuser(id) on delete cascade
);

create SEQUENCE br_seq
start with 1
increment by 1
NOMAXVALUE
minvalue 1;

commit;
------------------------------------------------------------------------------------------------------------------------------------------
select count(*) as buytotal from buy;

select * from buy order by buy_no desc;

select rownum as rnum, A.* from (select * from buy order by buy_no desc) A where rownum <= 10;

select X.* from (select rownum as rnum, A.* from (select * from buy order by buy_no desc) A where rownum <= 10) X where X.rnum >= 1;
---------------------------------------------------------------------------------------------------------------------------------------------------
select * from buy order by buy_no desc;
select * from buy where buy_title like '%asdf%' or buy_content like '%asdf%';
select * from buy where buy_title like '%asdf%';
select * from buy where buy_content like '%asdf%';
select * from buy where id like '%asdf%';

select X.* from (select rownum as rnum, A.* from (select * from buy where buy_title like '%qwer%' order by buy_no desc) A where rownum <= 10) X where X.rnum >= 1;
select X.* from (select rownum as rnum, A.* from (select * from buy order by buy_no desc) A where rownum <= 10) X where X.rnum >= 1 and (buy_content like '%asdf%');
select X.* from (select rownum as rnum, A.* from (select * from buy order by buy_no desc) A where rownum <= 20) X where X.rnum >= 11 and (id like '%asdf%');

select count(*) as buytotal from buy where buy_title like '%qwer%';
---------------------------------------------------------------------------------------------------------------------------------------------------------
create table sell(
    sell_no number(7) primary key,
    sell_title varchar2(50) not null,
    sell_genre varchar2(50) not null,
    id varchar2(20) not null,
    sell_count number(10) default 0 not null,
    tel varchar2(20) not null,
    email varchar2(30) not null,
    sell_content varchar2(4000) not null,
    sell_image1 varchar2(1000) not null,
    sell_image2 varchar2(1000),
    sell_image3 varchar2(1000),
    constraint sell_fk FOREIGN KEY (id) REFERENCES picuser(id) on delete cascade
);

create SEQUENCE sell_seq
start with 1
increment by 1
NOMAXVALUE
minvalue 1;

commit;
-----------------------------------------------------------------------------------------------
create table sell_reply(
    sell_no number(7) not null,              --(buy)
    sr_no number(7) primary key,
    id varchar2(20) not null,               --(picuser)
    sr_date date default sysdate not null,
    sr_content varchar2(1000) not null,
    constraint fk_sell_no foreign key(sell_no) REFERENCES sell(sell_no) on delete cascade,
    constraint fk_id2 foreign key(id) REFERENCES picuser(id) on delete cascade
);

create SEQUENCE sr_seq
start with 1
increment by 1
NOMAXVALUE
minvalue 1;

commit;
