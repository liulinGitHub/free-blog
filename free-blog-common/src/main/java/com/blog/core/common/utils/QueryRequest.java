package com.blog.core.common.utils;

import com.google.common.base.MoreObjects;

import java.io.Serializable;

/**
 * @CalssNmae: QueryRequest
 * @description:
 * @author: 950103
 * @create: 2019-04-27 13:43
 */
public class QueryRequest implements Serializable {

	private static final long serialVersionUID = -4869594085374385813L;

	private int size;
	private int current;

	/**
	 * 排序列的名字
	 */
	private String sortField;

	/**
	 * 排序方向(ASC/DESC)
	 * 默认是ASC
	 */
	private String sortType = "ASC";

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getCurrent() {
		return current;
	}

	@Override
	public String toString() {
		return MoreObjects.toStringHelper(this)
				.add("size", size)
				.add("current", current)
				.toString();
	}

	public void setCurrent(int current) {
		this.current = current;
	}

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

}
