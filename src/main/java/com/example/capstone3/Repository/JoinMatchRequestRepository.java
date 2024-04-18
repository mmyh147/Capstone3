package com.example.capstone3.Repository;

import com.example.capstone3.Model.JoinMatchRequest;
import com.example.capstone3.Model.MatchModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface JoinMatchRequestRepository extends JpaRepository<JoinMatchRequest, Integer> {

    JoinMatchRequest findJoinMatchRequestById(Integer request_id);

    List<JoinMatchRequest> findJoinMatchRequestsByMatchModel(MatchModel match);
}
