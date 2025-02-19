package com.mongo.repo;

import com.mongo.entities.Ascents;
import com.mongo.entities.Peaks;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeaksRepo extends MongoRepository<Peaks, String> {
    public List<Peaks> findAll();
    @Query("{'name': ?0}")
    public Peaks findByName(String name);
    @Query("{'name':{$ne:?0}}")
    public List<Peaks> findByNameNotEqual(String name);
    @Query("{'height':{'$gt':?0}}")
    public List<Peaks>  findByHeightGraterThan(int height);
    @Query("{'name':?0 , 'height':?1}")
    public List<Peaks>  findByNameAndHeight(String name, int height);
    @Query("{'$or':[{'name':?0}, {'height':?1}]}")
    public List<Peaks>  findByNameOrHeight(String name, int height);
    @Query("{'location':{$all:?0}}")
    public List<Peaks> findByLocation(List<String> locations);
    @Query("{'ascents.total':{'$gt':?0}}")
    public List<Peaks> findByAscents(int total);
}
