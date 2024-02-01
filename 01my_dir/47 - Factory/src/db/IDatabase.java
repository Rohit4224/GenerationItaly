package db;

import java.sql.Connection;

public interface IDatabase
{
	public Connection getC();
	public void open();
	public void close();
}
