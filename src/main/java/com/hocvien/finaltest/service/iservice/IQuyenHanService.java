package com.hocvien.finaltest.service.iservice;

import com.hocvien.finaltest.model.QuyenHan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IQuyenHanService {
    public Page<QuyenHan> hienThiQuyenHan(Pageable pageable);

    public String themQuyenHan(String quyenHanJson);

    public String xoaQuyenHan(int idXoa);

    public QuyenHan suaQuyenHan(String quyenHanSuaJson);
}
