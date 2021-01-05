package id.Controller;


import org.springframework.web.bind.annotation.*;


@RestController
public class HelloWorld {


    @GetMapping(path = "/Hello")
    public String getByKodeKantorMonthYe() {
            return "Hello World";
        }
 }


