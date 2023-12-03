package com.hocvien.finaltest.service.iservice;

import com.hocvien.finaltest.model.LoaiKhoaHoc;

public interface ILoaiKhoaHocService {
    public String themLoaiKhoaHoc(String loaiKhoaHocJson);
    public LoaiKhoaHoc suaLoaiKhoaHoc(String loaiKhoaHocSuaJson);
    public LoaiKhoaHoc xoaLoaiKhoaHoc(int idLoaiKhoaHocXoa);

}
