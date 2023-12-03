package com.hocvien.finaltest.repository;

import com.hocvien.finaltest.model.TaiKhoan;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaiKhoanRepo extends JpaRepository<TaiKhoan,Integer> {
    public Page<TaiKhoan> findTaiKhoanByTaiKhoanContainingIgnoreCase(String tenTimKiem, Pageable pageable);
}
