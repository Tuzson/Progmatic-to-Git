package AES_practice;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.GCMParameterSpec;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Base64;


public class EncryptorAesGcmPasswordFile {
    private static final String ENCRYPT_ALGO = "AES/GCM/NoPadding";

    private static final int TAG_LENGTH_BIT = 128;
    private static final int IV_LENGTH_BYTE = 12;
    private static final int SALT_LENGTH_BYTE = 16;
    private static final Charset UTF_8 = StandardCharsets.UTF_8;

    public static byte[] encrypt(byte[] pText, String password) throws Exception{

        byte[] salt = CryptoUtils.getRandomNonce(SALT_LENGTH_BYTE);

        byte[] iv = CryptoUtils.getRandomNonce(IV_LENGTH_BYTE);

        SecretKey aesKeyFromPassword = CryptoUtils.getAESKeyFromPassword(password.toCharArray(),salt);

        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);

        cipher.init(Cipher.ENCRYPT_MODE,aesKeyFromPassword,new GCMParameterSpec(TAG_LENGTH_BIT,iv));

        byte[] cipherText = cipher.doFinal(pText);

        byte[] cipherTextWithIvSalt = ByteBuffer.allocate(iv.length + salt.length + cipherText.length)
                .put(iv)
                .put(salt)
                .put(cipherText)
                .array();

        return cipherTextWithIvSalt;
    }

    public static void encryptFile (String fromFile, String toFile, String password) throws  Exception{

        byte[] fileContent = Files.readAllBytes(Paths.get(ClassLoader.getSystemResource(fromFile).toURI()));

        byte[] encryptedText = EncryptorAesGcmPasswordFile.encrypt(fileContent,password);

        Path path = Paths.get(toFile);

        Files.write(path,encryptedText);
    }
//    public static byte[] decrypt (byte[] cText, String password) throws Exception{
//
//        byte[] decode = Base64.getDecoder().decode(cText.getBytes(UTF_8));
//
//        ByteBuffer bb = ByteBuffer.wrap(decode);
//
//        byte[] iv = new byte[IV_LENGTH_BYTE];
//        bb.get(iv);
//
//        byte[] salt = new byte[SALT_LENGTH_BYTE];
//        bb.get(salt);
//
//        byte[] cipherText = new byte[bb.remaining()];
//        bb.get(cipherText);
//
//        SecretKey aesKeyFromPassword = CryptoUtils.getAESKeyFromPassword(password.toCharArray(),salt);
//
//        Cipher cipher = Cipher.getInstance(ENCRYPT_ALGO);
//
//        cipher.init(Cipher.DECRYPT_MODE,aesKeyFromPassword,new GCMParameterSpec(TAG_LENGTH_BIT,iv));
//
//        byte[] plainText = cipher.doFinal(cipherText);
//
//        return plainText;
//    }

//    public static byte[] decryptFile(String fromEncryptedFile, String password) throws Exception {
//
//        byte[] fileContent = Files.readAllBytes(Paths.get(fromEncryptedFile));
//
//        return EncryptorAesGcmPasswordFile.decrypt(fileContent, password);
//    }

    }
