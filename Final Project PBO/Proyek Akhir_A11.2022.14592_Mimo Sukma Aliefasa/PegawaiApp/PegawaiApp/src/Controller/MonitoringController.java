package Controller;

import Dao.MonitoringDao;
import Dao.MonitoringDaoImpl;
import Model.Monitoring;
import View.MonitoringView;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.logging.Level;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MonitoringController {
    MonitoringView view;
    MonitoringDao dao;
    Monitoring model;

    public MonitoringController(MonitoringView view) {
        this.view = view;
        dao = new MonitoringDaoImpl();
    }
    

    public void insert() {
        try {
            LocalDate currentDate = LocalDate.now();
            // Membuat formatter untuk format "yyyt-MM-dd"
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("uuuu-MM-dd");
            // Memformat tanggal saat ini sesuai dengan formatter
            String formattedDate = currentDate.format(formatter);
            
            model = new Monitoring();
            String nama = (String) view.getCbNama().getSelectedItem();
            String alasan = (String) view.getCbAlasan().getSelectedItem();// Ambil nilai terpilih dari ComboBox
            model.setNama(nama);
            model.setAlasan(alasan);
            model.setTanggal(formattedDate);
            dao.insert(model);
            JOptionPane.showMessageDialog(view, "Entry data ok");
        } catch (Exception ex) {
            Logger.getLogger(PegawaiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void listNama() {
        try {
            DefaultComboBoxModel comboBoxModel = new DefaultComboBoxModel<>();
            List<Monitoring> list = dao.getAllNama();
            for (Monitoring absensi : list) {
                comboBoxModel.addElement(absensi.getNama());
            }
            view.getCbNama().setModel(comboBoxModel);
        } catch (Exception ex) {
            Logger.getLogger(MonitoringController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void listAbsensi() {
        try {
            DefaultComboBoxModel<String> comboBoxModel = new DefaultComboBoxModel<>(); // Tipe data disesuaikan dengan tipe data yang ingin Anda masukkan ke ComboBox

            // Contoh data nama yang akan dimasukkan ke dalam ComboBox
            List<String> list = new ArrayList<>();
            list.add("Izin");
            list.add("Cuti");
            list.add("Sakit");

            // Mengisi model ComboBox dengan data dari list
            for (String nama : list) {
                comboBoxModel.addElement(nama);
            }

            // Mengatur model ComboBox pada view
            view.getCbAlasan().setModel(comboBoxModel);
        } catch (Exception ex) {
            Logger.getLogger(MonitoringController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void viewTable(){   
        try {
            DefaultTableModel tabelmodel = (DefaultTableModel)
            view.getTblMonitoring().getModel();
            tabelmodel.setRowCount(0);
            List<Monitoring> list = dao.getAllMonitoring();
            for (Monitoring monitoring : list){
                Object[] data = {
                    monitoring.getTanggal(),
                    monitoring.getNama(),
                    monitoring.getAlasan(),
                };
                tabelmodel.addRow(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(PegawaiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
}
