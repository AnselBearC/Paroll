package com.example.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 〈用于配置需要动态生成的mapper接口的路径〉
 *
 * @author GPSD-IT
 * @create 2020/3/21
 * @since 1.0.0
 */
@Configuration
@MapperScan("com.ansel.payroll.mbg.mapper")
public class MyBatisConfig {
}
