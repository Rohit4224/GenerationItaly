package com.springbasics.scuola.database;

import java.util.Map;

import com.springbasics.scuola.entities.Entity;

public interface IDAO {
    public boolean create(Entity e);
	
	public Map<Integer, Entity> read();
	
	public boolean update(Entity e);
	
	public boolean delete(int id);
}
