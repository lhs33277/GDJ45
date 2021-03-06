DROP TABLE USER1;
DROP TABLE BOARD;
DROP TABLE PRODUCT;
DROP TABLE MAKER;
DROP TABLE STORAGE;
DROP TABLE DELIVERY;
DROP TABLE ORDER1;

CREATE TABLE USER1(
USER1_NO NUMBER NOT NULL PRIMARY KEY,
USER1_NAME VARCHAR2(20 BYTE) NOT NULL,
USER1_REGIST NUMBER,
USER1_PRO NUMBER,
USER1_ORDER1 NUMBER
);

CREATE TABLE BOARD(
BO_NO       NUMBER NOT NULL PRIMARY KEY,
BO_REGIST NUMBER REFERENCES USER1(USER1_NO),
BO_PRO      VARCHAR2(20 BYTE)
);


CREATE TABLE PRODUCT(
PRO_NO NUMBER NOT NULL PRIMARY KEY,
PRO_KIND VARCHAR2(20 BYTE) NOT NULL,
PRO_USER1 NUMBER,
PRO_MAKER VARCHAR2(20 BYTE),
PRO_STOR VARCHAR2(20 BYTE)
);

CREATE TABLE MAKER(
MAKER_NAME VARCHAR2(20 BYTE) NOT NULL PRIMARY KEY,
MAKER_PRO NUMBER,
MAKER_DEL VARCHAR2(20 BYTE)
);

CREATE TABLE STORAGE(
STOR_NAME VARCHAR2(20 BYTE) PRIMARY KEY,
STOR_PRO NUMBER,
STOR_MAKER VARCHAR2(20 BYTE)
);

CREATE TABLE DELIVERY(
DEL_NAME VARCHAR2(20 BYTE) NOT NULL PRIMARY KEY,
DEL_PRO NUMBER,
ORDER1_NO NUMBER,
ORDER1_USER1 NUMBER
);

CREATE TABLE ORDER1(
ORDER1_NO NUMBER NOT NULL PRIMARY KEY,
OLDER1_USER1 NUMBER NOT NULL,
ORDER1_PRO NUMBER,
ORDER1_DEL VARCHAR2(20 BYTE)
);




/*
게시판 BOARD       BO_NO(번호), BO_REGIST(작성자), BO_PRO(작성제품)
회원 USER          USER_NO(고객번호), USER_KIND(이름), USER_REGIST(방문게시판), USER_PRO(주문제품), USER_ORDER(고객 주문번호)
제품 PRODUCT       PRO_NO(번호), PRO_KIND(종류), PRO_USER(제품 주문자), PRO_MAKER(제품 제조사), PRO_STOR(제품 저장소)
제조사 MAKER       MAKER_NAME(이름), MAKER_PRO(생성제품), MAKER_DEL(사용택배)
창고 STORAGE       STOR_NAME(이름), STOR_PRO(저장제품), STOR_MAKER(저장제조사)
택배업체 DELIVERY  DEL_NAME(이름), DEL_PRO(배송제품), ORDER_NO(주문번호), ORDER_USER(받는사람)
주문 ORDER         ORDER_NO(주문번호), ORDER_USER(주문자), ORDER_PRO(주문제품), DEL_NAME(택배업체)
*/











