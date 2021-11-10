public class DecryptionCipher extends Cipher {
    // 1. Decryption when there's a key => make msg
    public DecryptionCipher(String key, String encryptedMsg) throws KeyException {
        this.key = key.toLowerCase();
        keyMapping("decryption");

        this.encryptedMsg = encryptedMsg;
        this.msg = makeMsg();
    }

    // 2. Decryption when there's not a key => find key (break cipher) && make msg
    public DecryptionCipher(String encryptedMsg) throws KeyException {
        this.key = Break.findKey(msg);
        keyMapping("decryption");

        this.encryptedMsg = encryptedMsg;
        this.msg = makeMsg();
    }

    private String makeMsg() {
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

        return sb.toString();
    }
}
