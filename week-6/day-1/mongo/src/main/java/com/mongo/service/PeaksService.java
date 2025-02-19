package com.mongo.service;

import com.mongo.entities.Ascents;
import com.mongo.entities.Peaks;
import com.mongo.repo.PeaksRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

public interface PeaksService {
    public List<Peaks> findAll();
  public Peaks findByName(String name);
  public List<Peaks> findByNameNotEqual(String name);
  public List<Peaks>  findByHeightGraterThan(int height);
  public List<Peaks>  findByNameAndHeight(String name, int height);
    public List<Peaks>  findByNameOrHeight(String name, int height);
    public List<Peaks> findByLocation(List<String> locations);
    public List<Peaks> findByAscents(int total);

}
