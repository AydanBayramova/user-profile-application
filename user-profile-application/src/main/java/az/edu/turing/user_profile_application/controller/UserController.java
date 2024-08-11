package az.edu.turing.user_profile_application.controller;



import az.edu.turing.user_profile_application.model.dto.UserDto;
import az.edu.turing.user_profile_application.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
@Slf4j

public class UserController {

    private final UserService userService;


    @PostMapping
    public UserDto addUser(@RequestBody UserDto user) {
        log.info("add user");
        return userService.save(user);
    }

    @GetMapping("/all")
    public Page<UserDto> getUsers(Pageable pageable) {
        log.info("get users with pagination");
        return userService.getAll(pageable);
    }

    @GetMapping("/{id}")
    public UserDto getUserById(@PathVariable Long id) {
        log.info("get user by id");
        Optional<UserDto> byId = userService.getById(id);
        return byId.orElse(null);
    }

    @DeleteMapping("/all")
    public void deleteAllUsers() {
        log.info("delete all users");
        userService.deleteAll();
    }

    @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Long id) {
        log.info("delete user by id");
        userService.deleteById(id);
    }

    @PutMapping("/{id}")
    public UserDto updateUserById(@PathVariable Long id, @RequestBody UserDto user) {
        log.info("update user by id");
        return userService.update(id, user);
    }




}
