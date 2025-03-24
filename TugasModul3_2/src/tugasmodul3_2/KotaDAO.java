/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasmodul3_2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


/**
 *
 * @author MyBook Z Series
 */
public class KotaDAO {
    public static ObservableList<Kota> getKota() {
        ObservableList<Kota> kotaList = FXCollections.observableArrayList();
        String query = "SELECT * FROM kota";
        
        try (
            Connection koneksi = DBConnection.getConnection();
            Statement stmt = koneksi.createStatement();
            ResultSet rs = stmt.executeQuery(query)) {
        while (rs.next()) {
            int id = rs.getInt("id");
            String nama = rs.getString("nama");

            
            kotaList.add(new Kota(
                id,
                nama
                ));
            }
            rs.close();
            stmt.close();
            koneksi.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return kotaList;
    }
    
    public static void addKota(Kota kota) {
    // SQL query tanpa menyertakan id karena sudah AUTO_INCREMENT
    String query = "INSERT INTO kota (nama) VALUES (?)";
    
    try (
        Connection koneksi = DBConnection.getConnection();
        PreparedStatement smt = koneksi.prepareStatement(query)) {
        
        // Menyertakan hanya nama kota
        smt.setString(1, kota.getNama());
        
        smt.executeUpdate();
        
        // Tidak perlu menutup koneksi dan statement secara manual jika menggunakan try-with-resources
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    
    public static void updateKota(Kota kota) {
        String query = "UPDATE kota SET nama = ? WHERE id = ?";
        
        try (
            Connection koneksi = DBConnection.getConnection();
            PreparedStatement smt = koneksi.prepareStatement(query)) {
            
            smt.setString(1, kota.getNama());
            smt.setInt(2, kota.getId());

            
            smt.executeUpdate();
            
            smt.close();
            koneksi.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public static void deleteKota(String nama) {
        String query = "DELETE FROM kota Where nama = ?";
        
        try (
            Connection koneksi = DBConnection.getConnection();
            PreparedStatement smt = koneksi.prepareStatement(query)) {
            
            smt.setString(1, nama);
            
            smt.executeUpdate();
            
            smt.close();
            koneksi.close();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

    
    