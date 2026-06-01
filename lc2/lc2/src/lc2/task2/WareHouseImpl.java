package lc2.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class WareHouseImpl implements WareHouse, Iterable<Product> {

	protected Map<Product, Integer> inventory;
	
	public WareHouseImpl() {
		inventory=new HashMap<>();
	}
	
	@Override
	public Iterator<Product> iterator() {
		
		List<Product> products = new ArrayList<>(inventory.keySet());
		products.sort(Comparator.comparingDouble(Product::getPrice));
		
		return products.iterator();
	}

	@Override
	public void addProduct(Product product, int amount) {
		if(inventory.containsKey(product)) {
			if(amount>0) {
				inventory.replace(product, inventory.get(product)+amount);
			}
		}else {
			inventory.put(product, amount);
		}
	}

	@Override
	public Map<Product, Integer> getInventory() {
		Map<Product, Integer> copy = inventory;
		return copy;
	}

	@Override
	public int getStock(Product product) {
		if(inventory.containsKey(product)) {
			return inventory.get(product);
		}else {
			return 0;
		}
	}

	@Override
	public List<Product> listAvailableProducts(String category) {
	
		List<Product> avProducts = new ArrayList<>();
		for (Product p : inventory.keySet()) {
			if(p.getCategory().equals(category)&&inventory.get(p)>0) {
				avProducts.add(p);
			}
		}
		return avProducts;
	}
}
