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
		PrintWriter Writer;
		File answerFile = new File("answerFile.txt");

		try {
			bufWriter = new BufferedWriter(new FileWriter(answerFile));
			Writer = new PrintWriter(bufWriter, true);
			Writer.print(list);
			Writer.close();
		}

		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
