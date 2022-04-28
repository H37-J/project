---
layout:     post
title:      "Spring(AOP)"
subtitle:   " \"내가 공부한 AOP 정리 \""
date:       2021-08-30 12:00:00
author:     "H37-J"
header-img: "img/post-bg-2015.jpg"
catalog: true
tags:
    - Spring
    - AOP

---


## AOP
* Aspect:흩어진 관심사를 모듈화 한 것
* Target:어떤 Class를 적용할지
* Advice:어떤 일을 할지.클래스 내 메서드로 정의된다.
* Join Point:Advice가 적용될 수 있는 위치에 대한 정의. 메서드의 명시적 호출,참조에 의한호출,클래스 초기화,객체 인스턴스 생성등이 있다
* Pointcut:구체적인 Advice가 실행될 위치
* Weaving:애플리케이션 코드의 적절한 위치에 애스펙트를 삽입하는 과정. 컴파일 시점 AOP 솔루션에는 일반적으로 위빙은 빌드 시점에 수핸된다. 런타임 AOP 솔루션에는 위빙 과정이 런타엠 동적으로 실행된다.

### 스프링 AOP의 특징
* 프록시 기반의 AOP 구현체
* 스프링 빈에만 적용 가능
* 빈에 AOP를 적용하면 그 빈 자체를 프록시 빈으로 생성한다
* 중복코드,클래스 작성의 번거로움등을 해결하기 위하여 사용

### 예시 코드
```java
@Around("@annotation(PerLogging)")
public Object logPerf(ProceedingJoinPoint pjp) throws Throwable{
    long start=System.currentTimeMillas();
    Object retVal=pjp.proceed();
    System.out.println(System.currentTimeMillis()-start);
    return retVal;
}
```
* @Around안에는 PointCut이 들어간다
* @annotation(PerLogging)은 PerLogging이라는 메서드가 실행될때 Advice를 실행하라는 얘기
* @Around는 메서드 전,후에 실행되고 @Before는 메서드 전에 실행된다

#### 세션검증 Apsect화 
```java
    @Around("@annotation(project.hjk.test.login)")
    public Stirng loginAuth(ProceedingJoinPoint pjp) throws Throwable{
        HttpSession session=null;
        for(Object o:pjp.getArgs()){
            if(o instanceof HttpSession){
                session=(HttpSession)o;
            }
        }

        if(session.getAttribute("User")==null){
            return "memeber/login";
        }
        return (String) pjp.proceed;
    }
```

### 포인트컷 사용법

execution([접근제한자 패턴] 리턴 값 패턴 [타입패턴.] 메소드이름 패턴 (파라미터 타입 패턴))

ex)execution(* getUser(..))는 모든 리턴타입,getUser,모든 매개변수를 의미한다.

```java
@Pointcut("execution(* getUser(..))")
private void all(){}

@Around("all()")
public Object getUser(ProceedingJoinPoint pjp) throws Throwable{
    Object ret=pjp.proceed();
    return ret;
}
```
