package com.generation.bar.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import com.generation.bar.db.Database;
import com.generation.bar.entities.Entity;
import com.generation.bar.entities.Snack;

@Component
public class SnackDAO implements IDAO
{

    @Autowired
    private Database database;

    @Autowired
    private ApplicationContext context;

    @Override
    public void create(Entity e)
    {
        String query = "INSERT INTO Snacks(nome, prezzo, quantita, salato) VALUES (?, ?, ?, ?)";
        PreparedStatement ps = null;
        try 
        {
            Snack s = (Snack)e;
            ps = database.getConnection().prepareStatement(query);
            ps.setString(1, s.getNome());
            ps.setDouble(2, s.getPrezzo());
            ps.setInt(3, s.getQuantita());
            ps.setBoolean(4, s.isSalato());

            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println("Errore inserimento Snack: " + ex.getMessage());
        }
        catch(ClassCastException ex)
        {
            System.out.println("Errore tipo dato errato in SnackDAO");
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
        String query = "SELECT * from Snacks";

        PreparedStatement ps = null;
        ResultSet rs = null;

        Map<Integer, Entity> ris = new HashMap<>();

        try
        {
            ps = database.getConnection().prepareStatement(query);
            rs = ps.executeQuery();

            while (rs.next())
            {
               /*  Entity e = new Snack(
                    rs.getInt(1),       // ID
                    rs.getString(2),   // nome
                    rs.getDouble(3),   // prezzo
                    rs.getInt(4),      // quantita
                    rs.getBoolean(5)   // salato
                ); */
                Map<String, String> params = new HashMap<>();
                params.put("id", rs.getInt(1) + "");
                params.put("nome", rs.getString(2));
                params.put("prezzo", rs.getDouble(3) + "");
                params.put("quantita", rs.getInt(4) + "");
                params.put("salato", rs.getBoolean(5) + "");

                Snack e = context.getBean(Snack.class, params);

                
                ris.put(e.getId(), e);
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Errore nella select in SnackDAO");
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
        String query = "UPDATE Snacks SET nome = ?, prezzo = ?, quantita = ?, salato = ? WHERE id = ?";
        PreparedStatement ps = null;
        try 
        {
            Snack s = (Snack)e;
            ps = database.getConnection().prepareStatement(query);
            ps.setString(1, s.getNome());
            ps.setDouble(2, s.getPrezzo());
            ps.setInt(3, s.getQuantita());
            ps.setBoolean(4, s.isSalato());
            ps.setInt(5, s.getId());

            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println("Errore inserimento Snack: " + ex.getMessage());
        }
        catch(ClassCastException ex)
        {
            System.out.println("Errore tipo dato errato in SnackDAO");
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
        String query = "DELETE from Snacks WHERE id = ?";

        PreparedStatement ps = null;
        try 
        {
            ps = database.getConnection().prepareStatement(query);
            ps.setInt(1, id);

            ps.executeUpdate();
        }
        catch (SQLException ex)
        {
            System.out.println("Errore inserimento Snack: " + ex.getMessage());
        }
        catch(ClassCastException ex)
        {
            System.out.println("Errore tipo dato errato in SnackDAO");
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
        String query = "SELECT * from Snacks WHERE nome LIKE '%?%'";

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
               /*  Entity e = new Snack(
                    rs.getInt(1),       // ID
                    rs.getString(2),   // nome
                    rs.getDouble(3),   // prezzo
                    rs.getInt(4),      // quantita
                    rs.getBoolean(5)   // salato
                ); */
                Map<String, String> params = new HashMap<>();
                params.put("id", rs.getInt(1) + "");
                params.put("nome", rs.getString(2));
                params.put("prezzo", rs.getDouble(3) + "");
                params.put("quantita", rs.getInt(4) + "");
                params.put("salato", rs.getBoolean(5) + "");

                Snack e = context.getBean(Snack.class, params);

                
                ris.put(e.getId(), e);
            }
        }
        catch(SQLException ex)
        {
            System.out.println("Errore nella select in SnackDAO");
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
