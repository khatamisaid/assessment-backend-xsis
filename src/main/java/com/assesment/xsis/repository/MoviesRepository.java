package com.assesment.xsis.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assesment.xsis.entity.Movies;

@Repository
public interface MoviesRepository extends JpaRepository<Movies, Integer>{
    
}
