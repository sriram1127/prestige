package com.beans;

public class Nominee {

	private Integer id;

	private Long nominationId;

	private String nominationFirstName;

	private String nominationLastName;

	private String nominationUserId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Long getNominationId() {
		return nominationId;
	}

	public void setNominationId(Long nominationId) {
		this.nominationId = nominationId;
	}

	public String getNominationFirstName() {
		return nominationFirstName;
	}

	public void setNominationFirstName(String nominationFirstName) {
		this.nominationFirstName = nominationFirstName;
	}

	public String getNominationLastName() {
		return nominationLastName;
	}

	public void setNominationLastName(String nominationLastName) {
		this.nominationLastName = nominationLastName;
	}

	public String getNominationUserId() {
		return nominationUserId;
	}

	public void setNominationUserId(String nominationUserId) {
		this.nominationUserId = nominationUserId;
	}

}
