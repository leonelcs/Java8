package main.examples;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Aula2Main {

	public static void main(String[] args) {
		List<Curso> cursos = new ArrayList<Curso>();
		cursos.add(new Curso("Python", 45));
		cursos.add(new Curso("JavaScript", 150));
		cursos.add(new Curso("Java 8", 113));
		cursos.add(new Curso("C", 55));
		
		cursos.sort(Comparator.comparingInt(Curso::getAlunos));
		
		int soma = cursos.stream()
			.filter(c -> c.getAlunos() > 100 )
			.mapToInt(Curso::getAlunos)
			.sum();
		System.out.println("Soma - "+soma);
		
		Optional<Curso> any = cursos.stream()
				.filter(c -> c.getAlunos() > 50)
				.findAny();
		
		any.ifPresent(System.out::println);
		
		Map<String, Integer> map = cursos
				.stream()
				.collect(Collectors.toMap(Curso::getNome,Curso::getAlunos));

		System.out.println(cursos.stream().mapToInt(Curso::getAlunos).average());
		
		System.out.println(map);
		

		
		
//		cursos.forEach(System.out::println);

	}

}
