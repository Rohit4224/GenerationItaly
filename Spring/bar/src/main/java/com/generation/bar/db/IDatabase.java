package com.generation.bar.db;

import java.sql.Connection;

public interface IDatabase
{
	public Connection getConnection();
	//public void open();
	public void closeConnection();
}
