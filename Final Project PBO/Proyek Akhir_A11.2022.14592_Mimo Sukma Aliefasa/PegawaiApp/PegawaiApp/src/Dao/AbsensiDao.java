/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Absensi;
import java.util.List;

/**
 *
 * @author HP
 */
public interface AbsensiDao {
    public void insert(Absensi Absensi) throws Exception;
    public List<Absensi> getAllNama() throws Exception;
    public List<Absensi> getAllAbsensi() throws Exception;
}
