package com.nextsaa.elm.mapper;

import com.nextsaa.elm.dto.OfficeDTO;
import com.nextsaa.elm.entity.Office;

public class OfficeMapper {

	public static OfficeDTO mapToDto(Office office) {
		OfficeDTO officeDTO = new OfficeDTO();
        officeDTO.setBranchCode(office.getBranchCode());
        officeDTO.setBranchName(office.getBranchName());
        officeDTO.setBranchAddress(office.getBranchAddress());
        officeDTO.setBranchLatitude(office.getLatitude());
        officeDTO.setBranchLongitude(office.getLongitude());
        officeDTO.setAllowedRadius(office.getRadius());
        officeDTO.setStatus(String.valueOf(office.getStatus()));
        officeDTO.setCreatedAt((office.getCreatedAt()));
        officeDTO.setCreatedBy((office.getCreatedBy()));
        officeDTO.setModifiedAt(office.getModifiedAt());
        officeDTO.setModifiedBy(office.getModifiedBy());
        return officeDTO;
    }

    public static Office mapToEntity(OfficeDTO officeDTO) {
        Office office = new Office();
        office.setBranchCode(officeDTO.getBranchCode());
        office.setBranchName(officeDTO.getBranchName());
        office.setBranchAddress(officeDTO.getBranchAddress());
        office.setLatitude(officeDTO.getBranchLatitude());
        office.setLongitude(officeDTO.getBranchLongitude());
        office.setRadius(officeDTO.getAllowedRadius());
        office.setCreatedAt(officeDTO.getCreatedAt());
        office.setCreatedBy(officeDTO.getCreatedBy());
        office.setModifiedBy(officeDTO.getModifiedBy());
        office.setModifiedAt(officeDTO.getModifiedAt());
        office.setStatus(StatusMapper.mapOfficeStatus(officeDTO.getStatus()));
        return office;
    }
}
