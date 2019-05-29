package gz.utils.object;

public class Homothetie extends Transformation {

	private String nom;
	private int x;
	private int y;
	private int rap;
	
	public Homothetie(String nom, int x, int y, int rap) {
		this.nom = nom;
		this.x = x;
		this.y = y;
		this.rap = rap;
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
	
	public int getRap() {
		return rap;
	}
	
	public String toString() {
		return this.nom + " : x = " + this.x + ", y = " + this.y + ", rapport = " + this.rap;
	}
	
}
