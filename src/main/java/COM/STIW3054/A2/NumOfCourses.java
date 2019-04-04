package COM.STIW3054.A2;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class NumOfCourses implements Runnable {
	String pdfFileInText;

	public NumOfCourses(String pdfFileInText) {
		this.pdfFileInText = pdfFileInText;
	}

	public void run() {
		int count = 0;
		String code = "(\\w{1,3}\\d{4})";
		Matcher m = Pattern.compile(code).matcher(pdfFileInText);
		while (m.find()) {
			count++;
		}
		System.out.println(Thread.currentThread().getName() + count);
	}

}