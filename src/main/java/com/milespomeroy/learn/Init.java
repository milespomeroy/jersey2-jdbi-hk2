package com.milespomeroy.learn;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;

import com.milespomeroy.learn.db.DatabaseUtil;

public class Init implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("Initializing database.");
		
		DBI dbi = DatabaseUtil.getDbi();
		
		try(Handle handle = dbi.open()) {
			handle.execute("CREATE TABLE IF NOT EXISTS learn (magic int)");
			handle.execute("DELETE FROM learn");
			handle.execute("INSERT INTO learn VALUES (35)");
		}
		
		System.out.println("Database initialized.");
	}

}
