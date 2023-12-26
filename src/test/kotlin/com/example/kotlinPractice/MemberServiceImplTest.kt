package com.example.kotlinPractice

import com.example.kotlinPractice.domain.MemberEntity
import com.example.kotlinPractice.domain.MemberRepository
import com.example.kotlinPractice.service.MemberService
import jakarta.transaction.Transactional
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class MemberServiceImplTest(
    @Autowired val memberService: MemberService,
    @Autowired val memberRepository: MemberRepository
) {
    @Test
    @DisplayName("member 조회에 성공한다.")
    @Transactional
    fun memberFind() {
        val member = MemberEntity(
            "hoondong", "hoondong@mail.com", "01025021875")
        memberRepository.save(member)
        val findMember = memberService.findMember("hoondong").get()
        assertEquals(findMember.name, member.name)
    }
}