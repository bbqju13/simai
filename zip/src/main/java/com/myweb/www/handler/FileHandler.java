package com.myweb.www.handler;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.apache.tika.Tika;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.myweb.www.domain.FileVO;

import lombok.AllArgsConstructor;
import net.coobird.thumbnailator.Thumbnails;

@Component
@AllArgsConstructor
public class FileHandler {
	private static final Logger log = LoggerFactory.getLogger(FileHandler.class);
	private final String up_dir = "D:\\_myweb\\_java\\fileupload";

	public List<FileVO> upList(MultipartFile[] files) {
		LocalDate date = LocalDate.now();
		log.info(" >>>>> DATE >>>>> : " + date);
		String today = date.toString();
		today = today.replace("-", File.separator);
		File folders = new File(up_dir, today);
		if (!folders.exists()) {
			folders.mkdirs();
		}
		List<FileVO> list = new ArrayList<FileVO>();
		for (MultipartFile file : files) {
			FileVO fvo = new FileVO();
			fvo.setSave_dir(today);
			fvo.setFile_size(file.getSize());

			String originalfileName = file.getOriginalFilename();
			String onlyfileName = originalfileName.substring(originalfileName.lastIndexOf(File.separator) + 1);
			log.info(" >>>>> 파일이름 : >>>>> : " + onlyfileName);
			fvo.setFile_name(onlyfileName);

			UUID uuid = UUID.randomUUID();
			fvo.setUuid(uuid.toString());

			String fullfileName = uuid.toString() + "_" + onlyfileName;
			log.info(" >>>>> 전체파일이름 >>>>> : " + fullfileName);
			File storeFile = new File(folders, fullfileName);

			try {
				file.transferTo(storeFile);
				if (isImgFile(storeFile)) {
					fvo.setFile_type(1);
					File thumbNail = new File(folders, uuid.toString() + "_th_" + onlyfileName);
					Thumbnails.of(storeFile).size(100, 100).toFile(thumbNail);
				}
			} catch (Exception e) {
				// TODO: handle exception
				log.info(" >>>>> file 생성 오류 >>>>> : ");
				e.printStackTrace();
			}
			list.add(fvo);
		}
		return list;
	}

	private boolean isImgFile(File storeFile) throws IOException {
		String mimType = new Tika().detect(storeFile);
		return mimType.startsWith("image") ? true : false;
	}
}
