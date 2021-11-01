public class App {

    public static String msg = "In cryptography, a substitution cipher is a method of encrypting in which units of plaintext are replaced with the ciphertext, in a defined manner, with the help of a key; the \"units\" may be single letters (the most common), pairs of letters, triplets of letters, mixtures of the above, and so forth. The receiver deciphers the text by performing the inverse substitution process to extract the original message.";
    
    public static void testWord() {
        Word word = new Word("apple");
        System.out.println(word.getIsValid());
    }

    public static void testEC1() {
        try {
            EncryptionCipher ec = new EncryptionCipher("msnuecripzbdafghjkltqvwxyo", msg);
            System.out.println(ec.getEncryptedMsg());
        } catch (Exception e) { System.out.println("The key must be 26 digits"); }
    }

    public static void testEC2() {
        try {
            EncryptionCipher ec = new EncryptionCipher(msg);
            System.out.println(ec.getEncryptedMsg());
            System.out.println("(Key: " + ec.getKey() + ")");
        } catch (Exception e) { System.out.println("The key must be 26 digits"); }
    }

    public static void main(String[] args) throws Exception {
        testEC2();
    }
}

// toLowerCase() mode
// toUpperCase() mode