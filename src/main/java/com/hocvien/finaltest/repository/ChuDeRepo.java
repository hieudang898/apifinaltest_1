package com.hocvien.finaltest.repository;

import com.hocvien.finaltest.model.ChuDe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChuDeRepo extends JpaRepository<ChuDe,Integer> {
}
