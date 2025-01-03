package com.morsecode.model;

/**
 * IMorseCodeConverter provides an interface for converting between plain text and Morse code.
 * Implementing classes should provide the functionality to encode text into Morse code and decode
 * Morse code back into text.
 */
public interface IMorseCodeConverter {

    /**
     * Converts a given text message into its equivalent Morse code representation.
     *
     * @param text The text message to be converted into Morse code.
     * @return A string representing the Morse code of the input text.
     */
    String encode(String text);

    /**
     * Converts a given Morse code message back into its plain text representation.
     *
     * @param morseCode The Morse code message to be converted into plain text.
     * @return A string representing the plain text of the input Morse code.
     */
    String decode(String morseCode);
}
