package com.formsdirectinc.functionaltests.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.Reporter;

/**
 * @author Orina<br>
 * Converts the PDF Pages Content to Text Files , Compares the files and Writes the Difference
 */

public class ComparePageContent {


	public static final String DIFFERENCE_LOG="<b><br>"+"\nDifference in Line : %d "+"</b><br>"+
			"<font color=\"green\"><b>"+"\nExpected Result : </b>%s"+"</font><br>"+
			"<font color=\"red\"><b>"+"\nActual Result   : </b>%s"+"</font><br>";


	private static final String ACTUAL_PDFTEXT_PATH = "src/test/resources/contentdiff/%s/actual/%s-Page %d out of %d.txt";
	private static final String EXPECTED_PDFTEXT_PATH = "src/test/resources/contentdiff/%s/expected/%s-Page %d out of %d.txt";
	private static final String DIFF_PDFTEXT_PATH = "src/test/resources/contentdiff/%s/diff/%s-Page %d out of %d.html";
	
	
	public void comparePDFPagesContent(String product,String flowname,int page,int totalPages) throws IOException {
		// File names to Read & Write.
		try{
			// Create FileReader & Writer Objects.
			FileReader actualFileReader  = new FileReader(String.format(ACTUAL_PDFTEXT_PATH,product,flowname,page,totalPages));
			FileReader expectedFileReader  = new FileReader(String.format(EXPECTED_PDFTEXT_PATH,product,flowname,page,totalPages));
			FileWriter resultWriter = new FileWriter(String.format(DIFF_PDFTEXT_PATH,product,flowname,page,totalPages));

			// Create Buffered Object.
			BufferedReader actualFileBufReader = new BufferedReader(actualFileReader);
			BufferedReader expectedFileBufReader = new BufferedReader(expectedFileReader);
			BufferedWriter resultFileBufWriter = new BufferedWriter(resultWriter);

			// Get the file contents into String Variables.
			String actualFileContent = actualFileBufReader.readLine();
			String expectedFileContent = expectedFileBufReader.readLine();

			// Compare the Contents of the files.
			String startOfComparision = "COMPARISON STARTS FOR PAGE "+page;
			resultFileBufWriter.write(startOfComparision);
			Reporter.log("<b><br>"+startOfComparision+"<br>");
			resultFileBufWriter.newLine();


			boolean isDifferent = false;
			int lineNumber = 1;

			if (actualFileContent != null || expectedFileContent != null) {

				// Check whether Actual file contains data or not
				while((actualFileContent!=null)  ){

					// Check whether Expected file contains data or not
					if (((expectedFileContent )!=null)) {

						// Check whether both the files have same data in the lines
						if (!actualFileContent.equals(expectedFileContent)) {
							resultFileBufWriter.write(String.format(DIFFERENCE_LOG, lineNumber,expectedFileContent,actualFileContent));
							resultFileBufWriter.newLine();
							Reporter.log(String.format(DIFFERENCE_LOG, lineNumber,expectedFileContent,actualFileContent));

							isDifferent = true;
						}
						lineNumber = lineNumber+1;
						expectedFileContent= expectedFileBufReader.readLine();
					}
					else{
						resultFileBufWriter.write(String.format(DIFFERENCE_LOG, lineNumber,expectedFileContent,actualFileContent));
						resultFileBufWriter.newLine();
						Reporter.log(String.format(DIFFERENCE_LOG, lineNumber,expectedFileContent,actualFileContent));

						isDifferent = true;
						lineNumber = lineNumber+1;
					}
					actualFileContent=actualFileBufReader.readLine();
				}

				// Check for the condition : if Actual File has Data & Expected File doesn't contain data.
				while ((expectedFileContent!=null)&&(actualFileContent==null)) {
					
					resultFileBufWriter.write(String.format(DIFFERENCE_LOG, lineNumber,expectedFileContent,actualFileContent));
					resultFileBufWriter.newLine();

					Reporter.log(String.format(DIFFERENCE_LOG, lineNumber,expectedFileContent,actualFileContent));


					isDifferent = true;
					lineNumber = lineNumber+1;
					expectedFileContent= expectedFileBufReader.readLine();
				}
			}
			else{
				// Mention that both the files don't have Data.
				resultFileBufWriter.write(String.format(DIFFERENCE_LOG, lineNumber,expectedFileContent,actualFileContent));
				resultFileBufWriter.newLine();
				Reporter.log(String.format(DIFFERENCE_LOG, lineNumber,expectedFileContent,actualFileContent));


				isDifferent = true;
			}

			// Check is there any difference or not.
			String endOfComparision = "COMPARISON ENDS FOR PAGE "+page;
			if (isDifferent) {
				
				resultFileBufWriter.append(endOfComparision);
				Reporter.log("<b><br>"+endOfComparision+"<br>");

			}
			else{
				resultFileBufWriter.append("THERE ARE NO DIFFERENCES IN PAGE "+page);
				resultFileBufWriter.newLine();
				resultFileBufWriter.append(endOfComparision);

				Reporter.log("THERE ARE NO DIFFERENCES IN PAGE "+page);
				Reporter.log("<b><br>"+endOfComparision);

			}

			//Close the streams.
			actualFileReader.close();
			expectedFileReader.close();
			resultFileBufWriter.close();
			actualFileBufReader.close();
			expectedFileBufReader.close();
		}
		catch( FileNotFoundException e )
		{
			e.printStackTrace();
		}              
	}

}
