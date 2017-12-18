package com.beans;

public class RecognitionProcess {

	private Integer id;

	private RecognitionType recognitionType;

	private Process process;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public RecognitionType getRecognitionType() {
		return recognitionType;
	}

	public void setRecognitionType(RecognitionType recognitionType) {
		this.recognitionType = recognitionType;
	}

	public Process getProcess() {
		return process;
	}

	public void setProcess(Process process) {
		this.process = process;
	}

}
