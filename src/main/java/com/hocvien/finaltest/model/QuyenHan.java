package com.hocvien.finaltest.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Setter
@Getter
@Table(name = "quyenhan")
public class QuyenHan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "quyenhanid")
    private int quyenHanId;
    @Column(name = "tenquyenhan")
    private String tenQuyenHan;
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "quyenHan", cascade = CascadeType.ALL)
    private List<TaiKhoan> taiKhoans;
}
