# Linear Congruential Generator (LCG)
This repository contains a Java implementation of a Linear Congruential Generator (LCG), a type of pseudorandom number generator. The LCG is commonly used for generating a sequence of randomized numbers with a specified range.
## Features
1. **LCG**: The LCG class includes a constructor that sets the modulus, multiplier, increment, and seed parameters for the generator. The `next()` method is used to generate the next number in the sequence.
2. **Prime Number Generation**: The program includes a method `isPrime(int n)` that checks if a number is prime. It also includes a method `getNthPrimeFromLcg(Lcg lcg, int n)` that generates the nth prime number from the LCG sequence.
3. **Text Encryption and Decryption**: The program includes methods `encrypt(String plainText)` and `decrypt(String base64EncodedValue)` that use the LCG to encrypt and decrypt text strings.

## Usage
To use the LCG, create an instance of the LCG class with the desired parameters. The `next()` method can then be used to generate the next number in the sequence.

To find the nth prime number in the LCG sequence, use the `getNthPrimeFromLcg(Lcg lcg, int n)` method.

To encrypt a text string, use the `encrypt(String plainText)` method. The output will be a Base64 encoded string. To decrypt the encoded string, use the `decrypt(String base64EncodedValue)` method.

In the main method, an example usage of the LCG is shown. An instance of the LCG class is created, and the 100th prime number in the LCG sequence is found. A text string is then encrypted and decrypted.

## Example Output
```java
The 100th prime number in the LCG sequence is: 62311
Original text: Hello, world!
Encrypted text: U0dWdlkyZGxZV1JzYjJsa1BJQmpiR0ZqZEhKaFkzVnliR2xqYkc5aFpDQT0=
Decrypted text: Hello, world!
```
---
