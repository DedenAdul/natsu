/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tugasmodul3_2;

/**
 *
 * @author MyBook Z Series
 */
public class Kota {
    private int id;
    private String nama;
    
    public Kota (int id, String nama){
        this.id = id;
        this.nama = nama;
    }
    
    public Kota ( String nama){
        this.nama = nama;
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;
    }
    
    public String getNama(){
        return nama;
    }
    
    public void setNama(String nama){
        this.nama = nama;
    }
    
    @Override
    public String toString() {
    return nama; // Agar yang tampil di ComboBox adalah nama kota
    } 
}

    
