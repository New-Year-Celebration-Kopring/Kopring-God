package com.example.kotlinPractice.domain

import jakarta.persistence.*

@Entity
@Table(name = "MEMBER")
class MemberEntity(
    var name: String,
    val email: String,
    val phone: String? = null,
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0L,
) {
    fun changeName(name: String) {
        this.name = name
    }
}