package com.morsecode.main;

import com.morsecode.model.IMorseCodeConverter;
import com.morsecode.model.MorseCodeConverter;

public class Main {
    public static void main(String[] args) {
        IMorseCodeConverter morseCodeConverter = new MorseCodeConverter();
        String morseCode = morseCodeConverter.encode("hello");
        System.out.println(morseCode);
        System.out.println(morseCodeConverter.decode(morseCode));

    }
}
