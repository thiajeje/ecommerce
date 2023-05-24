package org.una.sdm.aula09.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.una.sdm.aula09.domain.User;
import org.una.sdm.aula09.services.interfaces.UserServiceAPI;

import java.util.List;

@RestController
@CrossOrigin()
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserServiceAPI userService;

    @GetMapping
    public @ResponseBody
    HttpEntity<List<User>> findAll() {

        List<User> Users = userService.findAll();
        return ResponseEntity.ok(Users);
    }

    @GetMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<User> get(@PathVariable(name = "id") Long id) {

        User User = userService.get(id);
        return ResponseEntity.ok(User);
    }

    @PostMapping
    public @ResponseBody
    HttpEntity<User> create(@RequestBody User User) {

        User = userService.create(User);
        return ResponseEntity.ok(User);
    }

    @PutMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<User> update(@PathVariable(name = "id") Long id,
            @RequestBody User User) {

        User.setId(id);
        userService.update(User);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping(value = "/{id}")
    public @ResponseBody
    HttpEntity<User> remove(@PathVariable(name = "id") Long id) {

        userService.remove(id);
        return ResponseEntity.ok().build();
    }
}
