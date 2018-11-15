package murry.googlestreams;

import java.util.Arrays;
import java.util.stream.Collectors;


/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		var cities = Arrays.asList("Philadelphia", "New York", "Baltimore", "Boston", "Raleigh");
		
		var citiesStartingWithB = cities.stream().filter(city -> city.startsWith("B"));
		var printout = citiesStartingWithB.map(App::makeSentence).collect(Collectors.toList());
		printout.forEach(System.out::println);
	}


	public static String makeSentence(String city) {
		return city + ", this city was selected";
	}

}
