package com.example.demo.dao.repositories

import com.example.demo.dao.entities.Address
import org.springframework.data.repository.CrudRepository

interface AddressRepository: CrudRepository<Address, Long> {
}
