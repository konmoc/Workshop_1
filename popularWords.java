import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class popularWords {
	
	public static void main(String[] args) {
		searchForWords();
	}
	public static void searchForWords() {
		
		//My method begins with the code found inside Workshop Manual
		Connection connect = Jsoup.connect("https://onet.pl/");
		try {
		    Document document = connect.get();
		    Elements links = document.select("span.title");
		    PrintWriter out = new PrintWriter("./src/popular_words.txt");
		    for (Element elem : links) {
		        out.println(elem.text());
		    }
		    out.close();
		} catch (IOException e) {
		    e.printStackTrace();
		}
		//now we have our document - sadly it contains a lot of words we woudn't like to have
		//we would also like to have our words only longer than 3 characters
		
		String[] badWords = {"i", "się", "tak", "więc", "w", "u", "z", "dla", "na", "w"};
		String badString = Arrays.toString(badWords);
		//System.out.println(badString);

		try {
			File popular_words = new File("./src/popular_words.txt");
			Scanner scan = new Scanner(popular_words);
			
			PrintWriter out2 = new PrintWriter("./src/filtered_popular_words.txt");
			
			while(scan.hasNext()) {
				String wordToBeTested = scan.next().toLowerCase().replace("\"", "").replaceAll(":", "")
						.replace(".", "").replace("?", "").replaceAll(",", "");
				if(wordToBeTested.length()>3 && !wordToBeTested.contains(badString)) {
					out2.println(wordToBeTested + " ");
				}
			}
			out2.close();
			scan.close();
		}catch (FileNotFoundException e) {
			System.out.println("file not found");
		}
	}
}
