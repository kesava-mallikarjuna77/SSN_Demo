
package com.ssndemo.ssn;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HtmlController {

    @GetMapping("/streamdata")
    public String serveCustomPage() {
        return "eventstream"; // custom.html in src/main/resources
    }
}