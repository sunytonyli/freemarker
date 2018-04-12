package com.freemark.demo.util.file;

import java.io.File;
import java.io.FileNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author lisy
 *
 */

public class FileUtil {
	
	private static Logger logger = LoggerFactory.getLogger(FileUtil.class);

	/**
	 * 获取文件的绝对路径
	 * @param req
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String getFilePath(HttpServletRequest req) throws FileNotFoundException {
		
		String appPath = "", fullPath = "", downloadPath = "resources/downloads";

		/**
		 * 获取应用的绝对路径
		 */
		appPath = req.getSession().getServletContext().getRealPath("");
		fullPath = appPath + File.separator + downloadPath;
		
		return fullPath;
	}
	
	/**
	 * 获取文件
	 * @param req
	 * @return
	 * @throws FileNotFoundException
	 */
	public static File getFile(HttpServletRequest req, String fileName) throws FileNotFoundException {
		String filePath = getFilePath(req) + File.separator + fileName;
		logger.info("Destination Location For The File Is?= {}", filePath);
		File file = new File(filePath);
		if (!file.exists()) {
			throw new FileNotFoundException(String.format("file with path: %s was not found.", filePath));
		}
		return file;
	}
	
}
