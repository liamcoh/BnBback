package com.example.demo.dao.entities

import com.fasterxml.jackson.annotation.JsonBackReference
import javax.persistence.*

@Entity(name = "houses")
data class House(
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    val id: Long?,
    @ManyToOne
    @JsonBackReference
    val owner: User,
    val isActive: Boolean,
    val description: String,
    @OneToOne
    val address: Address
)
