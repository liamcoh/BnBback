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
                        "https://www.google.com/search?q=hotel+room&rlz=1C1PNBB_enIL924IL924&sxsrf=ALeKk01Fkk4_1ULPzVJ3RZDpyXIX-mmEfQ:1621467743091&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiFrt2G9tbwAhXRUMAKHQolDPsQ_AUoAXoECAMQAw&biw=1229&bih=578#imgrc=ir2Qav_1gjJmEM",
                        "https://www.google.com/search?q=hotel+room&rlz=1C1PNBB_enIL924IL924&sxsrf=ALeKk01Fkk4_1ULPzVJ3RZDpyXIX-mmEfQ:1621467743091&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiFrt2G9tbwAhXRUMAKHQolDPsQ_AUoAXoECAMQAw&biw=1229&bih=578#imgrc=tkUHov-lfC0zbM",
                        "https://www.google.com/search?q=hotel+room&rlz=1C1PNBB_enIL924IL924&sxsrf=ALeKk01Fkk4_1ULPzVJ3RZDpyXIX-mmEfQ:1621467743091&source=lnms&tbm=isch&sa=X&ved=2ahUKEwiFrt2G9tbwAhXRUMAKHQolDPsQ_AUoAXoECAMQAw&biw=1229&bih=578#imgrc=130V6HWjJViTbM"
                    ).random()
                )
            )
        }
    }
}
