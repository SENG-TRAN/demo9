package com.example.demo9;

import java.util.ArrayList;
import java.util.List;

public class SinhVienSevice {
    List<SinhVien> list = new ArrayList<SinhVien>();
    public void addSinhVien(SinhVien sv){
        validateSV(sv);
        list.add(sv);
    }

    public void updateSinhVien( SinhVien sinhVien,String maSV){
        for(SinhVien sv : list){
            if (sv.getMaSV().trim().equals(maSV.trim())){
                validateSV(sinhVien);
                sv.setTenSV(sinhVien.getTenSV());//truyền tên sinh viên mới
                sv.setDiemTB(sinhVien.getDiemTB());
                sv.setTuoi(sinhVien.getTuoi());
                sv.setKyHoc(sinhVien.getKyHoc());
                return;
            }
        }
        throw new IllegalArgumentException("Khong tim thay sinh vien");
    }

    private void validateSV(SinhVien sv) {
        if(sv.getMaSV()== null || sv.getMaSV().trim().isEmpty()){
            throw new IllegalArgumentException("Ma SV không được rỗng");
        }
        if(sv.getTenSV()== null || sv.getTenSV().trim().isEmpty()){
            throw new IllegalArgumentException("Tên không được rỗng");
        }
        if (sv.getDiemTB()<0||sv.getDiemTB()>10){
            throw new IllegalArgumentException("Không được nằm ngoài khoảng tu 0-10");
        }
        if (sv.getTuoi()<0||sv.getTuoi()>100){
            throw new IllegalArgumentException("Tuoi khong nam ngoai khoang tu 0-100");
        }
        if (sv.getKyHoc()<1||sv.getKyHoc()>6){
            throw new IllegalArgumentException("Ky hoc khong nam ngoai khoang tu 1-6");
        }
    }
}
