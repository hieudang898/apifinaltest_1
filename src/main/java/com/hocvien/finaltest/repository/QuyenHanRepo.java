package com.hocvien.finaltest.repository;

import com.hocvien.finaltest.model.QuyenHan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuyenHanRepo extends JpaRepository<QuyenHan,Integer> {
}
