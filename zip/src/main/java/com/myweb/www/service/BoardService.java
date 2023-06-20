package com.myweb.www.service;

import java.util.List;

import com.myweb.www.domain.BoardDTO;
import com.myweb.www.domain.BoardVO;
import com.myweb.www.domain.MemberVO;
import com.myweb.www.domain.PagingVO;

public interface BoardService {

	int register(MemberVO bvo);

	List<BoardVO> getList();

	BoardVO getDetail(int bno);

	int readCount(int bno);

	

	int delete(int bno);

	int modify(BoardDTO bdto, MemberVO user);

	List<BoardVO> getList(PagingVO pvo);

	int gettotalCnt(PagingVO pvo);

	List<BoardVO> search(String keyword);

	int register(BoardDTO bdto);

	BoardDTO getDetailfile(int bno);

	int removeFile(String uuid);

	int modifyFile(BoardDTO bdto, MemberVO user);

}