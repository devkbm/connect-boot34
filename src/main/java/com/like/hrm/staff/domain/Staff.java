package com.like.hrm.staff.domain;

import java.io.Serializable;
import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Table;

import org.hibernate.annotations.Comment;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.like.core.jpa.domain.AbstractAuditEntity;
import com.like.hrm.staff.domain.appointment.AppointmentRecord;
import com.like.hrm.staff.domain.appointment.AppointmentRecordList;
import com.like.hrm.staff.domain.dutyresponsibility.StaffDutyList;
import com.like.hrm.staff.domain.family.StaffFamilyList;
import com.like.hrm.staff.domain.license.StaffLicenseList;
import com.like.hrm.staff.domain.schoolcareer.StaffSchoolCareerList;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Aggregate Root 
 * <p> 직원정보 </p>
 *  
 */
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "HRMSTAFF")
@EntityListeners(AuditingEntityListener.class)
public class Staff extends AbstractAuditEntity implements Serializable {

	private static final long serialVersionUID = -3164713918774455925L;
	
	@EmbeddedId
	StaffId id;
	
	/*
	@Id
	@Comment("직원ID")
	@Column(name="STAFF_ID")
	String id;
	
	@Column(name="ORG_CD")
	String companyCode;
	
	@Column(name="STAFF_NO")
	String staffNo;
	*/
		
	@Embedded
	StaffName name;
				
	@Embedded
	ResidentRegistrationNumber residentRegistrationNumber;
	
	@Embedded
	StaffContact contact;
	
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
		
	@Embedded
	CurrentAppointmentInformation currentAppointment = new CurrentAppointmentInformation();
		
	@Embedded
	AppointmentRecordList appointmentRecordList = new AppointmentRecordList();
		
	@Embedded
	StaffDutyList staffDutyResponsibilityList = new StaffDutyList();
	
	@Embedded
	StaffFamilyList familyList = new StaffFamilyList();
		
	@Embedded
	StaffSchoolCareerList schoolCareerList = new StaffSchoolCareerList();
	
	/**
	 * 자격면허 명단
	 */
	@Embedded
	StaffLicenseList licenseList;			
			
	public Staff(String companyCode, StaffNoCreateStrategy strategy, StaffName name, String residentRegistrationNumber) {
		this.id 						= new StaffId(companyCode, strategy.create());
		//this.id 						= companyCode + "_" + strategy.create();
		//this.companyCode 			= companyCode;
		//this.staffNo					= strategy.create();
		this.name 						= name; 
		this.residentRegistrationNumber = ResidentRegistrationNumber.of(residentRegistrationNumber);
		this.gender 					= this.residentRegistrationNumber.getGender();
		this.birthday 					= this.residentRegistrationNumber.getBirthDay();		
	}	
					
	public void modifyEntity(StaffName name
						    ,LocalDate birthday) {
		this.name 		= name;				
		this.birthday 	= birthday;
	}
					
	public void changeImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	public void changeContact(StaffContact contact) {
		this.contact = contact;
	}
	
	public void applyAppointmentRecord(AppointmentRecord record) {		
		if (this.currentAppointment == null) this.currentAppointment = new CurrentAppointmentInformation(record.getInfo()); 		
								
		LocalDate today = LocalDate.now();		
		if (today.isAfter(record.getAppointmentDate())) {		
			this.currentAppointment.apply(record.getInfo());
					
			record.complete();
		}
	}	
		
}
