/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasmodul3_2;

import java.sql.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author MyBook Z Series
 */
public class AnggotaDAO {
  
     public static ObservableList<Anggota> getAnggota() {
        ObservableList<Anggota> anggotaList = FXCollections.observableArrayList();
        String query = "SELECT anggota.*, kota.nama AS nama_kota, organisasi.nama AS nama_organisasi " +
                   "FROM anggota " +
                   "INNER JOIN kota ON anggota.id_kota = kota.id " +
                   "INNER JOIN organisasi ON anggota.id_organisasi = organisasi.id";

        try (Connection koneksi = DBConnection.getConnection();
             Statement stmt = koneksi.createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nama = rs.getString("nama");
                String jenis = rs.getString("jenis");
                String alamat = rs.getString("alamat");
                String telepon = rs.getString("telepon");
                String tanggalDaftar = rs.getString("tanggal_daftar");
                String jenisKelamin = rs.getString("jenis_Kelamin");
                int idKota = rs.getInt("id_kota");
                String email = rs.getString("email");
                int idOrganisasi = rs.getInt("id_organisasi");
                String nama_Organisasi = rs.getString("nama_Organisasi");

                anggotaList.add(new Anggota(id, nama, jenis, alamat, telepon, tanggalDaftar, jenisKelamin, idKota, email, idOrganisasi, nama_Organisasi));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return anggotaList;
    }

    public static void addAnggota(Anggota anggota) {
        String query = "INSERT INTO anggota (nama, jenis, alamat, telepon, tanggal_daftar, jenis_Kelamin, id_kota, email, id_organisasi) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";


        try (Connection koneksi = DBConnection.getConnection();
             PreparedStatement smt = koneksi.prepareStatement(query)) {

            smt.setString(1, anggota.getNama());
            smt.setString(2, anggota.getJenis());
            smt.setString(3, anggota.getAlamat());
            smt.setString(4, anggota.gettelepon());
            smt.setString(5, anggota.gettanggalDaftar());
            smt.setString(6, anggota.getJenisKelamin());
            smt.setInt(7, anggota.getidKota());
            smt.setString(8, anggota.getemail());
            smt.setInt(9, anggota.getIdOrganisasi());

            smt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void updateAnggota(Anggota anggota) {
        String query = "UPDATE anggota SET nama = ?, jenis = ?, alamat = ?, telepon = ?, tanggal_daftar = ?, jenis_Kelamin = ?, id_kota = ?, email = ?, id_organisasi = ? WHERE id = ?";

        try (Connection koneksi = DBConnection.getConnection();
             PreparedStatement smt = koneksi.prepareStatement(query)) {

            smt.setString(1, anggota.getNama());
            smt.setString(2, anggota.getJenis());
            smt.setString(3, anggota.getAlamat());
            smt.setString(4, anggota.gettelepon());
            smt.setString(5, anggota.gettanggalDaftar());
            smt.setString(6, anggota.getJenisKelamin());
            smt.setInt(7, anggota.getidKota());
            smt.setString(8, anggota.getemail());
            smt.setInt(9, anggota.getIdOrganisasi());
            smt.setInt(10, anggota.getId());

            smt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void deleteAnggota(int id) {
        String query = "DELETE FROM anggota WHERE id = ?";

        try (Connection koneksi = DBConnection.getConnection();
             PreparedStatement smt = koneksi.prepareStatement(query)) {

            smt.setInt(1, id);
            smt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}