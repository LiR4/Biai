package com.api.biai.repository;

import com.api.biai.model.BiFile;


import org.springframework.data.jpa.repository.JpaRepository;

public interface IBiRepository extends JpaRepository<BiFile, Long>{

}
