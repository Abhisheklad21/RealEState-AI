package com.realestate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller

public class MapController {

    @GetMapping("/map")
    public String showMap() {
        return "index"; // This will resolve to /WEB-INF/views/index.jsp
    }
}

