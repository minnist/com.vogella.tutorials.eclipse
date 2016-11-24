package com.vogella.ide.adapter;

public class Task {
	private String summary = "";
	private String description = "";

	public Task(String summary) {
		this.summary = summary;
	}

	public Task(String summary, String description) {
		this.summary = summary;
		this.description = description;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
