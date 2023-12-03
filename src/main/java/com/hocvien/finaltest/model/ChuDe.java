package com.hocvien.finaltest.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity
@Setter
@Getter
@Table(name = "chude")
public class ChuDe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "chudeid")
    private int chuDeId;
    @Column(name = "tenchude")
    private String tenChuDe;
    @Column(name = "noidung")
    private String noiDung;
    @ManyToOne
    @JoinColumn(name = "loaibaivietid",referencedColumnName = "loaibaivietid")
    @JsonBackReference
    private LoaiBaiViet loaiBaiViet;

}
