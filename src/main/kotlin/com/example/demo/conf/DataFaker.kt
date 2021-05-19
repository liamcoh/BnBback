package com.example.demo.conf

import com.example.demo.dao.entities.Address
import com.example.demo.dao.entities.House
import com.example.demo.dao.entities.User
import com.example.demo.dao.repositories.AddressRepository
import com.example.demo.dao.repositories.HousesRepository
import com.example.demo.dao.repositories.UserRepository
import com.github.javafaker.Faker
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component
import javax.annotation.PostConstruct


@Component
class DataFaker(
    @Autowired val userRepository: UserRepository,
    @Autowired val addressRepository: AddressRepository,
    @Autowired val housesRepository: HousesRepository
) {

    @PostConstruct
    fun fake() {
        val faker = Faker()

        addressRepository.deleteAll()
        repeat(10) {
            addressRepository.save(Address(null,
                faker.address().country(),
                faker.address().city(),
                faker.address().streetName(),
                faker.address().buildingNumber().toInt(),
                faker.address().latitude().toDouble(),
                faker.address().longitude().toDouble()
            ))
        }
        val addresses = addressRepository.findAll()

        userRepository.deleteAll()
        repeat(10) {
            userRepository.save(User(
                faker.internet().emailAddress(),
                faker.phoneNumber().cellPhone()
            ))
        }
        val users = userRepository.findAll()

        housesRepository.deleteAll()
        repeat(10) {
            housesRepository.save(House(
                null,
                users.toList().random(),
                true,
                faker.lorem().paragraph(),
                (1..5).toList().random(),
                addresses.toList().random()
        }
        }
    }
}
