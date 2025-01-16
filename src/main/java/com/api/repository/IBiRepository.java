package com.api.repository;

import com.api.model.BiFile;


import org.springframework.data.jpa.repository.JpaRepository;

public interface IBiRepository extends JpaRepository<BiFile, Long>{

}
