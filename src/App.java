public class App {

    public static String msg = "In cryptography, a substitution cipher is a method of encrypting in which units of plaintext are replaced with the ciphertext, in a defined manner, with the help of a key; the units may be single letters (the most common), pairs of letters, triplets of letters, mixtures of the above, and so forth. The receiver deciphers the text by performing the inverse substitution process to extract the original message.";
    public static String encryptedMsg = "Tv exiobqrxfoji, f pgdpbtbgbtqv etojyx tp f kybjqm qn yvexiobtvr tv ujtej gvtbp qn olftvbysb fxy xyolfeym utbj bjy etojyxbysb, tv f myntvym kfvvyx, utbj bjy jylo qn f hyi; bjy gvtbp kfi dy ptvrly lybbyxp (bjy kqpb eqkkqv), oftxp qn lybbyxp, bxtolybp qn lybbyxp, ktsbgxyp qn bjy fdqwy, fvm pq nqxbj. Bjy xyeytwyx myetojyxp bjy bysb di oyxnqxktvr bjy tvwyxpy pgdpbtbgbtqv oxqeypp bq ysbxfeb bjy qxtrtvfl kyppfry.";
    public static String key = "fdemynrjtahlkvqocxpbgwusiz";

    public static void testWord() {
        Word word = new Word("apple");
        System.out.println(word.getIsValid());
    }

    public static void testEC1() {
        try {
            EncryptionCipher ec = new EncryptionCipher(key, msg);
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

    public static void testDC1() {
        try {
            DecryptionCipher ec = new DecryptionCipher(key, encryptedMsg);
            System.out.println(ec.getMsg());
        } catch (Exception e) { System.out.println("The key must be 26 digits"); }
    }

    public static void main(String[] args) throws Exception {
        testDC1();
    }
}

// toLowerCase() mode
// toUpperCase() mode