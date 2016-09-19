package com.formsdirectinc.functionaltests.utils;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;
import org.testng.Reporter;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.ChecksumException;
import com.google.zxing.FormatException;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;

/**
 * @author Orina<BR>
 *         Takes the PDF Files as input(actual, expected) and compares and lists
 *         their differences in image and text
 */
public class PDFComparison {

	public static final String DOWNLOADED_PDF_PATH = "src\\test\\resources\\pdf\\%s\\%s\\%s.pdf";

	private static final String PDFTEXT_PATH = "src/test/resources/contentdiff/%s/%s/%s-Page %d out of %d.txt";
	private static final String PDFIMAGE_PATH = "src/test/resources/imagediff/%s/%s/%s-Page %d out of %d.png";
	public static final String BARCODE_MESSAGE = "<b><br>"
			+ "The decoded barcode text of page %d of flow %s for product %s is : <br></b>"
			+ "<font color=\"green\">" + "%s" + "</font><br>";
	private static final String CONSOLE_MESSAGE = "The total pages for %s file of product %s in Flow %s are %d";
	
	@Test
	@Parameters({ "product", "flowname","pdfFileName","fileType"})
	
	public void pdfImageAndContentCompare(String product, String flowname,String pdfFileName,String fileType) throws IOException, NotFoundException,
			ChecksumException, FormatException {

		pdfFileName = String.format(DOWNLOADED_PDF_PATH, product, fileType,pdfFileName);

		File pdfFile = new File(pdfFileName);
		
		PDDocument pdfDoc = PDDocument.load(pdfFile);
		PDFRenderer pdfRenderer = new PDFRenderer(pdfDoc);

		System.out.println(String.format(CONSOLE_MESSAGE, fileType,product,flowname,pdfDoc.getPages().getCount()));
		Reporter.log(String.format(CONSOLE_MESSAGE, fileType,product,flowname,pdfDoc.getPages().getCount()));
		
		int pageNumber = 1;
		for (PDPage page : pdfDoc.getPages()) {
			PdfReader reader = new PdfReader(pdfFileName);
			String pdfText=PdfTextExtractor.getTextFromPage(reader, pageNumber); 
			//System.out.println(pdfText);		
			BufferedImage pdfPageImage = pdfRenderer.renderImageWithDPI((pageNumber-1), 300,ImageType.RGB);
			ImageIOUtil.writeImage(pdfPageImage, String.format(PDFIMAGE_PATH, product,fileType,flowname, (pageNumber++), pdfDoc.getPages().getCount()), 300);
		
			try
			{
			LuminanceSource source = new BufferedImageLuminanceSource(pdfPageImage);  
			BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));  
			Reader imageReader = new MultiFormatReader();  
			Result result = imageReader.decode(bitmap);
		
			String barcodeResult=result.getText();
			Reporter.log(String.format(BARCODE_MESSAGE, pageNumber,flowname,product,barcodeResult));
			FileUtils.writeStringToFile(new File(String.format(PDFTEXT_PATH,product,fileType,flowname,(pageNumber-1),pdfDoc.getPages().getCount())), pdfText+"\n"+barcodeResult);

			}
			catch(Exception e)
			{
				//System.out.println("No Barcode");
				Reporter.log(String.format(BARCODE_MESSAGE, pageNumber,flowname,product,"NONE"));
				FileUtils.writeStringToFile(new File(String.format(PDFTEXT_PATH,product,fileType,flowname,(pageNumber-1),pdfDoc.getPages().getCount())), pdfText+"\n"+"No Barcode");

			}
			
			if(fileType.equals("actual"))
			{
				ComparePDFPageImage imageDifference=new ComparePDFPageImage();
				imageDifference.comparePDFPageImages(product, flowname,(pageNumber-1), pdfDoc.getPages().getCount());

				ComparePageContent pageDifference=new ComparePageContent();
				pageDifference.comparePDFPagesContent(product, flowname,(pageNumber-1), pdfDoc.getPages().getCount());
			}
			
		}

		
	}

}
