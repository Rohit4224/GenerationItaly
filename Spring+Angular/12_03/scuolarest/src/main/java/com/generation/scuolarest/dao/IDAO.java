package com.generation.scuolarest.dao;

import java.util.Map;

import com.generation.scuolarest.entities.Entity;

public interface IDAO {
    public void create(Entity e);

    public Map<Integer, Entity> read();

    public void update(Entity e);

    public void delete(int id);
}
