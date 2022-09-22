package com.ldu.reservationOrder.controller;

import org.springframework.http.MediaType;
import org.springframework.security.access.annotation.Secured;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping(value = "/res/hello", produces = {MediaType.APPLICATION_JSON_VALUE})
public class HomeController {

//    @Secured("ROLE_CUSTOMER")
    //@PreAuthorize("hasRole('CUSTOMER')")  // config에서 prePostEnabled = true 설정해야 사용가능
    @GetMapping("/api")
    public String hello(Model model, HttpServletResponse response) {
        Map<String,String> map = new HashMap<>();
        map.put("1","1");
        map.put("test","test");
        map.put("ldu","이동욱");
        return "123";
    }
}
