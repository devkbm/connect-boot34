package com.like.hrm.payitem.web;

import static com.like.core.web.util.ResponseEntityUtil.toList;
import static com.like.core.web.util.ResponseEntityUtil.toOne;

import java.util.List;
import java.util.stream.Collectors;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.like.hrm.payitem.boundary.PayTableDTO;
import com.like.hrm.payitem.domain.model.PayTable;
import com.like.hrm.payitem.domain.model.PayTableItem;
import com.like.hrm.payitem.service.PayTableService;

@RestController
public class PayTableController {

	private PayTableService payTableService;
	
	public PayTableController(PayTableService payTableService) {
		this.payTableService = payTableService;
	}
	
	@GetMapping("/api/hrm/paytable")
	public ResponseEntity<?> getPayTableList(PayTableDTO.SearchPayTable dto) {			
						
		List<PayTableDTO.SavePayTable> list = payTableService.getPayTableList(dto)
															 .stream()
															 .map(e -> PayTableDTO.SavePayTable.convert(e))
															 .collect(Collectors.toList());
				
		return toList(list, String.format("%d 건 조회되었습니다.", list.size()));
	}
	
	@GetMapping("/api/hrm/paytable/{id}")
	public ResponseEntity<?> getPayTable(@PathVariable(value="id") Long id) {
		
		PayTable entity = payTableService.getPayTable(id);
						
		PayTableDTO.SavePayTable dto = PayTableDTO.SavePayTable.convert(entity);			
				
		return toOne(dto, String.format("%d 건 조회되었습니다.", dto == null ? 0 : 1));
	}
		
	@PostMapping("/api/hrm/paytable")
	public ResponseEntity<?> savePayTable(@RequestBody @Valid PayTableDTO.SavePayTable dto) {							
							
		payTableService.save(dto);						
								 					
		return toList(null, String.format("%d 건 저장되었습니다.", 1));
	}
	
		
	@DeleteMapping("/api/hrm/paytable/{id}")
	public ResponseEntity<?> deletePayTable(@PathVariable Long id) {				
																		
		payTableService.delete(id);						
								 					
		return toList(null, String.format("%d 건 삭제되었습니다.", 1));
	}
	
	@GetMapping("/api/hrm/paytable/{payTableId}/item")
	public ResponseEntity<?> getPayTableItems(@PathVariable(value="payTableId") Long payTableId) {
		
		List<PayTableItem> entity = payTableService.getPayTableItem(payTableId);
						
		List<PayTableDTO.SavePayTableItem> dto = entity.stream()
													  .map(e -> PayTableDTO.SavePayTableItem.convert(e))
													  .collect(Collectors.toList());			
				
		return toList(dto, String.format("%d 건 조회되었습니다.", dto.size()));
	}
	
	@GetMapping("/api/hrm/paytable/{payTableId}/item/{id}")
	public ResponseEntity<?> getPayTableItem(@PathVariable Long payTableId
			                                ,@PathVariable Long id) {
		
		PayTableItem entity = payTableService.getPayTableItem(payTableId, id);
						
		PayTableDTO.SavePayTableItem dto = PayTableDTO.SavePayTableItem.convert(entity);			
				
		return toOne(dto, String.format("%d 건 조회되었습니다.", dto == null ? 0 : 1));
	}
	
	@PostMapping("/api/hrm/paytable/item")
	public ResponseEntity<?> savePayTableItem(@RequestBody @Valid PayTableDTO.SavePayTableItem dto) {						
							
		payTableService.save(dto);						
								 					
		return toList(null, String.format("%d 건 저장되었습니다.", 1));
	}
	
		
	@DeleteMapping("/api/hrm/paytable/{payTableId}/item/{id}")
	public ResponseEntity<?> deletePayTableItem(@PathVariable Long payTableId
            								   ,@PathVariable Long id) {				
																		
		payTableService.delete(payTableId, id);						
								 					
		return toList(null, String.format("%d 건 삭제되었습니다.", 1));
	}
}
