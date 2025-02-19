package com.mongo.service;

import com.mongo.entities.Ascents;
import com.mongo.entities.Peaks;
import com.mongo.repo.PeaksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public interface PeaksService {
    public List<Peaks> findAll();
  public List<Peaks>  findByNameAndHeight(String name, int height);
    public List<Peaks> findByLocation(List<String> locations);
  public List<Peaks> findByAscend();
  public List<Peaks> findExceptLocationAndAsents();
  public List<Peaks> findByLimit(Pageable page);


}
