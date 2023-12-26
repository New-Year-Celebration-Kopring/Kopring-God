package com.example.kotlinPractice.service

import com.example.kotlinPractice.MemberDto
import com.example.kotlinPractice.domain.MemberEntity
import java.util.*

interface MemberService {
    fun findMember(name: String): Optional<MemberEntity>
    fun save(memberDto: MemberDto)
}