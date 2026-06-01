package lc2.task2;

import java.util.List;
import java.util.Map;

public interface WareHouse {

	public void addProduct(Product product, int amount);
	
	public Map<Product, Integer>  getInventory();
	
	public int getStock(Product product);
	
	public List<Product> listAvailableProducts(String string);
	
	
}
