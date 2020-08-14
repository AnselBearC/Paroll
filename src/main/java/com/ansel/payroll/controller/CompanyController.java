/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/8/4$ 上午 10:45$
 */

package com.ansel.payroll.controller;

import com.ansel.payroll.common.api.CommonPage;
import com.ansel.payroll.common.api.CommonResult;
import com.ansel.payroll.mbg.model.PyCompany;
import com.ansel.payroll.service.CompanyService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@Api(tags = "companyController",description = "公司管理")
@Controller
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;
    private static final Logger LOGGER = LoggerFactory.getLogger(CompanyController.class);

    @ApiOperation("获取所有公司信息")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PyCompany>> getCompanyList() {
        return CommonResult.success(companyService.listAllCompany());
    }

    @ApiOperation("创建公司信息")
    @RequestMapping(value = "create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createCompany(@RequestBody PyCompany pyCompany){
        Date date = new Date();
        pyCompany.setCreateTime(date);
        CommonResult commonResult;
        int count = companyService.createCompany(pyCompany);
        if (count == 1) {
            commonResult = CommonResult.success(pyCompany);
            LOGGER.debug("createCompany success:{}",pyCompany);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createCompany failed:{}","pyCompany");
        }
        return commonResult;
    }

    @ApiOperation("更新公司信息")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateCompany(@PathVariable Integer id,@RequestBody PyCompany pyCompany) {
        Date date = new Date();
        pyCompany.setUpdateTime(date);
        CommonResult commonResult;
        int count = companyService.updateCompany(id,pyCompany);
        if (count == 1) {
            commonResult = CommonResult.success(pyCompany);
            LOGGER.debug("updateCompany success:{}",pyCompany);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateCompany failed:{}",pyCompany);
        }
            return commonResult;
    }

    @ApiOperation("删除公司信息")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteCompany(@PathVariable Integer id) {
        int Count = companyService.deleteCompany(id);
        if (Count == 1 ) {
            LOGGER.debug("deleteCompany success id:{}",id);
            return CommonResult.success(null);
        }else {
            LOGGER.debug("deleteCompany failed id:{}",id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("分页查询公司信息")
    @RequestMapping(value = "/listCompany",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PyCompany>> listCompany(@RequestParam(value = "pageNum",defaultValue = "1")
                                                         @ApiParam("页码") Integer pageNum,
                                                     @RequestParam(value = "pageSize",defaultValue = "3")
                                                         @ApiParam("每页数量") Integer pageSize) {
        List<PyCompany> companyList = companyService.listCompany(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(companyList));
    }
}
