package com.itext.demo;

import java.io.File;
import java.io.IOException;

import com.itextpdf.html2pdf.ConverterProperties;
import com.itextpdf.html2pdf.HtmlConverter;
import com.itextpdf.html2pdf.resolver.font.DefaultFontProvider;
import com.itextpdf.io.font.FontProgram;
import com.itextpdf.io.font.FontProgramFactory;
import com.itextpdf.layout.font.FontProvider;

/**
 * 
 * @author lisy
 *
 */
public class FinalReport {

	/** An array with the paths to extra fonts. */
	public static final String[] FONTS = {
			"src/main/resources/fonts/noto/NotoSans-Regular.ttf",
			"src/main/resources/fonts/noto/NotoSans-Bold.ttf",
			"src/main/resources/fonts/noto/NotoSansCJKsc-Regular.otf"
	};
	/** The Base URI of the HTML page. */
	public static final String BASEURI = "src/main/resources/html/";
	/** The path to the source HTML file. */
	public static final String SRC = String.format("%sfinalReport.html", BASEURI);
	/** The target folder for the result. */
	public static final String TARGET = "target/results/ch02/";
	/** The path to the resulting PDF file. */
	public static final String DEST = String.format("%sfinalReport.pdf", TARGET);

	/**
	 * The main method of this example.
	 *
	 * @param args no arguments are needed to run this example.
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
    public static void main(String[] args) throws IOException {
    	File file = new File(TARGET);
    	file.mkdirs();
    	FinalReport app = new FinalReport();
        app.createPdf(SRC, FONTS, DEST);
    }

    /**
     * Creates the PDF file.
     *
     * @param src the path to the source HTML file
     * @param dest the path to the resulting PDF
     * @throws IOException Signals that an I/O exception has occurred.
     */
    public void createPdf(String src, String[] fonts, String dest) throws IOException {
    	
    	ConverterProperties properties = new ConverterProperties();
    	FontProvider fontProvider = new DefaultFontProvider(false, false, false);
    	for (String font : fonts) {
    		FontProgram fontProgram = FontProgramFactory.createFont(font);
    		fontProvider.addFont(fontProgram);
    	}
    	properties.setFontProvider(fontProvider);
		HtmlConverter.convertToPdf(new File(src), new File(dest), properties);
    	
    }
	
}
