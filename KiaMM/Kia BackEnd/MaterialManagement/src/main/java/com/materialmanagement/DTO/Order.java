package com.materialmanagement.DTO;

import java.util.ArrayList;

import com.materialmanagement.Model.MmProdReqDetailsEntity;
import com.materialmanagement.Model.MmProdReqHeaderEntity;


public class Order {

	private MmProdReqHeaderEntity mmProdReqHeaderEntity;

	private ArrayList<MmProdReqDetailsEntity> mmProdReqDetailsEntity;

	public MmProdReqHeaderEntity getMmProdReqHeaderEntity() {
		return mmProdReqHeaderEntity;
	}

	public void setMmProdReqHeaderEntity(MmProdReqHeaderEntity mmProdReqHeaderEntity) {
		this.mmProdReqHeaderEntity = mmProdReqHeaderEntity;
	}

	public ArrayList<MmProdReqDetailsEntity> getMmProdReqDetailsEntity() {
		return mmProdReqDetailsEntity;
	}

	public void setMmProdReqDetailsEntity(ArrayList<MmProdReqDetailsEntity> mmProdReqDetailsEntity) {
		this.mmProdReqDetailsEntity = mmProdReqDetailsEntity;
	}

}
