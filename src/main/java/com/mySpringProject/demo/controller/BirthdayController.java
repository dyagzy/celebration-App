package com.mySpringProject.demo.controller;

import com.mySpringProject.demo.bean.Birthday;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("students")
public class BirthdayController {

  @GetMapping("/hello-birthday")
  public String hello() {
    return "Hello Birthday";
  }

  @GetMapping("/student")
  public Birthday getBirthday() {

    return new Birthday(1, "2024-12-2", "Daniel");
  }

  @GetMapping
  public List<Birthday> getBirthdays() {

    return List.of(
        new Birthday(1, "2024-12-2", "Daniel"),
        new Birthday(1, "2024-12-2", "Daniel"),
        new Birthday(2, "2022-11-21", "John"),
        new Birthday(3, "2023-10-4", "James"),
        new Birthday(4, "2021-1-24", "Paul"));
  }

  @GetMapping("/student/{id}")
  public Birthday getBirthdaByIdy(@PathVariable int id) {

    return new Birthday(id, "2024-12-2", "Daniel");
  }

  @GetMapping("/student/query")
  public Birthday getBirthdaByQueryParam(
      @RequestParam int id, @RequestParam String dob, @RequestParam String name) {

    return new Birthday(id, dob, name);
  }

  @PostMapping("/student/create")
  public Birthday createStudent(@RequestBody Birthday birthday) {

    return birthday;
  }

  @PutMapping("{id}")
  public Birthday updateStudent(@PathVariable int id, @RequestBody Birthday birthday) {

    return birthday;
  }
}
