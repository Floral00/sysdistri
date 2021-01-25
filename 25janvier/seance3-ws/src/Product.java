import javax.xml.bind.annotation.XmlTransient;

public class Product {

	private int code;
	private String designation;
	private double prix;
	public Product() {
		super();
	}
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	@XmlTransient
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	@Override
	public String toString() {
		return "Product [code=" + code + ", designation=" + designation + ", prix=" + prix + "]";
	}
	public Product(int code, String designation, double prix) {
		this.code=code;
		this.designation=designation;
		this.prix=prix;
	}
}
