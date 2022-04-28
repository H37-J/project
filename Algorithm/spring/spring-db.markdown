---
layout:     post
title:      "Spring(DB)"
subtitle:   " \"내가 공부한 DB 정리 \""
date:       2021-08-30 12:00:00
author:     "H37-J"
header-img: "img/post-bg-2015.jpg"
catalog: true
tags:
    - Spring
    - AOP

---


## DB

### JDBC
DB벤더와 개발팀은 JDBC(인터페이스를) 구현한 드라이버를 제공하기 때문에 사용방법은 DB가 변경 되어도 그대로 사용 할 수 있다.

최신 ORM기술도 내부적으로는 DB와의 연동을 위해 JDBC를 이용한다.

#### Spring JDBC가 해주는 일
* Connection 열고 닫기
* Statement 준비와 닫기
* Statement 실행
* ResultSet 루프: ResultSet에 담긴 쿼리 실행 결과가 한건 이상이라면 루프를 돌며 각각 처리해준다
* 에외처리와 변환: JDBC작업 중 발생하는 모든 예외는 스프링 JDBC의 예외 변환기가 처리해준다.
* 트랜잭션 처리

#### DataSource,JDBCTemplate
스프링부트는 Spring-JDBC가 클래스 패스에 존재하면 DB와 관련된 빈들을 자동설정 해준다. 자동등록 되는 빈 중에서 가장 대표적인 빈 두개가 DataSource와 JDBCTemplate이다.

* DataSource는 커넥션 풀을 관리하는 객체인데,자동으로 HikariDataSource를 등록해준다.
* JPDB API템플릿을 쉽게 제공하므로 개발자는 Connection 생성,소멸등을 관리할 필요가 없다.

#### h2콘솔 허용
h2 콘솔을 사용하기 위해서는 spring-dev-tools의존성을 추가한다 그러면 h2-console로 데이터베이스를 확인 할 수 있다.

### 하이버네이트란
JDBC의 코드양을 줄여주고 객체 관계 매핑을 지향한다.



### JPA

#### 의존성 추가
```xml
<dependency>
<groupId> org.springframework.boot </groupId>
<artifactId> spring-boot-starter-data-jpa </artifactId>
</dependency>
```

#### Entity클래스 만들기
```java
@Entity
public class Account{
    @Id @GenerateValue
    private long id;
    private String username;
    private String password;
}
```

#### Repository 만들기
```java
public interface AccountRepository extends JpaRepository<Account,Long>{
    Account findByUsername(String username);
}
```

### Redis
NoSql로 캐시,메시지 브로커,키 밸류 스토어의 데이터베이스다

#### docker
```terminal
docker run -p 6379:6379 --name redis_boot -d redis
docker exec -i -t redis_boot redis-clie

keys *
get {key}
hget {key} {column}
hgetall {key}
```

#### 의존성추가
```xml
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-data-redis</artifactId>
</dependency>
```

#### 코드예시
```java
@Override
public void run(ApplicationArguments args) throws Exception{
    ValuOperation<String,String> values=redisTemplate.opsForValue();
    values.set("key","value"); 값설정
}
```

