package org.centresportif.services;

import org.centresportif.entities.Member;
import org.centresportif.interfaces.Repository;

import java.util.List;

public class MemberService extends BaseService implements Repository<Member> {

    public MemberService() {
        super();
    }

    @Override
    public boolean create(Member o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.save(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Member o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.update(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(Member o) {
        session = sessionFactory.openSession();
        session.beginTransaction();
        session.delete(o);
        session.getTransaction().commit();
        session.close();
        return true;
    }

    @Override
    public Member findById(int id) {
        Member member = null;
        session = sessionFactory.openSession();
        member = (Member) session.get(Member.class, id);
        session.close();
        return member;
    }

    @Override
    public List<Member> findAll() {
        List<Member> memberList = null;
        session = sessionFactory.openSession();
        memberList = session.createQuery("from Member").list();
        session.close();
        return memberList;
    }

    public void begin() {
        session = sessionFactory.openSession();
    }

    public void end() {
    }
}
