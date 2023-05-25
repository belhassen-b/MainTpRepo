package org.example.dao.impl;

import org.example.dao.MemberDAO;
import org.example.model.Member;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class MemberDAOImpl implements MemberDAO {
    private final EntityManagerFactory entityManagerFactory;

    public MemberDAOImpl(EntityManagerFactory entityManagerFactory) {
        this.entityManagerFactory = entityManagerFactory;
    }

    @Override
    public boolean createMemberDAO(Member member) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(member);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
        finally {
            entityManager.close();
        }

    }

    @Override
    public boolean updateMemberDAO(Member member) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            entityManager.merge(member);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public boolean deleteMemberDAO(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Member member = entityManager.find(Member.class, id);
            entityManager.remove(member);
            entityManager.getTransaction().commit();
            return true;
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public Member getMemberDAOById(Long id) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            Member member = entityManager.find(Member.class, id);
            entityManager.getTransaction().commit();
            return member;
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public List<Member> getAllMembersDAO() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        try {
            entityManager.getTransaction().begin();
            List<Member> members = entityManager.createQuery("from Member", Member.class).getResultList();
            entityManager.getTransaction().commit();
            return members;
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
            return null;
        }
        finally {
            entityManager.close();
        }
    }
}
