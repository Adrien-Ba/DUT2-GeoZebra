package gz.utils.object;

public class Translation extends Transformation {

	private String nom;
	private int x;
	private int y;
	
	public Translation(String nom, int x, int y) {
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.addTransformation(this);
	}
	
	public String getNom() {
		return nom;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public String toString() {
		return this.nom + " : x = " + this.x + ", y = " + this.y;
	}
	
}
