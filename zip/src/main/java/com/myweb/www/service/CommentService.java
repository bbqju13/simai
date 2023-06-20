package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.CommentVO;

public interface CommentService {

	int cmtService(CommentVO cvo);

	List<CommentVO> getList(int bno);

	int updateComment(CommentVO cvo);

	int deleteComment(int cno);

}