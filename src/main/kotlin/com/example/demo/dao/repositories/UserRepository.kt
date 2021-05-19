package com.example.demo.dao.repositories

import com.example.demo.dao.entities.User
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<User,String>{
}
