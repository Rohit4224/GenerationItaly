package dao;

import java.util.List;
import java.util.Map;

import entities.Entity;

public interface IDAO
{
	public boolean create(Entity e);
	public List<Entity> read();
	public Entity find (int id);
	public boolean update(Entity e);
	public boolean delete(int id);
	
}
