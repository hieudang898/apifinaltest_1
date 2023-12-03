package com.hocvien.finaltest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "khoahoc")
public class KhoaHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "khoahocid")
    private int khoaHocId;
    @Column(name = "tenkhoahoc")
    private String tenKhoaHoc;
    @Column(name = "thoigianhoc")
    private int thoiGianHoc;
    @Column(name = "gioithieu")
    private String gioiThieu;
    @Column(name = "noidung")
    private String noiDung;
    @Column(name = "hocphi")
    private double hocPhi;
    @Column(name = "sohocivien")
    private int soHocVien;
    @Column(name = "soluongmon")
    private int soLuongMon;
    @Column(name = "hinhanh")
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "loaikhoahocid", referencedColumnName = "loaikhoahocid")
    @JsonBackReference
    private LoaiKhoaHoc loaiKhoaHoc;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "khoaHoc")
    private List<DangKyHoc> dangKyHocs;
}
