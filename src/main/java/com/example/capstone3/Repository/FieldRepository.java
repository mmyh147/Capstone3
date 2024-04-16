package com.example.capstone3.Repository;

import com.example.capstone3.Model.Field;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FieldRepository extends JpaRepository<Field,Integer> {
    Field findFieldById(Integer field_id);
}
