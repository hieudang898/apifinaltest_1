package com.hocvien.finaltest.service.cservice;

import com.hocvien.finaltest.model.LoaiKhoaHoc;
import com.hocvien.finaltest.repository.repomanager.RepoManager;
import com.hocvien.finaltest.service.cservice.svmanager.GsonNoDate;
import com.hocvien.finaltest.service.iservice.ILoaiKhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

//Thêm, sửa, xóa các loại khóa học
@Service
public class LoaiKhoaHocService implements ILoaiKhoaHocService {
    @Autowired
    RepoManager repoManager;

    @Override
    public String themLoaiKhoaHoc(String loaiKhoaHocJson) {
        LoaiKhoaHoc loaiKhoaHocThem = GsonNoDate.gson.fromJson(loaiKhoaHocJson, LoaiKhoaHoc.class);
        repoManager.loaiKhoaHocRepo.save(loaiKhoaHocThem);
        return "Đã thêm loại khoa học mới";
    }

    @Override
    public LoaiKhoaHoc suaLoaiKhoaHoc(String loaiKhoaHocSuaJson) {
        LoaiKhoaHoc loaiKhoaHocSua = GsonNoDate.gson.fromJson(loaiKhoaHocSuaJson, LoaiKhoaHoc.class);
        Optional<LoaiKhoaHoc> loaiKhoaHocNeedRemakeOptional = repoManager.loaiKhoaHocRepo.findById(loaiKhoaHocSua.getLoaiKhoaHocId());
        if (loaiKhoaHocNeedRemakeOptional.isPresent()) {
            LoaiKhoaHoc loaiKhoaHocRemake = loaiKhoaHocNeedRemakeOptional.get();
            loaiKhoaHocRemake.setTenLoai(loaiKhoaHocSua.getTenLoai());
            return repoManager.loaiKhoaHocRepo.save(loaiKhoaHocRemake);
        }
        return null;
    }

    @Override
    public LoaiKhoaHoc xoaLoaiKhoaHoc(int idLoaiKhoaHocXoa) {
        Optional<LoaiKhoaHoc> loaiKhoaHocXoaOptional = repoManager.loaiKhoaHocRepo.findById(idLoaiKhoaHocXoa);
        if (loaiKhoaHocXoaOptional.isPresent()) {
            LoaiKhoaHoc loaiKhoaHocXoa = loaiKhoaHocXoaOptional.get();
            repoManager.loaiKhoaHocRepo.delete(loaiKhoaHocXoa);
            return loaiKhoaHocXoa;
        }
        return null;
    }
}
