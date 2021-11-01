public class DecryptionCipher extends Cipher {
    // 1. Decryption when there's a key => make msg
    public DecryptionCipher(String key, String encryptedMsg) {
        this.key = key.toLowerCase();
        this.encryptedMsg = encryptedMsg;
    }

    // 2. Decryption when there's not a key => find key (break cipher) && make msg
    public DecryptionCipher(String encryptedMsg) {
        this.encryptedMsg = encryptedMsg;
    }


}
