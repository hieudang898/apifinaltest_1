package com.hocvien.finaltest.service.iservice;

import com.hocvien.finaltest.model.ChuDe;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;

public interface IChuDeService {
    public Page<ChuDe> hienThiDanhSachChuDe(Pageable pageable);
    public String themChuDe(String chuDeJson);
    public ChuDe suaChuDe(String chuDeSuaJson);
    public String xoaChuDe(int idXoa);
}
