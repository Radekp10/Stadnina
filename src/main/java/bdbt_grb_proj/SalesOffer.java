package bdbt_grb_proj;

public class SalesOffer {

	/* Fields */
	private int id;
	private String status;
	private float price;
	private int horseId;

	/* Constructor for superclass */
	public SalesOffer() {
	}

	/* Constructor */
	public SalesOffer(int id, String status, float price, int horseId) {
		super();
		this.id = id;
		this.status = status;
		this.price = price;
		this.horseId = horseId;
	}

	
	/* Getters and setters */
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getHorseId() {
		return horseId;
	}

	public void setHorseId(int horseId) {
		this.horseId = horseId;
	}

	/* toString() */
	@Override
	public String toString() {
		return "SalesOffer [id=" + id + ", status=" + status + ", price=" + price + ", horseId=" + horseId + "]";
	}

	
}
