package com.hocvien.finaltest.service.cservice;

import com.hocvien.finaltest.model.DangKyHoc;
import com.hocvien.finaltest.repository.repomanager.RepoManager;
import com.hocvien.finaltest.service.cservice.svmanager.GsonDate;
import com.hocvien.finaltest.service.iservice.IDangKyHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class DangKyHocService implements IDangKyHocService {
    @Autowired
    private RepoManager repoManager;

    @Override
    public DangKyHoc themDangKy(String dangKyMoiJson) {
        DangKyHoc dangKyMoi = GsonDate.gsonDate.fromJson(dangKyMoiJson, DangKyHoc.class);
        if (dangKyMoi.getTinhTrangHoc().getTenTinhTrang().equals("Đang học chính")) {
            dangKyMoi.setNgayDangKy(LocalDate.now());
            dangKyMoi.setNgayBatDau(LocalDate.now());
            dangKyMoi.setNgayKetThuc(dangKyMoi.getNgayBatDau().plusDays(dangKyMoi.getKhoaHoc().getThoiGianHoc()));
        }

        return repoManager.dangKyHocRepo.save(dangKyMoi);
    }

    @Override
    public Page<DangKyHoc> hienThiDangKy(Pageable pageable) {
        return repoManager.dangKyHocRepo.findAll(pageable);
    }

    @Override
    public void xoaDangKy(int idXoa) {
        repoManager.dangKyHocRepo.deleteById(idXoa);
    }

    @Override
    public DangKyHoc suaDangKy(int idSua, String dangKySuaJson) {
        DangKyHoc dangKySua = GsonDate.gsonDate.fromJson(dangKySuaJson, DangKyHoc.class);
        DangKyHoc dangKyCanSua = repoManager.dangKyHocRepo.findById(idSua).get();
        if (dangKyCanSua != null) {
            if (dangKySua.getTinhTrangHoc().getTenTinhTrang().equals("Đang học chính")) {
                dangKyCanSua.setKhoaHoc(dangKySua.getKhoaHoc());
                dangKyCanSua.setNgayBatDau(LocalDate.now());
                dangKyCanSua.setNgayDangKy(LocalDate.now());
                dangKyCanSua.setNgayKetThuc(dangKyCanSua.getNgayBatDau().plusDays(dangKyCanSua.getKhoaHoc().getThoiGianHoc()));
                dangKyCanSua.setHocVien(dangKyCanSua.getHocVien());
                dangKyCanSua.setTaiKhoanDangKy(dangKyCanSua.getTaiKhoanDangKy());
            }
            return repoManager.dangKyHocRepo.save(dangKyCanSua);
        }
        return null;

    }

}
