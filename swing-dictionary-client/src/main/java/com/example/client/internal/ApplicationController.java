package com.example.client.internal;

import java.util.Arrays;

import javax.swing.JOptionPane;

import org.osgi.util.tracker.ServiceTracker;

import com.example.service.DictionaryService;

public class ApplicationController {

	private final ServiceTracker serviceTracker;

	public ApplicationController(ServiceTracker serviceTracker) {
		this.serviceTracker = serviceTracker;
	}

	public void showUI() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowUI();
			}
		});
	}

	private void createAndShowUI() {
		ApplicationFrame frame = new ApplicationFrame(this);
		frame.setVisible(true);
	}

	public void searchWord(String text) {
		System.out.println("searching for : " + text);
		System.out.println("service being used: " + Arrays.toString(serviceTracker.getServiceReference().getPropertyKeys()));
		DictionaryService dictionaryService = (DictionaryService) serviceTracker
				.getService();
		if (dictionaryService == null) {
			JOptionPane.showMessageDialog(null,
					"Sorry, the dictionary service is not available.");
			return;
		}
		if (dictionaryService.checkWord(text)) {
			JOptionPane.showMessageDialog(null, "I found " + text
					+ " in the dictionary!");
		} else {
			JOptionPane.showMessageDialog(null, "Sorry, cannot find " + text
					+ " in the dictionary.");
		}
	}

}
