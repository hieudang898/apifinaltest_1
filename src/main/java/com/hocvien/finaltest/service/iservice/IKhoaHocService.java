package com.hocvien.finaltest.service.iservice;

import com.hocvien.finaltest.model.KhoaHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IKhoaHocService {
    public Page<KhoaHoc> hienThiDanhSachKhoaHoc(Pageable pageable);
    public String themKhoaHoc(KhoaHoc khoaHocMoi);
    public void xoaKhoaHoc(int idXoa);
    public KhoaHoc suaKhoaHoc(int idSua, KhoaHoc khoaHocMoi);
    public Page<KhoaHoc> timKiemTheoTen(String tenTimKiem, Pageable pageable);

}
