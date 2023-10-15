/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package latihan_percabangan_latcabang1.Model;

import java.util.Date;

/**
 *
 * @author mariq
 */
public class Lat_Cabang1_Denda {

    private Date Pinjam = new Date();
    private Date Kembali = new Date();
    private Double Total_Denda;

    public Date getPinjam() {
        return Pinjam;
    }

    public void setPinjam(Date Pinjam) {
        this.Pinjam = Pinjam;
    }

    public Date getKembali() {
        return Kembali;
    }

    public void setKembali(Date Kembali) {
        this.Kembali = Kembali;
    }

   

    public Double getTotal_Denda() {
        return Total_Denda;
    }

    public void setTotal_Denda(Double Total_Denda) {
        this.Total_Denda = Total_Denda;
    }

}
