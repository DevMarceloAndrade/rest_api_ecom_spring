package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.Review;
import com.ecomeerce.rest_api.services.ReviewService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/review")
public class ReviewController extends BaseController<Review>{
    public ReviewController(ReviewService baseService) {
        super(baseService);
    }
}
