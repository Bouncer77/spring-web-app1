package com.bouncer77.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 02.09.2020
 */

@Controller
public class HelloController {

    @GetMapping("/hello-world")
    public String sayHello() {
        return "hello_world";
    }
}
