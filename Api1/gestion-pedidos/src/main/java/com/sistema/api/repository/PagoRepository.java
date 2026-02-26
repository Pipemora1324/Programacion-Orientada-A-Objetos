package com.sistema.api.repository;

import com.sistema.api.model.PagoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends JpaRepository<PagoModel, Integer> {
}