package jpabook.jpashop;

import jpabook.jpashop.domain.Address;
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

            Member member = new Member();
            member.setName("minwoo");
            member.setHomeAddress(new Address("AA", "BB", "CC"));

            member.getFavoriteFoods().add("a");
            member.getFavoriteFoods().add("b");
            member.getFavoriteFoods().add("c");
            // Member refMember = em.getReference(Member.class, member.getId()); // 프록시 객체

            member.getAddressHistory().add(new Address("A1", "BB", "CC"));
            member.getAddressHistory().add(new Address("A2", "BB", "CC"));

            em.persist(member);

            em.flush();
            em.clear();

            System.out.println("--------------------------");

            Member findMember = em.find(Member.class, member.getId());

            List<Address> addressHistory = findMember.getAddressHistory();
            System.out.println("--------------------------");

            for (Address address : addressHistory) {
                System.out.println("address.getCity() = " + address.getCity());
            }

            findMember.setHomeAddress(new Address("new AA", "BB", "CC"));

            findMember.getFavoriteFoods().remove("a");
            findMember.getFavoriteFoods().add("a1");

            // equals()가 구현되어 있어야 함 > 키에 해당하는 모든 값을 지움(실무에서는 일대다로 푸는게 나음)
            findMember.getAddressHistory().remove(new Address("A1", "BB", "CC"));
            findMember.getAddressHistory().add(new Address("new A1", "BB", "CC"));

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }

        emf.close();
    }
}
