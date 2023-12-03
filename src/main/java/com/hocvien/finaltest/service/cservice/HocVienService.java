package com.hocvien.finaltest.service.cservice;

import com.hocvien.finaltest.model.HocVien;
import com.hocvien.finaltest.repository.repomanager.RepoManager;
import com.hocvien.finaltest.service.cservice.svmanager.GsonDate;
import com.hocvien.finaltest.service.iservice.IHocVienService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class HocVienService implements IHocVienService {
    private String dinhDangTen(String name) {
        String nameTrimed = name.trim().toLowerCase();
        String result = "";
        while (nameTrimed.contains("  ")) {
            nameTrimed = nameTrimed.replace("  ", " ");
        }
        String[] arrName = nameTrimed.split(" ");
        for (String s : arrName
        ) {
            result += s.substring(0, 1).toUpperCase() + s.substring(1) + " ";
        }
        return result.trim();
    }

    @Autowired
    private RepoManager repoManager;

    public Page<HocVien> hienThiDanhSachHocVien(Pageable pageable) {
        return repoManager.hocVienRepo.findAll(pageable);
    }

    public String themHocVien(String hocVienMoiJson) {
        HocVien hocVienMoi= GsonDate.gsonDate.fromJson(hocVienMoiJson, HocVien.class);
        List<HocVien> danhSachHocVien=repoManager.hocVienRepo.findAll();
        hocVienMoi.setHoTen(dinhDangTen(hocVienMoi.getHoTen()));
        for (HocVien hv:danhSachHocVien
             ) {
            if (hv.getSdt().equals(hocVienMoi.getSdt())||hv.getEmail().equals(hocVienMoi.getEmail())){
                return "tên hoặc email đã tồn tại";
            }
        }
         repoManager.hocVienRepo.save(hocVienMoi);
        return "thêm học viên thành công";
    }

    public void xoaHocVien(int idXoa) {
        repoManager.hocVienRepo.deleteById(idXoa);
    }

    public HocVien suaHocVien(int idSua, HocVien hocVienMoi) {
        Optional<HocVien> hocVienOptional = repoManager.hocVienRepo.findById(idSua);
        if (hocVienOptional.isPresent()) {
            HocVien hocVienCanSua = hocVienOptional.get();
            hocVienCanSua.setHoTen(hocVienMoi.getHoTen());
            hocVienCanSua.setNgaySinh(hocVienMoi.getNgaySinh());
            hocVienCanSua.setSdt(hocVienMoi.getSdt());
            hocVienCanSua.setEmail(hocVienMoi.getEmail());
            hocVienCanSua.setTinhThanh(hocVienMoi.getTinhThanh());
            hocVienCanSua.setQuanHuyen(hocVienMoi.getQuanHuyen());
            hocVienCanSua.setPhuongXa(hocVienMoi.getPhuongXa());
            hocVienCanSua.setSoNha(hocVienMoi.getSoNha());
            return repoManager.hocVienRepo.save(hocVienCanSua);
        }
        return null;
    }

    @Override
    public Page<HocVien> timKimTheoTen(String name, Pageable pageable) {
        List<HocVien> danhSachHocVien=repoManager.hocVienRepo.findAll();
        List<HocVien> searchResult= new ArrayList<>();
        for (HocVien hv :danhSachHocVien
             ) {
            if (hv.getHoTen().contains(name)||hv.getEmail().contains(name)){
                searchResult.add(hv);
            }
        }
        return new PageImpl<>(searchResult, pageable,searchResult.size());
    }
}

