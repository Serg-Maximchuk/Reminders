package com.serhii.reminder;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import java.util.List;

public class Writer {

	public static void writeToFile(List<?> list) {
		BufferedWriter bufWriter;
		PrintWriter writer;
		String separator = FileSystems.getDefault().getSeparator();
		StringBuffer root = new StringBuffer();
		Iterator<Path> iter = FileSystems.getDefault().getRootDirectories().iterator();
		while (iter.hasNext()) {
			root.append(iter.next().toString());
		}
		String path = root + separator + "answerFile.txt";
		Path answerPath = FileSystems.getDefault().getPath(path);

		try {
			if (Files.exists(answerPath)) {
				Files.delete(answerPath);
			}
			Files.createFile(answerPath);
			bufWriter = Files.newBufferedWriter(answerPath);
			writer = new PrintWriter(bufWriter, true);
			writer.print(list);
			writer.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
