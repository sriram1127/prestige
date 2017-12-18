package com.beans;

import java.sql.Timestamp;
import java.util.List;

public class Nomination {

	private Integer id;

	private String title;

	private Integer recognitionId;

	private String nominatorFirstName;

	private String nominatorLastname;

	private String nominatorUserId;

	private List<Nominee> nominees;

	private Integer recognitionAreaId;

	private String description;

	private Integer status;

	private Timestamp createdAt;

	private Timestamp updatedAt;

	private Timestamp deletedAt;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getRecognitionId() {
		return recognitionId;
	}

	public void setRecognitionId(Integer recognitionId) {
		this.recognitionId = recognitionId;
	}

	public String getNominatorFirstName() {
		return nominatorFirstName;
	}

	public void setNominatorFirstName(String nominatorFirstName) {
		this.nominatorFirstName = nominatorFirstName;
	}

	public String getNominatorLastname() {
		return nominatorLastname;
	}

	public void setNominatorLastname(String nominatorLastname) {
		this.nominatorLastname = nominatorLastname;
	}

	public String getNominatorUserId() {
		return nominatorUserId;
	}

	public void setNominatorUserId(String nominatorUserId) {
		this.nominatorUserId = nominatorUserId;
	}

	public List<Nominee> getNominees() {
		return nominees;
	}

	public void setNominees(List<Nominee> nominees) {
		this.nominees = nominees;
	}

	public Integer getRecognitionAreaId() {
		return recognitionAreaId;
	}

	public void setRecognitionAreaId(Integer recognitionAreaId) {
		this.recognitionAreaId = recognitionAreaId;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Timestamp getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Timestamp createdAt) {
		this.createdAt = createdAt;
	}

	public Timestamp getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Timestamp updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Timestamp getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Timestamp deletedAt) {
		this.deletedAt = deletedAt;
	}

}
