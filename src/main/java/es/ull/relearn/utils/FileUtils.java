package es.ull.relearn.utils;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {

	private static final Charset DEFAULT_ENCODING = StandardCharsets.UTF_8;
	
	public static String readFileContentToString(String filePath) {
		byte[] encoded = null;
		try {
			encoded = Files.readAllBytes(Paths.get(filePath));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new String(encoded, DEFAULT_ENCODING);
	}
}
