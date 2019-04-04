package COM.STIW3054.A2;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ListOFSOCCourse implements Runnable {

	String pdfFileInText;

	public ListOFSOCCourse(String pdfFileInText) {
		this.pdfFileInText = pdfFileInText;

	}

	public void run() {
		String Datesubs = "";
		String regexDate = "(\\d{1,3}.  ST[IQ][MSANDJKW]\\d{4} .* \\d{1,2}/\\d{1,2}/\\d{4} )";
		Matcher m = Pattern.compile(regexDate).matcher(pdfFileInText);
		while (m.find()) {
			Datesubs += "\n" + m.group().trim();
		}
		System.out.println(Thread.currentThread().getName() + Datesubs);
	}

}