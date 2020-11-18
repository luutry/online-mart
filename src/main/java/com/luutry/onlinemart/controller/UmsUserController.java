package com.luutry.onlinemart.controller;

import com.luutry.onlinemart.common.api.CommonResult;
import com.luutry.onlinemart.dto.UmsAdminLoginParam;
import com.luutry.onlinemart.dto.UmsAdminParam;
import com.luutry.onlinemart.mbg.model.UmsAdmin;
import com.luutry.onlinemart.service.UmsAdminService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: UmsUserController
 * @Description:
 * @Author: Luutry
 * @Date: 2020/11/6 16:13
 */
@Controller
@Api(tags = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsUserController {

    @Autowired
    private UmsAdminService umsAdminService;

    @ApiOperation(value = "用户注册")
    @PostMapping(value = "/register")
  //  @ApiImplicitParam(name = "umsUserParam", value = "用户信息", required = true)
    @ResponseBody
    public CommonResult register(@Validated @RequestBody UmsAdminParam umsAdminParam){

        // TODO 参数校验异常处理
        UmsAdmin umsAdmin = umsAdminService.register(umsAdminParam);
        if (umsAdmin == null){
            return CommonResult.failed("用户名已经存在！");
        }
        return CommonResult.success(umsAdmin);
    }

    @ApiOperation("用户登录")
    @PostMapping("/login")
    @ResponseBody
    public CommonResult login(@Validated @RequestBody UmsAdminLoginParam umsAdminLoginParam){
        String token = umsAdminService.login(umsAdminLoginParam.getUsername(), umsAdminLoginParam.getPassword());

        return CommonResult.success(token);
    }
}
