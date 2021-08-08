package com.nextsaa.elm.service;

import java.time.LocalDateTime;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nextsaa.elm.dto.OfficeDTO;
import com.nextsaa.elm.entity.Office;
import com.nextsaa.elm.exceptions.DataNotFoundException;
import com.nextsaa.elm.mapper.OfficeMapper;
import com.nextsaa.elm.repository.OfficeRepository;
import com.nextsaa.elm.security.ExtractUserAuthentication;
import com.nextsaa.elm.util.ExceptionConstants;

@Service
public class OfficeServiceImpl implements OfficeService{

	private OfficeRepository officeRepository;
	
	public OfficeServiceImpl(OfficeRepository officeRepo) {
		this.officeRepository = officeRepo;
	}

	@Override
	public Page<OfficeDTO> getAllOffices(Pageable pageable) {
		return officeRepository.findAll(pageable)
								.map(office -> OfficeMapper.mapToDto(office));
	}


	@Override
	public OfficeDTO getOfficeById(Long id) {
		Office office = officeRepository.findById(id)
				.orElseThrow(() -> new DataNotFoundException(ExceptionConstants.OFFICE_RECORD_NOT_FOUND));
		return OfficeMapper.mapToDto(office);
	}

	@Override
	public OfficeDTO createOffice(OfficeDTO officeDTO) {
		officeDTO.setCreatedBy(ExtractUserAuthentication.getCurrentUser().getUsername());
		officeDTO.setModifiedBy(ExtractUserAuthentication.getCurrentUser().getUsername());
		return OfficeMapper.mapToDto(officeRepository.save(OfficeMapper.mapToEntity(officeDTO)));
	}

	@Override
	public OfficeDTO updateOffice(OfficeDTO officeDTO) {
		Office existingOffice = officeRepository.findById(officeDTO.getBranchCode())
		.orElseThrow(() -> new DataNotFoundException(ExceptionConstants.OFFICE_RECORD_NOT_FOUND));
		
		Office officeDetailsToUpdate = OfficeMapper.mapToEntity(officeDTO);
		officeDetailsToUpdate.setModifiedBy(ExtractUserAuthentication.getCurrentUser().getUsername());
		officeDetailsToUpdate.setCreatedAt(existingOffice.getCreatedAt());
		officeDetailsToUpdate.setCreatedBy(existingOffice.getCreatedBy());
		officeDetailsToUpdate.setModifiedAt(LocalDateTime.now());
		return OfficeMapper.mapToDto(officeRepository.save(officeDetailsToUpdate));
	}

	@Override
	public Page<OfficeDTO> getAllOfficesByBranchName(Pageable pageable, String branchName) {
		return officeRepository.findByBranchNameContaining(pageable, branchName)
								.map(office -> OfficeMapper.mapToDto(office));
	}
}
