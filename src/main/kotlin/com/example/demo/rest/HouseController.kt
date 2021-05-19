package com.example.demo.rest

import com.example.demo.dao.entities.House
import com.example.demo.dao.repositories.AddressRepository
import com.example.demo.dao.repositories.HousesRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("houses")
class HouseController(
    @Autowired val housesRepository: HousesRepository,
    @Autowired val addressRepository: AddressRepository
) {

    @GetMapping("")
    fun getHouses(@RequestParam(required = false) email: String?): List<House> {
        if (email != null)
            return housesRepository.findAllByOwnerEmail(email)
        return housesRepository.findAll().toList()
    }

    @PostMapping("")
    fun addHouse(@RequestBody house: House): House {
        house.address = addressRepository.save(house.address)
        return housesRepository.save(house)
    }

    @DeleteMapping("{id}")
    fun deleteHouse(@PathVariable("id") id: Long) = housesRepository.deleteById(id)
}
