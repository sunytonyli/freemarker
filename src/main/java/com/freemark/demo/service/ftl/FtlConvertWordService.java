package com.freemark.demo.service.ftl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

/**
 * freemarker 生成 wrokd类
 * 
 * @author lisy
 *
 */

@Service
public class FtlConvertWordService {

	private static Logger logger = LoggerFactory.getLogger(FtlConvertWordService.class);

	@Autowired
	private FreeMarkerConfigurer freemarkerConfig;

	public <K, V> void generalWord97(String templateFile, String toFile, Map<K, V> dataMap)
			throws TemplateException, IOException {

		logger.info("start from ftl convert word97-03, templateFile[{}], toFile[{}]", templateFile, toFile);

		/* Get the template (uses cache internally) */
		Configuration cfg = freemarkerConfig.getConfiguration();
		Template temp = cfg.getTemplate(templateFile);

		/* Merge data-model with template */
		// 导出文件
		File outFile = new File(toFile);
		Writer out = null;
		
		try {

			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));

		} catch (FileNotFoundException fex) {
			
			logger.error("start from ftl convert word97-03, templateFile[{}], toFile[{}] exception:", fex);
			
		} finally {
			if (out != null) {
				out.flush();
				out.close();
			}
		}
		
		temp.process(dataMap, out);

	}

}
