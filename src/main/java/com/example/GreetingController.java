package com.example;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

@RestController
public class GreetingController {
    ThreadLocal<String> threadLocal=new ThreadLocal<>();
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/greeting")
    public String greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        threadLocal.set("sd");
        threadLocal.get();
        return new String(counter.incrementAndGet() + String.format(template, name));
    }
}