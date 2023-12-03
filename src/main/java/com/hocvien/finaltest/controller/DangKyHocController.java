package com.hocvien.finaltest.controller;

import com.hocvien.finaltest.model.DangKyHoc;
import com.hocvien.finaltest.model.reponseobject.ApiReponse;
import com.hocvien.finaltest.service.cservice.DangKyHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/dangky")
public class DangKyHocController {
    @Autowired
    private DangKyHocService dangKyHocService;

    @GetMapping(value = "hienthidangky", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<DangKyHoc> hienThiDanhSachDangKy(@RequestParam int pageNumber, @RequestParam int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return dangKyHocService.hienThiDangKy(page);
    }

    @DeleteMapping(value = "xoa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> xoaHocVien(@PathVariable int id) {
        dangKyHocService.xoaDangKy(id);
        return ResponseEntity.ok("Xóa đăng ký thành công");
    }

    @PostMapping(value = "themdangky", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> themDangKy(@RequestBody String dangKyMoiJson) {
        dangKyHocService.themDangKy(dangKyMoiJson);
        return ResponseEntity.ok("thêm thành công");
    }

    @PutMapping(value = "suadangky", produces = MediaType.APPLICATION_JSON_VALUE)
    public DangKyHoc suaDangKy(@RequestParam int idSua, @RequestBody String dangKySuaJson) {
        return dangKyHocService.suaDangKy(idSua, dangKySuaJson);

    }
}
