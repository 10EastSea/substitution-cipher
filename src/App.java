public class App {

    public static String msg = "ONe WAY tO SOLVe AN eNCRYPteD EeSSAGe, IF We KNOW ItS LANGUAGe, IS tO FIND A DIFFeReNt PLAINteXt OF tHe SAEe LANGUAGe LONG eNOUGH tO FILL ONe SHeet OR SO, AND tHeN We COUNt tHe OCCURReNCeS OF eACH LetteR. We CALL tHe EOSt FReQUeNtLY OCCURRING LetteR tHe 'FIRSt', tHe NeXt EOSt OCCURRING LetteR tHe 'SeCOND' tHe FOLLOWING EOSt OCCURRING LetteR tHe 'tHIRD', AND SO ON, UNtIL We ACCOUNt FOR ALL tHe DIFFeReNt LetteRS IN tHe PLAINteXt SAEPLe. tHeN We LOOK At tHe CIPHeR teXt We WANt tO SOLVe AND We ALSO CLASSIFY ItS SYEMOLS. We FIND tHe EOSt OCCURRING SYEMOL AND CHANGe It tO tHe FORE OF tHe 'FIRSt' LetteR OF tHe PLAINteXt SAEPLe, tHe NeXt EOSt COEEON SYEMOL IS CHANGeD tO tHe FORE OF tHe 'SeCOND' LetteR, AND tHe FOLLOWING EOSt COEEON SYEMOL IS CHANGeD tO tHe FORE OF tHe 'tHIRD' LetteR, AND SO ON, UNtIL We ACCOUNt FOR ALL SYEMOLS OF tHe CRYPtOGRAE We WANt tO SOLVe.";

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

    public static void main(String[] args) throws Exception {
        testEC1();
    }
}

// toLowerCase() mode
// toUpperCase() mode