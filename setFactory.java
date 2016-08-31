import java.util.Set;
import java.util.TreeSet;
import java.util.LinkedHashSet;
import java.util.HashSet;


public interface setFactory {

	public static Set ObtenerSet(String tipoSet)
	{
		switch(tipoSet)
		{
		case "HashSet":
			return new HashSet();
		case "TreeSet":
			return new TreeSet();
		case "LinkedHashSet":
			return new LinkedHashSet();
		default:
			return null;
		}
	}
}
