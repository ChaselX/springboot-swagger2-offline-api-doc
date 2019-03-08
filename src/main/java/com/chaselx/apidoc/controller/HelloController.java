package com.chaselx.apidoc.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ChaselX
 * @date 2019/1/30 11:39
 */
@RestController
@Api(value = "Say hello", description = "System Hello API", tags = "HelloApi", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class HelloController {
    @GetMapping("/greeting")
    @ApiOperation(value = "getGreeting", notes = "Get greeting from the system")
    public String getGreeting() {
        return "Hello!";
    }

    @PostMapping("/hello")
    @ApiOperation(value = "sayGreeting", notes = "Send a greeting to the system")
    public ResponseEntity sayGreeting(@RequestBody String greeting) {
        String result = "Received " + greeting;
        return ResponseEntity.ok(result);
    }
}
