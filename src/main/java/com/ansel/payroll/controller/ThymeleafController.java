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

import com.ansel.payroll.service.OrderFormService;
import com.ansel.payroll.service.PayrollService;
import com.ansel.payroll.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.text.SimpleDateFormat;
import java.util.Date;


@Api(tags = "ThymeleafController",description = "主页跳转")
@Controller
@RequestMapping(value="/")
public class ThymeleafController {

    @Autowired
    private PayrollService payrollService;

    @Autowired
    private StaffService staffService;

    @Autowired
    private OrderFormService orderFormService;

    @ApiOperation("首页")
    @GetMapping
    public String index() {
        return "index";
    }


    @ApiOperation("主页")
    @GetMapping(value = "home-page")
    public String homePage(ModelMap map) {
        Date ss = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月");
        String payDate = format.format(ss.getTime());
        float totalSalary = payrollService.totalSalary(payDate);
        long totalStaff = staffService.totalStaff();
        long totalOrderForm = orderFormService.totalOrderForm();
        map.put("totalSalary",totalSalary);
        map.put("totalStaff",totalStaff);
        map.put("totalOrderForm",totalOrderForm);
        return "home-page";
    }
}

