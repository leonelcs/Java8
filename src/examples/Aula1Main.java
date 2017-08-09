package examples;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Aula1Main {

	public static void main(String[] args) {
		List<String> palavras = new ArrayList<>();
		palavras.add("alura online");
		palavras.add("casa do código");
		palavras.add("caelum");
		
		//palavras.sort( (a,b) -> a.length()==b.length() ? 0 :((a.length()>b.length()) ? 1 :-1) );
		palavras.sort( Comparator.comparing( s -> s.length()*(-1)) );
		palavras.forEach(System.out::println);
		
		
		new Thread(() -> System.out.println("Executando um Runnable")).start();
		
	}

}

class ComparadorDeStringPorTamanho implements Comparator<String> {

    public int compare(String s1, String s2) {
    	return s1.length()==s2.length() ? 0 : (s1.length()>s2.length() ? -1 : 1);

    }

}
