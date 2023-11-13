package task1;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class MyWordCount {
//	 public static final String fileName = "lab7/data/hamlet.txt";
	public static final String fileName = "data/fit";
	private List<String> words = new ArrayList<>();

	public MyWordCount() {
		try {
			this.words.addAll(Utils.loadWords(fileName));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt)
	// In this method, we do not consider the order of tokens.
	public List<WordCount> getWordCounts() {
		List<WordCount> re = new ArrayList<>();
		for (String w : words) {
			WordCount wc = new WordCount(w, Count(w));
			if (!re.contains(wc)) {
				re.add(wc);
			}
		}
		return re;
	}

	private int Count(String w) {
		int count = 0;
		for (String word : words) {
			if (word.equals(w)) {
				count++;
			}
		}
		return count;
	}

	// Returns the words that their appearance are 1, do not consider duplidated
	// words
	public Set<String> getUniqueWords() {
		Set<String> re = new HashSet<>();
		List<WordCount> list = getWordCounts();
		for (WordCount wc : getWordCounts()) {
			if (wc.getCount() == 1) {
				re.add(wc.getWord());
			}
		}
		return re;
	}

	// Returns the words in the text file, duplicated words appear once in the
	// result
	public Set<String> getDistinctWords() {
		Set<String> re = new HashSet<>();
		List<WordCount> list = getWordCounts();
		for (WordCount wc : list) {
			if (wc.getCount() != 1) {
				re.add(wc.getWord());
			}
		}
		return re;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according ascending order of tokens
	// Example: An - 3, Bug - 10, ...
	public Set<WordCount> printWordCounts() {
		Set<WordCount> re = new TreeSet<>(new Comparator<WordCount>() {
			public int compare(WordCount wc1, WordCount wc2) {
				int countComparition = Integer.compare(wc2.getCount(), wc1.getCount());
				if (countComparition == 0) {

					return wc1.getWord().compareTo(wc2.getWord());
				}
				return countComparition;

			}
		});
		re.addAll(this.getWordCounts());
		return re;
	}

	// Prints out the number of times each unique token appears in the file
	// data/hamlet.txt (or fit.txt) according descending order of occurences
	// Example: Bug - 10, An - 3, Nam - 2.
	public Set<WordCount> exportWordCountsByOccurence() {
		Set<WordCount> re = new TreeSet<WordCount>(new Comparator<WordCount>() {
			public int compare(WordCount wc1, WordCount wc2) {
				return -(wc2.getCount() - wc1.getCount());
			}
		});
		re.addAll(this.getWordCounts());
		return re;
	}

	// delete words begining with the given pattern (i.e., delete words begin with
	// 'A' letter
	public Set<String> filterWords(String pattern) {
		Set<String> filteredWords = new HashSet<String>();
		// Tạo một biểu thức chính quy từ để khớp các từ bắt đầu bằng mẫu đã cho.
		List<WordCount> list = getWordCounts();
		for (WordCount wc : list) {
			if (!getFirst(wc.getWord()).equals(pattern)) {
				filteredWords.add(wc.getWord());
			}
		}
		return filteredWords;
	}

	public String getFirst(String word) {
		return word.charAt(0) + "";
	}

	public static void main(String[] args) {
		MyWordCount wordCounter = new MyWordCount();
		List<WordCount> wordCounts = wordCounter.getWordCounts();
		System.out.println("After: " + wordCounts);

		Set<String> wordCounts1 = wordCounter.getUniqueWords();
		System.out.println("getUniqueWords: " + wordCounts1);

		Set<String> wordCounts2 = wordCounter.getDistinctWords();
		System.out.println("getDistinctWords: " + wordCounts2);

		Set<WordCount> wordCounts3 = wordCounter.printWordCounts();
		System.out.println("printWordCounts: " + wordCounts3);

		Set<WordCount> wordCounts4 = wordCounter.exportWordCountsByOccurence();
		System.out.println("exportWordCountsByOccurence: " + wordCounts4);

		Set<String> wordCounts5 = wordCounter.filterWords("L");
		System.out.println("filterWords L: " + wordCounts5);
	}
}
