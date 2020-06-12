/**
 * 功能描述: <br>
 * 〈员工管理$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/5/27$ 下午 02:35$
 */

package com.ansel.payroll.controller;

import com.ansel.payroll.common.api.CommonPage;
import com.ansel.payroll.common.api.CommonResult;
import com.ansel.payroll.mbg.model.PyStaff;
import com.ansel.payroll.service.StaffService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Api(tags = "staffController",description = "员工管理")
@Controller
@RequestMapping("/staff")
public class StaffController {

    @Autowired
    private StaffService staffService;
    private static final Logger LOGGER = LoggerFactory.getLogger(StaffController.class);

    @ApiOperation("获取所有员工列表")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PyStaff>>  getStaffList() { return CommonResult.success(staffService.listAllStaff());}

    @ApiOperation("添加员工")
    @RequestMapping(value = "/create",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createStaff (@RequestBody PyStaff pyStaff) {
        Date date = new Date();
        CommonResult commonResult;
        pyStaff.setCreatTime(date);
        int count = staffService.creatStaff(pyStaff);
        if(count == 1) {
            commonResult = CommonResult.success(pyStaff);
            LOGGER.debug("createStaff success:{}",pyStaff);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createStaff failed:{}",pyStaff);
        }
        return commonResult;
    }

    @ApiOperation("更新指定id员工信息")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateStaff(@PathVariable("id") Integer id, @RequestBody PyStaff pyStaffDto, BindingResult result){
        Date date = new Date();
        CommonResult commonResult;
        pyStaffDto.setUpdateTime(date);
        int count = staffService.updateStaff(id,pyStaffDto);
        if(count==1) {
            commonResult = CommonResult.success(pyStaffDto);
            LOGGER.debug("updateStaff success:{}",pyStaffDto);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateStaff failed:{}",pyStaffDto);
        }
        return commonResult;
    }

    @ApiOperation("删除指定id的员工")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteStaff(@PathVariable("id") Integer id) {
        int count = staffService.deleteStaff(id);
        if(count == 1) {
            LOGGER.debug("deleteStaff success :id={}",id);
            return CommonResult.success(null);
        }else {
            LOGGER.debug("deleteStaff success :id={}",id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("分页查询员工列表")
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PyStaff>> listStaff(@RequestParam(value = "pageNum",defaultValue = "1")
                                                       @ApiParam("页码") Integer pageNum,
                                                       @RequestParam(value = "pageSize",defaultValue = "3")
                                                       @ApiParam("每页数量") Integer pageSize,
                                                       @RequestParam(value = "name",defaultValue = "")
                                                       String name) {
        if (name.equalsIgnoreCase("")) {
            List<PyStaff> staffList = staffService.listStaff(pageNum,pageSize);
            return CommonResult.success(CommonPage.restPage(staffList));
        }else {
            List<PyStaff> staffList = staffService.staffByName(pageNum,pageSize,name);
            return CommonResult.success(CommonPage.restPage(staffList));
        }

    }

    @ApiOperation("获取指定id的员工详情")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PyStaff> staff(@PathVariable("id") Integer id) {
        return CommonResult.success(staffService.getStaff(id));
    }

}
