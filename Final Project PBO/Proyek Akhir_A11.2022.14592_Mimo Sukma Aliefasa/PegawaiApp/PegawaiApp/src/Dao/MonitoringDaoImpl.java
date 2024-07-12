/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Monitoring;
import Model.Monitoring;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import utils.Koneksi;

/**
 *
 * @author HP
 */
public class MonitoringDaoImpl implements MonitoringDao{

    @Override
    public void insert(Monitoring Monitoring) throws Exception {
        Koneksi k = new Koneksi();
        Connection con = k.getConnection();
        String sql = "insert into monitoring (nama, tanggal, alasan) VALUES (?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, Monitoring.getNama());
        ps.setString(2, Monitoring.getTanggal());
        ps.setString(3, Monitoring.getAlasan());
        ps.executeUpdate();
    }

    @Override
    public List<Monitoring> getAllMonitoring() throws Exception {
        Koneksi k = new Koneksi();
        Connection con = k.getConnection();
        String sql = "select tanggal,nama,alasan from monitoring";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Monitoring> list = new ArrayList<>();
        Monitoring monitoring = null;
        while(rs.next()){
            monitoring = new Monitoring();
            monitoring.setTanggal(rs.getString(1));
            System.out.println(rs.getString(3));
            monitoring.setNama(rs.getString(2));
            monitoring.setAlasan(rs.getString(3));
            list.add(monitoring);
        }
        return list;
    }

    @Override
    public List<Monitoring> getAllNama() throws Exception {
        Koneksi k = new Koneksi();
        Connection con = k.getConnection();
        String sql = "select nama from pegawai";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Monitoring> list = new ArrayList<>();
        Monitoring Monitoring = null;
        while(rs.next()){
            Monitoring = new Monitoring();
            Monitoring.setNama(rs.getString(1));
            list.add(Monitoring);
        }
        return list;
    }
}
