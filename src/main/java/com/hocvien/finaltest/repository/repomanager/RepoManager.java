package com.hocvien.finaltest.repository.repomanager;

import com.hocvien.finaltest.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepoManager {
    @Autowired
    public BaiVietRepo baiVietRepo;
    @Autowired
    public ChuDeRepo chuDeRepo;
    @Autowired
    public DangKyHocRepo dangKyHocRepo;
    @Autowired
    public HocVienRepo hocVienRepo;
    @Autowired
    public KhoaHocRepo khoaHocRepo;
    @Autowired
    public LoaiBaiVietRepo loaiBaiVietRepo;
    @Autowired
    public LoaiKhoaHocRepo loaiKhoaHocRepo;
    @Autowired
    public QuyenHanRepo quyenHanRepo;
    @Autowired
    public TaiKhoanRepo taiKhoanRepo;
    @Autowired
    public TinhTrangHocRepo tinhTrangHocRepo;

}
