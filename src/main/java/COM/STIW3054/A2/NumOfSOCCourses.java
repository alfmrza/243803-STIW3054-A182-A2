package COM.STIW3054.A2;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;

public class NumOfSOCCourses implements Runnable {
	private String list;
	private String[] lines;

	public NumOfSOCCourses(String list) {
		this.list = list;
	}

	public void run() {
		lines = list.split("\\r?\\n");
		Pattern pattern = Pattern.compile("(\\d{1,3}.  ST[IQ][MSANDJKW]\\d{4} .* \\d{1,2}/\\d{1,2}/\\d{4} \\d{2}:\\d{2} )");
		int countSOC = 0;
		for (String line : lines) {
			String word = line;
			Matcher m = pattern.matcher(word);
			while (m.find()) {
				countSOC++;
			}
		}

		System.out.println(Thread.currentThread().getName() + countSOC);

	}
}