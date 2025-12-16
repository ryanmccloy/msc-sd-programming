/**
 * 
 */
package breeds;

import java.util.Comparator;

/**
 * 
 */
public class OrderByWeight implements Comparator<Dog> {

	@Override
	public int compare(Dog o1, Dog o2) {
		return Double.compare(o1.getWeight(), o2.getWeight());
	}

}
