---
layout:     post
title:      "Spring(concept)"
subtitle:   " \"내가 공부한 concept 정리 \""
date:       2021-08-30 12:00:00
author:     "H37-J"
header-img: "img/post-bg-2015.jpg"
catalog: true
tags:
    - Spring
    - concept

---


## 스프링 개념정리

### 스프링이란?
* 스프링은 웹 개발뿐만 아니라 어떤 형태의 자바 애플레키이션(단독 실행형 웹,JEE애플리케이션등)이라도 개발 할 수 있게해준다
* 경량프레임워크라고 하는데 여기서 경랑은 모듈의 크기등을 말하는 것이 아니라 스프링은 스프링 코어를 활용할 때 기존 애플리케이션 코드를 거의 바꾸지 않아도 된다는점에서 매우 가볍다는 이야기다. 또한 더는 사용하지 않으려고 할 때도 손쉽게 제거 할 수 있다.


#### 구성
![스피링 기본개념](./images/concept1.jpg)

* 스프링 코어:빈 컨테이너와 유틸리티 지원
* 스프링 컨텍스트:ApplicationContet, UI,유효성검증,JNDI,엔터프라이즈 자바빈즈,리모팅,메일지원
* 스프링 DAO:트랜잭션 인프라,JDBC(Java Database Connectivity),DAO(Data Access Object)
* 스프링 ORM:하이버네이트(Hibernate),ibatis,JDO
* 스프링 AOP:관점지향 프로그래밍 구현
* 스프링 Web:멀티파트처리,서블릿 리스너를 통한 컨텍스트 초기화, 웹애플리케이션 컨텍스트와 같은 기본적인 통합기능 
* 스프링 MVC:웹 기반 프레임워크


#### 2.5이후 추가된 기능
* 새로운 @Autowired추가
* 새로운 스테레오 타입 애너테이션:@Component,@Reopsitory,@Service,@Contorller
* 스테레오타입 애너테이션으로 구성되니 클래스 감지 및 와이어링을 위한 자동 클래스 경로 검색 지원
* ApectJ로드타임 위빙을 포함하는 AOP기능 개선
* 완전한 웹스피어 트랜잭션 관리 지원
  

### 제어역전에 대하여
이는 자바빈+인터페이스 두가지 핵심적인 자바 개념을 기반으로한다.
인터페이스를 사용하면 빈이 의존성을 충족시키는 인터페이서의 어떤 구현체라도 사용할 수 있어 DI의 활용을 극대화 할 수 있다. 또한 JDK의 동적 프록시를 활용해 크로스커팅 관심사에 대해 AOP와 같은 강력한 기능을 사용 할 수 있다.

#### DI의 장점
* 코드의 결합 감소
* 애플레케이션 구성의 단순화
* 단일 저장소에서 공통 의존성 
* 테스트 편의성 향상
  

### 모듈목록
* orm: 이 모듈은 스프링 표준 JDBC기능을 확장해 하이버네이트,JDO,JPA데이터 매퍼인 아이바티스처럼 널리 사용되는 ORM도구를 지원한다. 
* web:웹 기반 애플리케이션이 스프링을 시작하는데 필수적인 클래스들이 들어있다.웹 애플리케이션 시작시 자동으로 ApplicationContext를 시작하게 하는 클래스와 파일업로드,지원클래스,URL의 쿼리문자열에서 정수값을 잘라내는것과 같은 반복적인 작업에 유용한 많은 클래스가 포함되어 있다.
* core:모든 스프링 기반 애플리케이션에 필요한 핵심 모듈의 집합이다.
* context:스프링 코어의 기능을 확장한 많은 클래스가 들어있다. ApplicationContext기능을 사용하는데 필요한 클래스 및 엔터프라이즈 자바빈(EJB),JNDI(Java Naming Directory Interafce),JMX(Java Management Extension)연동에 필요한 모든 클래스가 들어있다.

### 기본 자바 코드를 스프링식으로 모듈화 해보기

#### 문자열을 출력하는 코드를 모듈화
```java
public static void main(String... args){
    if(args.length>0){
        System.out.println(args[0]);
    }else{
        System.out.println("Default Message");
    }
}
```

위와 같은 방식은 메시지를 가져오는 방식을 변경하면 메시지를 출력하는 코드도 바뀐다.
이를 컴포넌트는 인터페이스를 구현하고 실행자는 이 인터페이스를 실행 하도록 바꾸어보자.

#### 메서드를 가져오는 부분을 인터페이스화
```java
public interface MessageProvier{
    String getMessage();
}
```

