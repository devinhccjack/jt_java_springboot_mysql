package com.jt;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.jt.mapper")
class JtApplicationTests {

    @Test
    void contextLoads() {
    }

}
