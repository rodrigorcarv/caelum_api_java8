package java7;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OrdenaStringsJava7 {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caleum");

		ComparadorPorTamanho comparadorPorTamanho = new ComparadorPorTamanho();
		Collections.sort(palavras, comparadorPorTamanho);

		System.out.println(palavras);
		
		for (String palavra : palavras) {
			System.out.println(palavra);
		}
	}
	
}

class ComparadorPorTamanho implements Comparator<String> {

	@Override
	public int compare(String s1, String s2) {
		
		if (s1.length() < s2.length()) 
			return -1;
		if (s1.length() > s2.length())
			return 1;
		return 0;
	}
}