package com.revature.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class WelcomeMessageServiceImpl implements WelcomeMessageService {

	private static final String WELCOME_MESSAGE = "Welcome to the 'Track Your Todos' Application!!\r\n"
			+ "We encourage you to use this application for all of your Task Completion Needs!";

	@Override
	public List<String> getWelcomeMessage() {
		List<String> message = new ArrayList<>();
		message.add(WELCOME_MESSAGE);
		message.add("Today's Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")));
		return message;
	}

	/*
	private static final Integer LIST_SIZE = 1000;
	private static final List<BufferedReader> readers = new ArrayList<>(LIST_SIZE);

	private static List<String> getMessage() {
		try {
			BufferedReader reader = getReader();
			String s;
			List<String> message = new ArrayList<>(LIST_SIZE);
			while (reader != null && (s = reader.readLine()) != null) {
				message.add(s.intern());
			}
			message.add(getCurrentDate().intern());
			return message;
		} catch (IOException e) {
			return null;
		}
	}
	
	private static String getCurrentDate() {
		return new String("Today's Date: " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss dd/MM/yyyy")));
	}

	private static BufferedReader getReader() {
		try {
			readers.add(new BufferedReader(new FileReader(new File("src/main/resources/welcomeMessage.txt"))));
			return readers.get(readers.size() - 1);
		} catch (FileNotFoundException e) {
			return null;
		}
	}
	*/
}
