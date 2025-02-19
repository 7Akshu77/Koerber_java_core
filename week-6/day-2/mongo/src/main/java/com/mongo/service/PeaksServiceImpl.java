package com.mongo.service;

import com.mongo.entities.Ascents;
import com.mongo.entities.Peaks;
import com.mongo.repo.PeaksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
    public List<Peaks> findByNameAndHeight(String name, int height) {
        return peaksRepo.findByNameAndHeight(name,height);
    }

    @Override
    public List<Peaks> findByLocation(List<String> locations) {
     return peaksRepo.findByLocation(locations);
    }

    @Override
    public List<Peaks> findByAscend(){
        return peaksRepo.findByAscend();
    }
    @Override
    public List<Peaks> findExceptLocationAndAsents(){
        return peaksRepo.findExceptLocationAndAsents();
    }
    @Override
    public List<Peaks> findByLimit(Pageable page){
        return peaksRepo.findByLimit(PageRequest.of(0,3));
    }
}
