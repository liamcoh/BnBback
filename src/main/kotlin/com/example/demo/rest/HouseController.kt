package com.example.demo.rest

import com.example.demo.dao.entities.House
import com.example.demo.dao.repositories.HousesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("houses")
class HouseController(
    @Autowired val housesRepository: HousesRepository
) {

    @GetMapping("")
    fun getHouses(@RequestParam(required = false) email: String?): List<House> {
        if (email != null)
            return housesRepository.findAllByOwnerEmail(email)
        return housesRepository.findAll().toList()
    }
}
