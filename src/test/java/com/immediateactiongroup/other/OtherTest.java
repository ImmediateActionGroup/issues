package com.immediateactiongroup.other;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by beishan on 2017/7/24.
 */
public class OtherTest {

    public void test() {
        Map<String, String> map = new HashMap<>();
    }

    @Test
    public void testBin() throws Exception{
        int num = -3;
        printBin(num);
        int num2 = 3;
        printBin(num2);

        System.out.println("----------------");

        num = num << 1;
        num2 = num2 << 1;

        printBin(num);
        printBin(num2);
    }

    private void printBin(int num){
        System.out.println(Integer.toBinaryString(num));
    }
}
