package com.myweb.www.service;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.repository.CommentDAO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CommentServiceImpl implements CommentService {
	private static final Logger log = LoggerFactory.getLogger(CommentServiceImpl.class);

	@Inject
	private CommentDAO cdao;

	@Override
	public int cmtService(CommentVO cvo) {
		// TODO Auto-generated method stub
		log.info(" >>>>> post >>>>> : " + cvo);
		return cdao.cmtPost(cvo);
	}

	@Override
	public List<CommentVO> getList(int bno) {
		// TODO Auto-generated method stub
		log.info(" >>>>> LIST >>>>> : " + bno);
		return cdao.getList(bno);
	}

	@Override
	public int updateComment(CommentVO cvo) {
		// TODO Auto-generated method stub
		log.info(" >>>>> CMT 수정 >>>>> : " + cvo);
		return cdao.updateCmt(cvo);
	}

	@Override
	public int deleteComment(int cno) {
		// TODO Auto-generated method stub
		log.info(" >>>>> CMT 삭제 >>>>> : " + cno);
		return cdao.deleteCmt(cno);
	}
}