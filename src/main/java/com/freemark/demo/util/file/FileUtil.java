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
		
		String appPath = ""; String fullPath = ""; String downloadPath = String.format("resources%sdownloads", File.separator);

		/**
		 * 获取应用的绝对路径
		 */
		appPath = req.getSession().getServletContext().getRealPath("");
		
		logger.info("appPath====={}", appPath);
		
		fullPath = appPath + File.separator + downloadPath;
		
		logger.info("fullPath====={}", fullPath);
		
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
			throw new FileNotFoundException(
					String.format("file with path: %s was not found.", filePath));
		}
		return file;
	}

	/**
	 * 
	 * @param req
	 * @return
	 * @throws FileNotFoundException
	 */
	public static String getTemplateFilePath(HttpServletRequest req) throws FileNotFoundException {
		String appPath = "";
		String fullPath = "";
		String templateFilePath = String.format("WEB-INF%sviews%stemplate%s", File.separator, File.separator, File.separator);

		appPath = req.getSession().getServletContext().getRealPath("");
		fullPath = appPath + File.separator + templateFilePath;

		return fullPath;
	}
}
