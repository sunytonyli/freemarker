package com.freemark.demo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import com.freemark.demo.util.XmlToDocx;
import com.freemark.demo.util.XmlToExcel;

import freemarker.core.ParseException;
import freemarker.template.Configuration;
import freemarker.template.MalformedTemplateNameException;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;
import freemarker.template.TemplateNotFoundException;

/**
 * 
 * @author lisy
 *
 */
@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:D:/workspace-sts-3.9.1.RELEASE/freemarkdemo/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
//@ContextConfiguration(locations = {"classpath:./spring/appServlet/servlet-context.xml" })
public class ExportWordTest {

	@Autowired
	private FreeMarkerConfigurer freemarkerConfig;
	
	
	@Test
	public void testExportWord97To03() throws TemplateNotFoundException, MalformedTemplateNameException, ParseException, IOException, TemplateException {
			Map root = new HashMap();
	        root.put("user", "Big Joe");
	        Map latest = new HashMap();
	        root.put("latestProduct", latest);
	        latest.put("url", "products/greenmouse.html");
	        latest.put("name", "green mouse");

	        /* Get the template (uses cache internally) */
	        Configuration cfg = freemarkerConfig.getConfiguration();
	        Template temp = cfg.getTemplate("testword.ftl");

	        /* Merge data-model with template */
	        //Writer out = new OutputStreamWriter(System.out);
	        File outFile = new File("D:\\test.doc"); //导出文件
	        Writer out = null;
	        try {
	        	out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
	        	//out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
	        }catch(FileNotFoundException e1) {
	        	e1.printStackTrace();
	        }
	        temp.process(root, out);
	        out.flush();
	        out.close();
	}
	
	/**
	 * 生成word97-2003
	 * @throws IOException
	 * @throws TemplateException
	 */
	@Test
	public void testExportWord() throws IOException, TemplateException {
		
		/* Create and adjust the configuration singleton */
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_22);
        cfg.setDirectoryForTemplateLoading(new File("D:\\workspace-sts-3.9.1.RELEASE\\freemarkdemo\\src\\main\\webapp\\resources\\freemarker"));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        
        /* Create a data-model */
        Map root = new HashMap();
        root.put("user", "Big Joe");
        Map latest = new HashMap();
        root.put("latestProduct", latest);
        latest.put("url", "products/greenmouse.html");
        latest.put("name", "green mouse");

        /* Get the template (uses cache internally) */
        Template temp = cfg.getTemplate("testword.ftl");

        /* Merge data-model with template */
        //Writer out = new OutputStreamWriter(System.out);
        File outFile = new File("D:\\test.doc"); //导出文件
        Writer out = null;
        try {
        	out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile), "UTF-8"));
        	//out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outFile)));
        }catch(FileNotFoundException e1) {
        	e1.printStackTrace();
        }
        temp.process(root, out);
        out.flush();
        out.close();
        
        // Note: Depending on what `out` is, you may need to call `out.close()`.
        // This is usually the case for file output, but not for servlet output.
		
	}
	
	/**
	 * 生成word after 2007
	 */
	@Test
	public void testWord07() throws IOException, TemplateException {
		//xml的模板路径*/*  
        String xmlTemplate = "test.xml";  
          
        //设置docx的模板路径 和文件名  
        String docxTemplate = "D:\\workspace-sts-3.9.1.RELEASE\\freemarkdemo\\src\\main\\resources\\test.docx";  
        String toFilePath = "d:\\test.docx";  
          
        //填充完数据的临时xml  
        String xmlTemp = "d:\\temp.xml";  
        Writer w = new FileWriter(new File(xmlTemp));  
          
        //1.需要动态传入的数据  
        Map<String,Object> p = new HashMap<String,Object>();  
        List<String> students = new ArrayList<String>();  
        students.add("张三");  
        students.add("李四");  
        students.add("王二");       
        p.put("test", "测试一下是否成功");  
        p.put("students", students);  
          
        //2.把map中的数据动态由freemarker传给xml  
        XmlToExcel.process(xmlTemplate, p, w);  
          
        //3.把填充完成的xml写入到docx中  
        XmlToDocx xtd = new XmlToDocx();  
        xtd.outDocx(new File(xmlTemp), docxTemplate, toFilePath);  
	}
	
}
