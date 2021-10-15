import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;
import java.util.*;


public class Main
{
    public static void main(String args[])
    {
        if(args.length != 3) {
            System.out.println("파라미터가 잘못 입력됐습니다.(id password apikey)");
        }else{
            try{
                System.out.println(AES_Encode(args[0], "[abcdefghijklmnopqrstuvwxyz]2017"));
                System.out.println(AES_Encode(args[1], "[abcdefghijklmnopqrstuvwxyz]2017"));

            }catch (Exception e){
                e.printStackTrace();
            }

            String credentials = args[0] + ":" + args[2];
            String encodedCredentials = Base64.getEncoder().encodeToString(credentials.getBytes());
            System.out.println("Basic " + encodedCredentials);
        }

    }

    public static byte[] ivBytes = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
    public static String AES_Encode(String str, String key) throws Exception {

        byte[] textBytes = str.getBytes("UTF-8");
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        SecretKeySpec newKey = new SecretKeySpec(key.getBytes("UTF-8"), "AES");
        Cipher cipher = null;
        cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, newKey, ivSpec);

        return Base64.getEncoder().encodeToString(cipher.doFinal(textBytes));
    }


}