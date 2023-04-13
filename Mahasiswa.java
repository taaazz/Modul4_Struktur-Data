import java.util.HashMap;
import java.util.Scanner;

public class Mahasiswa {
    String nama, kelas, matkulPraktikum;
    int nim;

    public Mahasiswa(String nm, String kl, String mat, int ni){
        nama = nm;
        kelas = kl;
        matkulPraktikum = mat;
        nim  = ni;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        HashMap<String, Mahasiswa> mhs = new HashMap<>();
        String input;
        Mahasiswa data;


        mhs.put("1", new Mahasiswa("putri", "3H", "struktur data", 370311090));
        mhs.put("2", new Mahasiswa("putra", "3A", "Diskrit", 370311099));
        mhs.put("3", new Mahasiswa("dila", "3c", "basis data", 370311098));

        System.out.println("Masukan ID : ");
        input= in.nextLine();
        data = mhs.get(input);
        if(data != null){
            System.out.println("Data Mahasiswa : "+ data.nama + ", kelas : "+ data.kelas +
                    ", mata kuliah praktikum : " +  data.matkulPraktikum + ", nim :" + data.nim);
        }
    }
}


