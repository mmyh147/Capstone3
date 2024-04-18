package com.example.capstone3.Repository;

import com.example.capstone3.Model.Field;
import com.example.capstone3.Model.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FieldRepository extends JpaRepository<Field,Integer> {
    Field findFieldById(Integer field_id);

    List<Field> findFieldsByOrganizer(Organizer organizer);
}
