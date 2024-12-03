package com.like.hrm.workchangeapp.port.in.app;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.workchangeapp.adapter.out.db.jpa.DutyApplicationRepository;
import com.like.hrm.workchangeapp.domain.WorkChangeApplication;
import com.like.hrm.workchangeapp.port.in.DutyApplicationDTO;
import com.like.system.holiday.domain.DateInfo;

@Service
@Transactional
public class DutyApplicationCommandService {

	private DutyApplicationRepository repository;	
	
	public DutyApplicationCommandService(DutyApplicationRepository repository) {
		this.repository = repository;		
	}
	
	public WorkChangeApplication getDutyApplication(Long dutyId) {
		return repository.findById(dutyId).orElse(null);
	}
	
	public void saveDutyApplication(DutyApplicationDTO.Form dto) {
		WorkChangeApplication entity = null;
		
		if (dto.dutyId() == null) {
			entity = dto.newEntity();
		} else {
			entity = this.getDutyApplication(dto.dutyId());
			dto.modifyEntity(entity);
		}
		
		repository.save(entity);
	}
	
	public void deleteDutyApplication(Long dutyId) {
		repository.deleteById(dutyId);		
	}
	
	public List<DateInfo> getDateList(LocalDate fromDate, LocalDate toDate) {
		return null; //this.holidayUtilService.getDateInfoList(fromDate, toDate).getDates();		
	}
	
}
