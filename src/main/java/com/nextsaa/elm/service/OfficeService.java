package com.nextsaa.elm.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.access.prepost.PreAuthorize;

import com.nextsaa.elm.dto.OfficeDTO;

public interface OfficeService {

	@PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    Page<OfficeDTO> getAllOffices(Pageable pageable);

    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    OfficeDTO getOfficeById(Long id);

    // only allowed to admin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    OfficeDTO createOffice(OfficeDTO officeDTO);

    // only allowed to admin
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    OfficeDTO updateOffice(OfficeDTO officeDTO);
    
    @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_USER')")
    Page<OfficeDTO> getAllOfficesByBranchName(Pageable pageable, String branchname);
}
