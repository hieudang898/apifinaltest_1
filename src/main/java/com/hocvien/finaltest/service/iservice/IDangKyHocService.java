package com.hocvien.finaltest.service.iservice;

import com.hocvien.finaltest.model.DangKyHoc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDangKyHocService {
    public DangKyHoc themDangKy(String dangKyMoiJson);

    public Page<DangKyHoc> hienThiDangKy(Pageable pageable);

    public void xoaDangKy(int idXoa);

    public DangKyHoc suaDangKy(int idSua, String dangKySuaJson);

}
