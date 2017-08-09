package examples;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReadingInvoiceFiles {

	public static void main(String[] args) {
		if (args.length>0) {
			Path path = Paths.get(args[0]);

			Pattern pattern = Pattern.compile("^(#|DOCNO)");
			Stream<String> lines;
			try {
				lines = Files.lines(path);
				List<InvoiceDetails> cLines = lines
								.filter( l -> !(pattern.matcher(l.trim()).find()) )
								.map(line -> {
									String[] ls = line.split(",");
									InvoiceDetails id = new InvoiceDetails(ls[0], ls[1], ls[2], ls[3]);
									return id;
								})
								.collect(Collectors.toList());
				
				cLines
					.sort(Comparator.comparing(InvoiceDetails::getValue).reversed());
				
				System.out.println(cLines.get(0));

				Map<String, Double> map = cLines.stream()
						.collect(Collectors.groupingBy(InvoiceDetails::getCustomer,Collectors.summingDouble(InvoiceDetails::getValue)));
				
				List<String> orderedList = new ArrayList<>();
				
		        map.entrySet().stream()
		                .sorted(Map.Entry.<String, Double>comparingByValue()
		                        .reversed()).forEachOrdered(e -> orderedList.add(e.getKey()));
				
		        System.out.println(orderedList.get(0));

			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
    
		}
	}

}

class InvoiceComparator implements Comparator<InvoiceDetails> {

    public int compare(InvoiceDetails inv1, InvoiceDetails inv2) {
    	return inv1.value==inv2.value ? 0 : (inv1.value>inv2.value ? -1 : 1);

    }

}

class InvoiceDetails {
	String id;
	float value;
	String date;
	String customer;
	
	float getValue() {
		return this.value;
	}
	
	String getCustomer() {
		return this.customer;
	}
	
	public InvoiceDetails(String id, String value, String date, String customer) {
		this.id = id.trim();
		this.value = Float.parseFloat(value.trim());
		this.date = date.trim();
		this.customer = customer.trim();
	}
	
	public String toString() {
		return this.id + ", " + this.value + ", " + this.date + ", " + this.customer;
	}
}