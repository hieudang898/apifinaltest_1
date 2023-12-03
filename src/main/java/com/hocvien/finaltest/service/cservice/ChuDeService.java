package com.hocvien.finaltest.service.cservice;

import com.hocvien.finaltest.model.ChuDe;
import com.hocvien.finaltest.repository.repomanager.RepoManager;
import com.hocvien.finaltest.service.cservice.svmanager.GsonNoDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ChuDeService {
    @Autowired
    private RepoManager repoManager;

    public Page<ChuDe> hienThiDanhSachChuDe(Pageable pageable) {
        return repoManager.chuDeRepo.findAll(pageable);
    }

    public String themChuDe(String chuDeJson) {
        ChuDe chuDeMoi = GsonNoDate.gson.fromJson(chuDeJson, ChuDe.class);
        repoManager.chuDeRepo.save(chuDeMoi);
        return "Thêm chủ đề thành công";
    }

    public ChuDe suaChuDe(String chuDeSuaJson) {
        ChuDe chuDeSua = GsonNoDate.gson.fromJson(chuDeSuaJson, ChuDe.class);
        ChuDe chuDeCanSua = repoManager.chuDeRepo.findById(chuDeSua.getChuDeId()).orElse(null);
        if (chuDeCanSua != null) {
            chuDeCanSua.setTenChuDe(chuDeSua.getTenChuDe());
            chuDeCanSua.setNoiDung(chuDeSua.getNoiDung());
            repoManager.chuDeRepo.save(chuDeCanSua);
        }
        return chuDeCanSua;
    }

    public String xoaChuDe(int idXoa) {
        ChuDe chuDeXoa = repoManager.chuDeRepo.findById(idXoa).orElse(null);
        if (chuDeXoa == null) {
            return "Không tồn tại chủ đề cần xóa";
        }
        repoManager.chuDeRepo.delete(chuDeXoa);
        return "Xóa chủ đề thành công";
    }
}
