package murry.googlestreams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Items<E> extends ArrayList<E> implements List<E> {

	/**
	 * Default
	 */
	private static final long serialVersionUID = 1L;
	private Seller<E> itemSeller = e -> System.out.println(e + " was sold...");

	public static <E> Items<E> asList(E... e) {
		Items<E> items = new Items<>();
		items.addAll(Arrays.stream(e).collect(Collectors.toList()));
		return items;

	}

	public void sell(E e) {
		if (this.contains(e)) {
			System.out.println(e + " was sold...");
			this.remove(e);
		}
	};

	public void sell(E... e) {
		Arrays.stream(e).forEach(element -> {
			if (this.contains(element)) {
				System.out.println(e + " was sold...");
				this.remove(element);
			}
		});
	}

	public void sellWith(E e, Seller<E> seller) {
		Objects.requireNonNull(seller);
		if (this.contains(e)) {
			seller.sell(e);
			this.remove(e);
		}
	};

	public void sellIf(E e, Predicate<E> pred) {
		Objects.requireNonNull(pred);
		if (this.contains(e) && pred.test(e)) {
			itemSeller.sell(e);
			this.remove(e);
		}
	};

	public void sellAll() {
		this.forEach(item -> itemSeller.sell(item));
		this.clear();
	};

	public void sellAllWith(Seller<E> seller) {
		Objects.requireNonNull(seller);
		this.forEach(item -> seller.sell(item));
		this.clear();
	}
}
