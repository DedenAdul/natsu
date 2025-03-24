/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasmodul3_2;

/**
 *
 * @author MyBook Z Series
 */
public class Anggota {
    private int id;
    private String nama;
    private String jenis;
    private String alamat;
    private String telepon;
    private String tanggalDaftar;
    private String jenisKelamin;
    private int idKota;
    private String email;
    private int idOrganisasi;
    private String namaOrganisasi;

    public Anggota(int id,String nama, String jenis, String alamat, String telepon, String tanggalDaftar,String jenisKelamin, int idKota, String email, int idOrganisasi, String namaOrganisasi) {
        this.id = id;
        this.nama = nama;
        this.jenis = jenis;
        this.alamat = alamat;
        this.telepon = telepon;
        this.tanggalDaftar = tanggalDaftar;
        this.jenisKelamin = jenisKelamin;
        this.idKota = idKota;
        this.email = email;
        this.idOrganisasi = idOrganisasi;
        this.namaOrganisasi = namaOrganisasi;
        
    }
    
    public Anggota(String nama, String jenis, String alamat, String telepon, String tanggalDaftar,String jenisKelamin, int idKota, String email, int idOrganisasi, String namaOrganisasi) {
        this.nama = nama;
        this.jenis = jenis;
        this.alamat = alamat;
        this.telepon = telepon;
        this.tanggalDaftar = tanggalDaftar;
        this.jenisKelamin = jenisKelamin;
        this.idKota = idKota;
        this.email = email;
        this.idOrganisasi = idOrganisasi;
        this.namaOrganisasi = namaOrganisasi;
        
    }
    public int getId(){
        return id;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    public String getJenis(){
        return jenis;
    }
    public void setjenis(String jenis){
        this.jenis = jenis;
    }
    
    public String getAlamat(){
        return alamat;
    }
    public void setalamat(String alamat){
        this.alamat = alamat;
    }
    public String gettelepon(){
        return telepon;
    }
    public void settelepon(String telepon){
        this.telepon = telepon;
    }
    public String gettanggalDaftar(){
        return tanggalDaftar;
    }
    public void settanggalDaftar(String tanggalDaftar){
        this.tanggalDaftar = tanggalDaftar;
    }
    public String getJenisKelamin(){
        return jenisKelamin;
    }
    public void setjenisKelamin(String jenisKelamin){
        this.jenisKelamin = jenisKelamin;
    }
    public int getidKota(){
        return idKota;
    }
    public void setidKota(int idKota){
        this.idKota = idKota;
    }
    public String getemail(){
        return email;
    }
    public void setemail(String email){
        this.email = email;
    }

    public String getNamaOrganisasi() {
        return namaOrganisasi;
    }

    public void setNamaOrganisasi(String namaOrganisasi) {
        this.namaOrganisasi = namaOrganisasi;
    }
    public int getIdOrganisasi(){
        return idOrganisasi;
    }
    public void setidOrganisasi(int idOrganisasi){
        this.idOrganisasi = idOrganisasi;
    }

}