-- 날짜 처리 함수


-- 1. 현재 날짜 및 시간
--   SYSDATE, SYSTIMESTAMP

SELECT
        SYSDATE
      , SYSTIMESTAMP
  FROM DUAL;

-- 2. 날짜 연산
--    1) 하루를 숫자 1로 처리한다.
--    2) 12시간을 숫자 0.5로 처리한다.
--    3) +, - 연산이 가능하다.
SELECT
       SYSDATE - 1 AS 어제
     , SYSDATE     AS 오늘
     , SYSDATE + 1 AS 내일
     , SYSDATE - 0.5 AS "12시간 전"     -- AS 별명엔 숫자로시작하거나 공백이 불가
     , SYSDATE + 0.5 AS "12시간 후"
     , TO_CHAR(SYSDATE - 0.5, 'yyyy-mm-dd hh24:mi:ss') AS "12시간 전"
     , TO_CHAR(SYSDATE + 0.5, 'YYYY-MM-DD HH24: MI:SS') AS "12시간 후"
  FROM DUAL;

-- 3. 단위(연, 월, 일, 시, 분, 초) 추출
--    EXTRACT(단위 FROM 잘짜)
SELECT
       EXTRACT(YEAR  FROM SYSDATE) AS 년도
     , EXTRACT(MONTH FROM SYSDATE) AS 월
     , EXTRACT(DAY   FROM SYSDATE) AS 일
     , EXTRACT(HOUR   FROM SYSTIMESTAMP) AS 시   -- UTC(표준시) 시간 기준
     , EXTRACT(TIMEZONE_HOUR FROM SYSTIMESTAMP) AS 시    -- TIMEZONE 설정 후 사용
     , EXTRACT(MINUTE FROM SYSTIMESTAMP) AS 분
     , EXTRACT(SECOND FROM SYSTIMESTAMP) AS 초
     , FLOOR(EXTRACT(SECOND FROM SYSTIMESTAMP)) AS 초
  FROM DUAL;


-- 참고. 단위(년, 월, 일, 시, 분, 초) 추출은 TO_CHAR 함수 사용 가능
SELECT TO_CHAR(SYSDATE, 'HH24')
  FROM DUAL;


-- 4. N개월 전후 날짜 반환
--    ADD_MONTHS(날짜, N)
SELECT
       ADD_MONTHS(SYSDATE, 1) AS "1개월 후"
     , ADD_MONTHS(SYSDATE, -1) AS "1개월 전"
  FROM DUAL;


-- 5. RUDRHK RODNJF TN QKSGHKS
--    MONTHS_BETWEEN(날짜1, 날짜2) : 날짜1 - 날짜2 방식으로 경과한 개월 수 반환
--    MONTHS_BETWEEN(최근, 이전)
SELECT MONTHS_BETWEEN(SYSDATE, HIRE_DATE)
  FROM EMPLOYEES;