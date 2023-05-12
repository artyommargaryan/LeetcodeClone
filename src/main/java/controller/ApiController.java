package controller;

import models.Adapter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class ApiController {
    @PostMapping("/test")
    public String[] test(@ModelAttribute("script") String script, @ModelAttribute("lang") String lang) {
        Adapter.convertTo(script, lang);
        String path = Adapter.convertTo(script, lang);
        return new String[]{"","",""};
    }

    @PostMapping("/submit")
    public String[] submit(@ModelAttribute("script") String script, @ModelAttribute("lang") String lang) {
        String path = Adapter.convertTo(script, lang);
        return new String[]{"","",""};
    }

}
