/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ntt.controllers;

import com.ntt.pojo.BaiViet;
import com.ntt.pojo.TrangThaiBaiViet;
import com.ntt.service.BaiVietService;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Admins
 */
@RestController
@RequestMapping("/api")
@CrossOrigin
public class ApiBaiVietController {

    @Autowired
    private BaiVietService baivietService;

    @DeleteMapping("/capnhat1/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteBViet(@PathVariable(value = "id") int id) {
        this.baivietService.deleteBaiViet(id);
    }

}
