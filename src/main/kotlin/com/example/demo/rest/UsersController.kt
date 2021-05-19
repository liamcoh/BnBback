package com.example.demo.rest

import com.example.demo.dao.entities.User
import com.example.demo.dao.repositories.HousesRepository
import com.example.demo.dao.repositories.UserRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("users")
class UsersController(
    @Autowired val userRepository: UserRepository,
    @Autowired val housesRepository: HousesRepository
) {

    @GetMapping("")
    fun getAllUsers() = userRepository.findAll().toList()

    @PostMapping("")
    fun addUser(@RequestBody user: User) = userRepository.save(user)

    @DeleteMapping("{email}")
    fun deleteUser(@PathVariable("email") email: String) {
        housesRepository.findAllByOwnerEmail(email).forEach{
            housesRepository.delete(it)
        }
        userRepository.deleteById(email)
    }
}
