package com.mongo;

import com.mongo.entities.Ascents;
import com.mongo.entities.FirstAscent;
import com.mongo.entities.Peaks;
import com.mongo.repo.PeaksRepo;
import com.mongo.service.PeaksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@SpringBootApplication
public class MongoApplication implements CommandLineRunner {

	@Autowired
	private PeaksRepo peaksRepo;

	public static void main(String[] args) {

		SpringApplication.run(MongoApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		//System.out.println(peaksRepo.findByName("Everest"));
//		System.out.println(peaksRepo.findByNameNotEqual("Everest"));
//		System.out.println(peaksRepo.findByHeightGraterThan(8500));
//		System.out.println(peaksRepo.findByNameAndHeight("Everest", 8848));
//		System.out.println(peaksRepo.findByNameOrHeight("Everest", 8848));
	//	System.out.println(peaksRepo.findByLocation(List.of("China", "Nepal")));
		System.out.println(peaksRepo.findByAscents(1000));
	}
}
