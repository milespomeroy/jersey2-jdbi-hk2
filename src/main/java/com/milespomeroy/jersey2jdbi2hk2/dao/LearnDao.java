package com.milespomeroy.jersey2jdbi2hk2.dao;

import org.skife.jdbi.v2.sqlobject.SqlQuery;

public interface LearnDao {

	@SqlQuery("SELECT magic FROM learn")
	public int getMagicNumber();
	
	public void close();
}
