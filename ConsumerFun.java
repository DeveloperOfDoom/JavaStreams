package murry.googlestreams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerFun {
	static String error = "Your code is wrong";
	static String corporateEncouragemnet
	
	
	= "Your code has an opportunity to be correct";
	public static void main(String[] args) {
		// List<String> items = Arrays.asList("FunkoPop", "VideoGame");
		Items<String> items = Items.asList("FunkoPop", "VideoGame");
		items.sellAll();
		items.sell("FunkoPop");
		if (!items.contains("FunkoPop")) {
			System.out.println(corporateEncouragemnet);
		}
		items.add("FunkoPop");
		items.sellAll();
		if (!items.isEmpty()) {
			System.out.println(error);
		}
	}
}
