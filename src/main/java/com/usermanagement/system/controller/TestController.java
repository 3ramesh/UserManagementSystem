package com.usermanagement.system.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.usermanagement.system.constant.SwaggerConstants.TestConstant.BASE_API_VALUE;
import static com.usermanagement.system.constant.SwaggerConstants.TestConstant.TEST_OPERATION;
import static com.usermanagement.system.constant.WebResourceKeyConstants.API;
import static com.usermanagement.system.constant.WebResourceKeyConstants.TestResourceConstant.BASE_TEST_RESOURCE;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */

@RestController
@RequestMapping(API + BASE_TEST_RESOURCE)
@Api(BASE_API_VALUE)
public class TestController {

    @GetMapping
    @ApiOperation(TEST_OPERATION)
    public String test() {
        return "User Management System is running successfully! ....";
    }
}
