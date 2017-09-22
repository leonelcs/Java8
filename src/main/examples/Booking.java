package main.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Booking {

	public static void main(String[] args) {

		String busca = "mar banheiro";
        int reviews = 3;
        int[] hotel_ids = {1,2,1};
        String[] hotel_reviews = {"a vista para o mar é sensacional","tem ótimo banheiro","O banheiro é um mar"};
        Map<Integer, Integer> map = rankByReviews(hotel_ids,hotel_reviews,busca);
        
        List<Integer> orderedList = new ArrayList<>();

        map.entrySet().stream()
        .sorted(Map.Entry.<Integer, Integer>comparingByValue()
                .reversed()).forEachOrdered(e -> orderedList.add(e.getKey()));
        
        System.out.println(orderedList);
        
        Integer.parseInt("a");
        
	}
	
	public static Map<Integer, Integer> rankByReviews(int[] hotel_ids, String[] hotel_reviews, String busca) {
		Map<Integer, Integer> mapHotelFrequencia = new HashMap<>();
		List<String> wordsBusca = Arrays.asList(busca.toLowerCase().split(" "));

		for (int i=0; i < hotel_reviews.length;i++) {
			Set<String> conjuntoPalavras = new HashSet<>(Arrays.asList(hotel_reviews[i].toLowerCase().split(" ")));

			for (String palavra : wordsBusca) {
				if (conjuntoPalavras.contains(palavra)) {
					if (mapHotelFrequencia.containsKey(hotel_ids[i])) {
						mapHotelFrequencia.put(hotel_ids[i], mapHotelFrequencia.get(hotel_ids[i]) + 1);
					} else {
						mapHotelFrequencia.put(hotel_ids[i], 1);
					}
				}
			}
		}
		
		return mapHotelFrequencia;
	}

}
