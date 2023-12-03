package com.hocvien.finaltest.controller;

import com.hocvien.finaltest.model.KhoaHoc;
import com.hocvien.finaltest.service.cservice.KhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/khoahoc")
public class KhoaHocController {

    @Autowired
    private KhoaHocService khoaHocService;

    @GetMapping
    public Page<KhoaHoc> hienThiDanhSachKhoaHoc(@RequestParam int pageNumber,
                                                @RequestParam int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return khoaHocService.hienThiDanhSachKhoaHoc(page);
    }

    @PostMapping
    public String themKhoaHoc(@RequestBody KhoaHoc khoaHocMoi) {
        return khoaHocService.themKhoaHoc(khoaHocMoi);
    }

    @DeleteMapping("/{id}")
    public void xoaKhoaHoc(@PathVariable int id) {
        khoaHocService.xoaKhoaHoc(id);
    }

    @PutMapping("/{id}")
    public KhoaHoc suaKhoaHoc(@PathVariable int id, @RequestBody KhoaHoc khoaHocMoi) {
        return khoaHocService.suaKhoaHoc(id, khoaHocMoi);
    }

    @GetMapping("/search")
    public Page<KhoaHoc> timKiemTheoTen(@RequestParam String ten, @RequestParam int pageNumber, @RequestParam int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return khoaHocService.timKiemTheoTen(ten, page);
    }
}
