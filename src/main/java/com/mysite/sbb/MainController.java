package com.mysite.sbb;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Log4j2
public class MainController {

    @GetMapping("/sbb")
    public void index() {
        log.info("GET /sbb");
    }

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }
}
