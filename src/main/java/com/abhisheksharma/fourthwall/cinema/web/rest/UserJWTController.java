package com.abhisheksharma.fourthwall.cinema.web.rest;

import com.abhisheksharma.fourthwall.cinema.config.Constants;
import com.abhisheksharma.fourthwall.cinema.security.DomainUser;
import com.abhisheksharma.fourthwall.cinema.security.jwt.TokenProvider;
import com.abhisheksharma.fourthwall.cinema.service.dto.LoginDTO;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Controller to authenticate users.
 */
@RestController
@RequestMapping("/api")
public class UserJWTController {

    private final TokenProvider tokenProvider;

    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public UserJWTController(TokenProvider tokenProvider,AuthenticationManagerBuilder authenticationManagerBuilder){
        this.tokenProvider = tokenProvider;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<T> authorize(@Valid @RequestBody LoginDTO loginDTO) {

        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(loginDTO.getUsername(), loginDTO.getPassword());

        try {
            Authentication authentication = authenticationManagerBuilder.getObject().authenticate(authenticationToken);

            DomainUser domainUser = (DomainUser) authentication.getPrincipal();

            if(loginDTO.getDeviceDTO() == null) {
                domainUser.setSource(Constants.Source.WEB);
            }else {
                domainUser.setSource(loginDTO.getDeviceDTO().getSource());
            }
            boolean rememberMe = loginDTO.isRememberMe();

            String jwt = tokenProvider.createToken(authentication, rememberMe, domainUser.getSource());

            return new ResponseEntity<>(new JWTToken(jwt), HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(new CodeError("Invalid Access"), HttpStatus.UNAUTHORIZED);

        }
    }

    /**
     * Object to return as body in JWT Authentication.
     */
    static class T{ }

    static class JWTToken extends T{

        private String idToken;

        JWTToken(String idToken) {
            this.idToken = idToken;
        }

        @JsonProperty("id_token")
        String getIdToken() { return idToken; }

        void setIdToken(String idToken) { this.idToken = idToken; }
    }

    static class JWTTokenRefresh extends JWTToken{

        private Boolean status;
        private String message;

        JWTTokenRefresh(String idToken, Boolean status, String message){
            super(idToken);
            this.status = status;
            this.message = message;
        }

        @JsonProperty("status")
        public Boolean isStatus(){return status;}

        public void setStatus(Boolean status) { this.status = status; }

        public String getMessage() { return message; }

        public void setMessage(String message) { this.message = message; }
    }

    static class Message extends T{
        private Boolean status;

        private String message;

        Message(String message){
            this.status = false;
            this.message = message; //"Login Code has been expired. Please try again";
        }

        Message(Boolean status, String message){
            this.status = status;
            this.message = message;
        }

        @JsonProperty("status")
        public Boolean isStatus() { return status; }

        @JsonProperty("message")
        public String getMessage() { return message; }

        public void setStatus(Boolean status) { this.status = status; }

        public void setMessage(String message) { this.message = message; }
    }

    static class CodeError extends Message{

        CodeError(String message){
            super(message);
        }
        CodeError(Boolean status, String message){
            super(status, message);
        }
    }
}
