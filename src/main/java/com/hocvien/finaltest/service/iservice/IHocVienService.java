package com.hocvien.finaltest.service.iservice;

import com.hocvien.finaltest.model.HocVien;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IHocVienService {
    public Page<HocVien> hienThiDanhSachHocVien(Pageable pageable);
    public String themHocVien(String hocVienMoiJson);
    public void xoaHocVien(int idXoa);
    public HocVien suaHocVien(int idSua, HocVien hocVienMoi);
    public Page<HocVien> timKimTheoTen(String name,Pageable pageable);


}
