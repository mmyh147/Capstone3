package com.example.capstone3.Serivce;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Organizer;
import com.example.capstone3.Repository.OrganizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrganizerService {
    private final OrganizerRepository organizerRepository;

    public void addOrganizerRepository(Organizer organizer){
        organizerRepository.save(organizer);
    }

    public List<Organizer> getAllOrganizers(){
        return organizerRepository.findAll();
    }

    public void updateOrganizer(Integer organizer_id, Organizer organizer){
        Organizer o = organizerRepository.findOrganizerById(organizer_id);

        if(o == null){
            throw new ApiException("organizer does not exists");
        }

        o.setName(organizer.getName());
        o.setAge(organizer.getAge());
        o.setPhone(organizer.getPhone());
        organizerRepository.save(o);
    }

    public void deleteOrganizer(Integer organizer_id){
        Organizer organizer = organizerRepository.findOrganizerById(organizer_id);
        if(organizer == null){
            throw new ApiException("organizer does not exists");
        }
        organizerRepository.delete(organizer);
    }

}
