package org.example.SpringBootDevleoperApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.util.Optional;
import java.util.List;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    public void test() {
        // 생성(Create)
        memberRepository.save(new Member(1L, "A"));

        // 조회(Read)
        Optional<Member> member = memberRepository.findById(1L);
        List<Member> allMember = memberRepository.findAll();

        // 삭제(Delete)
        memberRepository.deleteById(1L);
    }
}
