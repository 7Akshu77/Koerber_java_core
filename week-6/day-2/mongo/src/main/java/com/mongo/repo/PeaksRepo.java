package com.mongo.repo;

import com.mongo.entities.Ascents;
import com.mongo.entities.Peaks;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PeaksRepo extends MongoRepository<Peaks, String> {
    public List<Peaks> findAll();
    @Query("{'name':{$ne:?0}}")
    public List<Peaks>  findByNameAndHeight(String name, int height);
    @Query("{'location':{$all:?0}}")
    public List<Peaks> findByLocation(List<String> locations);
   @Query("{'ascents.first_winter.year':{'$gt':2000}}")
    public List<Peaks> findByAscend();
   @Query("{},{'ascents':0, 'location':0}")
    public List<Peaks> findExceptLocationAndAsents();
   @Query("{{}}")
    public List<Peaks> findByLimit(Pageable page);
}
