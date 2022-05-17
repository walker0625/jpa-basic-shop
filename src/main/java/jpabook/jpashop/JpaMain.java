package jpabook.jpashop;

import jpabook.jpashop.domain.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa"); // <persistence-unit name="jpa">
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        try {
            Member member1 = new Member();
            member1.setName("kim1");

            em.persist(member1);

            Member member2 = new Member();
            member2.setName("kim2");

            em.persist(member2);

            em.flush();
            em.clear();

            // JPQL(가장 주로 쓰임) > QueryDSL로 만들어줌 - QueryDSL > JPQL > SQL > DB
            List<Member> resultList = em.createQuery("SELECT m FROM Member m WHERE m.name LIKE '%kim%'", Member.class).getResultList();

            for (Member member : resultList) {
                System.out.println("member.getName() = " + member.getName());
            }

            // Native Query : 특정 DB에 종속적인 Query에 경우 주로 사용(connect by)
            List select_name_from_member = em.createNativeQuery("SELECT name FROM MEMBER", Member.class).getResultList();



            /* Critetia : 실무에서 안씀 > 가독성 최악 > QueryDSL 추천
            CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
            CriteriaQuery<Member> query = criteriaBuilder.createQuery(Member.class);

            Root<Member> m = query.from(Member.class);

            CriteriaQuery<Member> cq = query.select(m).where(criteriaBuilder.equal(m.get("name"), "kim"));
            List<Member> resultList1 = em.createQuery(cq).getResultList();
            */

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
