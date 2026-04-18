import com.example.demo9.SinhVien;
import com.example.demo9.SinhVienSevice;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SinhVienTest {
    SinhVienSevice sevice = new SinhVienSevice();
    @Test
    void updateThanhCong(){
        SinhVien sv = new SinhVien("SV1","Tung",10,2.1f,5);
        sevice.addSinhVien(sv);
        SinhVien newSV = new SinhVien("SV1","Seng",9,6.1f,4);
        sevice.updateSinhVien(newSV,"SV1");
        assertEquals("Seng",sv.getTenSV());
        assertEquals(9,sv.getTuoi());
        assertEquals(6.1f,sv.getDiemTB());
        assertEquals(4,sv.getKyHoc());
    }

    @Test
    void updateTenRong(){
        SinhVien sinhVien = new SinhVien("SV1","Tung",10,2.1f,5);
        sevice.addSinhVien(sinhVien);
        SinhVien newSV = new SinhVien("SV1","",9,6.1f,4);
        assertThrows(IllegalArgumentException.class,()->sevice.updateSinhVien(newSV,"SV1"));
    }
}
