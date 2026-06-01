package lc2.task2;

public class ProductImpl implements Product {

	private String name;
	private double price;
	private String category;


	public ProductImpl(String name, double price, String category) {

		this.name = name;
		this.price = price;
		this.category = category;
	}

	@Override
	public int compareTo(Product p) {
		int diff = (int) (this.price - p.getPrice());
		return diff;
	}

	@Override
	public String getCategory() {
		return category;
	}

	@Override
	public double getPrice() {
		return price;
	}

	@Override
	public String getName() {
		return name;
	}

	public int hashCode() {
		return name.hashCode()+category.hashCode()+Double.hashCode(price);
	}
	
	public String toString() {
		String out = category+ ": " +name + " " + price;
		return out;
	}
	
	public boolean equals(Object o) {

		if(!name.equals(((ProductImpl)o).getName())) {
			 return false;
		}
		if(!category.equals(((ProductImpl)o).getCategory())) {
			 return false;
		}
		if(price!=((ProductImpl)o).getPrice()) {
			 return false;
		}
		return true;
	}
}
