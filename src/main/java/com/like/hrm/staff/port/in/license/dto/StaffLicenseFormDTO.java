package com.like.hrm.staff.port.in.license.dto;

import java.time.LocalDate;

import com.like.hrm.staff.domain.Staff;
import com.like.hrm.staff.domain.license.StaffLicense;

import jakarta.validation.constraints.NotEmpty;
import lombok.AccessLevel;
import lombok.Builder;

@Builder(access = AccessLevel.PRIVATE)
public record StaffLicenseFormDTO(
		String clientAppUrl,
		String companyCode,			
		@NotEmpty String staffNo,
		String staffName,
		Long seq,
		@NotEmpty String licenseType,
		@NotEmpty String licenseNumber,
		LocalDate dateOfAcquisition,
		String certificationAuthority,
		String comment
		) {
	
	public StaffLicense newEntity(Staff staff) {
		StaffLicense entity = StaffLicense.builder()
										  .staff(staff)
										  .licenseType(licenseType)
										  .licenseNumber(licenseNumber)
										  .dateOfAcquisition(dateOfAcquisition)
										  .certificationAuthority(certificationAuthority)
										  .comment(comment)
										  .build();
		entity.setAppUrl(clientAppUrl);
		
		return entity; 			
	}
	
	public void modifyEntity(StaffLicense entity) {
		entity.modifyBuilder()			
		      .licenseType(licenseType)
		      .licenseNumber(licenseNumber)
		      .dateOfAcquisition(dateOfAcquisition)
		      .certificationAuthority(certificationAuthority)
		      .comment(comment)
			  .modify();
		
		entity.setAppUrl(clientAppUrl);
	}	
	
	public static StaffLicenseFormDTO toDTO(StaffLicense entity)  {
		if (entity == null) return null; 
		
		return StaffLicenseFormDTO.builder()
				   .companyCode(entity.getStaff().getId().companyCode())
				   .staffNo(entity.getStaff().getId().staffNo())
				   .staffName(entity.getStaff().getName().getName())
				   .seq(entity.getId().getSeq())
				   .licenseType(entity.getLicenseType())
				   .licenseNumber(entity.getLicenseNumber())
				   .dateOfAcquisition(entity.getDateOfAcquisition())
				   .certificationAuthority(entity.getCertificationAuthority())
				   .comment(entity.getComment())
				   .build();			
	}
}