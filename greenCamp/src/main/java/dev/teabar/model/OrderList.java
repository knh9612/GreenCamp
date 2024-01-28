package dev.teabar.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
public class OrderList {
	
	private int id;
	@NonNull
	private String name;
	@NonNull
	private String size;
	@NonNull
	private int price;
	@NonNull
	private int quantity;
	
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
	public int getQuantity() {
		return quantity;
	}
	
	
}
