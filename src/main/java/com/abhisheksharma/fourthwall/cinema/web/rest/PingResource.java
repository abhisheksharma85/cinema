package com.abhisheksharma.fourthwall.cinema.web.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PingResource {

    @GetMapping(value = "/health")
    public ResponseEntity<String> pingGet() {
        return new ResponseEntity<String>("pong", HttpStatus.OK);
    }

    @PostMapping(value = "/health")
    public ResponseEntity<String> pingPost() {
        return new ResponseEntity<String>("pong", HttpStatus.OK);
    }

}
