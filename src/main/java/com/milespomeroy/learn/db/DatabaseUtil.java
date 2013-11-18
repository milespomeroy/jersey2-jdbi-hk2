package com.milespomeroy.learn.db;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.skife.jdbi.v2.DBI;

public class DatabaseUtil {
	private static DataSource dataSource;
	private static DBI dbi;

    static {
        try {
            dataSource = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/learndb");
        } catch (NamingException e) {
            throw new ExceptionInInitializerError(e);
        }
        
        dbi = new DBI(dataSource);
    }

    public static DataSource getDataSource() {  
        return dataSource;             
    }
    
    public static DBI getDbi() {
    	return dbi;
    }
}
