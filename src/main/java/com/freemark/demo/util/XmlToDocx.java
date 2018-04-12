package com.freemark.demo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/** 
 * 其实docx属于zip的一种，这里只需要操作word/document.xml中的数据，其他的数据不用动 
 * @author yigehui http://www.cnblogs.com/xiaoL/p/7904433.html
 * 
 */  
public class XmlToDocx {

	 /** 
     *  
     * @param documentFile  动态生成数据的docunment.xml文件 
     * @param docxTemplate  docx的模板 
     * @param toFileName    需要导出的文件路径 
     * @throws ZipException 
     * @throws IOException 
     */  
      
    public  void outDocx(File documentFile,String docxTemplate,String toFilePath) throws ZipException, IOException {  
      
        try {  
//        String fileName = XmlToDocx.class.getClassLoader().getResource("").toURI().getPath()+docxTemplate; 
        
        String fileName = docxTemplate;  
              
            File docxFile = new File(fileName);  
            ZipFile zipFile = new ZipFile(docxFile);              
            Enumeration<? extends ZipEntry> zipEntrys = zipFile.entries();  
            ZipOutputStream zipout = new ZipOutputStream(new FileOutputStream(toFilePath));  
            int len=-1;  
            byte[] buffer=new byte[1024];  
            while(zipEntrys.hasMoreElements()) {  
                ZipEntry next = zipEntrys.nextElement();  
                InputStream is = zipFile.getInputStream(next);  
                //把输入流的文件传到输出流中 如果是word/document.xml由我们输入  
                zipout.putNextEntry(new ZipEntry(next.toString()));  
                if("word/document.xml".equals(next.toString())){  
                    //InputStream in = new FileInputStream(new File(XmlToDocx.class.getClassLoader().getResource("").toURI().getPath()+"template/test.xml"));  
                    InputStream in = new FileInputStream(documentFile);  
                    while((len = in.read(buffer))!=-1){  
                        zipout.write(buffer,0,len);  
                    }  
                    in.close();  
                }else {  
                    while((len = is.read(buffer))!=-1){  
                        zipout.write(buffer,0,len);  
                    }  
                    is.close();  
                }         
            }             
            zipout.close();           
        } catch (FileNotFoundException e) {  
            e.printStackTrace();  
        }     
    }  
	
}
