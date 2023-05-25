package org.example.dao;

import org.example.model.Member;

import java.util.List;

public interface MemberDAO {

    boolean createMemberDAO(Member member);

    boolean updateMemberDAO(Member member);

    boolean deleteMemberDAO(Long id);

    Member getMemberDAOById(Long id);

    List<Member> getAllMembersDAO();




}
