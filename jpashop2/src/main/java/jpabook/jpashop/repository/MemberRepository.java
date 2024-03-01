package jpabook.jpashop.repository;

import jpabook.jpashop.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> { // 클래스 타입, pk 타입
    List<Member> findByName(String name); // select m from Member m where m.name = ?

}
