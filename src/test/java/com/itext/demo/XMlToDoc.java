package com.itext.demo;

import freemarker.template.Configuration;
import freemarker.template.Template;
import org.apache.poi.xwpf.usermodel.XWPFDocument;

import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.BaseFont;

import fr.opensagres.poi.xwpf.converter.pdf.PdfConverter;
import fr.opensagres.poi.xwpf.converter.pdf.PdfOptions;
import fr.opensagres.xdocreport.converter.ConverterTypeTo;
import fr.opensagres.xdocreport.converter.ConverterTypeVia;
import fr.opensagres.xdocreport.converter.Options;
import fr.opensagres.xdocreport.core.XDocReportException;
import fr.opensagres.xdocreport.document.IXDocReport;
import fr.opensagres.xdocreport.document.registry.XDocReportRegistry;
import fr.opensagres.xdocreport.itext.extension.font.IFontProvider;
import fr.opensagres.xdocreport.itext.extension.font.ITextFontRegistry;
import fr.opensagres.xdocreport.template.IContext;
import fr.opensagres.xdocreport.template.TemplateEngineKind;

import java.awt.Color;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class XMlToDoc {

	 private  static  final  String basePath = "D:/test/report/";   //模版存储路径，项目里我就放在resource下
	   public static void main(String[] args)  throws  Exception{

		 makeWord();
		 makePdfByXcode();
		 //testX();

	    }

	    /**
	     * 生成docx
	     * @throws Exception
	     */
	     static  void makeWord() throws Exception{
	        /** 初始化配置文件 **/
	        Configuration configuration = new Configuration(Configuration.VERSION_2_3_28);
	        String fileDirectory = basePath;
	        /** 加载文件 **/
	        configuration.setDirectoryForTemplateLoading(new File(fileDirectory));
	        /** 加载模板 **/
	        Template template = configuration.getTemplate("document.xml");
	        /** 准备数据 **/
	        Map<String,String> dataMap = new HashMap<String, String>();
	        /** 在ftl文件中有${textDeal}这个标签**/
	        dataMap.put("id","黄浦江吴彦祖");
	        dataMap.put("number","20");
	        dataMap.put("language","java,php,python,c++.......");
	        dataMap.put("example","Hello World!");

	        /** 指定输出word文件的路径 **/
	        String outFilePath = basePath+"data.xml";
	        File docFile = new File(outFilePath);
	        FileOutputStream fos = new FileOutputStream(docFile);
	        Writer out = new BufferedWriter(new OutputStreamWriter(fos),10240);
	        template.process(dataMap,out);
	        if(out != null){
	            out.close();
	        }
	        try {
	            ZipInputStream zipInputStream = ZipUtils.wrapZipInputStream(new FileInputStream(new File(basePath+"report.zip")));
	            ZipOutputStream zipOutputStream = ZipUtils.wrapZipOutputStream(new FileOutputStream(new File(basePath+"report.docx")));
	            String itemname = "word/document.xml";
	            ZipUtils.replaceItem(zipInputStream, zipOutputStream, itemname, new FileInputStream(new File(basePath+"data.xml")));
	            System.out.println("success");

	        } catch (Exception e) {
	            System.out.println(e.toString());
	        }
	    }

	    /**
	     * 生成pdf
	     */
	     static  void makePdfByXcode(){
	        long startTime=System.currentTimeMillis();
	        try {
	            XWPFDocument document=new XWPFDocument(new FileInputStream(new File(basePath+"report.docx")));
	        //    document.setParagraph(new Pa );
	            File outFile=new File(basePath+"test1.pdf");
	            outFile.getParentFile().mkdirs();
	            OutputStream out=new FileOutputStream(outFile);
	            //    IFontProvider fontProvider = new AbstractFontRegistry();
	            PdfOptions options= PdfOptions.create();  //gb2312
	            //options.fontEncoding(BaseFont.IDENTITY_H);
	            //options.fontEncoding("windows-1250");
	            options.fontProvider( new ITextFontRegistry()
	            {
	                public Font getFont( String familyName, String encoding, float size, int style, Color color )
	                {
	                    try
	                    {
	                        BaseFont bfChinese =
	                            BaseFont.createFont( "d:/STSONG.TTF", BaseFont.IDENTITY_H, BaseFont.EMBEDDED );
	                        Font fontChinese = new Font( bfChinese, size, style, color );
	                        if ( familyName != null )
	                            fontChinese.setFamily( familyName );
	                        return fontChinese;
	                    }
	                    catch ( Throwable e )
	                    {
	                        e.printStackTrace();
	                        // An error occurs, use the default font provider.
	                        return ITextFontRegistry.getRegistry().getFont( familyName, encoding, size, style, color );
	                    }
	                }
	 
	            } );
	            PdfConverter.getInstance().convert(document,out,options);

	        }
	        catch (  Exception e) {
	            e.printStackTrace();
	        }
	        System.out.println("Generate ooxml.pdf with " + (System.currentTimeMillis() - startTime) + " ms.");
	}
	
	     public static void testX() throws IOException, XDocReportException {
	    	  //
	    	    // read template
	    	    //
	    	    File docxFile = new File("D:/test/report/report.docx");
	    	    InputStream in = new FileInputStream(docxFile);

	    	    // 
	    	    // prepare document context
	    	    //
	    	    IXDocReport report = XDocReportRegistry.getRegistry().loadReport(in, TemplateEngineKind.Velocity);
	    	    IContext context = report.createContext();
	    	    context.put("name", "Michael Küfner");

	    	    // 
	    	    // generate PDF output
	    	    //
	    	   
	    	    PdfOptions pdfOptions = PdfOptions.create();
	    	    //pdfOptions.fontEncoding("windows-1250");
	    	    pdfOptions.fontProvider( new ITextFontRegistry()
	            {
	                public Font getFont( String familyName, String encoding, float size, int style, Color color )
	                {
	                    try
	                    {
	                        BaseFont bfChinese =
	                            BaseFont.createFont( "c:/Windows/Fonts/arialuni.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED );
	                        Font fontChinese = new Font( bfChinese, size, style, color );
	                        if ( familyName != null )
	                            fontChinese.setFamily( familyName );
	                        return fontChinese;
	                    }
	                    catch ( Throwable e )
	                    {
	                        e.printStackTrace();
	                        // An error occurs, use the default font provider.
	                        return ITextFontRegistry.getRegistry().getFont( familyName, encoding, size, style, color );
	                    }
	                }
	 
	            } );
	    	    Options options = Options.getTo(ConverterTypeTo.PDF).via(ConverterTypeVia.XWPF).subOptions(pdfOptions);

	    	    OutputStream out = new FileOutputStream(new File(docxFile.getPath() + ".pdf"));
	    	    report.convert(context, options, out);
	     }
}
