package java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ExemploCursos {

	public static void main(String[] args) {
		
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Pyton", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparing(c -> c.getAlunos()));
		cursos.sort(Comparator.comparing(Curso::getAlunos));
		
		cursos.forEach(c -> System.out.println(c.getNome()));

		int sum = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.mapToInt(Curso::getAlunos)
			.sum();

		System.out.println(sum);
		
		//Optinal ajuda a trabalha com null
		Optional<Curso> optionalCurso = cursos.stream()
			.filter(c -> c.getAlunos() >= 100)
			.findAny();
		
		//Obtem o curso caso na exista se lanca excecao 
		optionalCurso.get();	
	
		//Otem o curso ou devolve o que foi informado
		optionalCurso.orElse(null);
		
		//Obtem o curso e impremi no nome caso exista.
		optionalCurso.ifPresent(c -> System.out.println(c.getNome()));
	
	
		List<Curso> resultado = 
				//Interface fluente 
				cursos.stream()
					//Filtra a lista
					.filter(c -> c.getAlunos() >= 100)
					//Coleta os cursos e devolve em uma nova lista.
					.collect(Collectors.toList());
	
	
		cursos.stream()
					.filter(c -> c.getAlunos() >= 100)
					.collect(Collectors.toMap(
								c -> c.getNome(), 
								c -> c.getAlunos()))
					.forEach((nome, alunos) -> System.out.println(nome + " tem " + alunos + " alunos "));
		
		
	}

}


