package com.hocvien.finaltest.service.iservice;

import com.hocvien.finaltest.model.BaiViet;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBaiVietService {
    public Page<BaiViet> hienThiDanhSachBaiViet(Pageable pageable);
    public String themBaiViet(String baiVietJson);
    public BaiViet suaBaiViet(String baiVietSuaJson);
    public String xoaBaiViet(int idXoa);
    public Page<BaiViet> timKiemTheoTen(String tenTimKiem,Pageable pageable);
}
