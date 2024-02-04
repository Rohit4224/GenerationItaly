package dao;

import java.util.List;

import entities.Entity;

public interface IDAOTabelle
{
	public boolean delete(int id);
	public boolean update(Entity e);
	public boolean insert(Entity e);
	public List<Entity> list();
	public Entity find(int id);
}
