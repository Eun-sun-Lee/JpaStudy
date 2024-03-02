package hellojpa;

import jakarta.persistence.*;

import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello"); // 애플리케이션 로딩 시점에 딱 하나만 만들어놔야함.
        EntityManager em = emf.createEntityManager(); // DB connection을 얻어 쿼리를 날리고 종료되는 한 일관적인 단위를 수행할 때마다 entityManager 생성 필요

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setId(1L);
            member.setName("HelloA");
            em.persist(member);

            Member findMember = em.find(Member.class, 1L);
            findMember.setName("HelloJPA");
            System.out.println("findMember.id = " + findMember.getId());
            System.out.println("findMember.name = " + findMember.getName());

            List<Member> result = em.createQuery("select m from Member m", Member.class)
                    .setFirstResult(0)
                    .setMaxResults(100)
                    .getResultList();

            for (Member m : result) {
                System.out.println("member.name = " + m.getName());
            }

            em.remove(findMember); // 회원 삭제

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close(); // 실제 application이 완전히 끝나면 EntityManagerFactory를 닫아줌.
    }
}
