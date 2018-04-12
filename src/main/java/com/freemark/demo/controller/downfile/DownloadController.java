package com.freemark.demo.controller.downfile;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.fileUpload;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.freemark.demo.enums.ContentTypeEnum;
import com.freemark.demo.util.file.FileUtil;

@RestController
@RequestMapping({ "/download" })
public class DownloadController {
	
	private static Logger logger = Logger.getLogger(DownloadController.class);

	private static final String APPLICATION_PDF = "application/pdf";

	@RequestMapping(value = "/a", method = RequestMethod.GET, produces = APPLICATION_PDF)
	public void downloadA(HttpServletResponse response, HttpServletRequest request) throws IOException {
		File file = FileUtil.getFile(request, "example.pdf");
		InputStream in = new FileInputStream(file);

		response.setContentType(ContentTypeEnum.PDF.type);
		response.setHeader("Content-Disposition", "attachment; filename=" + file.getName());
		response.setHeader("Content-Length", String.valueOf(file.length()));
		FileCopyUtils.copy(in, response.getOutputStream());
	}

	@RequestMapping(value = "/b", method = RequestMethod.GET, produces = APPLICATION_PDF)
	public HttpEntity<byte[]> downloadB(HttpServletRequest request) throws IOException {
		File file = FileUtil.getFile(request, "example.pdf");
		byte[] document = FileCopyUtils.copyToByteArray(file);

		HttpHeaders header = new HttpHeaders();
		header.setContentType(new MediaType("application", "pdf"));
		header.set("Content-Disposition", "inline; filename=" + file.getName());
		header.setContentLength(document.length);

		return new HttpEntity<byte[]>(document, header);
	}

	@RequestMapping(value = "/c", method = RequestMethod.GET, produces = APPLICATION_PDF)
	public Resource downloadC(HttpServletResponse response, HttpServletRequest request) throws FileNotFoundException {
		File file = FileUtil.getFile(request, "example.pdf");
		response.setContentType(ContentTypeEnum.PDF.type);
		response.setHeader("Content-Disposition", "inline; filename=" + file.getName());
		response.setHeader("Content-Length", String.valueOf(file.length()));
		return new FileSystemResource(file);
	}
}