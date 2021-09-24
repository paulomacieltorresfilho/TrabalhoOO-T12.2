package Model;

public class Snack {
	private String name;
	private double price;
	private int stockQuantity;
	private boolean available;
	
	//constructor
	public Snack(String name, double price, int stockQuantity) {
		this.setName(name);
        this.setPrice(price);
        this.setStockQuantity(stockQuantity);
	}

	//gets and sets
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

}