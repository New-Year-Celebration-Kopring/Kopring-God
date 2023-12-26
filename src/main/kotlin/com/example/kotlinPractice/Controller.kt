package com.example.kotlinPractice

import com.example.kotlinPractice.domain.MemberEntity
import com.example.kotlinPractice.service.MemberService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.ui.set
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/v1/member")
class Controller (
    private val memberService: MemberService,
) {
    @GetMapping("/{name}")
    fun getMember(@PathVariable(value = "name") name: String): ResponseEntity<MemberEntity> {
        return ResponseEntity.ok(memberService.findMember(name).get())
    }

    @PostMapping("")
    fun insertMember(@RequestBody memberDto: MemberDto): ResponseEntity<Any> {
        memberService.save(memberDto)
        return ResponseEntity.status(HttpStatus.CREATED).body("회원가입 완료")
    }
}