package com.api;

import com.data.UserService;
import com.model.User;
import com.mongodb.client.MongoCollection;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.SimpleRestrictionModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import javax.xml.ws.Response;

@RestController
public class UserController {
    UserService userService = new UserService();
    @RequestMapping(value = "/user", method = RequestMethod.POST)
    ResponseEntity addUser(@RequestBody User user) throws Exception{
        userService.addNewUser(user);
        return new ResponseEntity<>("UserAdded SuccesFully", HttpStatus.OK);
    }
    @RequestMapping(value = "/user", method = RequestMethod.GET)
    List getUser(){
        //List result = userService.getAllItems();
        return userService.getAllItems();
    }
}
