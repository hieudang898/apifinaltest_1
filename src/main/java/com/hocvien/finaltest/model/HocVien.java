package com.hocvien.finaltest.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hocvien")
public class HocVien {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hocvienid")
    @NotNull
    private int hocVienId;
    @Column(name = "hoten")
    @NotNull
    private String hoTen;
    @Column(name = "ngaysinh")
    @NotNull
    private LocalDate ngaySinh;
    @Column(name = "sdt")
    @NotNull
    private String sdt;
    @Column(name = "email")
    @NotNull
    private String email;
    @Column(name = "tinhthanh")
    @NotNull
    private String tinhThanh;
    @Column(name = "quanhuyen")
    @NotNull
    private String quanHuyen;
    @Column(name = "phuongxa")
    @NotNull
    private String phuongXa;
    @Column(name = "sonha")
    @NotNull
    private int soNha;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "hocVien")
    @JsonManagedReference
    private List<DangKyHoc> dangKyHocs;

}
