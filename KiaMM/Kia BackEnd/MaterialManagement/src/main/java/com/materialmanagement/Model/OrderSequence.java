package com.materialmanagement.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "order_sequence")
public class OrderSequence {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "sequence_id")
	private int sequenceId;
	
	@Column(name = "prefix")
	private String prefix;
	
	@Column(name = "running_sequence_no")
	private int runningSequenceNo;
	
	@Column(name = "sequence_type")
	private String sequenceType;

	public int getSequenceId() {
		return sequenceId;
	}

	public void setSequenceId(int sequenceId) {
		this.sequenceId = sequenceId;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public int getRunningSequenceNo() {
		return runningSequenceNo;
	}

	public void setRunningSequenceNo(int runningSequenceNo) {
		this.runningSequenceNo = runningSequenceNo;
	}

	public String getSequenceType() {
		return sequenceType;
	}

	public void setSequenceType(String sequenceType) {
		this.sequenceType = sequenceType;
	}

	public OrderSequence(int sequenceId, String prefix, int runningSequenceNo, String sequenceType) {
		super();
		this.sequenceId = sequenceId;
		this.prefix = prefix;
		this.runningSequenceNo = runningSequenceNo;
		this.sequenceType = sequenceType;
	}

	@Override
	public String toString() {
		return "OrderSequence [sequenceId=" + sequenceId + ", prefix=" + prefix + ", runningSequenceNo="
				+ runningSequenceNo + ", sequenceType=" + sequenceType + "]";
	}

	public OrderSequence() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
