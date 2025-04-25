import java.util.Scanner;

public class Main25 {
    static Scanner scanner25 = new Scanner(System.in);
    static Penilaian25[] daftarPenilaian25 = new Penilaian25[100];
    static int jumlahData25 = 0;

    public static void main(String[] args) {
        int pilihan25;
        do {
            System.out.println("\n=== MENU SIAKAD ===");
            System.out.println("1. Input Data Mahasiswa dan Nilai");
            System.out.println("2. Tampilkan Daftar Mahasiswa");
            System.out.println("3. Tampilkan Daftar Mata Kuliah");
            System.out.println("4. Tampilkan Penilaian");
            System.out.println("5. Urutkan Mahasiswa berdasarkan Nama (Selection Sort) Ascending dan Descending");
            System.out.println("6. Urutkan Mahasiswa berdasarkan Nilai Akhir (Insertion Sort) Ascending dan Descending");
            System.out.println("7. Cari Mahasiswa Berdasarkan Nama (Binary Search)");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");
            pilihan25 = scanner25.nextInt(); scanner25.nextLine();

            switch (pilihan25) {
                case 1: inputData25(); break;
                case 2: tampilDaftarMahasiswa25(); break;
                case 3: tampilDaftarMataKuliah25(); break;
                case 4: tampilPenilaian25(); break;
                case 5: urutkanNamaMahasiswa25(); break;
                case 6: urutkanNilaiAkhirMahasiswa25(); break;
                case 7: binarySearchNama25(); break;
                case 0: System.out.println("Keluar..."); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan25 != 0);
    }

    static void inputData25() {
        System.out.print("Masukkan jumlah mahasiswa: ");
        int mhsCount25 = scanner25.nextInt(); scanner25.nextLine();

        for (int i = 0; i < mhsCount25; i++) {
            System.out.println("\nMahasiswa ke-" + (i+1));
            System.out.print("NIM: ");
            String nim25 = scanner25.nextLine();
            System.out.print("Nama: ");
            String nama25 = scanner25.nextLine();
            System.out.print("Prodi: ");
            String prodi25 = scanner25.nextLine();

            Mahasiswa25 mhs25 = new Mahasiswa25(nim25, nama25, prodi25);

            System.out.print("Jumlah mata kuliah yang diambil: ");
            int mkCount25 = scanner25.nextInt(); scanner25.nextLine();

            for (int j = 0; j < mkCount25; j++) {
                System.out.println("Mata kuliah ke-" + (j+1));
                System.out.print("Kode MK: ");
                String kodeMK25 = scanner25.nextLine();
                System.out.print("Nama MK: ");
                String namaMK25 = scanner25.nextLine();
                System.out.print("SKS: ");
                int sks25 = scanner25.nextInt(); scanner25.nextLine();

                MataKuliah25 mk25 = new MataKuliah25(kodeMK25, namaMK25, sks25);

                System.out.print("Nilai Tugas: ");
                double tugas25 = scanner25.nextDouble();
                System.out.print("Nilai UTS: ");
                double uts25 = scanner25.nextDouble();
                System.out.print("Nilai UAS: ");
                double uas25 = scanner25.nextDouble();
                scanner25.nextLine();

                Penilaian25 p25 = new Penilaian25(mhs25, mk25, tugas25, uts25, uas25);
                daftarPenilaian25[jumlahData25++] = p25;
            }
        }
    }

    static void tampilDaftarMahasiswa25() {
        System.out.println("\n=== Daftar Mahasiswa ===");
        for (int i = 0; i < jumlahData25; i++) {
            System.out.println("NIM: " + daftarPenilaian25[i].mahasiswa25.nim25 +
                               ", Nama: " + daftarPenilaian25[i].mahasiswa25.nama25);
        }
    }

    static void tampilDaftarMataKuliah25() {
        System.out.println("\n=== Daftar Mata Kuliah ===");
        for (int i = 0; i < jumlahData25; i++) {
            System.out.println("Kode MK: " + daftarPenilaian25[i].matakuliah25.kodeMK25 +
                               ", Nama MK: " + daftarPenilaian25[i].matakuliah25.namaMK25);
        }
    }

    static void tampilPenilaian25() {
        for (int i = 0; i < jumlahData25; i++) {
            daftarPenilaian25[i].tampilPenilaian25();
            System.out.println();
        }
    }

    static void urutkanNamaMahasiswa25() {
        System.out.println("\nPilih urutan: ");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        int pilihan25 = scanner25.nextInt(); scanner25.nextLine();

        if (pilihan25 == 1) {
            selectionSortNama25(true);
        } else if (pilihan25 == 2) {
            selectionSortNama25(false);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    static void urutkanNilaiAkhirMahasiswa25() {
        System.out.println("\nPilih urutan: ");
        System.out.println("1. Ascending");
        System.out.println("2. Descending");
        int pilihan25 = scanner25.nextInt(); scanner25.nextLine();

        if (pilihan25 == 1) {
            insertionSortNilai25(true);
        } else if (pilihan25 == 2) {
            insertionSortNilai25(false);
        } else {
            System.out.println("Pilihan tidak valid.");
        }
    }

    static void selectionSortNama25(boolean ascending) {
        for (int i = 0; i < jumlahData25 - 1; i++) {
            int idxMin25 = i;
            for (int j = i + 1; j < jumlahData25; j++) {
                if (ascending) {
                    if (daftarPenilaian25[j].mahasiswa25.nama25.compareToIgnoreCase(daftarPenilaian25[idxMin25].mahasiswa25.nama25) < 0) {
                        idxMin25 = j;
                    }
                } else {
                    if (daftarPenilaian25[j].mahasiswa25.nama25.compareToIgnoreCase(daftarPenilaian25[idxMin25].mahasiswa25.nama25) > 0) {
                        idxMin25 = j;
                    }
                }
            }
            Penilaian25 temp = daftarPenilaian25[i];
            daftarPenilaian25[i] = daftarPenilaian25[idxMin25];
            daftarPenilaian25[idxMin25] = temp;
        }
        System.out.println("\n=== Setelah diurutkan berdasarkan Nama (Ascending/Descending) ===");
        tampilPenilaian25();
    }

    static void insertionSortNilai25(boolean ascending) {
        for (int i = 1; i < jumlahData25; i++) {
            Penilaian25 key = daftarPenilaian25[i];
            int j = i - 1;
            if (ascending) {
                while (j >= 0 && daftarPenilaian25[j].nilaiAkhir25 > key.nilaiAkhir25) {
                    daftarPenilaian25[j + 1] = daftarPenilaian25[j];
                    j--;
                }
            } else {
                while (j >= 0 && daftarPenilaian25[j].nilaiAkhir25 < key.nilaiAkhir25) {
                    daftarPenilaian25[j + 1] = daftarPenilaian25[j];
                    j--;
                }
            }
            daftarPenilaian25[j + 1] = key;
        }
        System.out.println("\n=== Setelah diurutkan berdasarkan Nilai Akhir (Ascending/Descending) ===");
        tampilPenilaian25();
    }

    static void binarySearchNama25() {
        selectionSortNama25(true);
        System.out.print("\nMasukkan nama yang dicari: ");
        String cariNama25 = scanner25.nextLine();

        boolean found = false;
        double totalNilai = 0;
        int jumlah = 0;

        for (int i = 0; i < jumlahData25; i++) {
            if (daftarPenilaian25[i].mahasiswa25.nama25.equalsIgnoreCase(cariNama25)) {
                if (!found) {
                    System.out.println("Data ditemukan di index ke-" + i);
                    System.out.println("NIM: " + daftarPenilaian25[i].mahasiswa25.nim25 +
                                       ", Nama: " + daftarPenilaian25[i].mahasiswa25.nama25);
                }
                System.out.print("Mata Kuliah: " + daftarPenilaian25[i].matakuliah25.namaMK25 + ", ");
                System.out.print("Tugas: " + daftarPenilaian25[i].tugas25 + ", ");
                System.out.print("UTS: " + daftarPenilaian25[i].uts25 + ", ");
                System.out.print("UAS: " + daftarPenilaian25[i].uas25 + ", ");
                System.out.println("Nilai Akhir: " + daftarPenilaian25[i].nilaiAkhir25);

                totalNilai += daftarPenilaian25[i].nilaiAkhir25;
                jumlah++;
                found = true;
            }
        }

        if (found) {
            System.out.printf("Rata-rata Nilai Akhir: %.1f\n", totalNilai / jumlah);
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }
}
