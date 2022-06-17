## JOIN
SELECT U.NAME FROM USER AS U INNER JOIN CUSTOMER AS C ON U.ID = C.ID
-- 유저아이디랑 고객 아이디 같은 값만 출럭

## GROUP
SELECT animal_type as ANIMAL_TYPE, count(*) as count from animal group by animal_type order by ANIMAL_TYPE

SELECT name, count(name) from animal where name is not null group by name having count(name) >= 2 order by name
-- 같은 이름인 동물 찾기

## NULL
SELECT animal_id from animal where name is null

## IN
SELECT ANIMAL_ID FROM animal where name in ('hjk', 'hjk2')

## if
SELECT animal_id, name, if(sex like '%Neutered%' or sex like '%Spayed%', 'o', 'x') as '중성화' from animal order by animal_id

## 서브쿼리
SELECT ID, RooNum FROM Reservation WHERE Name IN (SELECT Name FROM Customer where address='서울')