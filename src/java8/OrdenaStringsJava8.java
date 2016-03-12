package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class OrdenaStringsJava8 {

	public static void main(String[] args) {

		List<String> palavras = new ArrayList<String>();
		palavras.add("alura online");
		palavras.add("editora casa do codigo");
		palavras.add("caleum");

		ComparadorPorTamanho comparadorPorTamanho = new ComparadorPorTamanho();

		palavras.sort(comparadorPorTamanho);
		
		//Refactor Comparator para Lambda Fase 1 --> Equivalente classe anonima 
		palavras.sort(new Comparator<String>() {

			@Override
			public int compare(String s1, String s2) {

				if (s1.length() < s2.length()) 
					return -1;
				if (s1.length() > s2.length())
					return 1;
				return 0;
			}
		});
		
		//Refactor Comparator para Lambda Fase 2 
		palavras.sort((String s1, String s2) -> {

				if (s1.length() < s2.length()) 
					return -1;
				if (s1.length() > s2.length())
					return 1;
				return 0;
		});

		
		//Refactor Comparator para Lambda Fase 3 
		palavras.sort((String s1, String s2) -> Integer.compare(s1.length(), s2.length())) ;

		//Refactor Comparator para Lambda Fase 4 
		palavras.sort(Comparator.comparing(s -> s.length())) ;
		
		//Refactor Comparator para Lambda Fase 5 
		palavras.sort(Comparator.comparing(String::length)) ;
		
		//Igual ao Refactor Comparator para Lambda Fase 4 --> Somente demostracao de passos 
		Function<String, Integer> funcao = s -> s.length();
		Comparator<String> comparador = Comparator.comparing(funcao);
		palavras.sort(comparador) ;
		
		
		//Chamada comentada utilizando classe Utilizando classe anonima
		//Consumer<String> consumer = new ImprimeNaLinha();

		//Refactor Consume para Lambda Fase 1 --> Equivalente classe anonima 
		palavras.forEach(new Consumer<String>() {

			@Override
			public void accept(String t) {
				System.out.println(t);
			}
		});

		//Refactor Consume para Lambda Fase 2
		palavras.forEach((String s) -> { System.out.println(s); });
		
		//Refactor Lambda Fase 3
		palavras.forEach(s ->  System.out.println(s));

		//Refactor Lambda Fase 4
		palavras.forEach(System.out::printf);
	}
}

//Equivalente a classe anonima
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