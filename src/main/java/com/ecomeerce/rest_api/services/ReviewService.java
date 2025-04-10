package com.ecomeerce.rest_api.services;

import com.ecomeerce.rest_api.models.Review;
import com.ecomeerce.rest_api.repositories.ReviewRepository;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReviewService extends BaseService<Review>{
    @Autowired
    public ReviewService(ReviewRepository dataBaseRepository, Validator validator) {
        super(dataBaseRepository, validator);
    }
}
