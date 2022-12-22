package com.example.demo.controllers;

import com.example.demo.models.User;
import com.example.demo.repositories.UserRepository;
import com.example.demo.security.AuthenticationRequest;
import com.example.demo.security.AuthenticationResponse;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.MyUSerDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
class UserController {
  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private JwtUtil jwtTokenUtil;

  @Autowired
  private MyUSerDetailService userDetailsService;

  @Autowired
  private UserRepository userRepository;

  @RequestMapping({"/hello"})
  public String firstPage() {
    return "Hello World";
  }

  @PostMapping("/authenticate")
  public ResponseEntity<?> createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {

    try {
      authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
      );
    } catch (Exception e) {
      throw new Exception("Incorrect username or password", e);
    }


    final UserDetails userDetails = userDetailsService
      .loadUserByUsername(authenticationRequest.getUsername());

    final String jwt = jwtTokenUtil.generateToken(userDetails);

    return ResponseEntity.ok(new AuthenticationResponse(jwt));
  }

  @PostMapping("/signup")
  public void addUser(@RequestBody User user) {
    user.setUsername(user.getEmail());
    user.setActive(true);
    user.setRoles("ADMIN");
    this.userRepository.save(user);
  }

}
