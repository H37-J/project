---
layout:     post
title:      "Spring(MVC)"
subtitle:   " \"내가 공부한 MVC 정리 \""
date:       2021-08-30 12:00:00
author:     "H37-J"
header-img: "img/post-bg-2015.jpg"
catalog: true
tags:
    - Spring
    - MVC

---


## MVC
![Dispatcher](./images/DispatcherServlet_and_MVC.png)

MVC아키텍처는 보통 프론트 컨트롤러 패턴과 함께 사용되며,Spring MVC에서는 DispatcherServlet이 프론트 컨트롤러 역할을 수행한다.

### DispatcherServlet의 동작 과정

#### (1) DispatcherServlet에게 요청 전달
* 서블릿 컨테이너는 HTTP 요청이 Dispatcher이 처리하는 URL패턴이라면 DispatcherServlet에게 요청을 전달한다.
* DispatcherServlet은 모든 요청에 대해 공통적으로 수행해야 하는 전처리 작업이 등록되어 있다면 이를 먼저 수행한다(AOP,보안,파라미터조작,인코딩등)

#### (2) Controller에게 요청전달
* Dispatcher이 어떤 Controller에게 요청할지는 핸들러 매핑을 통해서 이루어진다. 
* DispatcherServlet이 핸들러 어댑터에 웹 요청을 전달할 때는 모든 웹 요청 정보가 담긴 HttpServletRequest타입의 오브젝트를 전달해준다. 이를 어댑터가 적절히 변환핸서 컨트롤러의 메소드가 받을 수 있는 파라미터로 변환해서 전달 해준다.

```java
@Controller
public class UserController{

    @RequestMapping("/getUser")
    public String getUser(@RequestParam("name")String name,ModelMap map){
        map.put("user",name);
        return "user";
    }
}
```

* 다음과 같이 /getUser로 들어온 요청에 대해서는 getUser의 메서드가 실행 되야 하는데 HandlerMapping에 맞는 HandlerAdapter를 사용하여 컨트롤러를 호출한다. 다음은 HandlerAdapter의 인터페이스이다.

```java
public interface HandlerAdapter{
    boolean supports(Object handler);

    ModelAdnView handle(HttpSservletRequest request,HttpServletResponse response,Object handler) throws Excpetion;

    long getLastModified(HttpServletRequest request,Object handler);
}
```

1. @Controller방식으로 구현된 컨트롤러는 DispatcherServlet이 AnnotationMethodHandlerAdapter라는 어댑터에게 HttpServletRequest를 넘겨준다.

2. AnnotationMethodHandlerAdapter는 supports메소드에 Controller를 대입하여 지원할 수 있는지를 파악한 후 handler()메소드를 수행한다.

3. handle 메서드에서는 request를 Controller의 매핑 메소드가 필요로 하는 매개변수로 가공하여 처리한다.

#### (3) 컨트롤러의 모델 생성과 정보 등록
* 컨트롤러의 작업은 사용자 요청 해석, 서비스 계층에게 작업 위임, 결과를 받아서 모델생성, 어떤 뷰를 사용할지 결정 순으로 이루어진다.
* 컨트롤러는 DispatcherServlet에게 모델과 뷰를 전달해야하는데 이는 키-밸류형식의 값이다.

```java
@RequestaMapping("getUser")
public String hello(@RequestParam("name")String name,ModelMap map){
    map.put("message",name);
    return "/user/login" //뷰 리졸버
}
```

* InternalResourceViewResolver가 뷰 객체를 생성 하는데 이는 빈으로 등록 되어 있다.

#### (4)DispatcherServlet의 뷰 호출,뷰 페이지 생성
* DispatcherServlet은 모델을 뷰에게 전달하여 클라이언트에게 보여준다
* 뷰에서는 받아온 모데을 ${user.name}과 같이 사용 할 수 있다.

다음은 view 인터페이스이다
```java
public interface View {
    String getContentType();

    void render(Map<String,?>model,HttpServletRequest request,HttpServletResponse response) throws Excepiton;
}
```

* getContentType()은 뷰 오브젝트가 생성하는 콘텐트 타입 정보를 제공해준다.
* render()는 모델을 전달받아 클라이언트에게 돌려줄 결과물을 생성한다
  
#### (5)Http응답
* 뷰 페이지 생성까지의 작업을 모두 마쳤으면 DispatcherServlet은 후처리가 있는지 확인하고, 뷰가 만들어준 HttpServletResponse에 담긴 최종 결과를 담아 서블릿 컨테이너에게 돌려준다
* 서블릿 컨테이너는 HttpServletResponse에 담긴 정보를 HTTP응답으로 만들어서 사용자의 브라우저나 클라이언트에게 전송하고 작업을 종료한다.

