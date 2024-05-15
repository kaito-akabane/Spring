package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Transactional
public class MemberService {
    private final MemberRepository memberRepository;
    
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    
    public Long join(Member member) {
        // 이름 중복 X
        validateDuplicate(member);
        memberRepository.save(member);
        return member.getId();
    }
    
    private void validateDuplicate(Member member) {
        memberRepository.findByName(member.getName()).
                ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    
    public List<Member> findMember() {
        return memberRepository.findAll();
    }
    
    public Optional<Member> findOne(Long id) {
        return memberRepository.findById(id);
    }
}
