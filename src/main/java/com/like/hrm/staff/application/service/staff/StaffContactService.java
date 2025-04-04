package com.like.hrm.staff.application.service.staff;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.common.vo.Address;
import com.like.common.vo.PhoneNumber;
import com.like.hrm.staff.adapter.out.db.staff.data.StaffJpaRepository;
import com.like.hrm.staff.application.dto.staff.StaffContactSaveDTO;
import com.like.hrm.staff.domain.staff.Staff;
import com.like.hrm.staff.domain.staff.StaffContact;
import com.like.hrm.staff.domain.staff.StaffId;

@Service
@Transactional
public class StaffContactService {

	private StaffJpaRepository repository;	
	
	public StaffContactService(StaffJpaRepository repository) {
		this.repository = repository;
	}
	
	public StaffContactSaveDTO get(String companyCode, String staffNo) {
		Staff staff = repository.findById(new StaffId(companyCode,staffNo)).orElse(null);
		
		return StaffContactSaveDTO.toDTO(staff);
	}
	
	public void save(StaffContactSaveDTO dto) {
		Staff staff = repository.findById(new StaffId(dto.companyCode(), dto.staffNo())).orElseThrow(() -> new IllegalArgumentException("직원정보가 존재하지 않습니다."));
						
		staff.changeContact(new StaffContact(new Address(dto.homeAddressType(), dto.homePostNumber(), dto.homeMainAddress(), dto.homeSubAddress())
						   ,new PhoneNumber(dto.extensionNumber())
						   ,new PhoneNumber(dto.mobileNumber())));
		
		this.repository.save(staff);
	}
	
	
}
