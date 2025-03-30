package com.like.hrm.staff.domain.staff;

import java.time.LocalDate;

import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "HRMSTAFF")
@EntityListeners(AuditingEntityListener.class)
public class PartnerCompanyStaff extends AbstractStaff {

	@EmbeddedId
	StaffId id;
	
	@Embedded
	StaffName name;
				
	@Embedded
	ResidentRegistrationNumber residentRegistrationNumber;
	
	@Column(name="STAFF_YN")
	Boolean isStaff = false;
	
	@Comment("성별")
	@Column(name="GENDER")
	String gender;
				
	@Comment("생일")
	@Column(name="BIRTHDAY")
	LocalDate birthday;	
		
	@Comment("근무상태")
	@Column(name="WORK_STATE_CODE")
	String workStateCode;
		
	@Comment("이미지경로")
	@Column(name="IMG_PATH")
	String imagePath;
}
