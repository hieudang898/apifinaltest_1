package com.hocvien.finaltest.controller;

import com.hocvien.finaltest.model.TinhTrangHoc;
import com.hocvien.finaltest.model.reponseobject.ApiReponse;
import com.hocvien.finaltest.service.cservice.TinhTrangHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tinhtranghoc")
public class TinhTrangHocController {

    @Autowired
    private TinhTrangHocService tinhTrangHocService;

    // Hiển thị danh sách tình trạng học
    @GetMapping(value = "hienthidanhsach", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TinhTrangHoc> hienThiDanhSachTinhTrangHoc() {
        return tinhTrangHocService.hienThiDanhSachTinhTrangHoc();
    }

    // Thêm tình trạng học
    @PostMapping(value = "them", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> themTinhTrangHoc(@RequestBody TinhTrangHoc tinhTrangHoc) {
        TinhTrangHoc resultThem = tinhTrangHocService.themTinhTrangHoc(tinhTrangHoc);
        return ResponseEntity.ok(new ApiReponse("Thêm tình trạng học thành công"));
    }

    // Sửa tình trạng học
    @PutMapping(value = "sua/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> suaTinhTrangHoc(@PathVariable int id, @RequestBody TinhTrangHoc tinhTrangHocMoi) {
        TinhTrangHoc resultSua = tinhTrangHocService.suaTinhTrangHoc(id, tinhTrangHocMoi);
        if (resultSua != null) {
            return ResponseEntity.ok(new ApiReponse("Sửa tình trạng học thành công"));
        } else {
            return ResponseEntity.ok(new ApiReponse("Không tìm thấy tình trạng học để sửa"));
        }
    }

    // Xóa tình trạng học
    @DeleteMapping(value = "xoa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> xoaTinhTrangHoc(@PathVariable int id) {
        tinhTrangHocService.xoaTinhTrangHoc(id);
        return ResponseEntity.ok(new ApiReponse("Xóa tình trạng học thành công"));
    }
}

