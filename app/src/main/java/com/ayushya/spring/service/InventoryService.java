package com.ayushya.spring.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.ayushya.spring.bean.InventoryAccessories;
import com.ayushya.spring.bean.InventoryParts;
import com.ayushya.spring.bean.Technician;
import com.ayushya.spring.bean.Tickets;


public interface InventoryService {

	public InventoryParts updatePart (String pardId,InventoryParts item);
	public InventoryAccessories updateAccessory (String pardId,InventoryAccessories item);

	public Iterable<InventoryParts> fetchMatchingParts(String brand, String category, String sub_category, String model);
	public Iterable<InventoryAccessories> fetchMatchingAccessory(String brand, String category, String sub_category, String model);

	public InventoryParts requestNewPart(InventoryParts itemDetails);
	public InventoryAccessories requestNewAccessory(InventoryAccessories itemDetails);
	
	public Iterable<InventoryParts> fetchMatchingPartsWithoutSubCategory(String brand, String category, String model);
	public Iterable<InventoryAccessories> fetchMatchingAccessoryWithoutSubCategory(String brand, String category, String model);

}
