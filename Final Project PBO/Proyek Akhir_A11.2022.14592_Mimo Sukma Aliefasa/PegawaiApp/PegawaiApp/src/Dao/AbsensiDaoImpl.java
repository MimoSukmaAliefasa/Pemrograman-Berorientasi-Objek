/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Absensi;
import Model.Absensi;
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
public class AbsensiDaoImpl implements AbsensiDao{

    @Override
    public void insert(Absensi Absensi) throws Exception {
        Koneksi k = new Koneksi();
        Connection con = k.getConnection();
        String sql = "insert into absensi (nama, jamMasuk, jamKeluar, tanggal, durasi) VALUES (?,?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, Absensi.getNama());
        ps.setString(2, Absensi.getJamMasuk());
        ps.setString(3, Absensi.getJamKeluar());
        ps.setString(4, Absensi.getTanggal());
        ps.setString(5, Absensi.getDurasi());
        ps.executeUpdate();
    }


    @Override
    public List<Absensi> getAllAbsensi() throws Exception {
        Koneksi k = new Koneksi();
        Connection con = k.getConnection();
        String sql = "select tanggal,nama,jamMasuk,jamKeluar,durasi from absensi";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Absensi> list = new ArrayList<>();
        Absensi absensi = null;
        while(rs.next()){
            absensi = new Absensi();
            absensi.setTanggal(rs.getString(1));
            absensi.setNama(rs.getString(2));
            absensi.setJamMasuk(rs.getString(3));
            absensi.setJamKeluar(rs.getString(4));
            absensi.setDurasi(rs.getString(5));
            list.add(absensi);
        }
        return list;
    }

    @Override
    public List<Absensi> getAllNama() throws Exception {
        Koneksi k = new Koneksi();
        Connection con = k.getConnection();
        String sql = "select nama from pegawai";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Absensi> list = new ArrayList<>();
        Absensi Absensi = null;
        while(rs.next()){
            Absensi = new Absensi();
            Absensi.setNama(rs.getString(1));
            list.add(Absensi);
        }
        return list;
    }
}
