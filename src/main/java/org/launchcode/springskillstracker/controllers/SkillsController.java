package org.launchcode.springskillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SkillsController {

    private final String htmlStarter = "<html><head><title='Skills Tracker'></head><body>";
    private final String htmlEnder = "</body></html>";

    @GetMapping()
    @ResponseBody
    public String buildPage() {
        String html =
                        htmlStarter +
                        "<h1>Skills Tracker</h1>" +
                        "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                        "<h3><ol>" +
                        "<li>Shakespeare</li>" +
                        "<li>Malbolge</li>" +
                        "<li>Whitespace</li>" +
                        "</ol></h3>" +
                        "<a href='/form'>Proceed to form</a>" +
                        htmlEnder;
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
                        htmlStarter +
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
                        htmlEnder;
        return html;

    }

    @GetMapping("/form2")
    @ResponseBody
    public String formResultsViewer(@RequestParam String name, String language1, String language2, String language3) {
        String snarkyMessage = "";
        if (language1.equals(language2) && language1.equals(language3)) {
            snarkyMessage = "<h3>A little heavy on the " + language1 + " there! It's undeniably a great language, but consider branching out!";
        }
        String html =
                        htmlStarter +
                        "<h1>" + name + "</h1><br>" +
                        "<table>" +
                        "<tr><td><h2>1. " + language1 + "</h2></td></tr>" +
                        "<tr><td><h2>2. " + language2 + "</h2></td></tr>" +
                        "<tr><td><h2>3. " + language3 + "</h2></td></tr>" +
                        "</table><br>" +
                        snarkyMessage +
                        htmlEnder;
        return html;

    }

}
