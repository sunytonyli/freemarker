package com.freemark.demo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.freemark.demo.service.ftl.FtlConvertWordService;
import com.freemark.demo.vo.ReportEntity;
import com.freemark.demo.vo.ReportKindEntity;

import freemarker.template.TemplateException;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:D:/workspace-sts-3.9.1.RELEASE/freemarkdemo/src/main/webapp/WEB-INF/spring/appServlet/servlet-context.xml" })
public class ReportServiceTest {

	
	@Autowired
	private FtlConvertWordService ftlConvertWordService;
	
	private ReportEntity reportEntity;
	
	@Before
	public void init() {
		
		reportEntity = new ReportEntity();
		reportEntity.setDevelopmentUnit("中国国家科学技术研究院");
		reportEntity.setUnitContacts("张大毛");
		
		List<ReportKindEntity> kinds = new ArrayList<ReportKindEntity>();
		ReportKindEntity kindOne = new ReportKindEntity();
		kindOne.setKindName("钢铁");
		kindOne.setLevelOne(1);
		
		ReportKindEntity kindTwo = new ReportKindEntity();
		kindOne.setKindName("黄金");
		kindOne.setLevelOne(8);
		
		kinds.add(kindOne);
		kinds.add(kindTwo);
		
		reportEntity.setKinds(kinds);
		
		System.out.println(reportEntity.getKinds().size());
		
	}
	
	
	@Test
	public void testGeneralReport() throws TemplateException, IOException {
		
		Map<String, ReportEntity> dataMap = new HashMap<String, ReportEntity>();
		
		dataMap.put("report", reportEntity);
        
		ftlConvertWordService.generalWord97("report.ftl", "d:\\report.xml", dataMap);
	}
}
