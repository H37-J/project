---
layout:     post
title:      "Spring(스프링부트)"
subtitle:   " \"내가 공부한 AOP 정리 \""
date:       2021-08-30 12:00:00
author:     "H37-J"
header-img: "img/post-bg-2015.jpg"
catalog: true
tags:
    - Spring
    - 스프링부트

---


## 스프링부트

### @SpringBootApplication
@SpringBootApplication은 @Configuration+@ComponentScan,@EnableAutoConfiguration의 세 어노테이션의 합이라고 볼 수 있다.
@Configureation은 빈 설정파임을 명시하는 어노테이션이고,@ComoenentScan은 해당 패키지 아래에 있는 모든 패키지에 대해 컴포넌트클 스캔 할 수 있도록 해준다.

@EnableAutoConfiguration은 빈을 찾아 등록하는 어노테이션이다.
빈 등록 단계는 두가지인데 @ComponentScan->@EnableAutoConfiguration이다.
@EnableAutoConfiguration은 spring-boot-autoconfiugre.xxx.jar 라는 프로젝트에 있는 대부분의 Configuration을 bean으로 등록해준다.

### 프로파일
프로파일은 런타임 환경마다 빈 설정 파일을 다르게 해준다.
@Compoenet가 붙은곳에 @Profile("이름")붙여서 사용한다

### 테스트

#### @SpringBootTest
* SpringBootTest는 @SpringBootApplication에노테이션을 찾아 애플리케이션에 필요한 모든 빈을 등록해준다. 즉, 모든 애플리케이션에 있는 모든 빈을 @Autowired로 주입받아 사용이 가능하다.
* @RunWith(SpringRunner.class)와 함께 사용해야 한다.

#### MockMvc
```java
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class Test{
    @Autowired
    MockMvc mockMvc;

    @Test
    public void test1() throws Exception{
        mockMvc.perform(get("/getUser"))
        .andExpect(status().isOk())
        .andExpect(content().string("hello hjk"))
        .andDo(print())
    }
}
```