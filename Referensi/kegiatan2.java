package Referensi;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class kegiatan2 {
    private Map<String, String> tabelData;
    private Map<String, String> tabelSesiLogin;

    public kegiatan2() {
        tabelData = new HashMap<>();
        tabelSesiLogin = new HashMap<>();
    }

    public void tambahData(String nim, String namaAsisten) {
        tabelData.put(nim, namaAsisten);
    }

    public void hapusData(String nim) {
        tabelData.remove(nim);
    }

    public boolean cariData(String namaAsisten) {
        boolean ditemukan = false;
        for (Map.Entry<String, String> entry : tabelData.entrySet()) {
            if (entry.getValue().equals(namaAsisten)) {
                System.out.println(entry.getKey());
                ditemukan = true;
            }
        }
        return ditemukan;
    }

    public void login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Masukkan email: ");
        String email = scanner.nextLine();
        System.out.print("Masukkan password: ");
        String password = scanner.nextLine();

        if (tabelSesiLogin.containsKey(email) && tabelSesiLogin.get(email).equals(password)) {
            if (email.endsWith("@umm.ac.id")) {
                System.out.println("Login berhasil");
                tampilkanFitur();
            } else {
                System.out.println("Email harus menggunakan domain @umm.ac.id");
            }
        } else {
            System.out.println("Gagal Login");
        }
    }

    public void logout() {
        System.out.println("Logout berhasil");
    }

    private void tampilkanFitur() {
        System.out.println("\nMENU");
        System.out.println("1. Tambah data praktikan");
        System.out.println("2. Hapus data praktikan");
        System.out.println("3. Cari data praktikan");
        System.out.println("4. Logout");
        System.out.print("Pilih opsi:  ");

        Scanner scanner = new Scanner(System.in);
        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1:
                System.out.print("Masukkan NIM praktikan: ");
                String nim = scanner.nextLine();
                System.out.print("Masukkan nama asisten: ");
                String namaAsisten = scanner.nextLine();
                tambahData(nim, namaAsisten);
                System.out.println("Data berhasil ditambahkan");
                tampilkanFitur();
                break;
            case 2:
                System.out.print("Masukkan NIM praktikan: ");
                nim = scanner.nextLine();
                hapusData(nim);
                System.out.println("Data berhasil dihapus");
                tampilkanFitur();
                break;
            case 3:
                System.out.print("Masukkan nama asisten: ");
                namaAsisten = scanner.nextLine();
                if (!cariData(namaAsisten)) {
                    System.out.println("Data tidak ditemukan");
                }
                tampilkanFitur();
                break;
            case 4:
                logout();
                break;
            default:
                System.out.println("Pilihan tidak valid");
                tampilkanFitur();
                break;
        }
    }

    public static void main(String[] args) {
        kegiatan2 dataPraktikan = new kegiatan2();
        dataPraktikan.tabelSesiLogin.put("lusy@umm.ac.id", "p");

        dataPraktikan.login();
    }
}