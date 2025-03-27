import java.util.Scanner;

public class CRC16 {
    public static int stdPoly = 0xA001;
    public static int initialValue = 0xffff;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Entre la trame hexadécimale : ");
        String trameHex = scanner.nextLine();
        byte[] trameOctets = hexStringEnByteArray(trameHex);
        int crc16 = calculCrc16(trameOctets, 0xFFFF, stdPoly);
        System.out.println("CRC16 = " + crc16);

    }
    public static int calculCrc16(byte[] octets, int valeurInitiale, int polynome) {
        int crc = valeurInitiale;
        return crc;

    }
    public static byte[] hexStringEnByteArray(String trameHex) {
        int len = trameHex.length();
        byte[] octets = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {

            octets[i / 2] = (byte) ((Character.digit(trameHex.charAt(i), 16) << 4)

                    + Character.digit(trameHex.charAt(i + 1), 16));

        }
        return octets;

    }
}