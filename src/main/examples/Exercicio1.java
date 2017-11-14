package main.examples;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exercicio1 {
	
	static List<Integer> greatestFlightRangeDrones(Integer numberOfRequiredDrones, List<Drone> drones, List<Integer> inMaintenanceDrones) {
        // TODO: implement this function
		
		Set<Integer> set = new HashSet<>();
		inMaintenanceDrones.stream().forEach( m -> set.add(m));
		return drones
			.stream()
			.filter( d -> !set.contains(d.getId()) )
			.sorted(Comparator.comparingInt(Drone::getFlightRange).reversed())
			.map(d -> Integer.valueOf(d.getId()))
			.collect(Collectors.toList()).subList(0, numberOfRequiredDrones);

    }

}

class Drone {
    private int id;
    private int flightRange;

    public Drone(int id, int flightRange) {

        this.id = id;
        this.flightRange = flightRange;
    }

    public int getId() {
        return id;
    }

    public int getFlightRange() {
        return flightRange;
    }
}
