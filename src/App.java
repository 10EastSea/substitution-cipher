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
            DecryptionCipher dc = new DecryptionCipher(key, encryptedMsg);
            System.out.println(dc.getMsg());
        } catch (Exception e) { System.out.println("The key must be 26 digits"); }
    }

    public static void testDC2() {
        try {
            DecryptionCipher dc = new DecryptionCipher(encryptedMsg);
            System.out.println(dc.getMsg());
            System.out.println("(Key: " + dc.getKey() + ")");
        } catch (Exception e) { System.out.println("The key must be 26 digits"); }
    }

    public static void help(String msg) {
        System.out.println("\n" + msg + "\n");
        System.out.println("    -e <message> : Encrypt the message => {encrypted message}");
        System.out.println("                                          (Key: {key})");
        // System.out.println("    -d <message> : Decrypt the message => {decrypted message}"); // break cipher
        // System.out.println("                                          (Key: {key})");
        System.out.println("    -e-key <key> <message> : Encrypt the message using key => {encrypted message}");
        System.out.println("    -d-key <key> <message> : Decrypt the message using key => {decrypted message}");
        System.out.println();
        System.out.println("    -help : how to use it");
        System.out.println();
    }

    public static void main(String[] args) throws Exception {
        if(args.length < 1) { help("Please enter the [FLAG]\nThe following flag provides the values in { .. }"); return; }

        if(args[0].equals("-e")) {
            if(args.length < 2) { help("[-e]: Please enter the <message>"); return; }
            try {
                EncryptionCipher ec = new EncryptionCipher(args[1]);
                System.out.println(ec.getEncryptedMsg());
                System.out.println("(Key: " + ec.getKey() + ")");
            } catch(NullPointerException npe) { help("[-e]: This program only supports English"); return; }
        } else if(args[0].equals("-d")) {
            if(args.length < 2) { help("[-d]: Please enter the <message>"); return; }
            System.out.println("Sorry, this function is being prepared..");
        } else if(args[0].equals("-e-key")) {
            if(args.length < 3) { help("[-e-key]: Please enter the <key> and <message>"); return; }
            try {
                EncryptionCipher ec = new EncryptionCipher(args[1], args[2]);
                System.out.println(ec.getEncryptedMsg());
            }
            catch(NullPointerException npe) { help("[-e-key]: This program only supports English"); return; }
            catch(KeyException e) { help("[-e-key]: <key> must consist of 26 different alphabets (Length: 26)"); return; }
        } else if(args[0].equals("-d-key")) {
            if(args.length < 3) { help("[-d-key]: Please enter the <key> and <message>"); return; }
            try {
                DecryptionCipher dc = new DecryptionCipher(args[1], args[2]);
                System.out.println(dc.getMsg());
            }
            catch(NullPointerException npe) { help("[-d-key]: This program only supports English"); return; }
            catch(KeyException e) { help("[-d-key]: <key> must consist of 26 different alphabets (Length: 26)"); return; }
        }

        else if(args[0].equals("-help")) { help("Usage: java App [FALG]\nThe following flag provides the values in { .. }"); return; }
        else { help("This [FLAG] does not exist\nThe following flag provides the values in { .. }"); return; }
    }
}

// toLowerCase() mode
// toUpperCase() mode

// File IO version