package db;

import java.sql.Connection;

public interface IDatabase
{
	Connection getC();
	void apriConnessione();
	void chiudiConnessione();
}
