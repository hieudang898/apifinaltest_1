package com.hocvien.finaltest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@Table(name = "dangkyhoc")

public class DangKyHoc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "ngaydangky")
    private LocalDate ngayDangKy;
    @Column(name = "ngaybatdau")
    private LocalDate ngayBatDau;
    @Column(name = "ngayketthuc")
    private LocalDate ngayKetThuc;

    @ManyToOne
    @JoinColumn(name = "khoahocid", referencedColumnName = "khoahocid")
    @JsonBackReference
    private KhoaHoc khoaHoc;

    @ManyToOne
    @JoinColumn(name = "hocvienid", referencedColumnName = "hocvienid")
    @JsonBackReference
    private HocVien hocVien;

    @ManyToOne
    @JoinColumn(name = "tinhtranghocid", referencedColumnName = "tinhtranghocid")
    @JsonBackReference
    private TinhTrangHoc tinhTrangHoc;

    @ManyToOne
    @JoinColumn(name = "taikhoanid", referencedColumnName = "taikhoanid")
    @JsonBackReference
    private TaiKhoan taiKhoanDangKy;

}