#### 메서드를 출력하는 부분 인터페이스화
```java
public interface MessageRender{
    void render();
    void setMessageProvider(MessageProvider provider);
    MessageProvider getMessageProvier();
}
```

* 위의 인터페이스 메서드 구성중 하나는 render()이고 하나는 자바빈 스타일 setMessageProvider이다
* MessageRender구현 클래스는 메세지를 가져오는 로직과 분리되어 있으며 MessageProivider에게 메세지를 가져오는 책임을 위임한다

#### MessageProvider를 구현한 클래스 작성
```java
public class HellMessageProvider implements MessageProvider{
    @Override
    public String getMessage(){
        return "Hell";
    }
}
```

#### MessageRender를 구현한 클래스 작성
```java
public class CustomMessageRender implements MessageRender{
    private MessageProvider messageProvider;

    @Override
    public void render(){
        if(messageProvider==null){
            throw new RuntimeException("Error!!"+CustomMessageRender.class.getName());
        }
        System.out.pritnln(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider){
        this.messageProivder=messageProvider;
    }

    @Override   
    public MessageProivder getMessageProvider(){
        return this.messageProider;
    }
}
```

#### 구한한 클래스를 사용
```java
public static void main(String... args){
    MessageRender mr=new CustomMessageRender();
    MessageProvider mp=new HellMessageProvider();
    mr.seteMessageProvider(mp);
    mr.render();
}
```
위와같이 인터페이스를 만들고 클래스를 통하여 구현하여 사용하면 서로 의존성을 가지 않는다. 즉 결합도가 낮아진다.

#### 애플리케이션 실행 도중 속성 파일에서 구현 클래스 이름을 읽어 인스턴스로 만드는 팩터리 클래스 작성
```java
public class MessageFactory{
    private static MessageFactory instance;
    private Properties props;
    private MessageProvider provider;
    private MssageRednerer renderer;

    private MessageFactory(){
        props=new Properties();

        try{
            props.load(this.getClass().getResourceAsStream("/msf.properties"));
            String renderClass=props.getProperty("render.class");
            String providerClass=props.getPropery("provider.class");

            renderer=(MessageRender)Class.forName(renderClass).newInstance();
            provider=(MessageProvider)Class.forName(providerClass).newInstance();
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }

    static{
        instance=new MessageFacotry();
    }

    public static MessageFacotry getInstance(){
        return instance;
    }

    public MessageRenderer getMessageRenderer(){
        return renderer;
    }

    public MessageProvider getMessageProvider(){
        return provider
    }

}

```

#### 팩토리 클래스 사용법
```java
public void main(String... args){
    MessageRenderer mr=MessageFactory.getInstance().getMessageRenderer();

    MessageProvider mp=MessageFactory.getInstance().getMssageProvider();
    mr.setMessageProvider(mp);
    mr.render();
}
```

#### 남은 문제
코드의 작성야이 너무 많고, MessageRenderer 구현체에 직접 MessageProvider인스턴스를 제공해야 했다. 이를 해결하기 위하여 ApplicatioinContext인터페이스가 있다. ApplicationContext는 스프링이 관리하는 범위 내에 있는 모든 환경 정보를 제공한다. 이 인터페이스는 ListableBeanFactory라는 인터페이스를 상속해 스프링이 관리하는 모든 빈 인스턴스에 대한 공급자 역할을 한다.

#### 스프링으로 리팩터링 하기
```java
public static void main(String args){
    ApplicationContext ctx=new ClassPathXlApplicationContext("spring/app-context.xml");
    MessageRender mr=ctx.getBean("renderer",MessageRender.class);
    mr.render();
}
```

* app-context.xml
```xml
<bean id="provider" class="com.hjk.test.MessageProvider"/>

<bean id="renderer" class="com.hjk.test.MessageRender" p:messageProvider-ref="provider"/>
```

#### 애너테이션을 이용한 스프링 구성
버전 3.0부터 무조건 XML을 사용하지 않아도 되게 되었다.
@Configuration이나 ComponentScan을 붙여 애플리케이션 내의 빈 정의를 정의한다
위에서 작성한 XML은 다음과 같이 변경 할 수 있다.

```java
@Configuration 
public class MessageConfiguration{

    @Bean
    public MessageProvider provider(){
        return new MessageProvider();
    }

    @Bean
    public MessageRenderer renderer(){
        return new MessageRenderer();
    }
```
#### ApplicationContext의 변경
```java
public static void main(String... args){
    ApplicationContext ctx=new AnnotationConfigApplicationContext(MessageConfiguration.class);
    MessageRenderer mr=ctx.getBean("renderer",messageRenderer.class);
    mr.render();
}
```


