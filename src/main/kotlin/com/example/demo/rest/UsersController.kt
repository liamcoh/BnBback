package com.example.demo.rest

import com.example.demo.dao.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("users")
class UsersController(
    @Autowired val userRepository: UserRepository
) {

    @GetMapping("")
    fun getAllUsers() = userRepository.findAll().toList()
}
