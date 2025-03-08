package org.example.userconfiguration.Controller;
import org.example.userconfiguration.Services.UserService;
import org.example.userconfiguration.dto.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")

public class UserController {

    @Autowired
    private UserService userService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public List<UserDto> getUsers() {
        return userService.getAllUsers();
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public UserDto createUser(@RequestBody UserDto userDto) {
        return userService.createUser(userDto);
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/{id}")
    public UserDto updateUser(@PathVariable Long id, @RequestBody UserDto userDto) {
        return userService.updateUser(id, userDto);
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/login")
    public UserDto loginUser(@RequestBody UserDto userDto) {
        return userService.loginUser(userDto);
    }

    @CrossOrigin(origins = "*")
    @GetMapping("/error")
    public String error() {
        return "You are on the user service error page";
    }


}
