package com.testing.geohash;

import com.testing.geohash.Domain.StoreEntity;
import com.testing.geohash.Service.StoreService;
import com.testing.geohash.Utility.Geography.Geohash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class GeohashApplication implements CommandLineRunner{
	@Autowired
	StoreService storeService;

	public static void main(String[] args) {
		SpringApplication.run(GeohashApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World");
		List<StoreEntity> stores = storeService.getNearby(121.431332, 31.02223);
		stores.forEach(e -> System.out.println(e.toString()));
	}


}
