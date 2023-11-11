package org.example.SpringBootDevleoperApplication;

import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;

public class example {

    @Autowired
    EntityManager em;

    public void example_EntityStatus() {
        // 비영속 상태
        Member member = new Member(1L, "홍길동");
        // 관리 상태
        em.persist(member);
        // 비영속 상태
        em.detach(member);
        // 삭제 상태
        em.remove(member);
    }



}
