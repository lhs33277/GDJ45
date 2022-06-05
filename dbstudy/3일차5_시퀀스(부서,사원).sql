-- 테이블 삭제
DROP TABLE EMPLOYEE;
DROP TABLE DEPARTMENT;

-- DEPARTMENT 테이블 생성
CREATE TABLE DEPARTMENT(
    DEPT_NO   NUMBER NOT NULL,
    DEPT_NAME VARCHAR2(15 BYTE) NOT NULL,
    LOCATION  VARCHAR2(15 BYTE) NOT NULL
);

-- 기본키
ALTER TABLE DEPARTMENT ADD CONSTRAINT DEPARTMENT_PK PRIMARY KEY(DEPT_NO);

-- EMPLOYEE 테이블 생성
CREATE TABLE EMPLOYEE(
    EMP_NO    NUMBER NOT NULL,
    NAME      VARCHAR2(20 BYTE) NOT NULL,
    DEPART    NUMBER,
    POSITION  VARCHAR2(20 BYTE),
    GENDER    CHAR(2),
    HIRE_DATE DATE,
    SALARY    NUMBER
);

-- 기본키
ALTER TABLE EMPLOYEE ADD CONSTRAINT EMPLOYEE_PK PRIMARY KEY(EMP_NO);

-- 외래키
ALTER TABLE EMPLOYEE 
    ADD CONSTRAINT EMPLOYEE_DEPARTMENT_FK FOREIGN KEY(DEPART) 
        REFERENCES DEPARTMENT(DEPT_NO);

/****************************************************************/

/*
    시퀀스
    
    1. 일련번호를 생성하는 데이터베이스 객체이다.
    2. 기본키에서 주로 사용된다.
    3. 자동으로 증가하는 번호를 생성한다.
    4. nextval를 이용하면 다음에 생성될 번호를 알 수 있다. (주로 사용)
    5. currval를 이용하면 현재 생성된 번호를 알 수 있다.
    6. insert에서 주로 사용
*/

-- 시퀀스 생성하기
create sequence department_seq
    start with 1    -- 시작값 1
    increment by 1  -- 증가값 1
    minvalue 1      -- 최소값 1
    maxvalue 100;    -- 최대값 100
    

-- 시퀀스 이용해서 번호 삽입하기
INSERT INTO DEPARTMENT VALUES(department_seq.nextval, '영업부', '대구');
INSERT INTO DEPARTMENT VALUES(department_seq.nextval, '인사부', '서울');
INSERT INTO DEPARTMENT VALUES(department_seq.nextval, '총무부', '대구');
INSERT INTO DEPARTMENT VALUES(department_seq.nextval, '기획부', '서울');


-- 시퀀스 생성하기
create sequence employee_seq
    start with 1001 -- 시작값 1001
    increment by 1  -- 증가값 1
    nominvalue      -- 최소값 없음
    nomaxvalue      -- 최대값 없음
    nocache         -- 메모리 캐시 사용 안 함(추천)
    nocycle;        -- 번호 순환 없음(pk에서 주로 사용하기 때문에 추천)
    
INSERT INTO EMPLOYEE(EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY)
VALUES (employee_seq.nextval, '구창민', 1, '과장', 'M', '95-05-01', 5000000);
INSERT INTO EMPLOYEE(EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY)
VALUES (employee_seq.nextval, '김민서', 1, '사원', 'M', '17-09-01', 2500000);
INSERT INTO EMPLOYEE(EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY)
VALUES (employee_seq.nextval, '이은영', 2, '부장', 'F', '90-09-01', 5500000);
INSERT INTO EMPLOYEE(EMP_NO, NAME, DEPART, POSITION, GENDER, HIRE_DATE, SALARY)
VALUES (employee_seq.nextval, '한성일', 2, '과장', 'M', '93-04-01', 5000000);

COMMIT;