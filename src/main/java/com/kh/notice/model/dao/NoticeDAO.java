package com.kh.notice.model.dao;

import java.util.List;

import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;

import com.kh.notice.model.vo.Notice;

public class NoticeDAO {

	// 글 작성 
	public int insertNotice(SqlSession session, Notice notice) {
		// JDBC랑 다르게 1줄이면 코드 끝 	
		// insert를 하려면 session에서 insert() 메소드 호출 후 
		// mapper.xml의 name값(NoticeMapper)과 쿼리문의 id값(insertNotice)을 호출!
		// 한 줄 쓰고 끝나는게 아니라 notice-mapper.xml을 만들고 태그를 이용해서 쿼리문 작성
		// mapper.xml을 사용한다고 mybatis-config.xml에 신고/등록 해야함! 
		int result = session.insert("NoticeMapper.insertNotice", notice);
		return result;
	}
	
	public int updateNotice(SqlSession session, Notice notice) {
		int result = session.update("NoticeMapper.updateNotice", notice);
		return result;
	}

	public int deleteNotice(SqlSession session, int noticeNo) {
		int result = session.insert("NoticeMapper.deleteNotice", noticeNo);
		return result;
	}

	// 전체 조회 
	public List<Notice> selectNoticeList(SqlSession session, int currentPage) {
		// select를 하려면 session에서 selectList, selectOne 메소드 중에서 필요에 맞게 호출!
		// mapper.xml의 name값(NoticeMapper)과 쿼리문의 id값(selectNoticeList)을 호출!
		// 넘겨주는 값(매개변수)은 없으므로 name.id값만 selectList() 메소드의 전달값으로 넘겨줌
		// mapper.xml에서는 select이기 때문에 rsetToNotice에 해당하는 ResultMap을 작성해줘야함
		/*
		 *  RowBounds는 왜 쓰나요? 쿼리문을 변경하지 않고도 페이징을 처리할 수 있게 해주는 클래스
		 *  RowBounds의 동작은 offset값과 limit값을 이용해서 동작함 
		 *  limit값은 한 페이지당 보여주고 싶은 게시물의 갯수
		 *  offset값은 시작값, 변하는 값 
		 *  1페이지에서는 0부터 시작해서 10개를 가져오고 1 ~ 10
		 *  2페이지에서는 10부터 시작해서 ...			 11 ~ 20
		 *  3페이지에서는 20부터 시작해서 ... 			 21 ~ 30
		 */
		int limit = 10;
		int offset = (currentPage-1)*limit;
		RowBounds rowBounds = new RowBounds(offset, limit);
		List<Notice> nList = session.selectList("NoticeMapper.selectNoticeList", null, rowBounds);
		return nList;
	}

	// 공지사항 상세 보기
	public Notice selectOneByNo(SqlSession session, int noticeNo) {
		Notice notice = session.selectOne("NoticeMapper.selectOneByNo", noticeNo);
		return notice;
	}
	
	


}
