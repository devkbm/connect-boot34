package com.like.hrm.staff.domain.family;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import org.hibernate.annotations.Comment;

import com.like.hrm.staff.domain.Staff;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@EqualsAndHashCode(of = {"companyCode","staffNo","seq"})
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Embeddable
public class StaffFamilyId implements Serializable {
	
	private static final long serialVersionUID = -8748836639137047169L;
	
	@Column(name="ORG_CD")
	String companyCode;
		
	@Column(name="STAFF_NO")
	String staffNo;
		
	@Comment("등록순번")
	@Column(name="SEQ")
	Long seq;		
	
	public StaffFamilyId(Staff staff, Long seq) {
		this.companyCode = staff.getId().companyCode();
		this.staffNo = staff.getId().staffNo();
		this.seq = seq;
	}	
	
}
