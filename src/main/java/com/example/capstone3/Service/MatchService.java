package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Field;
import com.example.capstone3.Model.MatchModel;
import com.example.capstone3.Model.Team;
import com.example.capstone3.Repository.FieldRepository;
import com.example.capstone3.Repository.MatchRepository;
import com.example.capstone3.Repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchRepository matchRepository;
    private final FieldRepository fieldRepository;
    private final TeamRepository teamRepository;
    public List<MatchModel> getAllMatch()

    {
        return matchRepository.findAll();
    }
    public void addMatch(Integer field_id, MatchModel matchModel){
        Field field =fieldRepository.findFieldById(field_id);
        if (field==null){
            throw new ApiException("Field not found ");
        }
        matchModel.setField(field);
        matchRepository.save(matchModel);
    }
    public void UpdateMatch(Integer id , MatchModel matchModel){
        MatchModel m =matchRepository.findMatchById(id);
        if (m==null){
            throw new ApiException(" not found");
        }
        m.setStartDate(matchModel.getStartDate());
        m.setEndDate(matchModel.getEndDate());
        m.setWinner(matchModel.getWinner());
        m.setResult(matchModel.getResult());
        matchRepository.save(m);
    }
    public void deleteMatch(Integer id){
        MatchModel matchModel =matchRepository.findMatchById(id);
        if (matchModel ==null){
            throw new ApiException("not found");
        }
        matchRepository.delete(matchModel);
    }

    public void assignTeamsToMatch(Integer match_id,Integer firstTeam_id, Integer secondTeam_id){
        Team firstTeam = teamRepository.findTeamById(firstTeam_id);
        Team secondTeam = teamRepository.findTeamById(secondTeam_id);
        if(firstTeam == null || secondTeam == null){
            throw new ApiException("can't assign teams");
        }
        MatchModel matchModel = matchRepository.findMatchById(match_id);
        if(matchModel == null){
            throw new ApiException("match does not exists");
        }
        matchModel.getTeams().add(firstTeam);
        matchModel.getTeams().add(secondTeam);
        matchRepository.save(matchModel);
    }
}