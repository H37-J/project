 package com.hjk.shopboot.test;



 import org.junit.jupiter.api.DisplayName;
 import org.junit.jupiter.api.Test;
 import org.springframework.beans.factory.annotation.Autowired;
 import org.springframework.http.MediaType;
 import org.springframework.test.web.servlet.ResultActions;
 import org.springframework.web.context.WebApplicationContext;

 import lombok.extern.slf4j.Slf4j;

 import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
 import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

 import java.time.LocalDateTime;
 import java.util.*;

 import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

 @Slf4j
 public class TestOne extends BaseTest {
     @Autowired WebApplicationContext webContext;

     @Test
     @DisplayName("로그인")
     public void test() throws Exception {

     }





 }
