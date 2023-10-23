-- 기본키, 작성자 이름, 제목, 내용, 작성일, 조회수
CREATE table board(
   board_idx number(4) primary key,
   board_name varchar(20),
   board_title varchar2(100),
   board_content varchar2(300),
   board_date date default sysdate,
   board_hit number(4) default 0
);
create sequence board_seq;

insert into board(board_idx, board_name, board_title,
board_content, board_date)
VALUES(board_seq.nextval,'홍길동','글제목1','글 내용1', sysdate);

insert into board(board_idx, board_name, board_title,
board_content, board_date)
VALUES(board_seq.nextval, '변사또','글제목2','글내용2',sysdate);
insert into board(board_idx, board_name, board_title,
board_content, board_date)
VALUES(board_seq.nextval, '사임당','글제목2','글내용2',sysdate);

SELECT *
FROM board;

-- reply_board_idx : 외래키 - 다른 테이블의 인덱스키를 가지고 있음
create table reply(
   reply_idx number(4) primary key,
   reply_name varchar2(20),
   reply_content varchar2(300),
   reply_date date default sysdate,
   reply_board_idx number(4)
);

create SEQUENCE reply_board_seq;
-- 시퀀스 테이블에 고유 값을 주기 위함

insert into reply(reply_idx, reply_name, reply_content, reply_date, reply_board_idx)
values(reply_board_seq.nextval, '홍두꺠', '댓글제목1', sysdate, 1);

insert into reply(reply_idx, reply_name, reply_content, reply_date, reply_board_idx)
values(reply_board_seq.nextval, '심청', '댓글제목2', sysdate, 2);

insert into reply(reply_idx, reply_name, reply_content, reply_date, reply_board_idx)
values(reply_board_seq.nextval, '태홍', '댓글제목3', sysdate, 3);

select *
from reply;

commit;
