package com.mongo.service;

import com.mongo.entities.Ascents;
import com.mongo.entities.Peaks;
import com.mongo.repo.PeaksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PeaksServiceImpl implements PeaksService {

    @Autowired
   private PeaksRepo peaksRepo;

    @Override
    public List<Peaks> findAll() {
       return  peaksRepo.findAll().stream().toList();
    }

    @Override
    public Peaks findByName(String name) {
        return peaksRepo.findByName(name);
    }

    @Override
    public List<Peaks> findByNameNotEqual(String name) {
        return peaksRepo.findByNameNotEqual(name);
    }

    @Override
    public List<Peaks> findByHeightGraterThan(int height) {
        return peaksRepo.findByHeightGraterThan(height);
    }

    @Override
    public List<Peaks> findByNameAndHeight(String name, int height) {
        return peaksRepo.findByNameAndHeight(name,height);
    }

    @Override
    public List<Peaks> findByNameOrHeight(String name, int height) {
        return peaksRepo.findByNameOrHeight(name, height);
    }

    @Override
    public List<Peaks> findByLocation(List<String> locations) {
     return peaksRepo.findByLocation(locations);
    }

    @Override
    public List<Peaks> findByAscents(int ascents) {
    return peaksRepo.findByAscents(ascents);
    }
}
