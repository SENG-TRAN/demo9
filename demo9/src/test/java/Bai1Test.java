import com.example.demo9.Bai1;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Bai1Test {
    Bai1 bai1 = new Bai1();

    @Test
    void hopLe(){
        assertEquals(6,bai1.tongHam(new int[]{1,2,3}));
    }

    @Test
    void hopLe2(){
        assertEquals(13,bai1.tongHam(new int[]{6,7}));
    }

    @Test
    void Rong(){
        assertThrows(IllegalArgumentException.class, () -> {bai1.tongHam(null);});
    }

    @Test
    void MangAm(){
        assertThrows(IllegalArgumentException.class,()->{bai1.tongHam(new int []{-1,-2,-3});});
    }

    @Test
    void lonHon1000(){
        assertThrows(IllegalArgumentException.class,()->{bai1.tongHam(new int []{1500,2000});});
    }
}
