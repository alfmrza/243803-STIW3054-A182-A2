package COM.STIW3054.A2;

import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.util.Arrays;

public class NumOfDays implements Runnable {
	
	String pdfFileInText;

	public NumOfDays(String pdfFileInText) {
		this.pdfFileInText = pdfFileInText;
	}
	
	public void run() {
		
        String dateSubS = "";
        String regex =  "(\\d{1,2}/\\d{1,2}/\\d{4})";
        Matcher m = Pattern.compile(regex).matcher(pdfFileInText);
        
        while (m.find()) {
        	dateSubS +="\n" + m.group().trim();
        }
        String [] date = dateSubS.split("\n");
        date = Arrays.stream(date).distinct().toArray(String[]::new);
        int length =  date.length-1;
        System.out.println(Thread.currentThread().getName() + length);
	}
	
	
}