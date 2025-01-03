package com.morsecode.model;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * MorseCodeConverter helps in converting plain text to Morse code and vice versa.
 * It uses a file to load the mapping of characters to Morse code.
 *
 * Example:
 * A = .-
 * B = -...
 *
 * This class can encode a text message into Morse code and decode Morse code back to text.
 */
public class MorseCodeConverter implements IMorseCodeConverter {

    /**
     * Map to convert characters to Morse code.
     */
    Map<Character, String> encoderMap = new HashMap<>();

    /**
     * Map to convert Morse code to characters.
     */
    Map<String, Character> decoderMap = new HashMap<>();

    /**
     * Reads the Morse code mappings from a file and sets up the encoder and decoder maps.
     */
    public MorseCodeConverter() {
        String pathToMorseCodeMapping = "src/com/morsecode/resource/morseCode.txt";

        try {
            File morseCodeSource = new File(pathToMorseCodeMapping);
            Scanner scan = new Scanner(morseCodeSource);

            while (scan.hasNextLine()) {
                String line = scan.nextLine();

                if (line.isEmpty()) continue;

                String[] textToCode = line.split(" = ");

                encoderMap.put(textToCode[0].charAt(0), textToCode[1]);
                decoderMap.put(textToCode[1], textToCode[0].charAt(0));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        decoderMap.put("$", ' ');
    }

    /**
     * Converts a text message to Morse code.
     * The input text is converted to uppercase to ensure uniformity.
     * Words in the text are separated by a space and converted into Morse code.
     * Each character in a word is converted to its Morse code representation, separated by a single space.
     * Each word in Morse code is separated by three spaces.
     *
     * @param text The message to convert.
     * @return The Morse code representation of the input text.
     */
    @Override
    public String encode(String text) {
        text = text.toUpperCase();
        String ans = "";
        String[] words = text.split(" ");
        for (String word : words) {
            word = word.trim();
            if (word.isEmpty()) continue;

            for (char c : word.toCharArray()) {
                ans += encoderMap.get(c);
                ans += " ";
            }
            ans += "   ";
        }
        return ans.trim();
    }

    /**
     * Converts Morse code to a text message.
     * Words in the Morse code are separated by three spaces, which are replaced with a marker "$"
     * to distinguish them from single spaces used between characters.
     * Each Morse code sequence is split by spaces and converted back to a character using the decoder map.
     *
     * @param morseCode The Morse code to convert.
     * @return The decoded text representation of the Morse code.
     */
    @Override
    public String decode(String morseCode) {
        String text = "";
        morseCode = morseCode.replace("   ", " $ ");

        String[] characters = morseCode.split(" ");

        for (String character : characters) {
            if (character.isEmpty()) continue;
            text += decoderMap.get(character);
        }
        return text;
    }
}
