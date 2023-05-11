package Referensi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class kegiatan1 {
    static HashMap<String, String> tabelData = new HashMap<String, String>();
    //String nimPraktikan;
    String namaAsisten;
    static String praktikan;
    static String asisten;
    static Scanner p = new Scanner(System.in);
    static Scanner a = new Scanner(System.in);

    public boolean tambahData(String nimPraktikan, String namaAsisten) {
        // Syarat nimPraktikan hanya bisa diinputkan jika terdapat kata "IF"
        if (!nimPraktikan.contains("IF")) {
            System.out.println("NIM praktikan tidak valid!");
            return false;
        }

        // Cek apakah nimPraktikan sudah terdaftar di dalam dataPraktikan
        if (tabelData.containsKey(nimPraktikan)) {
            System.out.println("NIM praktikan sudah terdaftar!");
            return false;
        }

        // Jika nimPraktikan belum terdaftar, tambahkan ke dalam dataPraktikan
        tabelData.put(nimPraktikan, namaAsisten);
        System.out.println("Data praktikan berhasil ditambahkan!");
        return true;
    }

    public void tampil() {
        System.out.println("Data praktikan yang berhasil diinputkan:");
        for (String nim : tabelData.keySet()) {
            String namaAsisten = tabelData.get(nim);
            System.out.println(nim + " - " + namaAsisten);
        }
    }

    public void listNimPraktikan() {
        System.out.println("List NIM praktikan:");
        for (String nim : tabelData.keySet()) {
            System.out.println(nim);
        }
    }

    public void listNamaAsisten() {
        System.out.println("List nama asisten:");
        for (String nim : tabelData.keySet()) {
            String namaAsisten = tabelData.get(nim);
            System.out.println(namaAsisten);
        }
    }

    public static int totalEmail() {
        return tabelData.size();
    }

    public boolean hapusData(String nimPraktikan, String namaAsisten) {
        if (tabelData.containsKey(nimPraktikan) && tabelData.get(nimPraktikan).equals(namaAsisten)) {
            tabelData.remove(nimPraktikan);
            System.out.println("NIM berhasil dihapus");
            return true;
        }
        System.out.println("NIM gagal dihapus");
        return false;
    }

    public void editData(String nimPraktikan) {
        Scanner as = new Scanner(System.in);
        System.out.println("Data yang ingin diubah");
        System.out.print("NIM: ");
        nimPraktikan = p.next();
        System.out.print("Nama asisten: ");
        namaAsisten = a.next();
        if (tabelData.containsKey(nimPraktikan))
        {
            System.out.print("Masukan NIM baru: ");
            String newNim = as.nextLine();
            System.out.print("Masukkan nama asisten baru: ");
            String aslab = as.nextLine();
            tabelData.put(newNim, tabelData.remove(nimPraktikan));
            tabelData.replace(newNim, aslab);
            System.out.println("Data berhasil diupdate!");
        } else {
            System.out.println("NIM praktikan tidak ditemukan!");
        }
    }

    public boolean cariDataAsisten(String namaAsisten) {
        boolean ditemukan = false;
        for (Map.Entry<String, String> entry : tabelData.entrySet()) {
            if (entry.getValue().equals(namaAsisten)) {
                System.out.println("NIM Praktikan: " + entry.getKey());
                ditemukan = true;
            }
        }
        return ditemukan;
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        kegiatan1 dataPraktikan = new kegiatan1();

        int choice;
        char N;
        do {
            System.out.println("MENU");
            System.out.println("1. Input data");
            System.out.println("2. Tampilkan data keseluruhan");
            System.out.println("3. Tampilkan list praktikan");
            System.out.println("4. Tampilkan list asisten");
            System.out.println("5. Tampilkan data total panjang hashmap");
            System.out.println("6. Edit data praktikan");
            System.out.println("7. Delete data praktikan");
            System.out.println("8. Cari data asisten");
            System.out.print("Pilih opsi:  ");
            choice = in.nextInt();


            switch (choice) {
                case 1 -> {
                    System.out.print("Masukkan NIM praktikan: ");
                    praktikan = p.next();
                    System.out.print("Masukkan nama asisten: ");
                    asisten = a.next();
                    dataPraktikan.tambahData(praktikan, asisten);
                }
                case 2 -> {
                    dataPraktikan.tampil();
                }
                case 3 -> {
                    dataPraktikan.listNimPraktikan();
                }
                case 4 -> {
                    dataPraktikan.listNamaAsisten();
                }
                case 5 -> {
                    System.out.println("Total data yang berhasil diinput: " + totalEmail());
                }
                case 6 -> {
                    dataPraktikan.editData(praktikan);
                }
                case 7 -> {
                    System.out.print("Masukkan NIM yang ingin dihapus: ");
                    praktikan = p.next();
                    System.out.print("Masukkan nama asisten: ");
                    asisten = p.next();
                    dataPraktikan.hapusData(praktikan,asisten);
                }
                case 8 -> {
                    System.out.print("Masukkan nama asisten: ");
                    asisten = a.next();
                    dataPraktikan.cariDataAsisten(asisten);
                }
                default -> System.out.println("Opsi tidak ada");
            }
            System.out.println();
            System.out.print("Pilih opsi lain (Y/N): ");
            N = in.next().charAt(0);
            System.out.println();
        } while (N != 'n');
        System.out.println("Terima Kasih");
    }

}
