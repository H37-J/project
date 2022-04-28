// package com.hjk.shopboot.aop;


// import lombok.AllArgsConstructor;
// import lombok.Builder;
// import lombok.Data;
// import lombok.Getter;
// import lombok.NoArgsConstructor;
// import lombok.Setter;
// import lombok.extern.slf4j.Slf4j;
// import org.aspectj.lang.ProceedingJoinPoint;
// import org.aspectj.lang.Signature;
// import org.aspectj.lang.annotation.Around;
// import org.aspectj.lang.annotation.Aspect;
// import org.aspectj.lang.annotation.Pointcut;
// import org.aspectj.lang.reflect.MethodSignature;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Component;
// import org.springframework.web.context.request.RequestContextHolder;
// import org.springframework.web.context.request.ServletRequestAttributes;

// import javax.servlet.http.HttpServletRequest;
// import javax.servlet.http.HttpSession;

// import com.fasterxml.jackson.databind.ObjectMapper;
// import com.google.common.collect.Maps;
// import com.hjk.shopboot.dto.UserResponseDto;
// import com.hjk.shopboot.utils.javautils.ArrayUtils;
// import com.hjk.shopboot.utils.web.UserAgent;

// import java.io.File;
// import java.net.InetAddress;
// import java.net.UnknownHostException;
// import java.util.*;

// @Aspect
// @Component
// @Slf4j
// public class LogginAspect {

//    @Autowired
//    HttpSession httpSession;

//    @Pointcut("execution (* com.hjk.shopboot.controller.*Controller.*(..))")
//    public void log() {
//    }

//    @Around("log()")
//    public Object aroundLog(ProceedingJoinPoint point) throws Throwable {
//        ObjectMapper mapper=new ObjectMapper();
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = Objects.requireNonNull(attributes).getRequest();


//        long startTime = System.currentTimeMillis(); //실행시간 측정 시작
//        Object result = point.proceed(); //접속
//        String header = request.getHeader("User-Agent"); //브라우저
//        UserAgent userAgent = UserAgent.parseUserAgentString(header);

//        UserResponseDto user=(UserResponseDto)httpSession.getAttribute("User");
//        String accountId="";
//        String name="";
//        if(user!=null){accountId=user.getAccountId(); name=user.getName();}
//        else{accountId="로그인 하지 않았습니다"; name="로그인 하지 않았습니다";}

//        final Log l = Log.builder().threadId(Long.toString(Thread.currentThread().getId()))
//                .threadName(Thread.currentThread().getName()).ip(getIp(request)).url(request.getRequestURL().toString())
//                .httpMethod(request.getMethod())
//                .accountId(accountId)
//                .name(name)
//                .timeCost((System.currentTimeMillis() - startTime)/1000.0).userAgent(header)
//                .result(result)
//                .browser(userAgent.getBrowser().toString()).os(userAgent.getOperatingSystem().toString()).build();

//        log.info("Request Log Info : {}", l.toString());

//        Map<Integer,Object> add_map=new HashMap<>();
//        Map<Integer,Object> current_map=mapper.readValue(new File("result.json"),Map.class);

//        int num=1;

//        if(!current_map.isEmpty()) {
//            for (Map.Entry<Integer, Object> entry : current_map.entrySet()) {
//                add_map.put(num, entry.getValue());
//                num++;
//            }
//        }

//        add_map.put(num,l);
//        mapper.writerWithDefaultPrettyPrinter().writeValue(new File("result.json"),add_map);

//        return result;
//    }

//    public static String getIp(HttpServletRequest request) {
//        String ip = request.getHeader("x-forwarded-for");
//        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
//            ip = request.getHeader("Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
//            ip = request.getHeader("WL-Proxy-Client-IP");
//        }
//        if (ip == null || ip.length() == 0 || UNKNOWN.equalsIgnoreCase(ip)) {
//            ip = request.getRemoteAddr();
//        }
//        String comma = ",";
//        String localhost = "127.0.0.1";
//        if (ip.contains(comma)) {
//            ip = ip.split(",")[0];
//        }
//        if (localhost.equals(ip)) {

//            try {
//                ip = InetAddress.getLocalHost().getHostAddress();
//            } catch (UnknownHostException e) {
//                log.error(e.getMessage(), e);
//            }
//        }
//        return ip;
//    }

//    private Map<String, Object> getNameAndValue(ProceedingJoinPoint joinPoint) {

//        final Signature signature = joinPoint.getSignature();
//        MethodSignature methodSignature = (MethodSignature) signature;
//        final String[] names = methodSignature.getParameterNames();
//        final Object[] args = joinPoint.getArgs();

//         if (ArrayUtils.isEmpty(names) || ArrayUtils.isEmpty(args)) {
//             return Collections.emptyMap();
//         }
//        if (names.length != args.length) {
//            log.warn("메소드 시그네처 네임", methodSignature.getName());
//            return Collections.emptyMap();
//        }
//        Map<String, Object> map = Maps.newHashMap();
//        for (int i = 0; i < names.length; i++) {
//            map.put(names[i], args[i]);
//        }
//        return map;
//    }

//    private static final String UNKNOWN = "unknown";


//    @Data
//    @Builder
//    @NoArgsConstructor
//    @AllArgsConstructor
//    @Getter
//    @Setter
//    static class Log {

//        private String accountId;

//        private String name;

//        private String threadId;

//        private String threadName;

//        private String ip;

//        private String url;

//        private String httpMethod;

//        private Object result;

//        private Double timeCost;

//        private String os;

//        private String browser;

//        private String userAgent;

//        @Override
//        public String toString() {
//            return "스레드: " + this.threadId + "," + "스레드네임: " + this.threadName + "," + "아이피: " + this.ip + "," + "URI: "
//                    + this.url + "," + "메소드: " + this.httpMethod + ", 클래스 메소드: " + ", 파라미터: "
//                    + ", 결과: " + this.result + ", 요청시간: " + this.timeCost + ", 브라우저: "
//                    + this.browser + ", 디바이스: " + this.os + ", 유저정보: " + this.userAgent;
//        }
//    }

// }

// // @Before("execution (* com.hjk.shopboot.service.*Service.*(..))")
// // public void loggerBofore(){
// // System.out.println("메서드 시작");
// // }

// // @After("execution (* com.hjk.shopboot.service.*Service.*(..))")
// // public void loggerAfter(){
// // System.out.println("메서드 시작");
// // }

// // @Around("log()")
// // public Object arpundLog(ProceedingJoinPoint pj) throws Throwable{
// // long beforeTimeMillis=System.currentTimeMillis();
// // System.out.println("[UserController] 실행 시작 : "
// // +pj.getSignature().getDeclaringTypeName() + "."
// // +pj.getSignature().getName());
// // Object result = pj.proceed();

// // long afterTimeMillis = System.currentTimeMillis() - beforeTimeMillis;
// // System.out.println("[UserController] 실행 완료: " + afterTimeMillis + "밀리초 소요"
// // +pj.getSignature().getDeclaringTypeName() + "."
// // +pj.getSignature().getName());

// // return result;
// // }