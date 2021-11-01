import java.util.HashMap;

public abstract class Cipher {
    protected String msg, key;
    protected String encryptedMsg;
    protected HashMap<Character, Character> keyMap = new HashMap<Character, Character>();

    protected void keyMapping(String mode) throws Exception {
        if(key.length() != 26) throw new Exception();
        
        char[] alphabetArr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] keyArr = key.toCharArray();
        for(int i=0; i<26; i++) { 
            if(mode.equals("encryption")) keyMap.put(alphabetArr[i], keyArr[i]);
            else if(mode.equals("decryption")) keyMap.put(keyArr[i], alphabetArr[i]);
        }
    }

    public String getMsg() { return msg; }
    public String getKey() { return key; }
    public String getEncryptedMsg() { return encryptedMsg; }
}
