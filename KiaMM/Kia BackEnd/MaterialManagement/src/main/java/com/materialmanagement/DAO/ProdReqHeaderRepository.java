package com.materialmanagement.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.materialmanagement.DTO.Myorders;
import com.materialmanagement.Model.MmProdReqHeaderEntity;

@Repository
public interface ProdReqHeaderRepository extends JpaRepository<MmProdReqHeaderEntity, Integer> {
	
	@Query(value = "select mmphd.reqNbr as reqnbr,uae.userName as username,bbdept.name as reqdept,bbsect.name as reqsect,mmphd.orderType as ordertype,mmphd.reqDate as issuedate,ede.name as status from MmProdReqHeaderEntity mmphd,BuBusinessUnitEntity bbsect,BuBusinessUnitEntity bbdept,UserAccountEntity  uae,EntityData ede where mmphd.requestedBy=uae.id and mmphd.reqDept=bbdept.id and mmphd.reqSection=bbsect.id and mmphd.statusId=ede.entityDataId and ede.code in ('Pending') order by mmphd.reqDate desc")
	public List<Myorders> findallPendingorders();

	@Query(value = "select mmphd.reqNbr as reqnbr,uae.userName as username,bbdept.name as reqdept,bbsect.name as reqsect,mmphd.orderType as ordertype,mmphd.reqDate as issuedate,ede.name as status from MmProdReqHeaderEntity mmphd,BuBusinessUnitEntity bbsect,BuBusinessUnitEntity bbdept,UserAccountEntity uae,EntityData ede where mmphd.requestedBy=uae.id and mmphd.reqDept=bbdept.id and mmphd.reqSection=bbsect.id and mmphd.statusId=ede.entityDataId and ede.code in('Rejected') order by mmphd.reqDate desc")
	public List<Myorders> findallRejectedorders();

	@Query(value = "select mmphd.reqNbr as reqnbr,uae.userName as username,bbdept.name as reqdept,bbsect.name as reqsect,mmphd.orderType as ordertype,mmphd.reqDate as issuedate,ede.name as status from MmProdReqHeaderEntity mmphd,BuBusinessUnitEntity bbsect,BuBusinessUnitEntity bbdept,UserAccountEntity  uae,EntityData ede where mmphd.requestedBy=uae.id and mmphd.reqDept=bbdept.id and mmphd.reqSection=bbsect.id and mmphd.statusId=ede.entityDataId and ede.code in('Delivered') order by mmphd.reqDate desc")
	public List<Myorders> findallRecivedorders();
}
