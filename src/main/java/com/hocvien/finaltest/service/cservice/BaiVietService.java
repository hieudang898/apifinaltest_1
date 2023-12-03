package com.hocvien.finaltest.service.cservice;

import com.hocvien.finaltest.model.BaiViet;
import com.hocvien.finaltest.repository.repomanager.RepoManager;
import com.hocvien.finaltest.service.cservice.svmanager.GsonDate;
import com.hocvien.finaltest.service.iservice.IBaiVietService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BaiVietService implements IBaiVietService {
    @Autowired
    private RepoManager repoManager;

    public Page<BaiViet> hienThiDanhSachBaiViet(Pageable pageable) {
        return repoManager.baiVietRepo.findAll(pageable);
    }

    public String themBaiViet(String baiVietJson) {
        BaiViet baiVietMoi = GsonDate.gsonDate.fromJson(baiVietJson, BaiViet.class);
        repoManager.baiVietRepo.save(baiVietMoi);
        return "Thêm bài viết thành công";
    }

    public BaiViet suaBaiViet(String baiVietSuaJson) {
        BaiViet baiVietSua = GsonDate.gsonDate.fromJson(baiVietSuaJson, BaiViet.class);
        BaiViet baiVietCanSua = repoManager.baiVietRepo.findById(baiVietSua.getBaiVietId()).orElse(null);
        if (baiVietCanSua != null) {
            baiVietCanSua.setTenBaiViet(baiVietSua.getTenBaiViet());
            baiVietCanSua.setThoiGianTao(baiVietSua.getThoiGianTao());
            baiVietCanSua.setTenTacGia(baiVietSua.getTenTacGia());
            baiVietCanSua.setNoiDung(baiVietSua.getNoiDung());
            baiVietCanSua.setNoiDungNgan(baiVietSua.getNoiDungNgan());
            baiVietCanSua.setHinhAnh(baiVietSua.getHinhAnh());
            baiVietCanSua.setChuDe(baiVietSua.getChuDe());
            baiVietCanSua.setTaiKhoan(baiVietSua.getTaiKhoan());

            repoManager.baiVietRepo.save(baiVietCanSua);
        }
        return baiVietCanSua;
    }

    public String xoaBaiViet(int idXoa) {
        BaiViet baiVietXoa = repoManager.baiVietRepo.findById(idXoa).orElse(null);
        if (baiVietXoa == null) {
            return "Không tồn tại bài viết cần xóa";
        }
        repoManager.baiVietRepo.delete(baiVietXoa);
        return "Xóa bài viết thành công";
    }

    @Override
    public Page<BaiViet> timKiemTheoTen(String tenTimKiem, Pageable pageable) {
        List<BaiViet> result = new ArrayList<>();
        List<BaiViet> baiVietAll = repoManager.baiVietRepo.findAll();
        for (BaiViet bv : baiVietAll
        ) {
            if (bv.getTenBaiViet().toLowerCase().contains(tenTimKiem.toLowerCase())) {
                result.add(bv);
            }
        }
        return new PageImpl<>(result, pageable, result.size());
    }
}
