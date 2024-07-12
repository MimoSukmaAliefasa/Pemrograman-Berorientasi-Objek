/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Pegawai;
import java.util.List;

/**
 *
 * @author HP
 */
public interface PegawaiDao {
    public void insert(Pegawai Pegawai) throws Exception;
    public void update(Pegawai Pegawai) throws Exception;
    public void delete(Pegawai Pegawai) throws Exception;
    public Pegawai getPegawai(String id) throws Exception;
    public List<Pegawai> getAllPegawai() throws Exception;
}
