package com.generation.bar.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.generation.bar.db.Database;
import com.generation.bar.entities.Bevanda;
import com.generation.bar.entities.Entity;
import com.generation.bar.entities.Snack;

public class BevandaDAO implements IDAO
{

    @Autowired
    private Database database;

    @Autowired
    private ApplicationContext context;

    @Override
    public void create(Entity e)
    {
        String query = "INSERT INTO Beverages(nome, prezzo) VALUES (?, ?)";
        PreparedStatement ps = null;
        try 
        {
            Bevanda s = (Bevanda)e;
            ps = database.getConnection().prepareStatement(query);
            ps.setString(1, s.getNome());
            ps.setDouble(2, s.getPrezzo());

            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println("Errore inserimento Beverages: " + ex.getMessage());
        }
        catch(ClassCastException ex)
        {
            System.out.println("Errore tipo dato errato in BevandaDAO");
        }
        finally
        {
            try
            {
                ps.close();
            } catch (Exception ex) {
                System.out.println("Errore chiusura PreparedStatement");
            }
        }
    }

    @Override
    public Map<Integer, Entity> read()
    {
        String query = "SELECT * from Beverages";

        PreparedStatement ps = null;
        ResultSet rs = null;

        Map<Integer, Entity> ris = new HashMap<>();

        try
        {
            ps = database.getConnection().prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next())
            {
                /* Entity e = new Bevanda(
                    rs.getInt(1),       // ID
                    rs.getString(2),   // nome
                    rs.getDouble(3)   // prezzo
                ); */

                Map<String, String> params = new HashMap<>();
                params.put("id", rs.getInt(1) + "");
                params.put("nome", rs.getString(2));
                params.put("prezzo", rs.getDouble(3) + "");

                Bevanda e = context.getBean(Bevanda.class, params);
                
                ris.put(e.getId(), e);
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Errore nella select in BevandaDAO");
            ex.printStackTrace();
        }
        finally
        {
            try {
                ps.close();
                rs.close();
            } catch (Exception ex) {
                System.out.println("Errore chiusura PreparedStatement");
            }
        }

        return ris;
    }

    @Override
    public void update(Entity e)
    {
        String query = "UPDATE Beverages SET nome = ?, prezzo = ? WHERE id = ?";
        PreparedStatement ps = null;
        try 
        {
            Bevanda s = (Bevanda)e;
            ps = database.getConnection().prepareStatement(query);
            ps.setString(1, s.getNome());
            ps.setDouble(2, s.getPrezzo());
            ps.setInt(3, s.getId());

            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println("Errore inserimento Beverages: " + ex.getMessage());
        }
        catch(ClassCastException ex)
        {
            System.out.println("Errore tipo dato errato in BevandaDAO");
        }
        finally
        {
            try {
                ps.close();
            } catch (Exception ex) {
                System.out.println("Errore chiusura PreparedStatement");
            }
        }    
    }

    @Override
    public void delete(int id)
    {
        String query = "DELETE from Beverages WHERE id = ?";

        PreparedStatement ps = null;
        try 
        {
            ps = database.getConnection().prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println("Errore inserimento Beverages: " + ex.getMessage());
        }
        catch(ClassCastException ex)
        {
            System.out.println("Errore tipo dato errato in BevandaDAO");
        }
        finally
        {
            try
            {
                ps.close();
            } catch (Exception ex) {
                System.out.println("Errore chiusura PreparedStatement");
            }
        }
    }

    public Map<Integer, Entity> read(String nome)
    {
        String query = "SELECT * from Beverages WHERE nome LIKE '%?%'";

        PreparedStatement ps = null;
        ResultSet rs = null;

        Map<Integer, Entity> ris = new HashMap<>();

        try
        {
            ps = database.getConnection().prepareStatement(query);
            ps.setString(1, nome);
            rs = ps.executeQuery();

            while (rs.next())
            {
                /* Entity e = new Bevanda(
                    rs.getInt(1),       // ID
                    rs.getString(2),   // nome
                    rs.getDouble(3)   // prezzo
                ); */

                Map<String, String> params = new HashMap<>();
                params.put("id", rs.getInt(1) + "");
                params.put("nome", rs.getString(2));
                params.put("prezzo", rs.getDouble(3) + "");

                Bevanda e = context.getBean(Bevanda.class, params);
                
                ris.put(e.getId(), e);
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Errore nella select in BevandaDAO");
            ex.printStackTrace();
        }
        finally
        {
            try {
                ps.close();
                rs.close();
            } catch (Exception ex) {
                System.out.println("Errore chiusura PreparedStatement");
            }
        }

        return ris;
    }
    
}
