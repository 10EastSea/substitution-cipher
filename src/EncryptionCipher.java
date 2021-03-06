import java.security.SecureRandom;
import java.util.Date;

public class EncryptionCipher extends Cipher {
    // 1. Encryption when there's a key => make encryptedMsg
    public EncryptionCipher(String key, String msg) throws KeyException {
        this.key = key.toLowerCase();
        keyMapping("encryption");
        
        this.msg = msg;
        this.encryptedMsg = makeEncryptedMsg();
    }

    // 2. Encryption when there's not a key => create random key && make encryptedMsg
    public EncryptionCipher(String msg) throws KeyException {
        this.key = createRandomKey();
        keyMapping("encryption");
        
        this.msg = msg;
        this.encryptedMsg = makeEncryptedMsg();
    }

    private String makeEncryptedMsg() {
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

        return sb.toString();
    }

    private String createRandomKey() {
        StringBuilder sb = new StringBuilder();

        SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());

        for(int i=0; i<26; ) {
            char c = (char) (sr.nextInt(26) + 'a');
            
            if(sb.toString().contains(c + "")) continue;
            else {
                sb.append(c);
                i++;
            }
        }

        return sb.toString();
    }
}
