package service.impl;

import java.util.HashMap;

public interface ICaculatorService {
    public float add(float numberA, float numberB);
    public float sub(float numberA, float numberB);
    public float multi(float numberA, float numberB);
    public float div(float numberA, float numberB);
    public HashMap<String,String> validate(String text1, String text2);
}
