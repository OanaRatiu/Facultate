import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class UtilCast {
	public static <T> List<T> castList(Class<? extends T> clazz, Collection<?> c) {
		List<T> r = new ArrayList<T>(c.size());
		for (Object o : c)
			r.add(clazz.cast(o));
		return r;
	}
	
	
	public static <T> Set<T> castSet(Class<? extends T> clazz, Collection<?> c) {
		Set<T> r = new LinkedHashSet<T>(c.size());
		for (Object o : c)
			r.add(clazz.cast(o));
		return r;
	}
}
