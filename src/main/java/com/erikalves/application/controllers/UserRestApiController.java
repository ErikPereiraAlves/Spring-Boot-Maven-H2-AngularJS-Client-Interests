package com.erikalves.application.controllers;


import com.erikalves.application.model.User;
import com.erikalves.application.service.UserServiceImpl;
import com.erikalves.application.utils.Util;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
class UserRestApiController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserRestApiController.class);

    @Autowired
    private UserServiceImpl userService;


    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<User>> findAll() {

        LOGGER.debug("****************  Return all users **********************  ");

        List <User> users =userService.findAll();

        if(null!=users && users.size() >0) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }



    @GetMapping(value = "/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User>  getExclude(@PathVariable("user_id") String userId) {

        User user =userService.get(Util.LongfyId(userId));
        LOGGER.debug("*** user found in H2 {}",user);
        if(null!=user) {
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        }

    }



    //delete
    @DeleteMapping(value = "/{user_id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> delete(@PathVariable("product_id") String productId) {

        userService.delete(Util.LongfyId(productId));

        return ResponseEntity.ok((productId));
    }

    // create
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> create(@RequestBody User product) {

        User savedUder = userService.save(product);

        return ResponseEntity.created(URI.create("/" + savedUder.getUserId())).body((savedUder));
    }


    // update
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> update(@RequestBody User user) {

        userService.update(user);

        return ResponseEntity.noContent().build();
    }

}