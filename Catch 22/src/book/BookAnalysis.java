/**
 * 
 */
package book;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Class analyses a given book by reading the text from a file
 * 
 * This class is set up to analyse the text of Catch 22 stored in a file titles "Catch 22.txt"
 */
public class BookAnalysis {

	/**
	 * Constants for text formatting
	 */
	final static String RED_TEXT = "\033[0;31m";
	final static String GREEN_TEXT = "\033[0;32m";
	final static String BOLD_TEXT = "\033[1m";
	final static String RESET_TEXT = "\033[0m";

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		System.out.println("CATCH 22 ANALYSIS");
		System.out.println("-----------------");
		System.out.println();

//		1. Output the full text to screen
		printBookToConsole("Catch 22.txt");
		System.out.println();

//		2. Output the number of lines 
		System.out.printf("Total number of lines in book: %s%d%s%n", BOLD_TEXT, numberOfLines("Catch 22.txt"),
				RESET_TEXT);

//		3. Output the number of words 
		System.out.printf("Total number of words in book: %s%d%s%n", BOLD_TEXT, numberOfWords("Catch 22.txt"),
				RESET_TEXT);

//		4. Output the number of characters 
		System.out.printf("Total number of characters in book: %s%d%s%n", BOLD_TEXT, numberOfCharacters("Catch 22.txt"),
				RESET_TEXT);

//		5. Output the number of times the main character's name (Yossarian) is referenced in the text.
		System.out.printf("Total number of times 'Yossarian' is mentioned in book: %s%d%s%n", BOLD_TEXT,
				numberOfGivenWordInText("Catch 22.txt", "Yossarian"), RESET_TEXT);

//		6. Output the number of times the letter a is used. 
		System.out.printf("Total number of times the letter 'a' is used in book: %s%d%s%n", BOLD_TEXT,
				numberOfGivenLetterInBook("Catch 22.txt", "a"), RESET_TEXT);

//		7. Redact the word Yossarian from the complete text and replace with ---------   (output the redacted text to an new file Catch22Redacted.txt.
		redactGivenWordFromBook("Catch 22.txt", "Yossarian");
	}

	/**
	 * method takes a file name for a book and prints the text to the console.
	 * 
	 * @param bookFileName
	 */
	public static void printBookToConsole(String bookFileName) {

		File book = new File(bookFileName);

		if (!book.exists()) {
			System.err.println("Book file does not exist!");
		} else {

			try (FileReader fr = new FileReader(book); BufferedReader br = new BufferedReader(fr);) {

				String line = br.readLine();

				while (line != null) {
					System.out.println(line);
					line = br.readLine();
				}

			} catch (IOException e) {
				System.err.println("Problem with book file");
				e.printStackTrace();
			}

		}

	}

	/**
	 * method returns the number of lines in a book
	 * 
	 * @param bookFileName
	 * @return
	 */
	public static int numberOfLines(String bookFileName) {
		int totalLines = 0;

		File book = new File(bookFileName);

		if (!book.exists()) {
			System.err.println("Book file does not exist!");
		} else {

			try (FileReader fr = new FileReader(book); BufferedReader br = new BufferedReader(fr);) {

				String line = br.readLine();

				while (line != null) {

					if (!line.trim().isEmpty()) {
						totalLines++;
					}

					line = br.readLine();
				}

			} catch (IOException e) {
				System.err.println("Problem with book file");
				e.printStackTrace();
			}

		}

		return totalLines;

	}

	/**
	 * method returns the number of words in a book
	 * 
	 * @param bookFileName
	 * @return
	 */
	public static int numberOfWords(String bookFileName) {
		int totalWords = 0;

		File book = new File(bookFileName);

		if (!book.exists()) {
			System.err.println("Book file does not exist!");
		} else {

			try (FileReader fr = new FileReader(book); BufferedReader br = new BufferedReader(fr);) {

				String line = br.readLine();

				while (line != null) {

					String trimmedLine = line.trim();

					if (!trimmedLine.isEmpty()) {
						String[] words = trimmedLine.split("\\s+");

						totalWords += words.length;
					}

					line = br.readLine();
				}

			} catch (IOException e) {
				System.err.println("Problem with book file");
				e.printStackTrace();
			}

		}

		return totalWords;
	}

	/**
	 * method returns the number of characters in a book
	 * 
	 * @param bookFileName
	 * @return
	 */
	public static int numberOfCharacters(String bookFileName) {

		int totalCharacters = 0;

		File book = new File(bookFileName);

		if (!book.exists()) {
			System.err.println("Book file does not exist!");
		} else {

			try (FileReader fr = new FileReader(book); BufferedReader br = new BufferedReader(fr);) {

				String line = br.readLine();

				while (line != null) {

					String trimmedLine = line.trim();

					if (!trimmedLine.isEmpty()) {

						String[] words = trimmedLine.split("\\s+");

						for (String word : words) {
							totalCharacters += word.length();
						}

					}

					line = br.readLine();
				}

			} catch (IOException e) {
				System.err.println("Problem with book file");
				e.printStackTrace();
			}

		}

		return totalCharacters;
	}

	/**
	 * method returns the number of times a given word is in a book
	 * 
	 * @param bookFileName
	 * @param wordToMatch
	 * @return
	 */
	public static int numberOfGivenWordInText(String bookFileName, String wordToMatch) {

		int totalNum = 0;

		File book = new File(bookFileName);

		if (!book.exists()) {
			System.err.println("Book file does not exist!");
		} else {

			try (FileReader fr = new FileReader(book); BufferedReader br = new BufferedReader(fr);) {

				String line = br.readLine();

				while (line != null) {

					String trimmedLine = line.trim();

					if (!trimmedLine.isEmpty()) {

						String[] words = trimmedLine.split("\\s+");

						for (String word : words) {
							if (word.toLowerCase().equals(wordToMatch.toLowerCase())) {
								totalNum++;
							}
						}

					}

					line = br.readLine();
				}

			} catch (IOException e) {
				System.err.println("Problem with book file");
				e.printStackTrace();
			}

		}

		return totalNum;

	}

	/**
	 * methdo returns the number of times a letter is used in a book
	 * 
	 * @param bookFileName
	 * @param letter
	 * @return
	 */
	public static int numberOfGivenLetterInBook(String bookFileName, String letter) {

		int totalNum = 0;
		char targetChar = letter.toLowerCase().charAt(0);
		File book = new File(bookFileName);

		if (!book.exists()) {
			System.err.println("Book file does not exist!");
		} else {

			try (FileReader fr = new FileReader(book); BufferedReader br = new BufferedReader(fr);) {

				String line = br.readLine();

				while (line != null) {

					String lowerCaseLine = line.toLowerCase();

					for (int i = 0; i < lowerCaseLine.length(); i++) {
						if (lowerCaseLine.charAt(i) == targetChar) {
							totalNum++;
						}
					}

					line = br.readLine();
				}

			} catch (IOException e) {
				System.err.println("Problem with book file");
				e.printStackTrace();
			}

		}

		return totalNum;
	}

	/**
	 * method redacts a word from a book and creates a new file for redacted text
	 * 
	 * @param bookFileName
	 * @param redact
	 */
	public static void redactGivenWordFromBook(String bookFileName, String redact) {
		// Create the redaction string
	    // Determine the length of the word to redact, so the replacement is the same length
		String replacement = redact.replaceAll(".", "-");

		// creating file objects
		File book = new File(bookFileName);
		File redactedBook = new File("Redacted - " + bookFileName);
		
		// \\b ensures it matches whole words (e.g., "cat" doesn't match "cattle")
	    // (?i) makes the pattern case-insensitive
	    String regex = "\\b(?i)" + redact + "\\b";

		// create file for redacted book
		try {
			if (!redactedBook.exists()) {
				redactedBook.createNewFile();
			} else {
				System.err.println("File already exists");
			}
		} catch (IOException e) {
			System.err.println("Problem creating file!");
			e.printStackTrace();
		}

		// searching through book for redacted word
		if (!book.exists()) {
			System.err.println("Book file does not exist!");
		} else {

			try (FileReader fr = new FileReader(book);
					BufferedReader br = new BufferedReader(fr);
					FileWriter fw = new FileWriter(redactedBook);
					BufferedWriter bw = new BufferedWriter(fw);) {

				String line = br.readLine();

				while (line != null) {
					String redactedLine =line.replaceAll(regex, replacement);
					bw.write(redactedLine);
					bw.newLine();
					
					line = br.readLine();

				}
				System.out.printf("Redaction complete. Output saves to %s%n", redactedBook.getName());

			} catch (IOException e) {
				System.err.println("Problem with book file");
				e.printStackTrace();
			}

		}
	}

}
