package com.hocvien.finaltest.controller;

import com.hocvien.finaltest.model.ChuDe;
import com.hocvien.finaltest.model.reponseobject.ApiReponse;
import com.hocvien.finaltest.service.cservice.ChuDeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chude")
public class ChuDeController {

    @Autowired
    private ChuDeService chuDeService;

    @GetMapping(value = "hienthidanhsach", produces = MediaType.APPLICATION_JSON_VALUE)
    public Page<ChuDe> hienThiDanhSachChuDe(@RequestParam int pageNumber,
                                            @RequestParam int pageSize) {
        Pageable page = PageRequest.of(pageNumber, pageSize);
        return chuDeService.hienThiDanhSachChuDe(page);
    }

    @PostMapping(value = "them", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> themChuDeMoi(@RequestBody String chuDeMoiJson) {
        String resultThem = chuDeService.themChuDe(chuDeMoiJson);
        return ResponseEntity.ok(new ApiReponse(resultThem));
    }

    @PutMapping(value = "sua", produces = MediaType.APPLICATION_JSON_VALUE)
    public ChuDe suaChuDe(@RequestBody String chuDeSuaJson) {
        return chuDeService.suaChuDe(chuDeSuaJson);
    }

    @DeleteMapping(value = "xoa", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ApiReponse> xoaChuDe(@RequestParam int idXoa) {
        String resultXoa = chuDeService.xoaChuDe(idXoa);
        return ResponseEntity.ok(new ApiReponse(resultXoa));
    }
}
