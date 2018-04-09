package com.freemark.demo.util.zip;

import java.io.*;
import java.util.zip.*;

/**
 * 转自: https://github.com/cncounter/translation/blob/master/tiemao_2016/22_xml_word_freemarker/xml_word_freemarker.md
 * @author lisy
 *
 */
public class ZipUtils {

	/**
     * 替换某个 item,不关闭任何输入输出流
     * @param zipInputStream zip文件的zip输入流
     * @param zipOutputStream 输出的zip输出流
     * @param itemName 要替换的 item 名称
     * @param itemInputStream 要替换的 item 的内容输入流
     */
    public static void replaceItem(ZipInputStream zipInputStream,
				   ZipOutputStream zipOutputStream,
				   String itemName,
				   InputStream itemInputStream
				   ){
		//
		if(null == zipInputStream){return;}
		if(null == zipOutputStream){return;}
		if(null == itemName){return;}
		if(null == itemInputStream){return;}
		//
		ZipEntry entryIn;
		try {
		    while((entryIn = zipInputStream.getNextEntry())!=null)
		    {
			String entryName =  entryIn.getName();
			ZipEntry entryOut = new ZipEntry(entryName);
			// 只使用 name
			zipOutputStream.putNextEntry(entryOut);
			// 缓冲区
			byte [] buf = new byte[8*1024];
			int len;
	
			if(entryName.equals(itemName)){
			    // 使用替换流
			    while((len = (itemInputStream.read(buf))) > 0) {
				zipOutputStream.write(buf, 0, len);
			    }
			} else {
			    // 输出普通Zip流
			    while((len = (zipInputStream.read(buf))) > 0) {
				zipOutputStream.write(buf, 0, len);
			    }
			}
			// 关闭此 entry
			zipOutputStream.closeEntry();
		    }
		} catch (IOException e) {
		    e.printStackTrace();
		}
    }

    /**
     * 包装输入流
     */
    public static ZipInputStream wrapZipInputStream(InputStream inputStream){
		ZipInputStream zipInputStream = new ZipInputStream(inputStream);
		return zipInputStream;
    }

    /**
     * 包装输出流
     */
    public static ZipOutputStream wrapZipOutputStream(OutputStream outputStream){
		ZipOutputStream zipOutputStream = new ZipOutputStream(outputStream);
		return zipOutputStream;
    }
	
}
