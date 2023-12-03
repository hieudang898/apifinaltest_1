package com.hocvien.finaltest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
@Getter
@Table(name = "baiviet")
public class BaiViet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "baivietid")
    @NotNull
    private int baiVietId;
    @Column(name = "tenbaiviet")
    @NotNull
    private String tenBaiViet;
    @Column(name = "thoigiantao")
    @NotNull
    private LocalDate thoiGianTao;
    @Column(name = "tentacgia")
    @NotNull
    private String tenTacGia;
    @Column(name = "noidung")
    @NotNull
    private String noiDung;
    @Column(name = "noidungngan")
    @NotNull
    private String noiDungNgan;
    @Column(name = "hinhanh")
    private String hinhAnh;

    @ManyToOne
    @JoinColumn(name = "chudeid", referencedColumnName = "chudeid")
    @JsonBackReference
    private ChuDe chuDe;
    @ManyToOne
    @JoinColumn(name = "taikhoanid", referencedColumnName = "taikhoanid")
    @JsonBackReference
    private TaiKhoan taiKhoan;


}