### IOC와 DI의 주된 목적
컴포넌트의 의존성을 제공하고 이러한 의존성을 라이프사이클 전반에 걸쳐 관리하는 보다 편한 메커니즘을 제공한다. 의존성이 필요한 컴포넌트를 의존 객체라 하고 IoC에서는 대상이라고 한다.일반적으로 IOC는 의존성 주입(DI)와 의존성 룩업(DL)로 나뉜다.
의존성 룩업에는 컴포넌트 스스로 의존성 참조를 가져와야 하지만 의존성 주입에서는 IOC컨테이너가 컴포넌트에 의존성을 주입한다.

일반적으로 컨테이너는 톰캣같은 서버나 스프링 같은 애플리케이션 프레임워크에서 제공한다.

#### 컨테이너에서 의존성을 가져오는 컴포넌트
interface
```java
public interface ManageComponent{
    void performLookup(Container container);
}

public interface Container{
    Object getDependency(String key);
}
```

```java
public class MessageLookup implements ManageComement{
    private Dependency dependency;

    @Override
    public void perfomLookup(Container container){
        this.dependency=(Dpendency)container.getDepency("myDependency");
    }

    @Override
    public String toString(){
        return dependency.toString();
    }
}
```

#### 생성자를 이용한 의존성 주입방법
```java
public class ConstructorInjection{
    private Dependency dependency;

    public ConstructorInjection(Dependency dependency){
        this.dependency=dependency;
    }

    @Ovierrde
    public String toString(){
        return dependency.toString();
    }
}
```

### 수정자 의존성 주입
```java
public class SetterInjection{
    private Dependency dependency;

    private void setDependency(Dependency dependency){
        this.dependency=dependency;
    }

    @Override
    public String toString(){
        return dependency.toString();

    }
}
```

### 의존성 주입vs의존성 룩업
의존성 주입을 이용하면 사용자 클래스는 협렵 객체를 의존 객체에게 제공하는 IoC컨테이너와 완전히 분리되어 자유롭게 사용 할 수 있는 반면에 룩업을 이용하면 사용자 클래스느는 컨테이너에 의해 정의된 클래스와 인터페이스에 항상 의존하게 된다.
따라서 스프링에서는 의존성 주입을 사용하는게 좋다.

### 생성자 주입vs수정자 주입
생성자 주입은 컴포넌트 사용전에 해당 컴포넌트의 의존성을 반드시 갖고 있어야 할 떄 유용하다. 또한 빈 객체를 불변객체로도 사용 할 수 있다.수정자 주입은 인터페이스에서 모든 의존성을 선언 할 수 있다는 장점이 있다. 스프링에서는 수정자 주입이 더 좋다.

#### 예시
```java
public interface Oracle{
    String isOracle();
}

public class MyOracle implements Oracle{
    private Sql sql;

    public void setSql(Sql sql){
        this.sql=sql;
    }

    @Override
    public String isOracle(){
        System.out.pritnlin("sql");
    }
}
```
위 클래스는 Oracle인터페이스를 구현 했을뿐만 아니라 생성자 의존성 주입도 정의 하였다. 스프링은 이와 같은 구조를 더 선호한다. 이렇게 특정 비즈니스 인터페이스의 모든 구현체들이 어떤 특정한 의존성을 필요로 한다고 완전히 확신 할 수 없다면 구현 클래스 각각이 자신의 의존성을 각자 정의하고 비즈니스 인터페이스는 비즈니스 메서드에만 유지해야 한다.

### 뉴스레이터 인터페이스
```java
public interface NewletterSender{
    voidi setSmtpServer(String stmpServer);
    String getSmtpServer();
    void setFromAddress(String fromAddress);
    String getFromAddress();
    void send();
}
```

* 수정자 주입의 가장 큰 장점은 주입 메커니즘을 자유 자재로 사용할 수 있다는 것이다. 생성자를 새로 생성하지 않아도 의존성을 변경 할 수 있기 때문이다
* 생성자로 주입자를 생성하는 경우에는 컴포넌트에 의존성 주입을 보장하거나 불변객체를 설계하는 경우에 좋다.

