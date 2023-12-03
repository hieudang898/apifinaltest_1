package com.hocvien.finaltest.service.iservice;

import com.hocvien.finaltest.model.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ITaiKhoanService {
    public Page<TaiKhoan> hienThiDanhSachTaiKhoan(Pageable pageable);
    public TaiKhoan themTaiKhoan(TaiKhoan taiKhoanMoi);
    public void xoaTaiKhoan(int idXoa);
    public Page<TaiKhoan> timKiemTheoTen(String tenTimKiem, Pageable pageable);
    public TaiKhoan suaTaiKhoan(int idSua,TaiKhoan taiKhoanMoi);
}
