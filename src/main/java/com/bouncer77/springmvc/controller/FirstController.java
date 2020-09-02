package com.bouncer77.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Kosenkov Ivan
 * Created by Kosenkov Ivan on 02.09.2020
 */
@Controller
@RequestMapping("first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(HttpServletRequest request) {

        String name = request.getParameter("name");
        String surname = request.getParameter("surname");

        System.out.println("Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(@RequestParam("name") String name,
                              @RequestParam("surname") String surname) {
        System.out.println("Goodbye, " + name + " " + surname);
        return "first/goodbye";
    }

}
