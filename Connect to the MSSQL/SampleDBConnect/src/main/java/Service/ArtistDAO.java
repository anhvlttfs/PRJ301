package Service;

import Db.DbContext;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Artist;

public class ArtistDAO extends DbContext {
    
    // GET - SELECT
    public ArrayList<Artist> GetArtist() {
        ArrayList<Artist> artists = new ArrayList<>();
        String sqlCommand = "SELECT [ArtistId], [Name] FROM [Chinook].[dbo].[Artist]";
        
        try (Statement smt = super.getConnection().createStatement(); ResultSet rs = smt.executeQuery(sqlCommand)) {
            while (rs.next()) {
                int id = rs.getInt("ArtistId");
                String name = rs.getString("Name");
                artists.add(new Artist(id, name));
            }
        } catch (SQLException sqlEx) {
            Logger.getLogger(DbContext.class.getName()).log(Level.SEVERE, null, sqlEx);
        }
        
        return artists;
    }
    
    public int AddArtist(int id, String name) {
        int retType = -1;
        String sqlCommand = """
                            SET IDENTITY_INSERT Artist ON;
                            INSERT INTO [Chinook].[dbo].[Artist] ([ArtistId], [Name]) 
                                VALUES (%d, '%s'); 
                            SET IDENTITY_INSERT Artist OFF;
                            """.formatted(id, name);
        System.out.println(sqlCommand);
        
        try (Statement smt = super.getConnection().createStatement()) {
            retType = smt.executeUpdate(sqlCommand);
        } catch (SQLException sqlEx) {
            Logger.getLogger(DbContext.class.getName()).log(Level.SEVERE, null, sqlEx);
        }
        
        return retType;
    }
    
    public int RemoveArtist(int id, String name) {
        int retType = -1;
        String sqlCommand = """
                            SET IDENTITY_INSERT Artist ON;
                            DELETE FROM [Chinook].[dbo].[Artist] 
                                WHERE [ArtistId] = %d AND [Name] = '%s';
                            SET IDENTITY_INSERT Artist OFF;
                            """.formatted(id, name);
        System.out.println(sqlCommand);
        
        try (Statement smt = super.getConnection().createStatement()) {
            retType = smt.executeUpdate(sqlCommand);
        } catch (SQLException sqlEx) {
            Logger.getLogger(DbContext.class.getName()).log(Level.SEVERE, null, sqlEx);
        }
        
        return retType;
    }
    
    public int EditArtist(int id, String name) {
        int retType = -1;
        String sqlCommand = """
                            SET IDENTITY_INSERT Artist ON; 
                            UPDATE [Chinook].[dbo].[Artist] 
                                SET [Name] = '%s'
                                WHERE [ArtistId] = %d;
                            SET IDENTITY_INSERT Artist OFF;
                            """.formatted(name, id);
        System.out.println(sqlCommand);
        
        try (Statement smt = super.getConnection().createStatement()) {
            retType = smt.executeUpdate(sqlCommand);
        } catch (SQLException sqlEx) {
            Logger.getLogger(DbContext.class.getName()).log(Level.SEVERE, null, sqlEx);
        }

        return retType;
    }
}
