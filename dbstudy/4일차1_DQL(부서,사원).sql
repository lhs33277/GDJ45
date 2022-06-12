/*
    DQL(Data Query Language

    1. 데이터 질의어
    2. 특정 테이블의 칼럼을 조회하거나 값을 조회한다.
    3. DB의 변경이 없다.
    4. 형식
        select 칼럼
            from 테이블
        [where 조건]
        [group by 그룹화]
        [oder by 정렬]        // 오름차순 내림차순
*/

-- 1. 사원(EMPLOYEE) 테이블에서 사원명(NAME)을 조회하시오.
select name
    from employee;
    
-- 칼럼 앞에 오너(OWNER)를 명시할 수 있다.   *오너 : 칼럼이 속한 테이블
select employee.name
    from employee;
    
-- 테이블에 별명(ALIAS)을 주고, 이를 오너로 명시할 수 있다.
select e.name
    from employee e;    -- EMPLOYEE 테이블의 별명은 e 이다.
    
-- 조회할 칼럼에 별명(ALIAS)을 줄 수 있다.
select name as 사원명  -- NAME칼럼의 별명은 사원명이다.
    from employee;
    
    
--2. 사원 테이블의 모든 칼럼을 조회하시오.
-- * : 모든 칼럼을 의미한다.
-- 중요 : 실무에서는 *를 사용하지 않는다. (성능 이슈)
select *
    from employee;
    
-- 모든 칼럼이 필요하면 모두 적기
select emp_no, name, depart, position, gender, hire_date, salary
    from employee;
    
    
-- 3. 부서(DEPARTMENT) 테이블의 지역명(LOCATION) 칼럼을 조회하시오.
select location
    from department;
    
-- distinct  중복을 제거한다.
select distinct location
    from DEPARTMENT;
    
    
-- 4. 사원테이블에서 직급(POSITION)이 '과장'인 사원의 이름(NAME)을 조회하시오.
select name
    from employee
    where position = '과장';
    

-- 5. 사원테이블에서 급여(SALARY)가 5000000 이상인 사원의 이름(NAME)과 직급(POSITION)을 조회하시오.
select name, position
    from employee
    where salary >= 5000000;


-- 6. 사원테이블에서 급여(SALARY)가 2000000 ~ 4000000 사이인 사원의 이름(NAME)과 급여(SALARY)를 조회하시오.
select name, salary
  from employee
 -- where salary >= 2000000 and salary <= 4000000;
 where salary between 2000000 and 4000000;


-- 7. 사원테이블에서 고용일(HIRE_DATE)이 '90/01/01'~'99/12/31' 사이인 사원의 이름(NAME)과 고용일(HIRE_DATE)를 조회하시오.
select name, hire_date
  from employee
 where hire_date between '90/01/01' and '99/12/31';
 
select name, hire_date
  from employee
 where to_date(hire_date, 'yy/mm/dd') between to_Date('90/01/01', 'yy/mm/dd') and to_date('99/12/31', 'yy/mm/dd');
 
 
-- 8. 사원테이블에서 직급(POSITION)이 '과장', '부장'인 사원의 이름(NAME)과 부서번호(DEPART)를 조회하시오.
select name, depart
  from employee
 where position = '과장' or postion = '부장';
   
select name, depart
  from employee
 where position in('과장','부장');  -- 추천
   
 
-- 9. 부서테이블에서 지역(LOCATION)이 '대구'인 지역의 부서명(DEPT_NAME)을 조회하시오.
select dept_name
  from department
 where location = '대구';
  
select dept_name
  from department
 where location in('대구');
 
 
-- 10. 사원테이블에서 성별(GENDER)이 NULL이 아닌 사원의 이름(NAME)을 조회하시오.
select name
  from employee
 where gender is not null;


-- 11. 부서테이블에서 부서명(DEPT_NAME)에 '무'가 포함된 부서의 모든 칼럼을 조회하시오.
-- 만능문자 : %, _
-- 문자 데이터를 대상으로 만능문자를 사용한다.
select dept_no, dept_name, location
  from department
 where dept_name like '%무%';
 
 
-- 12. 사원테이블에서 사원명(NAME)이 '김'으로 시작하지 않는 사원의 사원명(NAME)을 조회하시오.
select name
  from employee
 where name not like '김%';
 
 
-- 13. 사원테이블에서 급여(SALARY)가 높은 사원부터 낮은 사원순으로 사원명(NAME)과 급여(SALARY)를 조회하시오.
select name, salary
  from employee
 order by salary desc;


-- 14. 사원테이블의 모든 칼럼을 사원명(NAME)의 가나다순으로 조회하시오.
select emp_no, name, depart, position, gender, hire_date, salary
  from employee
 order by name;


-- 15. 사원테이블의 모든 칼럼을 부서(DEPART)별로 오름차순 정렬하되, 같은 부서내에서는 고용일(HIRE_DATE)의 오름차순으로 정렬하여 조회하시오.
select emp_no, name, depart, position, gender, hire_date, salary
  from employee
 order by depart, hire_date;