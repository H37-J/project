// package com.hjk.testboot.jdbc;

// import java.sql.Driver;

// import javax.sql.DataSource;

// import org.springframework.beans.factory.annotation.Value;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.context.annotation.Lazy;
// import org.springframework.context.annotation.PropertySource;
// import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
// import org.springframework.jdbc.datasource.SimpleDriverDataSource;

// @Configuration
// @PropertySource("classpath:db/jdbc.properties")
// public class Config {

//     @Value("${driverClassName}")
//     private String driverClassname;
    
//     @Value("${url}")
//     private String url;

//     @Value("${dbusername}")
//     private String username;

//     @Value("${dbpassword}")
//     private String password;
    

//     @Bean
//     public static PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer(){
//         return new PropertySourcesPlaceholderConfigurer();
//     }

//     @SuppressWarnings("unchecked")
//     @Lazy
//     @Bean
//     public DataSource dataSource(){
//         try{
//             SimpleDriverDataSource dataSource=new SimpleDriverDataSource();
//             Class<? extends Driver> driver=(Class<? extends Driver>) Class.forName(driverClassname);
//             dataSource.setDriverClass(driver);
//             dataSource.setUrl(url);
//             dataSource.setUsername(username);
//             dataSource.setPassword(password);
//             return dataSource;
//         }catch(Exception e){
//             return null;
//         }
//     }
// }
