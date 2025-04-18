package com.like.hrm.payitem.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.hrm.payitem.application.dto.PayItemDTO;
import com.like.hrm.payitem.application.port.out.PayItemCommandDbPort;
import com.like.hrm.payitem.domain.model.PayItem;

@Transactional
@Service
public class PayItemService {

	private PayItemCommandDbPort payItemRepository;
	
	public PayItemService(PayItemCommandDbPort payItemRepository) {
		this.payItemRepository = payItemRepository;
	}
	
	public List<PayItem> getPayItem(PayItemDTO.SearchPayItem dto) {
		return payItemRepository.getPayItemList(dto);
	}
	
	public PayItem getPayItem(String code) {
		return payItemRepository.getPayItem(code);
	}
	
	public void save(PayItemDTO.SavePayItem dto) {
		PayItem entity = payItemRepository.getPayItem(dto.getCode());
		
		if (entity == null) {
			entity = dto.newEntity();
		} else {
			dto.modifyEntity(entity);
		}
		
		payItemRepository.save(entity);
	}

	public void delete(String code) {
		PayItem entity = payItemRepository.getPayItem(code);
		payItemRepository.delete(entity);
	}
}
