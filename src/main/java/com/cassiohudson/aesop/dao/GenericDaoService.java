package com.cassiohudson.aesop.dao;

public interface GenericDaoService {
	
	public static final String INSERT_START = "INSERT INTO `cassio_aesop`.`";
	public static final String INSERT_END = "` (`trait`, `type`) VALUES ";
	public static final String QUERY_START = "SELECT * FROM `";
	public static final String QUERY_END = "` WHERE ";
	
	public String getInsertPath();
	public String getQueryPath();

}
