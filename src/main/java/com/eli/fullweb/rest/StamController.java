package com.eli.fullweb.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("stam")
public class StamController {
    @GetMapping("get-all-stam")
    public List<String> getAllStam(){
        return Arrays.asList("Hello","Spring","Framework");
    }
}