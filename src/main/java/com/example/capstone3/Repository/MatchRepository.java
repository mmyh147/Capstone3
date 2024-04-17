package com.example.capstone3.Repository;

import com.example.capstone3.Model.MatchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<MatchModel,Integer> {
    MatchModel findMatchById(Integer id);
}
