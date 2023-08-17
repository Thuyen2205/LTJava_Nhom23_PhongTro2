/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.controllers;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.ntt.pojo.BaiViet;
import com.ntt.pojo.BinhLuan;
import com.ntt.pojo.NguoiDung;
import com.ntt.service.BaiVietService;
import com.ntt.service.BinhLuanService;
import com.ntt.service.LoaiBaiVietService;
import com.ntt.service.NguoiDungService;
import com.ntt.service.TaiKhoanService;
import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Past;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author ThanhThuyen
 */
@Controller
@Transactional
public class BaiVietController {

    @Autowired
    private BaiVietService baivietService;
    @Autowired
    private LoaiBaiVietService loaiBaiViet;
    @Autowired
    private TaiKhoanService taikhoan;
    @Autowired
    private NguoiDungService ngdungService;
    @Autowired
    private BinhLuanService binhluanService;


    @GetMapping("/dangbai")
    public String list(Model model, Authentication authen) {
        model.addAttribute("nguoidung", this.taikhoan.getTaiKhoan(authen.getName()).get(0));
        model.addAttribute("baiviet_role", this.loaiBaiViet.getLoaiBaiViet());
        model.addAttribute("taikhoan", this.taikhoan.getTaiKhoan(authen.getName()).get(0));

        model.addAttribute("baiviet", new BaiViet());
        return "dangbai";

    }

    @RequestMapping("/thtin_bviet")
    public String bvietThTin(Model model, @RequestParam Map<String, String> params, Authentication authen) {
        String errMsg = "";
        int id = Integer.parseInt(params.get("baivietId"));
        if (authen != null) {

            model.addAttribute("taikhoan", this.taikhoan.getTaiKhoan(authen.getName()).get(0));
        }
        model.addAttribute("BaiViet", this.baivietService.getBaiVietById(id));
        model.addAttribute("binhluan", new BinhLuan());
        model.addAttribute("binhluans", this.binhluanService.getBinhLuan(id));

        return "thtin_bviet";
    }

    @PostMapping("/thtin_bviet_bl")
    public String addBinhLuan(Model model, @ModelAttribute(value = "binhluan") BinhLuan binhluan, Authentication authen, @RequestParam Map<String, String> params) {
        String errMsg = "";
        String ms = "";
        int id = Integer.parseInt(params.get("baivietId"));
        if (authen.getName() != null) {
            if (this.binhluanService.addBinhLuan(binhluan) == true) {
                return "forward:/thtin_bviet";
            } else {

                ms = "Đã có lỗi xãy ra";
            }
        }
        return "index";
    }

    @PostMapping("/dangbai")
    public String add(Model model, @ModelAttribute(value = "baiviet") BaiViet baiviet) {
        String errMsg = "";
        if (this.baivietService.addBaiViet(baiviet) == true) {

            return "redirect:/";
        } else {
            errMsg = "Đã có lỗi xãy ra";
        }

        return "baiviet";
    }

    @RequestMapping("/capnhat")
    public String bvietCapNhatThTin(Model model, @RequestParam Map<String, String> params, Authentication authen) {
        int id = Integer.parseInt(params.get("baivietId").toString());
        if (authen != null) {
            model.addAttribute("taikhoan", this.taikhoan.getTaiKhoan(authen.getName()).get(0));
        }
        model.addAttribute("BaiViet", this.baivietService.getBaiVietById(id));
        return "capnhat";
    }

    @PostMapping("/capnhat1")
    public String update(Model model, @ModelAttribute(value = "baiviet") BaiViet baiviet) {
        String errMsg = "";
        if (this.baivietService.updateBaiViet(baiviet) == true) {
            return "redirect:/canhan";
        } else {
            errMsg = "Đã có lỗi xãy ra";
        }

        return "capnhat1";
    }
//    
//    @RequestMapping(value = "DeleteBViet/{baivietId}")
//    public String deleteBViet(HttpServletRequest request, Http)

//    @RequestMapping("/capnhat")
//    public String xoaBViet(Model model, @RequestParam Map<String, String> params, Authentication authen) {
//        int id = Integer.parseInt(params.get("baivietId").toString());
//        if (authen != null) {
//            model.addAttribute("taikhoan", this.taikhoan.getTaiKhoan(authen.getName()).get(0));
//        }
//        model.addAttribute("BaiViet", this.baivietService.getBaiVietById(id));
//        return "capnhat";
//    }
}
