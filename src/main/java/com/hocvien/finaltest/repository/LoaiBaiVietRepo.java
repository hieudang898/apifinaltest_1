package com.hocvien.finaltest.repository;

import com.hocvien.finaltest.model.LoaiBaiViet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaiBaiVietRepo extends JpaRepository<LoaiBaiViet,Integer> {
}
