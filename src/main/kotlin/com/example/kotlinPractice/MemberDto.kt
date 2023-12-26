package com.example.kotlinPractice

data class MemberDto(
    val name: String,
    val email: String,
    val phone: String? = null
)
