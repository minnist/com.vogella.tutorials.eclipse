package com.example.e4.rcp.todo.model;

import java.util.List;

public class Tag<T> {

	public static String LABEL_FIELD = "label";

	public static String TAGGEDELEMENTS_FIELD = "taggedElements";

	private String label;

	private List<T> taggedElements;

	public Tag(String label, List<T> taggedElements) {
		this.label = label;
		this.taggedElements = taggedElements;
	}
	
	public String getLabel() {
		return label;
	}

	public List<T> getTaggedElements() {
		return taggedElements;
	}

	public void addTaggedElement(T element) {
		taggedElements.add(element);
	}

	public void removeTaggedElement(T element) {
		taggedElements.remove(element);
	}
}
