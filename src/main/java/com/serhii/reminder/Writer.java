package com.serhii.reminder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;
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

	public static void writeToFile(List<?> list) {
		BufferedWriter bufWriter;
		PrintWriter writer;
		String separator = FileSystems.getDefault().getSeparator();
		StringBuffer root = new StringBuffer();
		Iterator<Path> iter = FileSystems.getDefault().getRootDirectories().iterator();
		while (iter.hasNext()) {
			root.append(iter.next().toString()).append(separator);
		}
		String path = root.append("home").append(separator).append("answerFile.txt").toString();
		Path answerPath = FileSystems.getDefault().getPath(separator + "answerFile.txt");
		
		
		
		try {
			final OutputStream out = Files.newOutputStream(Paths.get("answerFile.txt"));
			//final PrintWriter writer = new PrintWriter(out);
			
			//if (Files.exists(answerPath)) {
			//	Files.delete(answerPath);
			//}
			//Files.createFile(answerPath);
			bufWriter = Files.newBufferedWriter(answerPath);
			writer = new PrintWriter(bufWriter, true);
			writer.print(list);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
