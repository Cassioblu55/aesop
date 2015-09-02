package com.cassiohudson.aesop.dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cassiohudson.aesop.generator.Aesop;
import com.cassiohudson.aesop.utils.ConnectionUtils;

public class GenericDAO {
	
	public GenericDAO(String dataTable){
		this.dataTable= dataTable;
	}
	
	private String dataTable;
	
	public String getDataTable() {
		return dataTable;
	}

	public void setDataTable(String dataTable) {
		this.dataTable = dataTable;
	}
	
	public String getEqualsString(String s, String s2){
		return isq(s).concat("=").concat(isqAlt(s2));
	}
		
//	INSERT INTO `cassio_aesop`.`villain_trait` (`type`, `kind`, `description`) VALUES ('test', 'test', 'test'), ('test2', 'test2', 'test2');
	
	public String createInsertFromHashList(List<HashMap<String, String>> hashList){
		String sql = this.getInsertStart();
		String columns = "(".concat(this.getColumnsFromHash(hashList.get(0))).concat(")");
		List<String> listOfValues = new ArrayList<String>();
		for(HashMap<String, String> row : hashList){
			List<String> valuesList = new ArrayList<String>();
			for(String key : row.keySet()){
				valuesList.add(row.get(key));
			}
			String value = "(".concat(getValuesFromList(valuesList)).concat(")");
			listOfValues.add(value);
		}
		return sql.concat(columns).concat(" VALUES ").concat(getCSVFromList(listOfValues)).concat(";");
	}
	
	public String getColumnsFromHash(HashMap<String,String> hash){
		String keys = "";
		for(String key : hash.keySet()){
			keys = keys.concat(isq(key)).concat(",");
		}
		return keys.substring(0, keys.length()-1);
	}
	
	public String getValuesFromList(List<String> list){
		String values= "";
		for(String s : list){
			values = values.concat(isqAlt(s)).concat(",");
		}
		return values.substring(0, values.length()-1);
	}
	
	public String getCSVFromList(List<String> list){
		String values= "";
		for(String s : list){
			values = values.concat(s).concat(",");
		}
		return values.substring(0, values.length()-1);
	}
	
	
	public String getInsertStart(){
		return "INSERT INTO ".concat(isq(Aesop.DATABASE)).concat(".").concat(isq(dataTable)).concat(" ");
	}
	
	//Will create a sql insert statement given a hashmap <String, String> with db column being the key, 
	// as well as the database table
	public String createInsertStatement(HashMap<String, String> hash){
		
		String sql = "INSERT INTO ".concat(isq(Aesop.DATABASE)).concat(".").concat(isq(dataTable));
		String column = " (";
		String value = ") VALUES (";
		for(String c : hash.keySet()){
			column = column.concat(isq(c));
			value = value.concat(isq(hash.get(c)));
		}
		
		return sql.concat(column).concat(value).concat(");");
	}

	protected static String isq(String s){ //InerstSingleQutoes
		return "`".concat(s).concat("`");
	}
	
	protected static String isqAlt(String s){ //InerstSingleQutoes
		return "'".concat(s).concat("'");
	}
	
	//Return sql statement that returns query of single column
	public String getQuery(String column,String value) {
		String sql = "SELECT * FROM ".concat(isq(this.dataTable)).concat(" WHERE ");
		return sql.concat(isq(column)).concat(" LIKE ").concat(isqAlt(value));
	}
	
	public String getAllQuery(){
		return "SELECT * FROM ".concat(isq(dataTable));
	}
	
	public ResultSet getAllFromTable(){
		return ConnectionUtils.getResults(this.getAllQuery());
	}
	
	//Return single random value from column
	public String getRandomFromColumn(String column, String value){
		
		String random = " ORDER BY RAND() LIMIT 1";
		
		return this.getQuery(column, value).concat(random);
	}
	
	
	
	
}
