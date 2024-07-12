package Controller;

import Dao.AbsensiDao;
import Dao.AbsensiDaoImpl;
import Model.Absensi;
import View.AbsensiView;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AbsensiController {
    AbsensiView view;
    AbsensiDao dao;
    Absensi model;

    public AbsensiController(AbsensiView view) {
        this.view = view;
        dao = new AbsensiDaoImpl();
    }
    
    public void clearForm() {
        view.getsJamMasuk().setValue("0");
        view.getsJamKeluar().setValue("0");
        view.getsMenitMasuk().setValue("0");
        view.getsMenitKeluar().setValue("0");
    }

    public void insert() {
        try {
            int jamMasuk = (int) view.getsJamMasuk().getValue();
            int menitMasuk = (int) view.getsMenitMasuk().getValue();
            int jamKeluar = (int) view.getsJamKeluar().getValue();
            int menitKeluar = (int) view.getsMenitKeluar().getValue();

            // Buat objek LocalTime untuk jam masuk dan jam keluar
            LocalTime timeMasuk = LocalTime.of(jamMasuk, menitMasuk);
            LocalTime timeKeluar = LocalTime.of(jamKeluar, menitKeluar);

            // Hitung durasi antara jam masuk dan jam keluar
            Duration durasi = Duration.between(timeMasuk, timeKeluar);

            // Konversi durasi menjadi string format HH:mm
            long durasiJam = durasi.toHours();
            long durasiMenit = durasi.toMinutes() % 60;
            String durasiStr = String.format("%02d:%02d", durasiJam, durasiMenit);
            LocalDate currentDate = LocalDate.now();

            // Membuat formatter untuk format "yyyt-MM-dd"
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");

            // Memformat tanggal saat ini sesuai dengan formatter
            String formattedDate = currentDate.format(formatter);
            
            model = new Absensi();
            String nama = (String) view.getCbNama().getSelectedItem(); // Ambil nilai terpilih dari ComboBox
            model.setNama(nama); 
            model.setJamMasuk(timeMasuk.toString());
            model.setJamKeluar(timeKeluar.toString());
            model.setTanggal(formattedDate);
            model.setDurasi(durasiStr);
            dao.insert(model);
            JOptionPane.showMessageDialog(view, "Entry data ok");
        } catch (Exception ex) {
            Logger.getLogger(PegawaiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void viewTable(){   
        try {
            DefaultTableModel tabelmodel = (DefaultTableModel)
            view.getTblAbsensi().getModel();
            tabelmodel.setRowCount(0);
            List<Absensi> list = dao.getAllAbsensi();
            for (Absensi absensi : list){
                Object[] data = {
                    absensi.getTanggal(),
                    absensi.getNama(),
                    absensi.getJamMasuk(),
                    absensi.getJamKeluar(),
                    absensi.getDurasi(),
                };
                tabelmodel.addRow(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(PegawaiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    
    public void listNama() {
        try {
            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel<>();
            List<Absensi> list = dao.getAllNama();
            for (Absensi absensi : list) {
                comboBoxModel.addElement(absensi.getNama());
            }
            view.getCbNama().setModel(comboBoxModel);
        } catch (Exception ex) {
            Logger.getLogger(AbsensiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
