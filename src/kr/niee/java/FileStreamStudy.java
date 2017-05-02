package kr.niee.java;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FileStreamStudy {
	public static void main(String[] args) {
		File file = new File("test.txt");
		try(FileWriter writer = new FileWriter(file)){
			IntStream.rangeClosed(1, 10).forEach(i -> {
				try{
					writer.write("test " + i + " \n");
				} catch (IOException e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			});
		}catch (IOException e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		try (Stream<String> stream = Files.lines(Paths.get("test.txt"))) {

			stream.forEach( i-> System.out.println(i));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
