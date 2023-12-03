package com.hocvien.finaltest.controller;

import com.hocvien.finaltest.model.BaiViet;
import com.hocvien.finaltest.model.reponseobject.ApiReponse;
import com.hocvien.finaltest.service.cservice.BaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/baiviet")
public class BaiVietController {

    @Autowired
    private BaiVietService baiVietService;

    @GetMapping(value = "hienthidanhsach", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<BaiViet> hienThiDanhSachBaiViet(@RequestParam int pageNumber,
                                                @RequestParam int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return baiVietService.hienThiDanhSachBaiViet(page);
    }

    @PostMapping(value = "them", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> themBaiVietMoi(@RequestBody String baiVietMoiJson) {
        String resultThem = baiVietService.themBaiViet(baiVietMoiJson);
        return ResponseEntity.ok(new ApiReponse(resultThem));
    }

    @PutMapping(value = "sua", produces = MediaType.APPLICATION_JSON_VALUE)
    public BaiViet suaBaiViet(@RequestBody String baiVietSuaJson) {
        return baiVietService.suaBaiViet(baiVietSuaJson);
    }

    @DeleteMapping(value = "xoa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> xoaBaiViet(@RequestParam int idXoa) {
        String resultXoa = baiVietService.xoaBaiViet(idXoa);
        return ResponseEntity.ok(new ApiReponse(resultXoa));
    }

    @GetMapping(value = "timkiem", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<BaiViet> timKiemBaiViet(@RequestParam String tenTimKiem,
                                        @RequestParam int pageNumber,
                                        @RequestParam int pageSize) {
        Pageable page = (Pageable) PageRequest.of(pageNumber, pageSize);
        return baiVietService.timKiemTheoTen(tenTimKiem, page);
    }
}
