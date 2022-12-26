package pdf2text;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Pdf2text {

	public static void main(String[] args) throws IOException {
		PDDocument doc = PDDocument.load(new File("Lista2_20221226.pdf"));
		String text = new PDFTextStripper().getText(doc);
		List<String> rows = Arrays.asList(text.split("\\n"));// Acta Zooliga Hung.

		//Pattern fajnevPattern = Pattern.compile("\\d{4}|sp\\.");//Acta Zoologica
		// Hung.
		//Pattern fajnevPattern = Pattern.compile("(.+\\n?(\\d{4}|sp\\.)+).+?");// Folia ent. hung.
		//Pattern fajnevPattern = Pattern.compile("(.+\\n?(, \\d{4}|sp\\.)+).+?");
		Pattern fajnevPattern = Pattern.compile("No {1,}material {1,}was {1,}found");
		// Pattern fajnevPattern = Pattern.compile("\\d{4}|sp\\.\\n");//Acta Zoologica
		// Hung.
//		for (String item : rows) {
//			Matcher fajnevMatcher = fajnevPattern.matcher(item);
//
//			if (fajnevMatcher.find()) {
//				System.out.println(item.replace("Folia ent. hung 58, 1997", "")
//				// .replaceFirst(".*— ?", "")
//
//				);
//				
//			}
//		}
		Matcher fajnevMatcher = fajnevPattern.matcher(text);
		var sum = 0;
		while(fajnevMatcher.find()) {
			//System.out.println(fajnevMatcher.group(0).replaceFirst("\\n", ""));
			sum++;
		}
		System.out.println(sum);

//	        String out = "azh_57_1_Mahunka.pdf".replace("pdf", "txt");
//	        try (FileWriter fw = new FileWriter(out)) {
//	            fw.write(text);

//	        }

	}

//	private static String replaced(String item) {
//		if (item.replaceAll(regex, replacement))
//		return item;
//	}

}
