package crc16;

import java.util.Scanner;

public class CRC16 {

    public static int stdPoly = 0xA001;
    public static int initialValue = 0xFFFF;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("quelle chaine d'octets (en hexa) pour le calcul du crc16");
        String trame = sc.nextLine();

        byte[] octets = formatage(trame);
        int crc16 = calculCrc16(octets, initialValue, stdPoly);

        System.out.printf("le CRC16=%d (0x%04X)%n", crc16, crc16);
    }

    static int calculCrc16(byte[] octets, int valeurInitiale, int polynome) {
        int crc = valeurInitiale;

        for (byte b : octets) {
            crc ^= (b & 0xFF);

            for (int i = 0; i < 8; i++) {
                if ((crc & 0x0001) != 0) {
                    crc = (crc >> 1) ^ polynome;
                } else {
                    crc = (crc >> 1);
                }
            }
            crc &= 0xFFFF;
        }

        return crc;
    }

    static byte[] hexStringEnByteArray(String message) {
        int len = message.length();
        byte[] data = new byte[len / 2];

        for (int i = 0; i < len; i += 2) {
            int ms = Character.digit(message.charAt(i), 16);
            int ls = Character.digit(message.charAt(i + 1), 16);
            data[i / 2] = (byte) ((ms << 4) + ls);
        }
        return data;
    }

    static byte[] formatage(String trame) {
        String msg = trame.replaceAll("\\s+", "").replace("0x", "").replace("0X", "");

        if (msg.length() % 2 != 0) {
            throw new IllegalArgumentException("La trame hexa doit avoir un nombre pair de caracteres.");
        }

        return hexStringEnByteArray(msg);
    }
}

