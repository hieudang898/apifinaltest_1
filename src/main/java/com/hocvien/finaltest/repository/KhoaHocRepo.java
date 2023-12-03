package com.hocvien.finaltest.repository;

import com.hocvien.finaltest.model.KhoaHoc;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface KhoaHocRepo extends JpaRepository<KhoaHoc, Integer> {
    @Query(value = "SELECT COUNT(*) FROM DangKyHoc d WHERE (select tentinhtrang from tinhtranghoc tth where tth.tinhtranghocid=d.tinhtranghocid)  IN ('Đang học chính', 'Chờ duyệt') AND d.khoaHocId= :khoaHocId", nativeQuery = true)
    public int demSoHocVien(int khoaHocId);
}
