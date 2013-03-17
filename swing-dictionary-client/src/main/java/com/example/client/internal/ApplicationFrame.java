package com.example.client.internal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class ApplicationFrame extends JFrame implements ActionListener {

	private final ApplicationController controller;
	private JButton searchButton;
	private final JTextField wordTextField;

	public ApplicationFrame(ApplicationController controller) {
		this.controller = controller;
		setTitle("Dictionary");
		setSize(300, 200);
		setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		wordTextField = new JTextField(10);
		// Add the ubiquitous "Hello World" label.
		searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		setLayout(new BorderLayout());
		add(wordTextField, BorderLayout.NORTH);
		add(searchButton, BorderLayout.CENTER);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		controller.searchWord(wordTextField.getText());
	}

}
