package com.idasound.ju321.common.dto;

import java.util.List;


/**
 * 集合信息
 * @author 
 *
 */
public class ListModel<T> {
	private List<T> list;

	public List<T> getList() {
		return list;
	}

	public void setList(List<T> list) {
		this.list = list;
	}
}