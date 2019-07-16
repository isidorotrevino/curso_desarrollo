package com.ies.curso.tema02.ejemplo02;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Main {

	public static void main(String[] args) {
		System.out.println("Lectura de archivo");
		try (RandomAccessFile aFile = new RandomAccessFile("src/main/resources/nioreadfile.txt", "rw")) {
			FileChannel inChannel = aFile.getChannel();
			
			ByteBuffer buf = ByteBuffer.allocate(48);

			int bytesRead = inChannel.read(buf);
			while (bytesRead != -1) {
				System.out.println();
				System.out.println("- Leyendo " + bytesRead);
				buf.flip();

				while (buf.hasRemaining()) {
					System.out.print((char) buf.get());
				}

				buf.clear();
				bytesRead = inChannel.read(buf);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}

	}

}
