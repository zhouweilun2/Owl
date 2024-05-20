package com.web.web_spingboot.controller;

import com.web.web_spingboot.entity.User;
import com.web.web_spingboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/game")
public class GameController {

    @Autowired
    private UserService userService;

    @PostMapping("/steal")
    public ResponseEntity<String> steal(@RequestBody Map<String, String> payload) {
        String username = payload.get("username");
        if(username == null || username.isEmpty()) {
            return ResponseEntity.badRequest().body("Username is empty");
        }
        userService.addEnergyByUsername(username, 10); // This method should exist in your UserService
        return ResponseEntity.ok("Energy updated successfully");
    }

    @GetMapping("/leaderboard")
    public List<User> leaderboard() {
        return userService.getUsersOrderedByEnergy();
    }

}
