package org.example.SpringBootDevleoperApplication;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class TestService {

    @Autowired
    MemberRepository memberRepository; // 빈 주입

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }
}
