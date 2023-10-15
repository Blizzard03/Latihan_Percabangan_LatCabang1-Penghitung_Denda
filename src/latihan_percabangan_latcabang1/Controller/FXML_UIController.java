/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXML2.java to edit this template
 */
package latihan_percabangan_latcabang1.Controller;

import java.net.URL;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import latihan_percabangan_latcabang1.Model.Lat_Cabang1_Denda;

/**
 *
 * @author mariq
 */
public class FXML_UIController implements Initializable {

    //Models
    Lat_Cabang1_Denda md = new Lat_Cabang1_Denda();

    //Curency Formatter
    Locale Indonesia = new Locale("in", "ID");
    NumberFormat formater = NumberFormat.getCurrencyInstance(Indonesia);

    @FXML
    private DatePicker Pinjam_date;
    @FXML
    private DatePicker kembali_date;
    @FXML
    private TextField Tothari_txt;

    @FXML
    private TextField Total_denda;
    @FXML
    private TextField denda_txt;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }

    @FXML
    private void Hitung_Button_click(ActionEvent event) {
        SimpleDateFormat tgl = new SimpleDateFormat("dd-MM-yyyy");
        try {
            md.setPinjam(tgl.parse(Pinjam_date.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            ));
            md.setKembali(tgl.parse(kembali_date.getValue().format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))
            ));
        } catch (ParseException e) {
            e.printStackTrace();

        }
        long stgl = Math.round(1.0 * (md.getKembali().getTime()
                - md.getPinjam().getTime()) / (1000 * 60 * 60 * 24));

        Tothari_txt.setText(String.valueOf(stgl));
        double hari = Double.parseDouble(Tothari_txt.getText());

        if (hari > 3) {
            denda_txt.setText(formater.format(3000));
            md.setTotal_Denda(3000 * hari);
            Total_denda.setText(formater.format(md.getTotal_Denda()));
        } else {
            denda_txt.setText(formater.format(0));
            Total_denda.setText(formater.format(0));
        }
    }

    @FXML
    private void Hapus_button_click(ActionEvent event) {
        Pinjam_date.getEditor().clear();
        kembali_date.getEditor().clear();
        Tothari_txt.setText("");
        denda_txt.setText(formater.format(0));
        Total_denda.setText(formater.format(0));

    }

    @FXML
    private void Keluar_Button_Click(ActionEvent event) {
        System.exit(0);
    }

}
