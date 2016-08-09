package com.csc.ultil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtils {

	public static String generateRandomString(int length) throws Exception {

		StringBuffer buffer = new StringBuffer();
		String characters = "";

		characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%&*_";

		int charactersLength = characters.length();

		for (int i = 0; i < length; i++) {
			double index = Math.random() * charactersLength;
			buffer.append(characters.charAt((int) index));
		}
		return buffer.toString();
	}

	public static String encodePassword(String password) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

		String hashedPassword = passwordEncoder.encode(password);

		return hashedPassword;
	}

	public static void exportPasswordFile(String content, File destination)
			throws InterruptedException, IOException {
		try {
			if (!destination.exists()) {
				destination.createNewFile();
			}

			FileWriter fw = new FileWriter(destination.getAbsoluteFile(), true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static boolean matchPassword(String rawPass, String encodedPass){
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if(passwordEncoder.matches(rawPass, encodedPass))
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String password = "admin";
		String encodePassword = encodePassword(password);
		System.out.println(encodePassword);
		// commit to resolve
	}
}
