package com.nextsaa.elm.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nextsaa.elm.entity.Office;
import com.nextsaa.elm.util.enums.OfficeStatus;

@Repository
public interface OfficeRepository extends JpaRepository<Office, Long>{

	@Override
    Page<Office> findAll(Pageable pageable);

	Office findByBranchName(String branchName);

    Office findBybranchNameAndStatus(String branchName, OfficeStatus status);
    
    Page<Office> findByBranchNameContaining(Pageable pageable, String branchname);
}
