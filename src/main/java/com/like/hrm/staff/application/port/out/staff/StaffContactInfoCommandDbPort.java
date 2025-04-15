package com.like.hrm.staff.application.port.out.staff;

import java.util.Optional;

import com.like.hrm.staff.domain.staff.contact.ContactInfo;
import com.like.hrm.staff.domain.staff.contact.ContactInfoId;

public interface StaffContactInfoCommandDbPort {

	Optional<ContactInfo> select(ContactInfoId id);	

	ContactInfo save(ContactInfo entity);
	
	void delete(ContactInfoId id);
}
