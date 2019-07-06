package com.ayushya.spring.service;

import java.util.List;

import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.ayushya.spring.bean.InventoryAccessories;
import com.ayushya.spring.bean.InventoryParts;
import com.ayushya.spring.bean.Technician;
import com.ayushya.spring.bean.Tickets;
import com.ayushya.spring.repository.InventoryAccessoryRepository;
import com.ayushya.spring.repository.InventoryPartsRepository;
import com.ayushya.spring.repository.TechnicianRepository;
import com.ayushya.spring.repository.TicketsRepository;

@Service
@Transactional
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private InventoryPartsRepository repository;
	
	@Autowired
	private InventoryAccessoryRepository accessoryRepository;
	
	@Override
	public InventoryParts updatePart(String pardId, InventoryParts item) {
		InventoryParts exisitingItem =  repository.findOne(pardId);
		if(exisitingItem!=null) item.set_id(exisitingItem._id);
		return repository.save(item);
	}

	@Override
	public Iterable<InventoryParts> fetchMatchingParts(String brand, String category, String sub_category, String model) {
		return repository.fetchMatchingParts(brand,category,sub_category,model);
	}

	@Override
	public InventoryParts requestNewPart(InventoryParts itemDetails) {
		return repository.save(itemDetails);
	}
	
	@Override
	public Iterable<InventoryParts> fetchMatchingPartsWithoutSubCategory(String brand, String category, String model) {
		return repository.fetchMatchingPartsWithoutSubcategory(brand,category,model);
	}

	@Override
	public InventoryAccessories updateAccessory(String pardId, InventoryAccessories item) {
		InventoryAccessories exisitingItem =  accessoryRepository.findOne(pardId);
		if(exisitingItem!=null) item.set_id(exisitingItem._id);
		return accessoryRepository.save(item);
	}

	@Override
	public Iterable<InventoryAccessories> fetchMatchingAccessory(String brand, String category, String sub_category,
			String model) {
		return accessoryRepository.fetchMatchingAccessories(brand, category, sub_category, model);
	}

	@Override
	public InventoryAccessories requestNewAccessory(InventoryAccessories accessoryDetails) {
		return accessoryRepository.save(accessoryDetails);
	}


	@Override
	public Iterable<InventoryAccessories> fetchMatchingAccessoryWithoutSubCategory(String brand, String category,
			String model) {
		return accessoryRepository.fetchMatchingAccessoriesWithoutSubCategory(brand, category, model);

	}

	}
