package com.like.hrm.staff.domain.staff.contact;

import org.hibernate.annotations.Comment;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = {"companyCode","staffNo","type"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class ContactInfoId {

	@Column(name="ORG_CD")
	String companyCode;
		
	@Column(name="STAFF_NO")
	String staffNo;
		
	@Comment("유형")
	@Column(name="CONTACT_TYPE")
	String type;	
}
