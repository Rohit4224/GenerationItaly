package com.generation.bar.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


/* The @GetMapping({"/", "/home"}) annotation in the home() method of the 
AppController class is a part of Spring MVC, 
a framework that is built on top of the Servlet API. */


@Controller // it tells Spring that this class will handle web requests.
public class AppController
{
    // this method will be called when the user access the home page
    // it will return the MainPage.html
    // the @GetMapping annotation tells Spring that this method will be called when the user access the home page
    // it can be accessed by the URL: http://localhost:8080/home
    // or by the URL: http://localhost:8080/
    
    @GetMapping({"/", "/home"})   // based on server URL, it will call this method
    public String home()
    {
        System.out.println("/home is processed");
        return "MainPage.html";
    }

    /* The home() method returns a String "MainPage.html", 
    which Spring MVC interprets as the name of the view (in this case, an HTML file) 
    to render in response to the request. 
    This is different from a Servlet, 
    where you would typically use a RequestDispatcher 
    to forward the request to a JSP or other resource. */

/* So, while this code doesn't directly involve Servlets, 
it's built on the same underlying technologies and serves a similar purpose. 
Spring MVC is a higher-level framework that abstracts away much of the complexity 
of working with the Servlet API, 
making it easier to build web applications in Java. */
}
