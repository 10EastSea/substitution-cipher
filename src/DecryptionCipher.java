public class DecryptionCipher extends Cipher {
    // 1. Decryption when there's a key => make msg
    public DecryptionCipher(String key, String encryptedMsg) throws Exception {
        this.key = key.toLowerCase();
        this.encryptedMsg = encryptedMsg;

        keyMapping("decryption");
        makeMsg();
    }

    // 2. Decryption when there's not a key => find key (break cipher) && make msg
    public DecryptionCipher(String encryptedMsg) {
        
        this.encryptedMsg = encryptedMsg;
    }

    private void makeMsg() {
        StringBuilder sb = new StringBuilder();
        
        char[] encryptedMsgArr = encryptedMsg.toCharArray();
        for(char c: encryptedMsgArr) {
            if(!Character.isLetter(c)) sb.append(c);
            else if(Character.isLowerCase(c)) sb.append(keyMap.get(c));
            else {
                c = Character.toLowerCase(c);
                c = keyMap.get(c);
                sb.append(Character.toUpperCase(c));
            }
        }

        msg = sb.toString();
    }
}
