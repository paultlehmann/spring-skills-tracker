package org.launchcode.springskillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SkillsController {

    @GetMapping()
    @ResponseBody
    public String buildPage() {
        String html =
                "<html>" +
                        "<body>" +
                        "<h1>Skills Tracker</h1><br>" +
                        "<h2><ol>" +
                        "<li>Shakespeare</li>" +
                        "<li>Malbolge</li>" +
                        "<li>Whitespace</li>" +
                        "</ol></h2>" +
                        "</body>" +
                        "</html>";
        return html;
    }

    @GetMapping("/form")
    @ResponseBody
    public String formGenerator() {
        String optionsDropdown = "<option value='Shakespeare'>Shakespeare</option>" +
                "<option value='Malbolge'>Malbolge</option>" +
                "<option value='Whitespace'>Whitespace</option>" +
                "</select>";
        String html =
                "<html>" +
                        "<body>" +
                        "<h2>Name:</h2>" +
                        "<form method='get' action='/form2'>" +
                        "<input type='text' name='name' />" +
                        "<h2>My favorite language:</h2>" +
                        "<select name='language1'>" +
                        optionsDropdown +
                        "<h2>My second favorite language:</h2>" +
                        "<select name='language2'>" +
                        optionsDropdown +
                        "<h2>My third favorite language:</h2>" +
                        "<select name='language3'>" +
                        optionsDropdown +
                        "<br><br><button type='submit'>Submit</button>" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;

    }

    @GetMapping("/form2")
    @ResponseBody
    public String formResultsViewer(@RequestParam String name, String language1, String language2, String language3) {
        String html =
                "<html>" +
                        "<body>" +
                        "<h1>" + name + "</h1><br>" +
                        "<h2><ol>" +
                        "<li>" + language1 + "</li>" +
                        "<li>" + language2 + "</li>" +
                        "<li>" + language3 + "</li>" +
                        "</ol></h2>" +
                        "</body>" +
                        "</html>";
        return html;

    }

}
