package com.hocvien.finaltest.service.cservice;


import com.hocvien.finaltest.model.HocVien;
import com.hocvien.finaltest.model.KhoaHoc;
import com.hocvien.finaltest.repository.repomanager.RepoManager;
import com.hocvien.finaltest.service.iservice.IKhoaHocService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KhoaHocService implements IKhoaHocService {

    @Autowired
    private RepoManager repoManager;

    private void capNhat() {
        List<KhoaHoc> khoaHocs = repoManager.khoaHocRepo.findAll();
        for (KhoaHoc kh : khoaHocs
        ) {
            int soHocVienCapNhat = repoManager.khoaHocRepo.demSoHocVien(kh.getKhoaHocId());
            kh.setSoHocVien(soHocVienCapNhat);
            repoManager.khoaHocRepo.save(kh);
        }
    }

    public Page<KhoaHoc> hienThiDanhSachKhoaHoc(Pageable pageable) {
        capNhat();
        return repoManager.khoaHocRepo.findAll(pageable);

    }

    public String themKhoaHoc(KhoaHoc khoaHocMoi) {
        repoManager.khoaHocRepo.save(khoaHocMoi);
        return "Thêm khóa học thành công";
    }

    public void xoaKhoaHoc(int idXoa) {
        repoManager.khoaHocRepo.deleteById(idXoa);
    }

    public KhoaHoc suaKhoaHoc(int idSua, KhoaHoc khoaHocMoi) {
        Optional<KhoaHoc> khoaHocOptional = repoManager.khoaHocRepo.findById(idSua);
        if (khoaHocOptional.isPresent()) {
            KhoaHoc khoaHocCanSua = khoaHocOptional.get();
            khoaHocCanSua.setTenKhoaHoc(khoaHocMoi.getTenKhoaHoc());
            khoaHocCanSua.setThoiGianHoc(khoaHocMoi.getThoiGianHoc());
            khoaHocCanSua.setGioiThieu(khoaHocMoi.getGioiThieu());
            khoaHocCanSua.setNoiDung(khoaHocMoi.getNoiDung());
            khoaHocCanSua.setHocPhi(khoaHocMoi.getHocPhi());
            khoaHocCanSua.setSoLuongMon(khoaHocMoi.getSoLuongMon());
            khoaHocCanSua.setHinhAnh(khoaHocMoi.getHinhAnh());
            khoaHocCanSua.setLoaiKhoaHoc(khoaHocMoi.getLoaiKhoaHoc());
            repoManager.khoaHocRepo.save(khoaHocCanSua);
            return khoaHocCanSua;
        }
        return null;
    }

    public Page<KhoaHoc> timKiemTheoTen(String tenTimKiem, Pageable pageable) {
        List<KhoaHoc> danhSachKhoaHoc = repoManager.khoaHocRepo.findAll();
        List<KhoaHoc> searchResult = filterKhoaHocByName(danhSachKhoaHoc, tenTimKiem);
        return new PageImpl<>(searchResult, pageable, searchResult.size());
    }

    private List<KhoaHoc> filterKhoaHocByName(List<KhoaHoc> danhSachKhoaHoc, String tenTimKiem) {
        String finalTenTimKiem = tenTimKiem;
        return danhSachKhoaHoc.stream()
                .filter(kh -> kh.getTenKhoaHoc().toLowerCase().contains(tenTimKiem.toLowerCase()))
                .toList();
    }

}

