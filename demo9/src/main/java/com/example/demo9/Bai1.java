package com.example.demo9;

public class Bai1 {
    public int tongHam(int [] arr){
        if(arr == null||arr.length == 0){
            throw new IllegalArgumentException("Mang khong duoc de trong");
        }
        int sum = 0;
        for(int i: arr){
            if (i>=1&&i<=1000){
                sum += i;
            }else{
                throw new IllegalArgumentException("Mang khong duoc nam ngoai khoang tu 1-1000");
            }
        }
        return sum;
    }
}
