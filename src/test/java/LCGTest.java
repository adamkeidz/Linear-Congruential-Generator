import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LCGTest {
    private LCG.Lcg lcg;

    @BeforeEach
    public void setUp() {
        lcg = new LCG.Lcg(65536, 137, 1, 0);
    }

    @Test
    public void testPrimeNumberGeneration() {
        long prime = LCG.getNthPrimeFromLcg(lcg, 100);
        long expectedPrime = 62311;
        Assertions.assertEquals(expectedPrime, prime, "100th Prime number generated incorrectly");
    }

    @Test
    public void testEncryptionDecryption() throws Exception {
        String plainText = "Hello, world!";
        String encryptedText = LCG.encrypt(plainText);
        String decryptedText = LCG.decrypt(encryptedText);
        Assertions.assertEquals(plainText, decryptedText, "Decryption does not match original text");
    }
}
