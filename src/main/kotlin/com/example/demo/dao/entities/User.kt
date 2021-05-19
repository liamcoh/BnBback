package com.example.demo.dao.entities

import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "users")
data class User(
    @Id
    val email: String,
    val contactPhone: String,
)
