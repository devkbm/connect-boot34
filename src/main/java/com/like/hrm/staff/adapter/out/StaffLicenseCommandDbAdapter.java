package com.like.hrm.staff.adapter.out;

import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.like.hrm.staff.application.port.out.StaffLicenseCommandDbPort;
import com.like.hrm.staff.domain.staff.license.StaffLicense;
import com.like.hrm.staff.domain.staff.license.StaffLicenseId;

@Repository
public class StaffLicenseCommandDbAdapter implements StaffLicenseCommandDbPort {

	@Override
	public Optional<StaffLicense> select(StaffLicenseId id) {
		// TODO Auto-generated method stub
		return Optional.empty();
	}

	@Override
	public void save(StaffLicense entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(StaffLicenseId id) {
		// TODO Auto-generated method stub
		
	}

}
