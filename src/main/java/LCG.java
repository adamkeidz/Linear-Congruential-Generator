public class LCG {
    static class Lcg {
        private final long modulus;
        private final int multiplier;
        private final int increment;
        private long seed;

        public Lcg(long modulus, int multiplier, int increment, long seed) {
            this.modulus = modulus;
            this.multiplier = multiplier;
            this.increment = increment;
            this.seed = seed;
        }

        public long next() {
            long val = (multiplier * seed) + increment;
            seed = val % modulus;
            return seed;
        }
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static long getNthPrimeFromLcg(Lcg lcg, int n) {
        int count = 0;
        while (true) {
            long number = lcg.next();
            if (isPrime((int) number)) {
                count++;
                if (count == n) {
                    return number;
                }
            }
        }
    }

    public static String encrypt(String plainText) throws Exception {
        Lcg lcg = new Lcg(256, 11, 1, 0);
        byte[] bytes = plainText.getBytes("UTF-8");
        int len = bytes.length;
        byte[] xors = new byte[len];
        for (int ix = 0; ix < len; ix += 1) {
            xors[ix] = (byte) ((int) bytes[ix] ^ ((int) lcg.next()));
        }
        return new String(java.util.Base64.getEncoder().encode(xors), "UTF-8");
    }

    public static String decrypt(String base64EncodedValue) throws Exception {
        Lcg lcg = new Lcg(256, 11, 1, 0);
        byte[] bytes = java.util.Base64.getDecoder().decode(base64EncodedValue.getBytes("UTF-8"));
        int len = bytes.length;
        byte[] decryptions = new byte[len];
        for (int ix = 0; ix < len; ix += 1) {
            decryptions[ix] = (byte) ((int) bytes[ix] ^ ((int) lcg.next()));
        }
        return new String(decryptions, "UTF-8");
    }

    public static void main(String[] args) throws Exception {
        Lcg lcg = new Lcg(65536, 137, 1, 0);
        System.out.println("The 100th prime number in the LCG sequence is: " + getNthPrimeFromLcg(lcg, 100));

        String text = "Hello, world!";
        String encrypted = encrypt(text);
        String decrypted = decrypt(encrypted);

        System.out.println("Original text: " + text);
        System.out.println("Encrypted text: " + encrypted);
        System.out.println("Decrypted text: " + decrypted);
    }
}
