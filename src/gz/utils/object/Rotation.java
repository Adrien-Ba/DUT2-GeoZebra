package gz.utils.object;

public class Rotation extends Transformation {

	private String nom;
	private int x;
	private int y;
	private int deg;
	
	public Rotation(String nom, int x, int y, int deg) {
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.deg = deg;
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
	
	public int getDeg() {
		return deg;
	}
	
	public String toString() {
		return this.nom + " : x = " + this.x + ", y = " + this.y + ", degre = " + this.deg;
	}
	
}
