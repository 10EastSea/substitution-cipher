import java.security.SecureRandom;
import java.util.Date;

public class EncryptionCipher extends Cipher {
    // 1. Encryption when there's a key => make encryptedMsg
    public EncryptionCipher(String key, String msg) throws Exception {
        this.key = key.toLowerCase();
        this.msg = msg;

        keyMapping();
        makeEncryptedMsg();
    }

    // 2. Encryption when there's not a key => create random key && make encryptedMsg
    public EncryptionCipher(String msg) throws Exception {
        createRandomKey();
        this.msg = msg;

        keyMapping();
        makeEncryptedMsg();
    }

    private void makeEncryptedMsg() {
        StringBuilder sb = new StringBuilder();
        
        char[] msgArr = msg.toCharArray();
        for(char c: msgArr) {
            if(!Character.isLetter(c)) sb.append(c);
            else if(Character.isLowerCase(c)) sb.append(keyMap.get(c));
            else {
                c = Character.toLowerCase(c);
                c = keyMap.get(c);
                sb.append(Character.toUpperCase(c));
            }
        }

        encryptedMsg = sb.toString();
    }

    private void createRandomKey() {
        StringBuilder sb = new StringBuilder();

        SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());

        // create key...

        key = "msnuecripzbdafghjkltqvwxyo";
    }
}