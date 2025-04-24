package com.ecomeerce.rest_api.controllers;

import com.ecomeerce.rest_api.controllers.dto.LoginRequest;
import com.ecomeerce.rest_api.controllers.dto.LoginResponse;
import com.ecomeerce.rest_api.projections.UserProjection;
import com.ecomeerce.rest_api.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
public class TokenController {
    private final JwtEncoder jwtEncoder;
    private final UserService userService;

    @Autowired
    public TokenController(JwtEncoder jwtEncoder, UserService userService) {
        this.jwtEncoder = jwtEncoder;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest){
        UserProjection user = userService.passwordMatch(loginRequest.email(), loginRequest.password());

        var now = Instant.now();
        var expiresIn = 300L;
        var claims = JwtClaimsSet.builder()
                .issuer("mybackend")
                .subject(user.getId().toString())
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();
        var jwtValue = jwtEncoder.encode(JwtEncoderParameters.from(claims)).getTokenValue();

        return ResponseEntity.ok(new LoginResponse(jwtValue,expiresIn));
    }
}
