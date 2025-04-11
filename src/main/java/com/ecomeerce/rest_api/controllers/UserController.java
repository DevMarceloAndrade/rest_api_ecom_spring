package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.User;
import com.ecomeerce.rest_api.services.UserService;

public class UserController extends BaseController<User>{
    public UserController(UserService baseService) {
        super(baseService);
    }
}
