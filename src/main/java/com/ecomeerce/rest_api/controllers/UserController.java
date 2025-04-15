package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.User;
import com.ecomeerce.rest_api.services.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController extends BaseController<User>{
    public UserController(UserService baseService) {
        super(baseService);
    }
}
