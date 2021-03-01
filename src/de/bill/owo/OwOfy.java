package de.bill.owo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class OwOfy {

	public static List<String> faces = Arrays.asList(new String[] {"(*^ω^)", "(◕‿◕✿)", "(◕ᴥ◕)", "ʕ•ᴥ•ʔ", "ʕ￫ᴥ￩ʔ", "(*^.^*)", "owo", "(｡♥‿♥｡)", "uwu", "(*￣з￣)", ">w<", "^w^", "(つ✧ω✧)つ", "(/ =ω=)/"});
	
	public static String owofy(String input, boolean useFace) {
		
		String face = faces.get(new Random().nextInt(faces.size()));
		String out = input;
		out = replaceAll(replaceAll(out, "lr", "w"), "LR", "W");
		out = replaceAllWithCharAfter(out, "n", "aeiou", "ny");
		out = replaceAllWithCharAfter(out, "N", "aeiou", "Ny");
		out = replaceAllWithCharAfter(out, "N", "AEIOU", "Ny");
		out = out.replace("ove", "uv");
		if(useFace) {
			out += " " + face;
		}
		
		return out;
	}
	
	public static String owofy(String input) {
		
		String out = owofy(input, false);
		return out;
	}
	
	
	
	private static String replaceAll(String text, String chars, String newChar) {
		
		String out = "";
		
		for(char c : text.toCharArray()) {
			if(chars.contains(String.valueOf(c))) {
				out += newChar;
			} else {
				out += c;
			}
		}
		return out;
	}
	
	private static String replaceAllWithCharAfter(String text, String chars, String charsAfter, String newChar) {
		String out = "";
		
		int current = 0;
		for(char c : text.toCharArray()) {
			if(chars.contains(String.valueOf(c))) {
				
				try {
					char after = text.charAt(current+1);
					if(charsAfter.contains(String.valueOf(after))) {
						out += newChar;
					}
				} catch(Exception ex) {
					out += c;
				}
			} else {
				out += c;
			}
			current++;
		}
		return out;
	}
}
