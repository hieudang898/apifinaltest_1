package com.hocvien.finaltest.service.cservice;

import com.hocvien.finaltest.model.QuyenHan;
import com.hocvien.finaltest.repository.repomanager.RepoManager;
import com.hocvien.finaltest.service.cservice.svmanager.GsonNoDate;
import com.hocvien.finaltest.service.iservice.IQuyenHanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

//Thêm, sửa, xóa, hiển thị các quyền hạn
@Service
public class QuyenHanService implements IQuyenHanService {
    @Autowired
    RepoManager repoManager;

    @Override
    public Page<QuyenHan> hienThiQuyenHan(Pageable pageable) {
        Page<QuyenHan> quyenHans = repoManager.quyenHanRepo.findAll(pageable);
        return quyenHans;
    }

    @Override
    public String themQuyenHan(String quyenHanJson) {
        QuyenHan quyenHanMoi = GsonNoDate.gson.fromJson(quyenHanJson, QuyenHan.class);
        repoManager.quyenHanRepo.save(quyenHanMoi);
        return "thêm thành công";
    }

    @Override
    public String xoaQuyenHan(int idXoa) {
        QuyenHan quyenHanXoa = repoManager.quyenHanRepo.findById(idXoa).get();
        if (quyenHanXoa == null) {
            return "không tồn tại quyền hạn cần xóa";
        }
        repoManager.quyenHanRepo.delete(quyenHanXoa);
        return "Xóa thành công";
    }

    @Override
    public QuyenHan suaQuyenHan(String quyenHanSuaJson) {
        QuyenHan quyenHanSua = GsonNoDate.gson.fromJson(quyenHanSuaJson, QuyenHan.class);
        QuyenHan quyenHanCanSua = repoManager.quyenHanRepo.findById(quyenHanSua.getQuyenHanId()).get();
        if (quyenHanCanSua != null) {
            quyenHanCanSua.setTenQuyenHan(quyenHanSua.getTenQuyenHan());
            repoManager.quyenHanRepo.save(quyenHanCanSua);

        }
        return null;
    }
}
