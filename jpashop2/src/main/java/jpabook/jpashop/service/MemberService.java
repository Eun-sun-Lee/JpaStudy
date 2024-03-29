package jpabook.jpashop.service;

import jpabook.jpashop.domain.Member;
import jpabook.jpashop.repository.MemberRepository;
import jpabook.jpashop.repository.MemberRepositoryOld;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true) // default
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     */
    @Transactional
    public Long join(Member member) {
        validateDuplicateMember(member);
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());
        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }
    }

    // 회원 전체 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findById(memberId).get(); // 스프링 데이터 JPA는 Optional로 반환해주므로 .get()을 통해 가져옴.
    }

    // 변경 감지에 의한 회원 수정
    @Transactional
    public void update(Long id, String name) {
        Member member = memberRepository.findById(id).get(); // 영속성 컨텍스트에서 조회
        member.setName(name);
    }
}
