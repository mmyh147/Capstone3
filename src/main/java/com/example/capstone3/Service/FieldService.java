package com.example.capstone3.Service;

import com.example.capstone3.Api.ApiException;
import com.example.capstone3.Model.Field;
import com.example.capstone3.Model.Organizer;
import com.example.capstone3.Repository.FieldRepository;
import com.example.capstone3.Repository.OrganizerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FieldService {
    private final FieldRepository fieldRepository;
    private final OrganizerRepository organizerRepository;

    public void addField(Integer organizer_id, Field field){
        Organizer organizer = organizerRepository.findOrganizerById(organizer_id);
        if(organizer == null){
            throw new ApiException("organizer does not exists");
        }
        field.setOrganizer(organizer);
        fieldRepository.save(field);
    }

    public List<Field> getAllField()
    {
        return fieldRepository.findAll();
    }

    public void updateField(Integer field_id, Field field){
        Field f = fieldRepository.findFieldById(field_id);
        if(f == null){
            throw new ApiException("field does not exists");
        }
        f.setName(field.getName());
        f.setDimensions(field.getDimensions());
        fieldRepository.save(field);
    }

    public void deleteField(Integer field_id){
        Field field = fieldRepository.findFieldById(field_id);
        if(field == null){
            throw new ApiException("field does not exists");
        }

        fieldRepository.delete(field);
    }
}
