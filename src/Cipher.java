import java.util.HashMap;

public abstract class Cipher {
    protected String msg, key;
    protected String encryptedMsg;
    protected HashMap<Character, Character> keyMap = new HashMap<Character, Character>();

    protected void keyMapping() throws Exception {
        if(key.length() != 26) throw new Exception();
        
        char[] alphabetArr = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        char[] keyArr = key.toCharArray();
        for(int i=0; i<26; i++) { keyMap.put(alphabetArr[i], keyArr[i]); }
    }

    public String getMsg() { return msg; }
    public String getKey() { return key; }
    public String getEncryptedMsg() { return encryptedMsg; }
}
