package com.helthplus.springbootstarter.repositories;

import org.springframework.data.repository.CrudRepository;

import com.helthplus.springbootstarter.domain.MedicineDTO;

public interface MedicineRepository extends CrudRepository<MedicineDTO, Long> {

}
