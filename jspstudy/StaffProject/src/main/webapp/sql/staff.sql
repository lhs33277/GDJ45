DROP TABLE STAFF;

CREATE TABLE STAFF(
    SNO VARCHAR2(5 BYTE) PRIMARY KEY,
    NAME VARCHAR2(32 BYTE) NOT NULL UNIQUE,
    DEPT VARCHAR2(20 BYTE),
    SALARY NUMBER
);
