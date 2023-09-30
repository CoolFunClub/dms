package com.coolfunclub.dms.hello;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOError;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

@RestController
public class HelloWorldController {
    @RequestMapping("/HelloWorld")
    public String helloWorld(){
        return "Hello World!";
    }

    @RequestMapping("/kml")
    public String cats() {
        return "(^=◕ᴥ◕=^)";
    }

    // grabs today's date from the On this day section of the Wikipedia home page
    @RequestMapping("/kml-a4")
    public String  soupGet() {
        try {
            Document doc = Jsoup.connect("https://en.wikipedia.org/wiki/Main_Page").get();
            Element otd = doc.getElementById("mp-otd");
            Elements p = otd.getElementsByTag("p");
            Elements b = p.first().getElementsByTag("b");
            Elements a = b.first().getElementsByTag("a");
            String day = a.first().text();


            return "Today is " + day + '.';
        } catch (Exception e) {
            System.out.println(e);
            return "";
        }
    }

    @RequestMapping("/dog")
    public String dog() {
        return "Here U go!";
    }

}
