package com.like.system.dept.port.out;

import java.util.List;

import com.like.system.dept.domain.DeptHierarchy;

public interface DeptHierarchySelectDbPort {

	List<DeptHierarchy> getAllNodes(String companyCode);
}
