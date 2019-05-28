package gz.utils.object;

import java.util.HashMap;
import java.util.Map;

public class Transformation {

	private Map<String, Transformation> lesTransformations = new HashMap<String, Transformation>();
	
	public void addTransformation(Translation t) {
		this.lesTransformations.put(t.getNom(), t);
	}
	
	public void addTransformation(Rotation r) {
		this.lesTransformations.put(r.getNom(), r);
	}
	
	public void addTransformation(Homothetie h) {
		this.lesTransformations.put(h.getNom(), h);
	}
	
}
