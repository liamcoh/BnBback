package com.example.demo.dao.repositories

import com.example.demo.dao.entities.House
import org.springframework.data.repository.CrudRepository

interface HousesRepository: CrudRepository<House, Long> {

    fun findAllByOwnerEmail(email: String): List<House>
}
