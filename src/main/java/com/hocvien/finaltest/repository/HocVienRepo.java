package com.hocvien.finaltest.repository;

import com.hocvien.finaltest.model.HocVien;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocVienRepo extends JpaRepository<HocVien,Integer> {
}
