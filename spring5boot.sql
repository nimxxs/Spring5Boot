-- member
create table member2 (
    mno         int             auto_increment,
    userid      varchar(18)     unique,
    passwd      varchar(18)     not null,
    name        varchar(10)     not null,
    email       varchar(50)     unique,
    zipcode     char(7)         not null,
    addr1       varchar(100)    not null,
    addr2       varchar(100)    not null,
    phone       char(13)        not null,
    regdate     datetime        default current_timestamp,
    primary key (mno)
);

insert into member2
(userid, passwd, name, email, zipcode, addr1, addr2, phone)
values ('abc123','987xyz','빵빵이','abc123@987xyz','123-456','서울 관악구','블라블라','123-4567-8912');

select * from member2;

-- board
create table board2 (
  bno       int             auto_increment,
  title     varchar(100)    not null,
  userid    varchar(18)     not null,
  regdate   datetime        default current_timestamp,
  thumbs    int             default 0,
  views     int             default 0,
  contents  text            not null,
  ipaddr    varchar(15)     not null,
  primary key (bno)
  -- foreign key (userid) references member2(userid) 외래키 제약조건은 같이 해도 되지만 따로 하는 것이 더 좋음
);

alter table board2
    add constraint fkuid
        foreign key (userid) references member2 (userid);

insert into board2
(userid, title, contents, ipaddr)
values ('abc123','자기얌 헌팅하고 오는거야?','알겠어 잘 다녀와','1.1.1.1.1');

insert into board2
(userid, title, contents, ipaddr)
values ('abc123a','빵빵아 나 연예인 누구 닮았어?','빵빵아 대답해','1.1.1.1.1');

insert into board2
(userid, title, contents, ipaddr)
values ('987xyz','밖에 비가 많이 오니','김치전이 먹고싶구나','1.1.1.1.1');

select count(userid) cnt, ceil(count(userid) / 25) pages from board2;
