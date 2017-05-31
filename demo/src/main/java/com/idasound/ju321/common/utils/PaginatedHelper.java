package com.idasound.ju321.common.utils;

import java.io.Serializable;

/**
 * 分页参数读取辅助类
 * 
 */
public class PaginatedHelper implements Serializable {
	private static final long serialVersionUID = 1L;
	
	/**
	 * 如果没有分页信息，默认最多查10000笔数据
	 */
	public static final int PAGE_SIZE = 10000;
	/**
	 * 分页时当前的页数; easyUI的分页默认会传该参数
	 */
	private int page;
	/**
	 * 分页时每页的数据量; easyUI的分页默认会传该参数
	 */
	private int rows;
	/**
	 * SQL查询的起点
	 */
	private int startIndex;
	/**
	 * SQL查询的终点
	 */
	private int endIndex;
	
	/**
	 * SQL排序
	 */
	private String orderByClause;
	/**
	 * SQL distinct标记
	 */
	protected boolean distinct;
	
	//**************************************************************************
	/**
	 * 返回当前页数；如果小于1则返回1
	 * <pre>
	 * 编写者：chenjs002
	 * 创建时间：Mar 19, 2015 3:35:55 PM
	 * </pre>
	 */
	//**************************************************************************
	public int getPage() {
		if (page < 1)
			page = 1;
		return page;
	}
	
	public void setPage(int page) {
		this.page = page;
	}
	
	//**************************************************************************
	/**
	 * 返回当前每页的数据量；如果小于1则返回默认值10000
	 * <pre>
	 * 编写者：chenjs002
	 * 创建时间：Mar 19, 2015 3:35:55 PM
	 * </pre>
	 */
	//**************************************************************************
	public int getRows() {
		if (rows < 1)
			rows = PAGE_SIZE;
		return rows;
	}
	
	public void setRows(int rows) {
		this.rows = rows;
	}
	
	//**************************************************************************
	/**
	 * SQL查询的起点
	 * <pre>
	 * 编写者：chenjs002
	 * 创建时间：Mar 19, 2015 3:35:55 PM
	 * </pre>
	 */
	//**************************************************************************
	public int getStartIndex() {
		startIndex = (getPage()-1)*getRows();
		return startIndex;
	}
	
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	//**************************************************************************
	/**
	 * SQL查询的终点
	 * <pre>
	 * 编写者：chenjs002
	 * 创建时间：Mar 19, 2015 3:35:55 PM
	 * </pre>
	 */
	//**************************************************************************
	public int getEndIndex() {
		endIndex = getStartIndex() + getRows();
		return endIndex;
	}

	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}

	public String getOrderByClause() {
		return orderByClause;
	}

	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}

	public boolean isDistinct() {
		return distinct;
	}

	public void setDistinct(boolean distinct) {
		this.distinct = distinct;
	}

}
