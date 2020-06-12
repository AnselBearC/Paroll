/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/6/1$ 下午 04:37$
 */

package com.ansel.payroll.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Api(tags = "PageController",description = "页面跳转控制")
@Controller
@RequestMapping(value = "/page")
public class PageController {
    @ApiOperation("首页")
    @GetMapping(value = "/home-page")
    public String homePage() {
        return "page/home-page";
    }

}
