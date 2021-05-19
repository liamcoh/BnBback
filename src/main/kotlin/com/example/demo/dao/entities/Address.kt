package com.example.demo.dao.entities

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity(name="addresses")
data class Address(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    val id: Long?,
    val country: String,
    val city: String,
    val street: String,
    val apt: Int,
    val lat: Double,
    val lng: Double,
)