### 빈과 빈 팩토리
스프링의 의존성 주입 컨테이너의 핵심은 빈 팩터리 인터페이스다. 컴포넌트를 관리하는 BeanFactory는 컴포넌트의 라이프 사이클 뿐만 아니라 의존성까지 관리한다. 스프링에서 빈이라는 단어는 컨테이너가 관리하는 모든 컴포넌트를 의미한다. ApplicationContext는 BeanFactory를 상속하여 구현되었다.

### 필드 주입에 대하여
```java
@Service("user")
public class user{
    @Autowired
    private Customer customer
    public void buy(){
        customer.buy();
    }
}
```

```java
@Component
public class Customer{
    
    private void buy(){

    }
}
```

필드 주입의 단점
* 의존성을 추가하기 쉽고 코드가 간단해지지만 단일 책임 원칙을 위반하지 않도록 주의해야한다. 더 많은 의존성이 생기면 클래스에 대한 책임이 커지므로 리팩터링 시에 관심사를 분리하기 어려울 수 있습니다.클래스가 비대해지는 상황은 생성자나 수정자 주입자라면 쉽게 알 수 있지만 필드 주입은 그렇지 않다.
* 필드 주입은 final 필드에는 사용 할 수 없다
* 수동으로 주입해야한다

### 싱글턴
스프링의 모든 빈은 기본적으로 싱글턴 인스턴스로 생성되며 스프링은 해당 빈에 대한 모든 요청을 동일한 인스턴스를 사용해 수행한다.

```java
public class Singleton{
    private static Singleton instance;

    static{
        instance=new Singleton();
    }

    public static Singleton getInstance(){
        return instance;
    }
    
}
```

싱글턴의 특징은 다음과 같다.
* 상태가 없는 공유 객체:상태를 유지하지 않으며 많은 의존 객체를 가지는 경우가 있다. 상태가 없으면 동기화 할 필요가 없으므로 의존 객체가 자신의 로직 처리를 위해 어떤 빈을 사용할 때마다 새 인스턴스를 사용 할 필요가 없다.
* 읽기 전용 상태를 갖는 공유객체

IoC컨테이너의 요약 키워드: BeanFactory,ApplicationContext,GenericXmlApplicatioinContext,AnnotationConfigApplicationContext

### XML bean생성법
```xml
기본적인 사용법 
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

<bean id="parent" class="com.hjk.user" p:name="hjk" p:age="28" >

<bean id="child" class="com.hjk.user p:naem="hani" p:age="5">
</beans>
```

프로퍼티 빈 참조(ref)
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
    xmlns:p="http://www.springframework.org/schema/p"
    xsi:schemaLocation="http://www.springframework.org/schema/beans
        http://www.springframework.org/schema/beans/spring-beans.xsd">

<bean id="rednerer" class="com.hjk.rednerer" 
ref="provider">

<bean id="provider" class="com.hjk.provider>
</beans>
```

생성자시 값 주입
```xml
<bean id="contructor" class="com.hjk.user">
    <constructor-arg>
        <value>99</value>
    </constructor-arg>
