package tutorial.example2;

import com.example.service.DictionaryService;

/**
 * Implements an English dictionary service.
 **/
public class EnglishDictionaryService implements DictionaryService {

	// The set of words contained in the dictionary.
	String[] words = { "welcome", "to", "the", "osgi", "tutorial" };

	/**
	 * {@inheritDoc}
	 */
	public boolean checkWord(String word) {
		word = word.toLowerCase();

		// This is very inefficient
		for (int i = 0; i < words.length; i++) {
			if (words[i].equals(word)) {
				return true;
			}
		}
		return false;
	}

}
