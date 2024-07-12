/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.Monitoring;
import java.util.List;

/**
 *
 * @author HP
 */
public interface MonitoringDao {
    public void insert(Monitoring Monitoring) throws Exception;
    public List<Monitoring> getAllNama() throws Exception;
    public List<Monitoring> getAllMonitoring() throws Exception;
}
