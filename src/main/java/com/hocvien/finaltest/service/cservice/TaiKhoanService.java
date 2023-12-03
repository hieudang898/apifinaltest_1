package com.hocvien.finaltest.service.cservice;

import com.hocvien.finaltest.model.TaiKhoan;
import com.hocvien.finaltest.repository.repomanager.RepoManager;
import com.hocvien.finaltest.service.iservice.ITaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TaiKhoanService implements ITaiKhoanService {
    @Autowired
    private RepoManager repoManager;

    @Override
    public Page<TaiKhoan> hienThiDanhSachTaiKhoan(Pageable pageable) {
        return repoManager.taiKhoanRepo.findAll(pageable);
    }

    @Override
    public TaiKhoan themTaiKhoan(TaiKhoan taiKhoanMoi) {
        return repoManager.taiKhoanRepo.save(taiKhoanMoi);
    }

    @Override
    public void xoaTaiKhoan(int idXoa) {
        repoManager.taiKhoanRepo.deleteById(idXoa);

    }

    @Override
    public Page<TaiKhoan> timKiemTheoTen(String tenTimKiem, Pageable pageable) {
//        List<TaiKhoan> taiKhoans = repoManager.taiKhoanRepo.findAll();
//        List<TaiKhoan> result = new ArrayList<>();
//        for (TaiKhoan tk : taiKhoans
//        ) {
//            if (tk.getTaiKhoan().toLowerCase().contains(tenTimKiem.toLowerCase())) {
//                result.add(tk);
//            }
//
//        }
//        return new PageImpl<>(result, pageable, result.size());
        return repoManager.taiKhoanRepo.findTaiKhoanByTaiKhoanContainingIgnoreCase(tenTimKiem, pageable);
    }

    @Override
    public TaiKhoan suaTaiKhoan(int idSua, TaiKhoan taiKhoanMoi) {
        Optional<TaiKhoan> taiKhoanOptional = repoManager.taiKhoanRepo.findById(idSua);
        if (taiKhoanOptional.isPresent()) {
            TaiKhoan taiKhoanCanSua = taiKhoanOptional.get();
            taiKhoanCanSua.setTaiKhoan(taiKhoanMoi.getTaiKhoan());
            taiKhoanCanSua.setMatKhau(taiKhoanMoi.getMatKhau());
            taiKhoanCanSua.setTenNguoiDung(taiKhoanMoi.getTenNguoiDung());
            taiKhoanCanSua.setQuyenHan(taiKhoanMoi.getQuyenHan());
            return repoManager.taiKhoanRepo.save(taiKhoanCanSua);
        }
        return null;
    }
}
