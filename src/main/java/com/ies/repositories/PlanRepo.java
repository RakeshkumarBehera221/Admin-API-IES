package com.ies.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ies.entities.PlanEntity;

public interface PlanRepo extends JpaRepository<PlanEntity, Integer>{

}
