/**
 * 功能描述: <br>
 * 〈$〉
 * <p>
 * $
 *
 * @return:$
 * @since: 1.0.0
 * @Author:Ansel
 * @Date: 2020/6/10$ 上午 09:17$
 */

package com.ansel.payroll.controller;


import com.ansel.payroll.common.api.CommonPage;
import com.ansel.payroll.common.api.CommonResult;
import com.ansel.payroll.mbg.model.PyProcess;
import com.ansel.payroll.service.ProcessService;
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

@Api(tags = "processController" ,description = "工序管理")
@Controller
@RequestMapping("/process")
public class ProcessController {

    private final ProcessService processService;
    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessController.class);

    @Autowired
    public ProcessController(ProcessService processService) {
        this.processService = processService;
    }

    @ApiOperation("获取所有工序名称")
    @RequestMapping(value = "/listAll",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<List<PyProcess>> getProcessList(){
        return CommonResult.success(processService.listAllProcess());
    }

    @ApiOperation("添加工序")
    @RequestMapping(value = "/create" ,method = RequestMethod.POST)
    @ResponseBody
    public CommonResult createProcess(@RequestBody PyProcess pyProcess) {
        Date date = new Date();
        CommonResult commonResult;
        pyProcess.setCreateTime(date);
        int count = processService.createProcess(pyProcess);
        if(count == 1){
            commonResult  = CommonResult.success(pyProcess);
            LOGGER.debug("createProcess success:{}",pyProcess);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("createProcess failed:{}",pyProcess);
        }
            return commonResult;
    }

    @ApiOperation("更新指定id的工序名")
    @RequestMapping(value = "/update/{id}",method = RequestMethod.POST)
    @ResponseBody
    public CommonResult updateProcess(@PathVariable("id") Integer id, @RequestBody PyProcess pyProcessDto, BindingResult result) {
        Date date = new Date();
        CommonResult commonResult ;
        pyProcessDto.setUpdateTime(date);
        int count  = processService.updateProcess(id,pyProcessDto);
        if (count == 1) {
            commonResult = CommonResult.success(pyProcessDto);
            LOGGER.debug("updateProcess success:{}",pyProcessDto);
        }else {
            commonResult = CommonResult.failed("操作失败");
            LOGGER.debug("updateProcess failed:{}",pyProcessDto);
        }
        return commonResult;
    }

    @ApiOperation("删除指定id的工序")
    @RequestMapping(value = "/delete/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult deleteProcess(@PathVariable("id") Integer id) {
        int count = processService.deleteProcess(id);
        if(count ==1) {
            LOGGER.debug("deleteProcess success :id={}",id);
            return CommonResult.success(null);
        }else {
            LOGGER.debug("deleteProcess success :id={}",id);
            return CommonResult.failed("操作失败");
        }
    }

    @ApiOperation("分页查询工序")
    @RequestMapping(value = "/listProcess",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<CommonPage<PyProcess>> listProcess(@RequestParam(value = "pageNum",defaultValue = "1")
                                                               @ApiParam("页码") Integer pageNum,
                                                           @RequestParam(value = "pageSize",defaultValue = "3")
                                                               @ApiParam("每页数量") Integer pageSize) {
        List<PyProcess> processList = processService.listProcess(pageNum,pageSize);
        return CommonResult.success(CommonPage.restPage(processList));
    }

    @ApiOperation("获取指定id的工序")
    @RequestMapping(value = "/{id}",method = RequestMethod.GET)
    @ResponseBody
    public CommonResult<PyProcess> process(@PathVariable("id") Integer id) {
        return CommonResult.success(processService.getProcess(id));
    }

}
