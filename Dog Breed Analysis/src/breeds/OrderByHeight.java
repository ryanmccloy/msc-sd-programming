package breeds;

import java.util.Comparator;

public class OrderByHeight implements Comparator<Dog> {


	@Override
	public int compare(Dog o1, Dog o2) {
		return Double.compare(o1.getHeight(), o2.getHeight());
	}


}
