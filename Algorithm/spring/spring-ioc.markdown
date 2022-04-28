---
layout:     post
title:      "Spring(Ioc-Container)"
subtitle:   " \"내가 공부한 Ioc-Container 정리 \""
date:       2021-08-30 12:00:00
author:     "H37-J"
header-img: "img/post-bg-2015.jpg"
catalog: true
tags:
    - Spring
    - Validator

---


## IOC컨테이너와 Bean
Ioc란 객체가 내부적으로 조작할 객체를 직접 생성하지않고 외부로부터 주입받는 기법을 의미한다. 이때 객체를 외부로부터 주입해주는 작업을 DI(의존성 주입)이라 한다.

 IOC컨테이너는 객체의 생성과 관계설정,사용,제거등을 대신하여 준다고 해서 붙은 이름이다. 이떄 Ioc Container에 의해 관리되는 오브젝트를 Bean이라 한다. IoC Container는 Bean을 저장한다하여 BeanFactory라고도 불린다. BeanFactory는 하나의 인터페이스이며, Application Context는 BeanFactory의 구현체를 상속받고 있는 인터페이스이다. 실제로 IoC Container라고 불리는 것은 Application Context의 구현체이다

### WebApplicationContext
![웹환경애플리케이션2](./images/웹환경애플리케이션_2.png)


웹 환경에서의 스프링은 클라이언트의 요청을 전부 받는 FrontController,DispatcherServlet을 제공한다. DispatcherServlet은 자체적으로 ApplicationContext를 생성하고,Root Application Context를 부모로 등록한다.

Dispatcher은 자체적으로 ApplicationContext를 생성하고 사용한다.
이를 ServletContext라고도 부른다. 이외에도 RootApplicationContext가 하나 존재하는데, 이는 Ajax Engine, JSP등에서 Spring IoC의 기능을 사용 할 수 있도록 하기 위함이다.
스프링 밖의 어디서라도 WebApplicationContextUtils.getWebApplicationCOntext(ServletContext sc)를 호출하면 루트 어플리케이션 컨텍스트를 가져올 수 있다.

![설정메타정보1](./images/설정메타정보1.png)
메타정보 중 반드시 들어가야 하는것은 클래스 이름과 빈의 이름이다.
빈의이름은 명시하지 않는 경우 클래스 이름에서 첫글자를 소문자로 바꿔사용하게 된다. 메타정보를 작성하는 방법은 크게 XML,@Configuration,@Component 등록 세 가지로 나뉜다.

### XML을 이용한등록
```xml
* id와 클래스를 필수적으로 지정한다
* property는 DI작업을 위해 준재한다. printer라는 속성에 myPrinter라는 빈을 주입한다(DI)
<bean id="hello" class="me.hjk.test.bean.Hello>
    <property name="printer" ref="myPrinter">
</bean>
```
스프링 부트가 도입된 후 잘 사용되지 않는다.


### 자동인식을 이용한 빈 등록
빈 스캐너는 지정된 클래스패스 밑에 있는 모든 패키지의 클래스를 대상으로 특정 애노테이션이 존재하는지를 파악하고 이를 빈으로 등록한다. 빈 스캐너에 의해 필터링 되는 애노테이션을 스테레오타입 애노테이션이라고 부른다. 주로 사용하는 스테레오 타입 에노테이션은 다음과 같다.

* @Component:빈으로 지정하는 가장 기본적인 애노테이션
* @Repository:데이터 액세스 계층의 DAO 또는 리포지토리 클래스에 사용된다.
* @Service:서비스 계층의 클래스에 사용된다.
* @Controller:MVC컨트롤러에 사용된다. 스프링 웹 서블릿에 의해 웹 요청을 처리하는 컨트롤리 빈으로 선정된다.

### 빈 등록 방법(@Configuration,@Bean)
```java
@Configuration
public class AnnotationConfig{
    @Bean
    public Hello hello(Printer printer){
        return new Hello(Printer);
    }

    @Bean
    public Printer printer(){
        return new Printer();
    }
}

```

* @Configuration 또한 @Component를 사용하기 때문에 빈 스캐너에 의해 자동 검색 된다.
* @Configuration를 사용한 클래스 자체도 Bean으로 등록된다.
* @Bean으로 등록된 메서드의 return 객체를 Bean으로 등록한다.
* @Bean("name")으로 이름을 지정 할 수 있으면 이름을 지정하지 않을시 메서드명이 id가 된다.
* new연산을 사용하지만,매번 다른 객체가 생성되지 않고 싱글톤으로 DI된다.

### @Autowired/@Injected를 이용한 DI
@Autowired는 의존 객체의 타입에 해당하는 빈을 찾아 주입한다.
Setter,Field,Constructor에 붙여 사용 할 수 있다
```java
public class Hello{
    @Autowired
    private Printer printer;
}
```

### 타입이 동일한 빈이 2개이상인 경우

#### primary
같은 타입의 빈이 여러 개 일때, 가장 우선순위를 높게 줄 빈을 설정한다

#### Qualifier
Qualifier("빈 이름")으로 어떤 빈을 주입할 지 명시함

## 스코프

### 싱글톤
스프링의 빈은 싱글톤으로 만들어진다. 싱글톤으로 생성된 빈의 경우DI,DL 어떤 경우에도 동일한 오브젝트를 얻어온다. 따라서 싱글톤의 필드에는 의존관계에 있는 빈에 대한 레퍼런스타 읽기전용 값만 저장해두고,DTO와 같은 변수는 파라미터나 리턴값으로 전달하는 것이 바람직하다.

## ApplicationContext 부가기능

### 이벤트 만들기
```java
public class Event{
    private int data;
    private String alias;

    public Event(int data,String alias){
        this.data=data;
        this.alias=alias;
    }
}
```

### 이벤트 발생시키기
```java
@Autowired
ApplicationEventPublisher applicationEventPublisher;

@Override
public void run(ApplicationArguments args) throws Exception{
    applicationEventPublisher.publishEvent(new Event(10,"hjk"));
}
```

### 이벤트 처리하기
```java
@Component
public class EventHandler{
    
    @EventListener
    public void handle(Event event){
        System.out.println(Thread.currentThread().toString());
        System.out.println(event.toString());
    }
}
```

## Rgistry 등록
스프링 부트라면 자동으로 등록되는 빈들이 있지만 아니라면 다음과 같이 등록 해주어야 한다.

```java
@Configuration
public class WebConfig implements WebMvcConfigurer{

    @Override
    public void addFormatters(FormatterRgistry registry){
        registry.addConverter(new EventConverter.StringToEventConverter());
    }

    @Override
    public void addFormatters(FormatterRegistry registry){
        registry.addFormater(new EventFormatter());
    }
}
```