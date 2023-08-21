package com.usermanagement.system.controller;

import com.usermanagement.system.dto.request.UserRequestDTO;
import com.usermanagement.system.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


import static com.usermanagement.system.constant.SwaggerConstants.TestConstant.BASE_API_VALUE;
import static com.usermanagement.system.constant.SwaggerConstants.UserConstant.*;
import static com.usermanagement.system.constant.WebResourceKeyConstants.*;
import static com.usermanagement.system.constant.WebResourceKeyConstants.UserResourceConstant.BASE_USER_RESOURCE;
import static java.net.URI.create;
import static org.springframework.http.ResponseEntity.created;
import static org.springframework.http.ResponseEntity.ok;

/**
 * @author Ramesh Jamakatel on 8/21/2023
 */
@RestController
@RequestMapping(API + BASE_USER_RESOURCE)
@Api(BASE_API_VALUE)
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ApiOperation(CREATE_OPERATION)
    public ResponseEntity<?> save(@Valid @RequestBody UserRequestDTO requestDTO) {
        userService.save(requestDTO);
        return created(create(API + BASE_USER_RESOURCE)).build();
    }

    @GetMapping(USER_NAME_PATH_VARIABLE_BASE)
    @ApiOperation(DETAILS_OPERATION)
    public ResponseEntity<?> fetchDetailsByUserName(@PathVariable("username") String userName) {
        return ok(userService.fetchDetailsByUserName(userName));
    }

    @GetMapping(FIRST_NAME + FIRST_NAME_PATH_VARIABLE_BASE)
    @ApiOperation(DETAILS_OPERATION_BY_FIRST_NAME)
    public ResponseEntity<?> fetchUserListByFirstName(@PathVariable("firstName") String firstName) {
        return ok(userService.fetchUserListByFirstName(firstName));
    }
}
