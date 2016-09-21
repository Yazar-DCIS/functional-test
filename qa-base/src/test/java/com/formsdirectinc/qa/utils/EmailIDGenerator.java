package com.formsdirectinc.qa.utils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.formsdirectinc.qa.enums.Sites;

/**
 * Class for Generating EMail
 * 
 * @author:Orina <br>
 *               Revision: $Rev$
 */

public class EmailIDGenerator {

	public static final String WRITE_EMAIL_ID = "build" + File.separator
			+ "test-output" + File.separator + "email-id.txt";

	public String generateEmailID(String sitename,String flowname,String product) {

		Sites site;
		if(System.getProperty("site.name")==null)
		{
			site = Sites.valueOf(sitename);
		}else
		{
			site = Sites.valueOf(System.getProperty("site.name"));
		}
		String timeStamp = new SimpleDateFormat("dd.MM.HH.mm.ss")
				.format(Calendar.getInstance().getTimeInMillis());
		String email = product+"."+flowname + "." + site + "." + timeStamp + "@dcis.net";
		return email;
	}

	public void writeEMail_ID(String emailID) throws IOException {

		File fileData = new File(String.format(WRITE_EMAIL_ID));
		BufferedWriter writer = new BufferedWriter(new FileWriter(new File(
				fileData.getAbsolutePath()), true));
		try {
			writer.newLine();
			writer.write("User Email-ID ----> " + emailID);
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (Exception e) {
					System.err.println(e);
				}
			}
		}
	}

}
