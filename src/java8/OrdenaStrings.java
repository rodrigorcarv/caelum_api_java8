package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

public class OrdenaStrings {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caleum");

		ComparadorPorTamanho comparadorPorTamanho = new ComparadorPorTamanho();
		palavras.sort(comparadorPorTamanho);
		
		Consumer<String> consumer = new ImprimeNaLinha();
		palavras.forEach(consumer);
	}
}

class ImprimeNaLinha implements Consumer<String> {

	@Override
	public void accept(String t) {
		System.out.println(t);
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