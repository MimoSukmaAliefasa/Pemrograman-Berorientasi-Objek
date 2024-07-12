/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Pegawai;
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
public class PegawaiDaoImpl implements PegawaiDao{

    @Override
    public void insert(Pegawai Pegawai) throws Exception {
        Koneksi k = new Koneksi();
        Connection con = k.getConnection();
        String sql = "insert into pegawai Values(?,?,?,?)";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, Pegawai.getId());
        ps.setString(2, Pegawai.getNama());
        ps.setString(3, Pegawai.getGolongan());
        ps.setInt(4, Pegawai.getGajiPokok());
        ps.executeUpdate();
    }

    @Override
    public void update(Pegawai Pegawai) throws Exception {
        Koneksi k = new Koneksi();
        Connection con = k.getConnection();
        String sql = "update pegawai set nama=?, golongan=?, gajipokok=? where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, Pegawai.getNama());
        ps.setString(2, Pegawai.getGolongan());
        ps.setInt(3, Pegawai.getGajiPokok());
        ps.setString(4, Pegawai.getId());
        ps.executeUpdate();
    }

    @Override
    public void delete(Pegawai Pegawai) throws Exception {
        Koneksi k = new Koneksi();
        Connection con = k.getConnection();
        String sql = "delete from pegawai where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, Pegawai.getId());
        ps.executeUpdate();
    }

    @Override
    public Pegawai getPegawai(String id) throws Exception {
        Koneksi k = new Koneksi();
        Connection con = k.getConnection();
        String sql = "select * from pegawai where id=?";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, id);
        ResultSet rs = ps.executeQuery();
        Pegawai Pegawai = null;
        if(rs.next()){
            Pegawai = new Pegawai();
            Pegawai.setId(rs.getString(1));
            Pegawai.setNama(rs.getString(2));
            Pegawai.setGolongan(rs.getString(3));
            Pegawai.setGajiPokok(rs.getInt(4));
        }
        return Pegawai;
    }

    @Override
    public List<Pegawai> getAllPegawai() throws Exception {
        Koneksi k = new Koneksi();
        Connection con = k.getConnection();
        String sql = "select * from pegawai";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Pegawai> list = new ArrayList<>();
        Pegawai Pegawai = null;
        while(rs.next()){
            Pegawai = new Pegawai();
            Pegawai.setId(rs.getString(1));
            Pegawai.setNama(rs.getString(2));
            Pegawai.setGolongan(rs.getString(3));
            Pegawai.setGajiPokok(rs.getInt(4));
            list.add(Pegawai);
        }
        return list;
    }
    
}