package COM.STIW3054.A2;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class DisplaySTIW3054 implements Runnable {

	String pdfFileInText;

	public DisplaySTIW3054(String pdfFileInText) {
		this.pdfFileInText = pdfFileInText;
	}

	public void run() {
		String Datesubs = "";
		String regexDate = "(\\d{1,3}.  STIW3054 .* \\d{1,2}/\\d{1,2}/\\d{4} \\d{2}:\\d{2})";
		Matcher m = Pattern.compile(regexDate).matcher(pdfFileInText);
		while (m.find()) {
			Datesubs += m.group();
		}
		System.out.println(Thread.currentThread().getName() + Datesubs);
	}

}