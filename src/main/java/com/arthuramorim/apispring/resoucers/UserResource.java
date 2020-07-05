package com.arthuramorim.apispring.resoucers;

import com.arthuramorim.apispring.entity.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/users")
public class UserResource {


    @GetMapping
    public ResponseEntity<User> findAll(){
        User u = new User(1L,"arthur","arthur@gmail.com","483213213","1234");
        return ResponseEntity.ok().body(u);
    }

}