</bean>
```

컴포넌트 스캔
```xml
<context:component-scan base-package="com.hjk.user">
```

```java
public static void main(String... args){
    GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
    ctx.load("classpath:spring/app-context-xml.xml");
    ctx.refresh();
    User user=(User)ctx.getBelan("User");
    System.out.println(user);
    ctx.close
}
```


### Bean애너테이션 인터페이스
```java
@Target({ElementType.METHOD,ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @Interface Bean{
    @AliasFor("name")
    String value() default{};

    @AliasFor("value")
    String name() default();
}
```

### 빈 라이프사이클 관리
스프링을 포함한 모든 IoC컨테이너가 제공하는 주요 기능 중 하나는 생성이나 소멸 같은 빈 라이프사이클의 특정 시점에 통지를 받을 수 있게 빈을 생성하는 기능이다.
빈이 라이프사이클 이벤트 통지를 받을 수 있게 설정하면 해당 빈은 이벤트 발생 시점에 관련 처리를 할 수 있다.초기화 이후 소멸이전이 대표적이다.

### MessageDigester빈 예시
MessageDigester은 무언가를 암호화 할 때 사용한다.

```java
public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean{
    private String algorithms="MD5";

    private MessageDigest messageDigest=null;

    public MessageDigest getObeject() throws Exception{
        return messageDigest;
    }

    public Class<MessageDigest> getObjectType(){
        return MessageDigest.class;
    }
    
    public boolean isSingleton(){
        return true;
    }

    public void afterPropertiesSet() throws Exception{
        messageDigest=MessageDigest.getInstance(algotihmname);
    }

    public void setAlgorithm(String algorithmname){
        this.algorithname=algorithmname;
    }
}
```


```java
public class MessageDigester{
    private MessageDigest digest1;
    private MessageDigest digest2;

    public void setDigest1(MessageDigest digest1){
        this.digest1=digest1;
    }

    public void setDigest2(MessageDigest digest2){
        this.digest1=digest2;
    }

    public void digest(String msg){
        digest(msg,digest1);
        digest(msg,digest2);
    }

    public void digest(String msg,MessageDigest digest){
        digest("사용하는 알고리즘"+digest.getAlgorithm());
        digest.rest();
        byte[] byte=msg.getBytes();
        byte[] out=digest.digest(bytes);
        System.out.printiln(out);
    }
}
```

```xml
<bean id="shDigest" class="com.hjk.test.MessageFactroyBean" p:algorithmName="SHA1"/>
<bean id="defaultDigest" class="com.hjk.test.MessageFactroyBean" >
<bean id="digester" class="com.hjk.test.MessageDigester" p:digest1-ref="shaDigest" p:digest2-ref="defaultDigest"/>

```

### 자바 구성 클래스로 구현
```java
public class MessageDigestConfi{
    
    @Configuration 
    static class  MessageDigestConfig{

        @Bean
        public MessageDigestFactroyBean shaDigeset(){
            MessageDigestFactoryBean factoryOne=new MessageDigesterFactoryBean();
            factroyOne.setAlgotirhmName("SHA1");
            return factoryOne;
        }

        @Bean 
        public MessageDigestFactoryBean defaultDigest(){
            return new MessageDigestFactoryBean();
        }

        @Bean MessageDigester digester() throws Exception{
            MessageDigester messageDigeseter=new MessageDigeseter();
            messageDigester.setDigest1(shaDigest().getObject());
            messageDigeester.setDigest2(defaultDigest().getObject());
            return messageDigester;
        }
    }

    public static void main(String... args){
        GenericApplicationContext ctx=new AnnotationConfigApplicationContext(MessageDigestConfig.class);

        MessageDigester digester=(MessageDigester)ctx.getBean("digester");
        digest.digest("test string");
        ctx.close():
    }


}
```

### Message예시를 XML을 대체하기
app-context.xml파일을 구성 클래스라 불리는 특수 클래스로 교체 해야한다.
여기서 @Configuration을 사용한다. 이 클래스에는 빈 정의르르 나타내는 @Bean애너테이션이 적용된 메서드가 들어있다.
@Bean은 스프링 빈과 DI 요구사항을 정의하는데 사용한다. 

Appconfig
```java
@Configuration
public class AppConfig {
    
    @Bean
    public MessageProvider messageProvider(){
        return new MessageProviderImpl("기본 메시지");
    }

    @Bean
    public MessageRender messageRender(){
        MessageRender render=new MessageRenderImpl();
        render.setMessageProvider(messageProvider());
        return render;
    }
}
```

MessageProivder 인터페이스
```java
public interface MessageProvider {
    String getMessage();
}
```

MessageProivder 구현체
```java

public class MessageProviderImpl implements MessageProvider {
    
    private String message="Default Message";

    public MessageProviderImpl(){

    }

    public MessageProviderImpl(String message){
        this.message=message;
    }

    public void setMessage(String message){
        this.message=message;
    }

    public String getMessage(){
        return message;
    }
}
```

MessageRender 인터페이스
```java
public interface MessageRender {
    
    void render();
    void setMessageProvider(MessageProvider messageProvider);
    MessageProvider getMessageProvider();
}
```

``` 
MessageRender 구현체
```java
public class MessageRenderImpl implements MessageRender{

    private MessageProvider messageProvider;

    public MessageRenderImpl(){
        System.out.println("MessageRender 생성자 호출");
    }

    @Override
    public void render(){
        if(messageProvider==null){
            throw new RuntimeException(MessageRenderImpl.class.getName()+"messageProvider 클래스의 프로퍼티를 설정해야 합니다");
        }
        System.out.println(messageProvider.getMessage());
    }

    @Override
    public void setMessageProvider(MessageProvider messageProvider){
        System.out.println("messageProvider 설정");
        this.messageProvider=messageProvider;
    }

    @Override
    public MessageProvider getMessageProvider(){
        return this.messageProvider;
    }

}
```

ApplicationContext를 이용한 사용
```java
  ApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
        MessageRender render=ctx.getBean("messageRender",MessageRender.class);
        render.render();
```
