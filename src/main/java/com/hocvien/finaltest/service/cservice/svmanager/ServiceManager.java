package com.hocvien.finaltest.service.cservice.svmanager;

import com.hocvien.finaltest.service.cservice.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceManager {
    @Autowired
    public BaiVietService baiVietService;
    @Autowired
    public ChuDeService chuDeService;
    @Autowired
    public DangKyHocService dangKyHocService;
    @Autowired
    public HocVienService hocVienService;
    @Autowired
    public KhoaHocService khoaHocService;
    @Autowired
    public LoaiBaiVietService loaiBaiVietService;
    @Autowired
    public LoaiKhoaHocService loaiKhoaHocService;
    @Autowired
    public QuyenHanService quyenHanService;
    @Autowired
    public TaiKhoanService taiKhoanService;
    @Autowired
    public TinhTrangHocService tinhTrangHocService;

}
