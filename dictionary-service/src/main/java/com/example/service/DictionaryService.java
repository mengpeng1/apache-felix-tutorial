package com.example.service;

/**
 * A simple service interface that defines a dictionary service. A dictionary
 * service simply verifies the existence of a word.
 **/
public interface DictionaryService {

	/**
	 * Check for the existence of a word.
	 * 
	 * @param word
	 *            the word to be checked
	 * @return <tt>true</tt> if the word is in the dictionary, <tt>false</tt>
	 *         otherwise.
	 **/
	boolean checkWord(String word);

}