### 컨트롤러 종류와 핸들러 어댑터
* 스프링 MVC가 제공하는 컨트롤러의 종류는 네 가지이고 그에 따른 핸들러 어댑터도 네 가지이다.
* 핸들러 어댑터는 DispatcherServlet이 Controller를 호출하기 위해 사용하는 객체이다.

```java
public interface Servlet{
    public void init(ServletConfig config) throws ServletException;

    public void service(ServletRequest req,ServletResponse res) throws ServletException,IOException;

    public void destory();
    public ServletConfig getServletConfig();
    public String getServletInfo();
}
```

SimpleControllerHandlerAdapter
```java
public interface Controller{
    ModelAndView handleRequest(HttpServletRequest req,HttpServletResponse res) throws Excpetion;
}
```

### 핸들러 매핑
* 핸들러 매핑은 HTTP정보를 이용해서 처리할 컨트롤러를 찾아주는 기능을 가진 DispatcherServlet의 전략이다.
* 디폴트 전략이 아닌것은 빈으로 등록해주어야 사용이 가능하다

#### DefaultAnnotationHandlerMapping
* 가장 인기있고 권장되는 핸들러 매핑 방식이다.
* @RequestMapping이라는 애노테이션을 컨트롤러 클래스나 메소드에 직접 부여하고 이를 이용해 매핑하는 전략이다.
* @RequestMapping은 메소드 단위로 URL을 매핑할 수 있어서 컨트롤러의 개수를 획기적으로 줄일 수 있는 장점이 있다.
* URL뿐 아니라, GET/POST와 같은 HTTP 메소드, 심지어는 파라미터와 HTTP 헤더정보까지 매핑에 활용할 수 있다.
* 애노테이션의 사용 정책과 작성 기준을 잘 만들어두지 않으면, 매핑정보가 지저분해지고 관리가 힘들어질 수도 있다.

### 핸들러 인터셉터
* 핸들러 매핑의 역할은 기본적으로 URL과 요청 정보로부터 컨트롤러 빈을 찾아주는 것이다. 하지만 이 기능 외에도 핸들러 인터셉터를 적용해주는 기능이 있다.
* 핸들러 인터셉터는 컨트롤러를 호출하기전과 후에 요청과 응답을 참조하거나 가공 할 수 있는 일종의 필터이다.
* 핸들러 인터셉터는 그 적용 대상이 DispatcherServlet의 특정 핸들러 매핑으로 제한된다는 제약이 있지만, 스프링의 빈으로 등록 할 수 있고 컨트롤러 오브젝트에 접근이 가능하며, ModelAndView와 같은 컨트롤러가 리턴하는 정보를 활용할 수 있다는 장점이 있다.

### 뷰 리졸버
* 뷰 리졸버는 핸들러 매핑이 URL로부터 컨트롤러를 찾아주는 것처럼, 뷰 이름으로부터 사용할 뷰 오브젝트를 찾아준다.
* 뷰 리졸버는 ViewResolver 인터페이스를 구현해서 만들어지며, 디폴트로는 InternalViewResolver가 사용된다.

### 핸들러 예외 리졸버
* HandlerExceptionResolver는 컨트롤러의 작업 중에 발생한 예외를 어떻게 처리할지 결정하는 전략이다.
* 컨트롤러나 그 뒤에 계층에서 던져진 예외는 DispatcherSevlet이 서블릿 밖으로 던져서 서블릿 컨터에너 서치하게 되는데 만약 핸들러 예외 리졸버가 등록되어 있다면 DispatcherServlet은 먼저 핸들러 예 외 리졸버에게 해당 예외를 처리 할 수 있는지 확인한다.

#### AnnotationMethodHandlerExceptionResolver
* 예외가 발생한 컨트롤러 내의 메소드 중에서 @ExceptionHandler 애노테이션이 붙은 메소드를 찾아 예외처리를 맡겨주는 디폴트 핸들러 예외 리졸버이다.

```java
@Controller
public class HelloCon{
    @ExceptionHandler(DataAccessException.class)
    public ModelAndView dataAccessExceptionHandler(DataAccessException ex){
        return new ModelAndView("dataexception").addObject("msg", ex.getMessge());
    }
}
```

### Annotation(스프링은 이 방식을 권고함)

#### @RequestMapping
```java
@RequestMapping("/hello")               // /hello와 매핑
@RequestMapping("/main*")               //와일드 카드 사용 ex) /mainPage, /main
@RequestMapping("/view.*")              //와일드 카드 사용 ex) /view.do, /view.abc
@RequestMapping("/admin/**/user")       //와일드 카드 사용. ex) /admin/a/bc/user
@RequestMapping("/user/{userid}")       //path variable
@RequestMapping({"/hello", "/hi"})      //하나 이상의 URL 패턴 사용
```

