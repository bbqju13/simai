package com.myweb.www.contorller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.myweb.www.domain.CommentVO;
import com.myweb.www.service.CommentService;

@RequestMapping("/comment/*")
@Controller
public class CommentContorller {
	private static final Logger log = LoggerFactory.getLogger(CommentContorller.class);

	@Inject
	private CommentService csv;

	
	@PostMapping(value = "/post", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> post(@RequestBody CommentVO cvo) {
		log.info(" >>>>> cvo >>>>> : " + cvo);
		int isOk = csv.cmtService(cvo);
		return isOk > 0 ? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@GetMapping(value = "/list/{bno}", produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<List<CommentVO>> list(@PathVariable("bno") int bno) {
		log.info(" >>>>> CMT LIST BNO >>>>> : " + bno);
		List<CommentVO> list = csv.getList(bno);
		log.info(" >>>>> list size >>>>> : " + list.size());
		return new ResponseEntity<List<CommentVO>>(list, HttpStatus.OK);
	}

	@PostMapping(value = "/update", consumes = "application/json", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> update(@RequestBody CommentVO cvo) {
		log.info(">>>>> update CVO >>>>> : " + cvo);
		int isOk = csv.updateComment(cvo);
		return isOk > 0 ? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PostMapping(value = "/delete/{cno}", produces = { MediaType.TEXT_PLAIN_VALUE })
	public ResponseEntity<String> delete(@PathVariable("cno") int cno) {
		log.info(">>>>> Delete CNO >>>>> : " + cno);
	
		int isOk = csv.deleteComment(cno);	
		return isOk > 0 ? new ResponseEntity<String>("1", HttpStatus.OK)
				: new ResponseEntity<String>("0", HttpStatus.INTERNAL_SERVER_ERROR);
	}


}