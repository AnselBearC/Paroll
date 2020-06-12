/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/4/24$ 下午 03:17$
 */

package com.ansel.payroll.controller;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Api(tags = "ThymeleafController",description = "主页跳转")
@Controller
@RequestMapping(value="/")
public class ThymeleafController {
    @GetMapping
    public String index(ModelMap map) {
        map.addAttribute("name","Ansel");
        return "index";
    }
}

