package com.hocvien.finaltest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "taikhoan")
public class TaiKhoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taikhoanid")
    private int taiKhoanId;
    @Column(name = "tennguoidung")
    private String tenNguoiDung;
    @Column(name = "taikhoan")
    private String taiKhoan;
    @Column(name = "matkhau")
    private String matKhau;
    @ManyToOne
    @JoinColumn(name = "quyenhanid", referencedColumnName = "quyenhanid")
    @JsonBackReference
    private QuyenHan quyenHan;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "taiKhoan")
    @JsonManagedReference
    private List<BaiViet> baiViets;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "taiKhoanDangKy")
    private List<DangKyHoc> dangKyHocs;
}
