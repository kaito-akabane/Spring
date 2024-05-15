package jpabook.jpashop.repository;

import jpabook.jpashop.entity.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest
public class MemberRepositoryTest {
    
    @Autowired private MemberRepository memberRepository;
    
    @Test
    @Transactional
    public void testMember() throws Exception {
        Member member = new Member();
        member.setName("memberA");
       
        Long saveId = memberRepository.save(member);
        Member findMember = memberRepository.find(saveId);
        
        Assertions.assertThat(findMember.getId()).isEqualTo(member.getId());
        Assertions.assertThat(findMember.getName()).isEqualTo(member.getName());
    }
}