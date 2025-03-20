package com.like.hrm.staff.domain.staff.appointment;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import org.hibernate.annotations.Comment;

import com.like.hrm.staff.domain.staff.Staff;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = {"companyCode","staffNo","seq"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class AppointmentRecordId implements Serializable {
	
	private static final long serialVersionUID = -9052607243196727987L;

	@Column(name="ORG_CD")
	String companyCode;
		
	@Column(name="STAFF_NO")
	String staffNo;
	
	@Comment("등록순번")
	@Column(name="SEQ")
	Long seq;
	
	public AppointmentRecordId(Staff staff, Long seq) {
		this.companyCode = staff.getId().companyCode();
		this.staffNo = staff.getId().staffNo();
		this.seq = seq;
	}
	
	public AppointmentRecordId(String companyCode, String staffNo, Long seq) {
		this.companyCode = companyCode;
		this.staffNo = staffNo;
		this.seq = seq;
	}
}
