package pl.kursy.filtry.zadanie.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.kursy.filtry.zadanie.model.UserEntity;
import pl.kursy.filtry.zadanie.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/login")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<UserEntity>> findAllUsers(){

        return ResponseEntity.ok(userService.findAllUsers());

    }

}