요청 파라미터 넣기
```java
@RequestMapping(value="/user/get",params="type=admin")

```

@PathVariable
```java
@RequestMapping("/memeber/{membercode}/order/{orderId}")
public String getOrder(@PathVairable("membercode")String code,@PathVariable("orderId")int orderId)
```

@RqeustParam
```java
@RequestMapping("/get/user")
public void getUser(@RequestParam("id")int id)
```

@RequestHeader
요청 헤더정보를 메소드 파라미터에 넣어준다
```java
public void header(@RequestHeader("Host")String host,
@RequestHeader("Keep-Alive")long keepAlive)
```

@ModelAttribute
* 모델에 추가해주지 않아도 자동으로 모델에 추가된다.(model.setAttribute로 등록 해주지 않아도 된다)
* ModelAttribute는 BingdingResult또는 Errors와 함께 사용되어 예외를 처리한다.

```java
@RequestMapping("user/add",method=RequestMethod.POST)
public String search(@ModelAttribute User user,BindingResult result){
    if(result.hasError()){
        return "/user/add";
    }

    userService.add(user);
}
```

@RequestBody
이 에노테이션은 Http Reuqest body부분을 그대로 전달해준다.
XML이나 JSON기반의 메시지를 사용하는 경우 매우 유용하다.

#### HttpMessageConverter
* HTTP요청 본문을 객체로 변경하거나 객체를 HTTP응답 본문으로 변경할 때 사용한다. 스프링 부트에서는 기본적으로 제공한다
```java
@RestController
public class UserController{
    @GetMapping("getUser")
    public @ResponseBody String getUser(){
        return "getUserPage";
    }
}
```
* @RestController을 사용하면 return 타입에 @ResponseBody애노테이션을 생략할 수 있다
* @ResponseBody는 reutnr 하는 값이 ViewResolver에 의해 View객체로 변환하는 것이 아니라 반환하는 값이 String임을 의미한다

```java
@RestContorller
public class UserController{
    @PostMappping("/user/create")
    public User user create(@RequsetBody User user){
        return user;
    }
}
```

@RequestBody어노테이션이 사용되면 HttpMessageConverter를 구현한 JsonMessageConverter가 request body에 있는 데이터를 User라는 객체에 바인딩해준다.

### 캐싱
스프링은 정적 리소스 캐싱이 가능하다.

#### addResourceHandler
```java
@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registr){
        registry.addResourceHandler("/m/**")
        .addResourceLoaction("classpath:/m/")
        .setCachePeriod(0)
    }
}
```

### JSP를 권장하지 않는 이유
* JSP는 프로젝트를 JAR로 패키징할때는 동작하지 않고 WAR로 해야지만 동작하는데 이는 스프링 부트가 추구하는 독립적인 실행과 맞지 않는다.
  

### ExceptionHandler
스프링 MVC의 기본 예외 처리 방법은 @ControllAdvice 애노테이션을 사용하는 것이다.

```java
@ControllerAdvice(basePackageClasses=AcmeController.class)
public class AcmeContorllerAdivce extends ResponseEntityExceptionHandler{

    @ExceptionHandler(MyException.class)
    @ResponseBody
    ResponseEntity<?> handlerContorllerException(HttpServletRequest request,Throwable ex){
        HttpStatus status=getStatus(request);
        return new ResponseEntity<>(new CustomerErrorType(status.value(),ex.getMessage()),status);
    }

    private HttpStatus getStatus(HttpServletRequest reuqest){
        Integer statusCode=(Integer)request.getAttribute("javax.servlet.error.status_code");
        if(statusCode==null){
            return HttpStatus.INTERVAL_SERVER_ERROR;
        }
        return HttpStatus.valueOf(statusCode);
    }
}
```

### CORS
CORS(Cross Origin Resoure Sharing)는 Origin이 다른 서버에서 자원을 요청하고 공유할 수 있도록 하는 표준 기술이다.

### Origin
Origin이란 스키마(http)+호스트명(localhost)+포트번호(8080)을 조합한것이다.

### Single Origin Policy
동일 출처 정책(Single Origin Policy)는 CORS와 같은 상황이 발생 했을때, 외부 서버에 요청한 데이터를 브라우저에서 보안 목적으로 차단하는 정책이다. 이를 허용 하고 싶다면 Access-Control-Allow-Origin헤더를 설정해야 한다

### 스프링에서의 CrossOrigin 설정 방법
WebMvcConfigurer를 이용한 설정
```java
@Configuration
public class WebConfig implements WebMvcConfigurer{
    @Override
    public void addCorsMapping(CorsRegistry registry){
        registry.addMapping("//*")
        .allowdOrigins("http://localhost:8081")
    }
}
```