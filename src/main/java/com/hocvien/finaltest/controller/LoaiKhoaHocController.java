package com.hocvien.finaltest.controller;

import com.hocvien.finaltest.model.LoaiKhoaHoc;
import com.hocvien.finaltest.model.reponseobject.ApiReponse;
import com.hocvien.finaltest.service.cservice.svmanager.ServiceManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class LoaiKhoaHocController {
    @Autowired
    ServiceManager serviceManager;

    @PostMapping(value = "themloaikhoahoc", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> themLoaiKhoaHocMoi(@RequestBody String loaiKhoaHocMoiJson) {
        String result = serviceManager.loaiKhoaHocService.themLoaiKhoaHoc(loaiKhoaHocMoiJson);
        return ResponseEntity.ok(new ApiReponse(result));
    }

    @PutMapping(value = "sualoaikhoahoc", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiKhoaHoc suaLoaiKhoaHoc(@RequestBody String loaiKhoaHocSuaJson) {
        return serviceManager.loaiKhoaHocService.suaLoaiKhoaHoc(loaiKhoaHocSuaJson);
    }

    @DeleteMapping(value = "xoaloaikhoahoc", produces = MediaType.APPLICATION_JSON_VALUE)
    public LoaiKhoaHoc xoaLoaiKhoaHoc(@RequestParam int idXoa) {
        return serviceManager.loaiKhoaHocService.xoaLoaiKhoaHoc(idXoa);
    }
}
