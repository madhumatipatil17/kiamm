package com.materialmanagement.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.materialmanagement.Model.OrderSequence;

@Repository
public interface OrderSequenceRepository extends JpaRepository<OrderSequence, Integer>{

	@Query("select o from OrderSequence o where o.sequenceType = ?1")
	OrderSequence findbySequenceType(String sequenceType);
	
	@Modifying
	@Query("update OrderSequence o set o.runningSequenceNo = ?1 where o.sequenceType = ?2")
	void updateRunningSequenceNo(int runningSequenceNo,String sequenceType);
		
}
