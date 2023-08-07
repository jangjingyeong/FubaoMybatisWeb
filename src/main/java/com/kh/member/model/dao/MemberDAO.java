package com.kh.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.member.model.vo.Member;

public class MemberDAO {

	public int insertMember(SqlSession session, Member member) {
//		int result = session.insert("쿼리문", 넘겨줄 값);
		int result = session.insert("MemberMapper.insertMember", member);
		// member-mapper.xml 파일이랑 같게 써야함 
		// MemeberMapper에 있는 insertMember를 쓰겠다고 지정해줌 
		return result;
	}

	public int updateMember(SqlSession session, Member member) {
		int result = session.delete("MemberMapper.updateMember", member);
		return result;
	}

	public int deleteMember(SqlSession session, String memberId) {
		int result = session.delete("MemberMapper.deleteMember", memberId);
		return result;
	}

	public Member selectCheckLogin(SqlSession session, Member member) {
		Member mOne = session.selectOne("MemberMapper.selectCheckLogin", member);
		return mOne;
	}

	public Member selectOneById(SqlSession session, String memberId) {
		Member member = session.selectOne("MemberMapper.selectOneById", memberId);
		return member;
	}



}
