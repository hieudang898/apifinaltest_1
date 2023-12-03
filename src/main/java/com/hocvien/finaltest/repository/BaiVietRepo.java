package com.hocvien.finaltest.repository;

import com.hocvien.finaltest.model.BaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BaiVietRepo extends JpaRepository<BaiViet,Integer> {
}
