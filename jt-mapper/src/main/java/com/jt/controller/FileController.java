package com.jt.controller;

import java.io.File;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.jt.service.FileService;
import com.jt.vo.ImageVO;
@RestController
public class FileController {
	
	@Autowired
	private FileService fileService;
	
	@RequestMapping("/file")
	public String file(MultipartFile fileImage) throws Exception {
		//定义文件目录信息
		String dirPath= "D:/jt-SOFT/images";
		File fileDir=new File(dirPath);
		
		//校验图片目录是否存在
		if(!fileDir.exists()) {//如果目标不存在则创建目录
			fileDir.mkdirs();//创建多级目录
			
		}
		//获取文件信息,一般都在上传提交的参数中
		String fileName=fileImage.getOriginalFilename();
		
		//实现文件上传
		File file=new File(dirPath+"/"+fileName);
		fileImage.transferTo(file);
		return "恭喜你,文件上传成功";
	}
	
	@RequestMapping("/pic/upload")
	public ImageVO uploadFile(MultipartFile uploadFile) {
		return fileService.uploadFile(uploadFile);
	}
	
	
}
