package com.hocvien.finaltest.service.iservice;

import com.hocvien.finaltest.model.LoaiBaiViet;
import com.hocvien.finaltest.model.QuyenHan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ILoaiBaiVietService {
    public Page<LoaiBaiViet> hienThiLoaiBaiViet(Pageable pageable);

    public String themLoaiBaiViet(String loaiBaiVietJson);

    public String xoaLoaiBaiViet(int idXoa);

    public LoaiBaiViet suaLoaiBaiViet(String loaiBaiVietSuaJson);
}
