package dev.servlet.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class Tea {
	private int id;
	private String name;
	private String size;
	private int price;
	
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getSize() {
		return size;
	}
	public int getPrice() {
		return price;
	}
	
	
	public Tea(String name, String size, int price) {
		this.name = name;
		this.size = size;
		this.price = price;
	}
	
}