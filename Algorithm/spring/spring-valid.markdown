---
layout:     post
title:      "Spring(Validator)"
subtitle:   " \"내가 공부한 Validator 정리 \""
date:       2021-08-30 12:00:00
author:     "H37-J"
header-img: "img/post-bg-2015.jpg"
catalog: true
tags:
    - Spring
    - Validator

---


## Validator

* @NotNull
* @Email
* @Min
* @Max
* @Size
등의 어노테이션을 이용 할 수 있다

```java
public class User{
    @NotNull @Min(value=0)
    private int id;

    @NotNull
    private String name;

    @NotNull
    private String alias;
}
```

검증하는 코드는 Controller단에서 @Valid를 사용한다.
```java
@RestController
public class UserController{
    @PostMapping("/getUser")
    public User getUser(@RequestBody @Valid User user,Errors erros){
        return user;
    }
}
```

Validator를 커스텀 할 수도 있다
```java
@Compoenet
public class UserValidator{
    public void validate(User user,Errors){
        if(user.getName().length() < user.getAlias().length()){
            errors.rejectValue("error");
        }
    }
}
```

```java
@RestController
public class UserController{

    @Autowired
    UserValidator userValidator;

    @PostMapping("/getUser")
    public User getUser(@RequestBody @Valid User user,Erros errors){
        userValidator.validate(user,errors);
        if(errors.hasErrors()){
            user.setAlias("none");
        }
        return user;
    }
}
