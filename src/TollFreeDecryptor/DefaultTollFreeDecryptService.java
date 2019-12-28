package TollFreeDecryptor;

import java.util.HashMap;
import java.util.Map;

public class DefaultTollFreeDecryptService implements TollFreeDecryptService {

    static Map<Character, Integer> decoderMap = buildDecoderMap();

    public String decode(String fancyNumber) {
        System.out.println("Decoding...");
        StringBuilder decode = new StringBuilder();
        for (int i = 0; i < fancyNumber.length(); i++) {
            char c = fancyNumber.charAt(i);
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                decode.append(decoderMap.get(c));
                continue;
            }
            decode.append(c);
        }
        return decode.toString();
    }

    private static  Map<Character, Integer> buildDecoderMap() {
        Map<Character, Integer> decoderMap = new HashMap<>();
        int window = 3, counter = 0;
        int keypadNumber = 2;
        for (int i = 65; i <= 90; i++) {
            if (counter == window) {
                keypadNumber++;
                counter = 0;
            }
            char c = (char)i;
            if (c == 'P' || c == 'W') {
                counter -= 1;
            }
            decoderMap.put(c, keypadNumber);
            decoderMap.put((char)((c-65)+97), keypadNumber);
            counter++;
        }
        return decoderMap;
    }
}
