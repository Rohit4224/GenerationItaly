package dao;

import java.util.List;
import java.util.Map;

public interface IDAO
{
	public boolean update(String query);
	public List<Map<String,String>> read(String query);
}