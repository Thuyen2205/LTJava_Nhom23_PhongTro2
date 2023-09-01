/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.ntt.repository;

import com.ntt.pojo.LoaiTaiKhoan;
import com.ntt.pojo.NguoiDung;
import java.util.Date;
import java.util.List;

/**
 *
 * @author ThanhThuyen
 */
public interface TaiKhoanRepository{
    boolean addTaiKhoan(NguoiDung nguoidung);
    List<NguoiDung> getTaiKhoan(String username);
    LoaiTaiKhoan getLoaiTaiKhoan (String tenLoaiTaiKhoan);
    NguoiDung getTaiKhoanbyTenTK(String tenTK);
    NguoiDung getTaiKhoanId(int id);
    List<NguoiDung> getTaiKhoansByYear(int year);
    List<NguoiDung> getTaiKhoansByMonth(int year,int month);
    List<NguoiDung> getTaiKhoansByQuarter(int year,int quarter);
    boolean deleteTaiKhoan(int idTaiKhoan);
    
   
}
