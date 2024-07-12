/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Dao.PegawaiDao;
import Dao.PegawaiDaoImpl;
import Model.Pegawai;
import View.PegawaiView;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class PegawaiController {
    PegawaiView view;
    PegawaiDao dao;
    Pegawai model;

    public PegawaiController(PegawaiView view) {
        this.view = view;
        dao = new PegawaiDaoImpl();
    }

    public void clearForm() {
        view.getTxtId().setText("");
        view.getTxtNama().setText("");
        view.getTxtGolongan().setText("");
        view.getTxtGajiPokok().setText("");
    }

    public void insert() {
        try {
            model = new Pegawai();
            model.setId(view.getTxtId().getText());
            model.setNama(view.getTxtNama().getText());
            model.setGolongan(view.getTxtGolongan().getText());
            model.setGajiPokok(Integer.parseInt(view.getTxtGajiPokok().getText()));
            dao.insert(model);
            JOptionPane.showMessageDialog(view, "Entry data ok");
        } catch (Exception ex) {
            Logger.getLogger(PegawaiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void update() {
        try {
            model = new Pegawai();
            model.setId(view.getTxtId().getText());
            model.setNama(view.getTxtNama().getText());
            model.setGolongan(view.getTxtGolongan().getText());
            model.setGajiPokok(Integer.parseInt(view.getTxtGajiPokok().getText()));
            dao.update(model);
            JOptionPane.showMessageDialog(view, "Update data ok");
        } catch (Exception ex) {
            Logger.getLogger(PegawaiController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void delete() {
        try {
            model = new Pegawai();
            model.setId(view.getTxtId().getText());
            dao.delete(model);
            JOptionPane.showMessageDialog(view, "delete data ok");
        } catch (Exception ex) {
            Logger.getLogger(PegawaiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void getPegawai() {
        try {
            String id = view.getTxtId().getText();
            Pegawai pegawai = dao.getPegawai(id);
            if (pegawai != null) {
                view.getTxtNama().setText(pegawai.getNama());
                view.getTxtGolongan().setText(pegawai.getGolongan());
                view.getTxtGajiPokok().setText(pegawai.getGajiPokok()+ "" );
            } else {
                JOptionPane.showMessageDialog(view, "Data Tidak ada");
            }
        } catch (Exception ex) {
            Logger.getLogger(PegawaiController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    


public void viewTable(){   
        try {
            DefaultTableModel tabelmodel = (DefaultTableModel)
            view.getTblPegawai().getModel();
            tabelmodel.setRowCount(0);
            List<Pegawai> list = dao.getAllPegawai();
            for (Pegawai Pegawai : list){
                Object[] data = {
                    Pegawai.getId(),
                    Pegawai.getNama(),
                    Pegawai.getGolongan(),
                    Pegawai.getGajiPokok()
                };
                tabelmodel.addRow(data);
            }
        } catch (Exception ex) {
            Logger.getLogger(PegawaiController.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }


