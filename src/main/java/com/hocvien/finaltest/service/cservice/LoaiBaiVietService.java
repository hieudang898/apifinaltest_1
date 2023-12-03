package com.hocvien.finaltest.service.cservice;

import com.hocvien.finaltest.model.LoaiBaiViet;
import com.hocvien.finaltest.repository.repomanager.RepoManager;
import com.hocvien.finaltest.service.cservice.svmanager.GsonNoDate;
import com.hocvien.finaltest.service.iservice.ILoaiBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class LoaiBaiVietService implements ILoaiBaiVietService {
    @Autowired
    RepoManager repoManager;

    @Override
    public Page<LoaiBaiViet> hienThiLoaiBaiViet(Pageable pageable) {
        Page<LoaiBaiViet> loaiBaiViets = repoManager.loaiBaiVietRepo.findAll(pageable);
        return loaiBaiViets;
    }

    @Override
    public String themLoaiBaiViet(String loaiBaiVietJson) {
        LoaiBaiViet loaiBaiVietMoi = GsonNoDate.gson.fromJson(loaiBaiVietJson, LoaiBaiViet.class);
        repoManager.loaiBaiVietRepo.save(loaiBaiVietMoi);
        return "thêm thành công";
    }

    @Override
    public String xoaLoaiBaiViet(int idXoa) {
        LoaiBaiViet loaiBaiVietXoa = repoManager.loaiBaiVietRepo.findById(idXoa).get();
        if (loaiBaiVietXoa == null) {
            return "không tồn tại loại bài viết cần xóa";

        }
        repoManager.loaiBaiVietRepo.delete(loaiBaiVietXoa);
        return "xóa thành công";
    }

    @Override
    public LoaiBaiViet suaLoaiBaiViet(String loaiBaiVietSuaJson) {
        LoaiBaiViet loaiBaiVietSua = GsonNoDate.gson.fromJson(loaiBaiVietSuaJson, LoaiBaiViet.class);
        ;
        LoaiBaiViet loaiBaiVietCanSUa = repoManager.loaiBaiVietRepo.findById(loaiBaiVietSua.getLoaiBaiVietId()).get();
        if (loaiBaiVietCanSUa != null) {
            loaiBaiVietCanSUa.setTenLoai(loaiBaiVietCanSUa.getTenLoai());
            repoManager.loaiBaiVietRepo.save(loaiBaiVietCanSUa);
        }
        return null;
    }
}
