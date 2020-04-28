/**
 * 功能描述: <br>
 * 〈测试控制器、$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/4/16$ 上午 10:31$
 */

package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.text.SimpleDateFormat;
import java.util.Date;

@Controller

public class TestlController {
        @GetMapping
        public String presentTime() {
            SimpleDateFormat sdf = new SimpleDateFormat();// 格式化时间
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");// a为am/pm的标记
            Date date = new Date();// 获取当前时间
            return sdf.format(date);
        }
}
