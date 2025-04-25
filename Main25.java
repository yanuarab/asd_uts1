import java.util.Scanner;

public class Main25 {
    static Scanner scanner25 = new Scanner(System.in);
    static Mahasiswa25[] daftarMahasiswa25 = new Mahasiswa25[100];
    static MataKuliah25[] daftarMataKuliah25 = new MataKuliah25[100];
    static Penilaian25[] daftarPenilaian25 = new Penilaian25[100];
    static int jumlahData25 = 0;

    public static void main(String[] args) {
        int pilihan25;
        do {
            System.out.println("\n=== MENU SIAKAD 25 ===");
            System.out.println("1. Input Data Mahasiswa dan Nilai");
            System.out.println("2. Tampilkan Daftar Mahasiswa");
            System.out.println("3. Tampilkan Daftar Mata Kuliah");
            System.out.println("4. Tampilkan Penilaian");
            System.out.println("5. Urutkan Mahasiswa berdasarkan Nama (Selection Sort)");
            System.out.println("6. Urutkan Mahasiswa berdasarkan Nilai Akhir (Insertion Sort)");
            System.out.println("7. Cari Mahasiswa berdasarkan Nama (Binary Search)");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");
            pilihan25 = scanner25.nextInt(); scanner25.nextLine();

            switch (pilihan25) {
                case 1: inputData25(); break;
                case 2: tampilMahasiswa25(); break;
                case 3: tampilMatakuliah25(); break;
                case 4: tampilPenilaian25(); break;
                case 5: selectionSortNama25(); break;
                case 6: insertionSortNilai25(); break;
                case 7: binarySearchNama25(); break;
                case 0: System.out.println("Keluar..."); break;
                default: System.out.println("Pilihan tidak valid.");
            }
        } while (pilihan25 != 0);
    }

    static void inputData25() {
        System.out.print("Masukkan jumlah data: ");
        int n25 = scanner25.nextInt(); scanner25.nextLine();

        for (int i = 0; i < n25; i++) {
            System.out.println("\nData ke-" + (i+1));
            System.out.print("NIM: "); String nim25 = scanner25.nextLine();
            System.out.print("Nama: "); String nama25 = scanner25.nextLine();
            System.out.print("Prodi: "); String prodi25 = scanner25.nextLine();
            Mahasiswa25 mhs25 = new Mahasiswa25(nim25, nama25, prodi25);
            daftarMahasiswa25[jumlahData25] = mhs25;

            System.out.print("Kode MK: "); String kodeMK25 = scanner25.nextLine();
            System.out.print("Nama MK: "); String namaMK25 = scanner25.nextLine();
            System.out.print("SKS: "); int sks25 = scanner25.nextInt(); scanner25.nextLine();
            MataKuliah25 mk25 = new MataKuliah25(kodeMK25, namaMK25, sks25);
            daftarMataKuliah25[jumlahData25] = mk25;

            System.out.print("Nilai Tugas: "); double tugas25 = scanner25.nextDouble();
            System.out.print("Nilai UTS: "); double uts25 = scanner25.nextDouble();
            System.out.print("Nilai UAS: "); double uas25 = scanner25.nextDouble();
            scanner25.nextLine();

            Penilaian25 p25 = new Penilaian25(mhs25, mk25, tugas25, uts25, uas25);
            daftarPenilaian25[jumlahData25] = p25;

            jumlahData25++;
            
        }
    }

    static void tampilMahasiswa25() {
        System.out.println("\n=== Daftar Mahasiswa ===");
        for (int i = 0; i < jumlahData25; i++) {
            daftarMahasiswa25[i].tampilMahasiswa25();
        }
    }

    static void tampilMatakuliah25() {
        System.out.println("\n=== Daftar Mata Kuliah ===");
        for (int i = 0; i < jumlahData25; i++) {
            daftarMataKuliah25[i].tampilMatakuliah25();
        }
    }

    static void tampilPenilaian25() {
        System.out.println("\n=== Daftar Penilaian ===");
        for (int i = 0; i < jumlahData25; i++) {
            daftarPenilaian25[i].tampilPenilaian25();
            System.out.println();
        }
    }

    static void selectionSortNama25() {
        System.out.println("\n1. Ascending\n2. Descending");
        System.out.print("Pilih mode: ");
        int mode25 = scanner25.nextInt(); scanner25.nextLine();

        for (int i = 0; i < jumlahData25 - 1; i++) {
            int idx25 = i;
            for (int j = i + 1; j < jumlahData25; j++) {
                String n1 = daftarPenilaian25[j].mahasiswa25.nama25;
                String n2 = daftarPenilaian25[idx25].mahasiswa25.nama25;
                boolean condition25 = (mode25 == 1) ? n1.compareTo(n2) < 0 : n1.compareTo(n2) > 0;
                if (condition25) idx25 = j;
            }
            Penilaian25 temp25 = daftarPenilaian25[i];
            daftarPenilaian25[i] = daftarPenilaian25[idx25];
            daftarPenilaian25[idx25] = temp25;
        }

        tampilPenilaian25();
    }

    static void insertionSortNilai25() {
        System.out.println("\n1. Ascending\n2. Descending");
        System.out.print("Pilih mode: ");
        int mode25 = scanner25.nextInt(); scanner25.nextLine();

        for (int i = 1; i < jumlahData25; i++) {
            Penilaian25 key25 = daftarPenilaian25[i];
            int j = i - 1;

            while (j >= 0 && (
                (mode25 == 1 && daftarPenilaian25[j].nilaiAkhir25 > key25.nilaiAkhir25) ||
                (mode25 == 2 && daftarPenilaian25[j].nilaiAkhir25 < key25.nilaiAkhir25)
            )) {
                daftarPenilaian25[j + 1] = daftarPenilaian25[j];
                j--;
            }
            daftarPenilaian25[j + 1] = key25;
        }

        tampilPenilaian25();
    }

    static void binarySearchNama25() {
        selectionSortNama25(); // agar data urut

        System.out.print("\nMasukkan nama yang dicari: ");
        String target25 = scanner25.nextLine();

        int low25 = 0, high25 = jumlahData25 - 1;
        boolean found25 = false;

        while (low25 <= high25) {
            int mid25 = (low25 + high25) / 2;
            String namaMid25 = daftarPenilaian25[mid25].mahasiswa25.nama25;
            int cmp25 = target25.compareToIgnoreCase(namaMid25);

            if (cmp25 == 0) {
                System.out.println("Data ditemukan di index ke-" + mid25);
                daftarPenilaian25[mid25].tampilPenilaian25();
                found25 = true;
                break;
            } else if (cmp25 < 0) {
                high25 = mid25 - 1;
            } else {
                low25 = mid25 + 1;
            }
        }

        if (!found25) {
            System.out.println("Data tidak ada di database.");
        }
    }
}
