package dao;

import java.util.List;

import entities.Entity;

interface IDAO 
{
	public List<Entity> read();
	public boolean delete(int id);
	public boolean update(Entity e);
	public boolean create(Entity e);
}
