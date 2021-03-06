/*
    트리거(TRIGGER)
    
    1. DML(INSERT, UPDATE, DELETE) 작업을 수행하는 경우 함께 수행하는 작업이다.
    2. DML 작업 수행 직전에 수행하는 BEFORE TRIGGER와 DML 작업 수행 직후에 수행하는 AFTER TRIGGER가 있다.
    3. 형식
        CREATE [OR REPLACE] TRIGGER 트리거명
            트리거 설정
        BEGIN
            작업 수행
        END
*/



-- 트리거 TRIG1 정의
CREATE OR REPLACE TRIGGER TRIG1
    AFTER                       -- AFTER, BEFORE
    INSERT OR DELETE OR UPDATE  -- INSERT, UPDATE, DELETE
    ON EMPLOYEES                -- 트리거를 적용할 테이블
    FOR EACH ROW                -- 크리거 적용을 행(ROW)마다 적용
BEGIN
    DBMS_OUTPUT.PUT_LINE('Hello Trigger');
END;


-- 트리거 TRIG1 동작 확인
UPDATE EMPLOYEES
   SET SALARY = 25000
 WHERE EMPLOYEE_ID = 100;




-- 트리거 TRIG2 정의
CREATE OR REPLACE TRIGGER TRIG2
    AFTER
    INSERT OR UPDATE OR DELETE
    ON EMPLOYEES
    FOR EACH ROW
BEGIN
    IF INSERTING THEN
        DBMS_OUTPUT.PUT_LINE('INSERT 이후 동작');
    ELSIF UPDATING THEN
        DBMS_OUTPUT.PUT_LINE('UPDATE 이후 동작');
    ELSIF DELETING THEN
        DBMS_OUTPUT.PUT_LINE('DELETE 이후 동작');
    END IF;
END TRIG2;

-- 트리거 TRIG2 동작 확인
UPDATE EMPLOYEES
   SET SALARY = 24000
 WHERE EMPLOYEE_ID = 100;



-- 트리거 실습
-- 사원(EMPLOYEES) 테이블에서 삭제된 데이터를 퇴사자(RETIRES) 테이블에 추가하시오.

-- 1. 퇴사자(RETIRES) 테이블 생성
--   1) EMPLYEE 테이블과 같은 구조로 복사
CREATE TABLE RETIRES
    AS (SELECT EMPLOYEE_ID, FIRST_NAME, LAST_NAME, EMAIL, PHONE_NUMBER, HIRE_DATE, JOB_ID, SALARY, COMMISSION_PCT, MANAGER_ID, DEPARTMENT_ID
          FROM EMPLOYEES
         WHERE 1 = 2);
--   2) 칼럼 추가
ALTER TABLE RETIRES ADD RETIRE_ID   NUMBER;
ALTER TABLE RETIRES ADD RETIRE_DATE DATE NOT NULL;
--   3) 기본키 설정
ALTER TABLE RETIRES ADD CONSTRAINT RETIRES_PO PRIMARY KEY(RETIRE_ID);

-- 2. 퇴사자 시퀀스 생성
CREATE SEQUENCE RETIRES_SEQ NOCACHE;

-- 3. 트리거에서 사용되는 테이블
/*
            INSERT          UPDATE          DELETE
    :OLD    NULL            수정전데이터    삭제된데이터
    :NEW    삽입데이터      수정후데이터    NULL
*/
--AFTER DELETE를 설정하면 삭제된 데이터가 :OLD에 저장된다.

-- 4. 트리거 정의
CREATE OR REPLACE TRIGGER RETIRE_TRIG
    AFTER
    DELETE
    ON EMPLOYEES
    FOR EACH ROW
BEGIN
    INSERT INTO RETIRES(
        RETIRE_ID
      , EMPLOYEE_ID
      , FIRST_NAME
      , LAST_NAME
      , EMAIL
      , PHONE_NUMBER
      , HIRE_DATE
      , JOB_ID
      , SALARY
      , COMMISSION_PCT
      , MANAGER_ID
      , DEPARTMENT_ID
      , RETIRE_DATE
        ) VALUES (
        RETIRES_SEQ.NEXTVAL
      , :OLD.EMPLOYEE_ID
      , :OLD.FIRST_NAME
      , :OLD.LAST_NAME
      , :OLD.EMAIL
      , :OLD.PHONE_NUMBER
      , :OLD.HIRE_DATE
      , :OLD.JOB_ID
      , :OLD.SALARY
      , :OLD.COMMISSION_PCT
      , :OLD.MANAGER_ID
      , :OLD.DEPARTMENT_ID
      , SYSDATE);
END RETIRE_TRIG;

-- 5. 트리거 동작 확인
DELETE
  FROM EMPLOYEES
 WHERE EMPLOYEE_ID = 100;