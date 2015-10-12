package com.serhii.reminder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class Writer {
	
	public static void writeToAnswerFile(List<?> list) {

		BufferedWriter bufWriter;
		PrintWriter writer;
		File answerFile = new File("answerFile.txt");

		try {
			bufWriter = new BufferedWriter(new FileWriter(answerFile));
			writer = new PrintWriter(bufWriter, true);
			writer.print(list);
			writer.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
