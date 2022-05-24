package com.vacvn.model;

public abstract class AbstractModel<T> {
	private Long id;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
