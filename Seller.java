package murry.googlestreams;

import java.util.List;

public interface Seller<T> {

	abstract void sell(T t);
}
