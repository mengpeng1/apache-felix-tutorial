package tutorial.example2b;

import tutorial.example2.service.DictionaryService;

/**
 * Implements a dictionary service; see DictionaryService for details of the
 * service.
 **/
public class FrenchDictionaryService implements DictionaryService {
	// The set of words contained in the dictionary.
	String[] m_dictionary = { "bienvenue", "au", "tutoriel", "osgi" };

	/**
	 * {@inheritDoc}
	 */
	public boolean checkWord(String word) {
		word = word.toLowerCase();

		// This is very inefficient
		for (int i = 0; i < m_dictionary.length; i++) {
			if (m_dictionary[i].equals(word)) {
				return true;
			}
		}
		return false;
	}

}
