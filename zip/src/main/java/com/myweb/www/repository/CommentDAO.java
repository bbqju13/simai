package com.myweb.www.repository;

import java.util.List;

import com.myweb.www.domain.CommentVO;

public interface CommentDAO {

	int cmtPost(CommentVO cvo);

	List<CommentVO> getList(int bno);

	int updateCmt(CommentVO cvo);

	int deleteCmt(int cno);

}