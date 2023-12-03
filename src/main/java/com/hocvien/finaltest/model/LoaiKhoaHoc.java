package com.hocvien.finaltest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "loaikhoahoc")
public class LoaiKhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "loaikhoahocid")
    private int loaiKhoaHocId;
    @Column(name = "tenloai")
    private String tenLoai;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "loaiKhoaHoc",cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<KhoaHoc> khoaHocs;
}
