package com.hocvien.finaltest.service.iservice;

import com.hocvien.finaltest.model.TinhTrangHoc;

import java.util.List;

public interface ITinhTrangHocService {
    public List<TinhTrangHoc> hienThiDanhSachTinhTrangHoc();
    public TinhTrangHoc themTinhTrangHoc(TinhTrangHoc tinhTrangHoc);
    public TinhTrangHoc suaTinhTrangHoc(int id, TinhTrangHoc tinhTrangHocMoi);
    public void xoaTinhTrangHoc(int id);
}
