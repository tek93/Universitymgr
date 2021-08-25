package com.example.universitymgr.controller;

import com.example.universitymgr.jwt.JwtTokenProvider;
import com.example.universitymgr.model.FieldStudent;
import com.example.universitymgr.model.Role;
import com.example.universitymgr.model.User;
import com.example.universitymgr.services.FieldStudentService;
import com.example.universitymgr.services.FiledService;
import com.example.universitymgr.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class UserController {

    @Autowired
    private JwtTokenProvider tokenProvider;
    @Autowired
    private UserService userService;
    @Autowired
    private FiledService fieldService ;
    @Autowired
    private FieldStudentService fieldStudentService;

        @PostMapping("/api/user/registration")
    public ResponseEntity<?> register(@RequestBody User user){
        if (userService.findByUsername(user.getUsername())!=null){
            return new ResponseEntity<>(HttpStatus.CONFLICT);

        }
        user.setRole(Role.STUDENT);
        return new ResponseEntity<>(userService.saveUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/api/user/login")
    public ResponseEntity<?> getUser(Principal principal){
        if(principal==null){
            return ResponseEntity.ok(principal);
        }
        UsernamePasswordAuthenticationToken authenticationToken = (UsernamePasswordAuthenticationToken)principal;
        User user = userService.findByUsername(authenticationToken.getName());
        user.setToken(tokenProvider.generateToken(authenticationToken));
        return new ResponseEntity<>(user,HttpStatus.OK);


    }
    @PostMapping("/api/user/enroll")
    public ResponseEntity<?>enrollFiled(@RequestBody FieldStudent fieldStudent){
          return new ResponseEntity<>(fieldStudentService.saveFieldStudent(fieldStudent), HttpStatus.CREATED);

    }
    @GetMapping("/api/user/fields")
    public ResponseEntity<?> getAllField(){
            return ResponseEntity.ok(fieldService.findAllField());
    }



}
