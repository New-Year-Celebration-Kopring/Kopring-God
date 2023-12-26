package com.example.kotlinPractice.service

import com.example.kotlinPractice.MemberDto
import com.example.kotlinPractice.domain.MemberEntity
import com.example.kotlinPractice.domain.MemberRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service
import java.util.*

@Service
class MemberServiceImpl(private val memberRepository: MemberRepository): MemberService {
    override fun findMember(name: String): Optional<MemberEntity> {
        return memberRepository.findByName(name)
    }

    @Transactional
    override fun save(memberDto: MemberDto) {
        memberRepository.save(MemberEntity(memberDto.name, memberDto.email, memberDto.phone))
    }
}