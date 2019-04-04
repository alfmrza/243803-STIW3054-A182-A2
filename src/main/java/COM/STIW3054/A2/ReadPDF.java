package COM.STIW3054.A2;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;
import java.io.File;
import java.io.IOException;

public class ReadPDF {
	public static void main(String[] args) throws IOException, InterruptedException {

		try (PDDocument document = PDDocument.load(new File("/Users/user/Desktop/A182 Draft.pdf"))) {

			document.getClass();

			if (!document.isEncrypted()) {

				PDFTextStripperByArea stripper = new PDFTextStripperByArea();
				stripper.setSortByPosition(true);
				PDFTextStripper textStripper = new PDFTextStripper();
				String pdfFileInText = textStripper.getText(document);
				
				
				Thread mainThread = Thread.currentThread();
				String[] lines = pdfFileInText.split("\\r?\\n");
				
				
				NumOfCourses i = new NumOfCourses(pdfFileInText);
				NumOfDays ii = new NumOfDays(pdfFileInText);
				ListOFSOCCourse iii = new ListOFSOCCourse(pdfFileInText);
				NumOfSOCCourses iv = new NumOfSOCCourses(pdfFileInText);
				DisplaySTIW3054 v = new DisplaySTIW3054(pdfFileInText);
				
				
				Thread t1 = new Thread(i);
				t1.setName("The total number of courses is: ");
				
				Thread t2 = new Thread(ii);
				t2.setName("The total number of days is: ");
				
				Thread t3 = new Thread(iii);
				t3.setName("The list of SOC Courses are: ");
				
				Thread t4 = new Thread(iv);
				t4.setName("The total number of SOC Courses are: ");
				
				Thread t5 = new Thread(v);
				t5.setName("Display STIW3054: ");
				
				t1.start();
				try {
					t1.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Thread.sleep(2000);
				t2.start();
				try {
					t2.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Thread.sleep(2000);
				t4.start();
				try {
					t4.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Thread.sleep(2000);
				t3.start();
				try {
					t3.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				Thread.sleep(2000);
				t5.start();
				try {
					t5.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}

	}
}