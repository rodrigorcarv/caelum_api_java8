package java8;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Datas {
	
	public static void main(String[] args) {
		
		//Date de hoje sem tempo
		LocalDate hoje = LocalDate.now();
		System.out.println(hoje);
		
		//Criando nova data
		LocalDate olimpiadas = LocalDate.of(2016, Month.JUNE, 5);
		System.out.println(olimpiadas);
		
		//Calculando diferenca de anos
		int anos = olimpiadas.getYear() - hoje.getYear();
		System.out.println(anos);

		//Demonstracao de imutabilidade
		olimpiadas.plusYears(4);
		System.out.println(olimpiadas);
		
		LocalDate proximasOlimpiadas = olimpiadas.plusYears(4);
		System.out.println(proximasOlimpiadas);
		
		//Periodo entre data de inicio e fim 
		Period periodo = Period.between(hoje, olimpiadas);
		System.out.println(periodo);

		//Formata data 
		DateTimeFormatter formataData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		System.out.println(proximasOlimpiadas.format(formataData));
		
		//Craindo data e hora
		LocalDateTime agora = LocalDateTime.now();
		System.out.println(agora);
		
		//Formatando data e hora
		//Obs.: O formatado de data e hora nao pode ser usado para formata data.
		DateTimeFormatter formataDataComHoras = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm");
		System.out.println(agora.format(formataDataComHoras ));
		
		LocalTime intervalo = LocalTime.of(15, 30);
		System.out.println(intervalo);
		
		 
		
	}

}
