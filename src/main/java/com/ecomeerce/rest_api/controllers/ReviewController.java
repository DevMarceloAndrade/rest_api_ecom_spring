package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.models.Review;
import com.ecomeerce.rest_api.services.ReviewService;

public class ReviewController extends BaseController<Review>{
    public ReviewController(ReviewService baseService) {
        super(baseService);
    }
}
