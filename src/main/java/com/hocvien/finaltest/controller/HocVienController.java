package com.hocvien.finaltest.controller;

import com.hocvien.finaltest.model.HocVien;
import com.hocvien.finaltest.service.cservice.HocVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hocvien")
public class HocVienController {

    @Autowired
    private HocVienService hocVienService;

    @GetMapping(value = "danhsach", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<HocVien> hienThiDanhSachHocVien(@RequestParam int pageNumber, @RequestParam int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return hocVienService.hienThiDanhSachHocVien(page);
    }

    @PostMapping(value = "them", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> themHocVienMoi(@RequestBody String hocVienMoiJson) {
        String resultThem = hocVienService.themHocVien(hocVienMoiJson);
        return ResponseEntity.ok(resultThem);
    }

    @PutMapping(value = "sua/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public HocVien suaHocVien(@PathVariable int id, @RequestBody HocVien hocVienMoi) {
        return hocVienService.suaHocVien(id, hocVienMoi);
    }

    @DeleteMapping(value = "xoa/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> xoaHocVien(@PathVariable int id) {
        hocVienService.xoaHocVien(id);
        return ResponseEntity.ok("Xóa học viên thành công");
    }

    @GetMapping(value = "timkiem", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<HocVien> timKiemTheoTen(@RequestParam String name, @RequestParam int pageNumber, @RequestParam int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return hocVienService.timKimTheoTen(name, page);
    }
}
