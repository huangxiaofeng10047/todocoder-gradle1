package com.todocoder.gradle.todocodergradle1.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/todocoder")
public class TodoCoderController {
   @GetMapping("/helloword")
  public ResponseEntity<String> helloword(){
      return ResponseEntity.ok("helloword");
  }
}
