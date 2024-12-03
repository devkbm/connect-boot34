package com.like.system.term.port.in.domain.app;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.like.system.term.port.in.domain.DataDomainDeleteUseCase;
import com.like.system.term.port.out.DataDomainCommandDbPort;

@Transactional
@Service
public class DataDomainDeleteService implements DataDomainDeleteUseCase {

	DataDomainCommandDbPort dbPort;
	
	DataDomainDeleteService(DataDomainCommandDbPort dbPort) {
		this.dbPort = dbPort;
	}
	@Override
	public void delete(String id) {
		this.dbPort.delete(id);
	}

}
