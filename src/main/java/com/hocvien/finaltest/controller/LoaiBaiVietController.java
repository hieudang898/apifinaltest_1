package com.hocvien.finaltest.controller;

import com.hocvien.finaltest.model.LoaiBaiViet;
import com.hocvien.finaltest.model.QuyenHan;
import com.hocvien.finaltest.model.reponseobject.ApiReponse;
import com.hocvien.finaltest.service.cservice.svmanager.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoaiBaiVietController {
    @Autowired
    ServiceManager serviceManager;
    @GetMapping(value = "hienthidanhsachloaibaiviet", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<LoaiBaiViet> hienThiLoaiBaiViet(@RequestParam int pageNumber,
                                          @RequestParam int pageSize) {
        Pageable page = (Pageable) PageRequest.of(pageNumber, pageSize);
        return serviceManager.loaiBaiVietService.hienThiLoaiBaiViet(page);
    }

    @PostMapping(value = "themloaibaiviet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> themLoaiBaiViet(@RequestBody String loaiBaiVietMoiJson) {
        String resultThem = serviceManager.quyenHanService.themQuyenHan(loaiBaiVietMoiJson);
        return ResponseEntity.ok(new ApiReponse(resultThem));
    }

    @PutMapping(value = "sualoaibaiviet", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiBaiViet suaLoaiBiaViet(@RequestBody String loaiBaiVietSuaJson) {
        return serviceManager.loaiBaiVietService.suaLoaiBaiViet(loaiBaiVietSuaJson);
    }

    @DeleteMapping(value = "xoaloaibaiviet", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> xoaLoaiBaiViet(@RequestParam int idXoa) {
        String resultXoa = serviceManager.loaiBaiVietService.xoaLoaiBaiViet(idXoa);
        return ResponseEntity.ok(new ApiReponse(resultXoa));
    }
}
