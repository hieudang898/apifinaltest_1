package com.hocvien.finaltest.service.cservice;

import com.hocvien.finaltest.model.TinhTrangHoc;
import com.hocvien.finaltest.repository.repomanager.RepoManager;
import com.hocvien.finaltest.service.iservice.ITinhTrangHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TinhTrangHocService implements ITinhTrangHocService {

    @Autowired
    private RepoManager repoManager;

    // Hiển thị danh sách tình trạng học
    public List<TinhTrangHoc> hienThiDanhSachTinhTrangHoc() {
        return repoManager.tinhTrangHocRepo.findAll();
    }

    // Thêm tình trạng học
    public TinhTrangHoc themTinhTrangHoc(TinhTrangHoc tinhTrangHoc) {
        return repoManager.tinhTrangHocRepo.save(tinhTrangHoc);
    }
    // Sửa tình trạng học
    public TinhTrangHoc suaTinhTrangHoc(int id, TinhTrangHoc tinhTrangHocMoi) {
        Optional<TinhTrangHoc> optionalTinhTrangHoc = repoManager.tinhTrangHocRepo.findById(id);
        if (optionalTinhTrangHoc.isPresent()) {
            TinhTrangHoc tinhTrangHocCanSua = optionalTinhTrangHoc.get();
            tinhTrangHocCanSua.setTenTinhTrang(tinhTrangHocMoi.getTenTinhTrang());
            return repoManager.tinhTrangHocRepo.save(tinhTrangHocCanSua);
        }
        // Handle not found scenario, throw exception or return null as needed
        return null;
    }

    // Xóa tình trạng học
    public void xoaTinhTrangHoc(int id) {
        repoManager.tinhTrangHocRepo.deleteById(id);
    }
}

