package com.mozza.backend.infrastructure.rest;


import com.mozza.backend.application.UserService;
import com.mozza.backend.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity <User> save(@RequestBody  User user){

        return ResponseEntity.ok(this.userService.save(user));


    }


    @GetMapping("/find/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){

        return ResponseEntity.ok(userService.findById(id));
    }



    @GetMapping("findAll")
    public ResponseEntity<Iterable<User>> getUsers(){
        return ResponseEntity.ok(userService.findAll());

    }

}
