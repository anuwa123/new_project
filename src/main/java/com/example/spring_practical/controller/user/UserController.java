package com.example.spring_practical.controller.user;

import com.example.spring_practical.dto.user.UserDto;
import com.example.spring_practical.models.user.User;
import com.example.spring_practical.services.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("api/sp")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping()
    public @ResponseBody UserDto saveUser(@RequestBody UserDto userInput) {

        User user = userService.saveuser(userInput);

        UserDto userDto = new UserDto();

        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
//        userDto.setPassword(user.getPassword());
        userDto.setStatus(String.valueOf(user.getStatus()));

        return userDto;
    }
    @GetMapping()
    public @ResponseBody List<UserDto> getAllUsers() {

        List<User> userList = userService.getAllUsers();
        List<UserDto> userDtoList = new ArrayList<>();

        for (User user : userList) {
            UserDto userDto = new UserDto();
            userDto.setId(user.getId());
            userDto.setUserName(user.getUserName());
            userDto.setEmail(user.getEmail());
//            userDto.setPassword(user.getPassword());
            userDto.setStatus(String.valueOf(user.getStatus()));
            userDtoList.add(userDto);
        }
        return userDtoList;
    }
    @PutMapping("/update/{id}")
    public @ResponseBody UserDto updateById(@PathVariable("id") String id, @RequestBody UserDto userDto){

        User user = userService.updateById(id,userDto);

        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());

        return userDto;

    }
//    @DeleteMapping("/delete/{id}")
//    public @ResponseBody String deleteById(@PathVariable("id") String id){
//        userService.deleteUser(id);
//        return "success";
//    }
    @DeleteMapping("/delete/{id}")
    public @ResponseBody UserDto delete(@PathVariable String id){
        User user = userService.deleteUser(id);

        UserDto userDto =new UserDto();

        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setStatus(String.valueOf(user.getStatus()));

        return userDto;
    }

    @PostMapping("/login")
    public  @ResponseBody UserDto login(@RequestParam("email") String email,
                         @RequestParam("password") String password){

        User user = userService.loginUser(email,password);

        UserDto userDto = new UserDto();
        userDto.setId(user.getId());
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());

        return userDto;
    }

}

