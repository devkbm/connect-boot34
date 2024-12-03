package com.like.hrm.staff.port.in.family.app;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.port.in.family.StaffFamilyQueryUseCase;
import com.like.hrm.staff.port.in.family.StaffFamilySaveDTO;
import com.like.hrm.staff.port.out.StaffCommandDbPort;

import jakarta.persistence.EntityNotFoundException;

@Transactional(readOnly = true)
@Service
public class StaffFamilyQueryService implements StaffFamilyQueryUseCase {

	StaffCommandDbPort dbPort;
	
	StaffFamilyQueryService(StaffCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}

	@Override
	public List<StaffFamilySaveDTO> select(String companyCode, String staffNo) {
		Staff staff = dbPort.select(companyCode, staffNo)
							.orElseThrow(() -> new EntityNotFoundException(staffNo + " 직원정보가 존재하지 않습니다."));
				
		return staff.getFamilyList()
					.getStream()
					.map(e -> StaffFamilySaveDTO.toDTO(e))
					.toList();
	}
}
