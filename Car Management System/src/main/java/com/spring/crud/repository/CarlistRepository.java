package com.spring.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.crud.model.entity.Carlist;

@Repository
public interface CarlistRepository extends JpaRepository<Carlist, Long>{

}
