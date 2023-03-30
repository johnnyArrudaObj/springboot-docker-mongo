package com.johnny.customerapi.controller;

import com.johnny.customerapi.domain.customer.Customer;
import com.johnny.customerapi.infra.security.AuthenticationDTO;
import com.johnny.customerapi.infra.security.JwtDTO;
import com.johnny.customerapi.domain.user.User;
import com.johnny.customerapi.infra.security.SecurityConfigurations;
import com.johnny.customerapi.infra.security.TokenService;
import com.johnny.customerapi.repository.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AuthenticationController {

    @Autowired
    private AuthenticationManager manager;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SecurityConfigurations securityConfigurations;

    @PostMapping
    public ResponseEntity doLogin(@RequestBody @Valid AuthenticationDTO data){
        var token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var authentication = manager.authenticate(token);

        var tokenJWT = tokenService.generateToken((User) authentication.getPrincipal());

        return ResponseEntity.ok(new JwtDTO(tokenJWT));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid AuthenticationDTO data){
        userRepository.save(new User(data, securityConfigurations.passwordEncoder()));
        return ResponseEntity.noContent().build();
    }
}
