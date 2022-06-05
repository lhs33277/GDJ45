-- 숫자 처리 함수


-- 1. 제곱
--    POWER(A, B) : A의 B제곱
SELECT POWER(2, 3)
    FROM DUAL;
    
-- 2. 제곱근(루트)
--    SQRT(A) : A의 제곱근(루트 A)
SELECT SQRT(25)
    FROM DUAL;
    
-- 3. 절대값
--    ABS(A) : A의 절대값
SELECT ABS(-5)
    FROM DUAL;
    
-- 4. 나머지
--    MOD(A, B) : A를 B로 나눈 나머지
SELECT MOD(5, 2)
    FROM DUAL;
    
-- 5. 부호 판별
--    SIGN(A) : A가 양수이면 1, 음수이면 -1, 0이면 0
SELECT SIGN(5)
    FROM DUAL;
    
-- 6. 올림
--    CEIL(A) : 실수 A의 정수 올림
SELECT CEIL(1.1)
    FROM DUAL;

-- 7. 내림
--    FLOOR(A) : 실수 A의 정수 내림
SELECT FLOOR(1.9)
    FROM DUAL;

-- 8. 절사
--    TRUNC(A, [DIGITT]) : 실수 A의 DIGITT 자릿수 절사, DIGITT 생략되면 정수로 절사
SELECT
      TRUNC(1.999)      -- 1    (소수점 절사)
    , TRUNC(1.999, 1)   -- 1.9  (소수 1자리)
    , TRUNC(1.999, 2)   -- 1.99 (소수 2자리)
    , TRUNC(199.9, -1)  -- 190  (1의자리 절사/ 원 단위 절사)
    , TRUNC(199.9, -2)  -- 100  (10 단위 절사)
    FROM DUAL;
    
-- 내림과 절사의 차이
-- 음수 처리에서 발생
SELECT FLOOR(-1.9)  -- -2 (내림 :  -1.9보다 작은 정수)
    FROM DUAL;
      
SELECT TRUNC(-1.9)  -- -1 (절사 : 정수 아래 잘라 버림)
    FROM DUAL;

-- 9. 반올림
--    ROUND(A, [DIGIT]) : 실수 A의 DIGITT 자릿수 반올림, DIGITT 생략되면 정수로 반올림
SELECT
      ROUND(145.45)     -- 145
    , ROUND(145.45, 1)  -- 145.5
    , ROUND(145.45, -1) -- 150
    FROM DUAL;


-- 문제1. 1.11을 소수 1자리로 올림 처리하시오. (결과 1.2)
SELECT CEIL(1.11 * 10) / 10
    FROM DUAL;

-- 문제2. 1.111을 소수 2자리 올림 처리하시오. (결과 1.12)
SELECT CEIL(1.111 * 100) / 100
    FROM DUAL;

-- 문제3. 111을 1의 자리 올림 처리하시오. (결과 120)
SELECT CEIL(111 * 0.1) / 0.1
    FROM DUAL;

-- 문제4. 111을 10의 자리 올림 처리하시오. (결과 200)
SELECT CEIL(111 * 0.01) / 0.01
    FROM DUAL;

-- 문제5. A를 DIGIT 자리 올림 처리하시오.
SELECT CEIL(A * POWER(10, DIGIT)) / POWER(10, DIGIT)
    FROM DUAL;
    
-- 문제6. A를 DIGIT 자리 내림 처리하시오.
SELECT FLOOR(A * POWER(10, DIGIT)) / POWER(10, DIGIT)
    FROM DUAL;
