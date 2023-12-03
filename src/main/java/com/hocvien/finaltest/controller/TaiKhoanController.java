package com.hocvien.finaltest.controller;

import com.hocvien.finaltest.model.TaiKhoan;
import com.hocvien.finaltest.model.reponseobject.ApiReponse;
import com.hocvien.finaltest.service.cservice.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/taikhoan")
public class TaiKhoanController {

    @Autowired
    private TaiKhoanService taiKhoanService;

    // Hiển thị danh sách tài khoản
    @GetMapping(value = "hienthidanhsach", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<TaiKhoan> hienThiDanhSachTaiKhoan(@RequestParam int pageNumber,
                                                  @RequestParam int pageSize) {
        return taiKhoanService.hienThiDanhSachTaiKhoan(PageRequest.of(pageNumber, pageSize));
    }

    // Thêm tài khoản
    @PostMapping(value = "them", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> themTaiKhoan(@RequestBody TaiKhoan taiKhoan) {
        TaiKhoan resultThem = taiKhoanService.themTaiKhoan(taiKhoan);
        return ResponseEntity.ok(new ApiReponse("Thêm tài khoản thành công"));
    }

    // Xóa tài khoản
    @DeleteMapping(value = "xoa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> xoaTaiKhoan(@PathVariable int id) {
        taiKhoanService.xoaTaiKhoan(id);
        return ResponseEntity.ok(new ApiReponse("Xóa tài khoản thành công"));
    }

    // Tìm kiếm tài khoản theo tên
    @GetMapping(value = "timkiemtheoten", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<TaiKhoan> timKiemTheoTen(@RequestParam String tenTimKiem,
                                         @RequestParam int pageNumber,
                                         @RequestParam int pageSize) {
        return taiKhoanService.timKiemTheoTen(tenTimKiem, PageRequest.of(pageNumber, pageSize));
    }

    // Sửa tài khoản
    @PutMapping(value = "sua/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> suaTaiKhoan(@PathVariable int id, @RequestBody TaiKhoan taiKhoanMoi) {
        TaiKhoan resultSua = taiKhoanService.suaTaiKhoan(id, taiKhoanMoi);
        if (resultSua != null) {
            return ResponseEntity.ok(new ApiReponse("Sửa tài khoản thành công"));
        } else {
            return ResponseEntity.ok(new ApiReponse("Không tìm thấy tài khoản để sửa"));
        }
    }
}

