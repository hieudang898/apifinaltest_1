package com.hocvien.finaltest.controller;

import com.hocvien.finaltest.model.LoaiKhoaHoc;
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
public class QuyenHanController {
    @Autowired
    ServiceManager serviceManager;

    @GetMapping(value = "hienthidanhsachquyenhan", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<QuyenHan> hienThiQuyenHan(@RequestParam int pageNumber,
                                          @RequestParam int pageSize) {
        Pageable page = (Pageable) PageRequest.of(pageNumber, pageSize);
        return serviceManager.quyenHanService.hienThiQuyenHan(page);
    }

    @PostMapping(value = "themquyenhan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> themQuyenHanMoi(@RequestBody String quyenHanMoiJson) {
        String resultThem = serviceManager.quyenHanService.themQuyenHan(quyenHanMoiJson);
        return ResponseEntity.ok(new ApiReponse(resultThem));
    }

    @PutMapping(value = "suaquyenhan", produces = MediaType.APPLICATION_JSON_VALUE)
    public QuyenHan suaQuyenHan(@RequestBody String quyenHanSuaJson) {
        return serviceManager.quyenHanService.suaQuyenHan(quyenHanSuaJson);
    }

    @DeleteMapping(value = "xoaquyenhan", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> xoaLoaiKhoaHoc(@RequestParam int idXoa) {
        String resultXoa = serviceManager.quyenHanService.xoaQuyenHan(idXoa);
        return ResponseEntity.ok(new ApiReponse(resultXoa));
    }

}
