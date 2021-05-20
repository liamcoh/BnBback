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
        housesRepository.deleteAll()
        addressRepository.deleteAll()
        userRepository.deleteAll()

        val faker = Faker()

        repeat(10) {
            addressRepository.save(
                Address(
                    null,
                    faker.address().country(),
                    faker.address().city(),
                    faker.address().streetName(),
                    faker.address().buildingNumber().toInt(),
                    faker.address().latitude().toDouble(),
                    faker.address().longitude().toDouble()
                )
            )
        }
        val addresses = addressRepository.findAll()

        repeat(10) {
            userRepository.save(
                User(
                    faker.internet().emailAddress(),
                    faker.name().name(),
                    faker.phoneNumber().cellPhone()
                )
            )
        }
        val users = userRepository.findAll()

        repeat(10) {
            housesRepository.save(
                House(
                    null,
                    users.toList().random(),
                    true,
                    faker.lorem().paragraph(),
                    (1..5).toList().random(),
                    addresses.toList().random(),
                    arrayOf(
                        "https://blisssaigon.com/wp-content/uploads/2019/10/Untitled.jpg",
                        "https://miro.medium.com/max/5360/1*p1zBnv11CSx_EII8sB9Uaw.jpeg",
                        "https://expatlifeinthailand.com//assets/media/2018/08/dirtiest.jpg"
                    ).random()
                )
            )
        }
    }
}
