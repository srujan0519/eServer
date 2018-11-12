package com.api;
import com.data.TestConncetion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

@ComponentScan({"com.data"})
@RestController
public class Hello {

    TestConncetion test = new TestConncetion("srujan");

    @Autowired
    @RequestMapping("/hello")
    String home() {
        return test.checkCon();
    }
}
