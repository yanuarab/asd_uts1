public class Penilaian25 {
    Mahasiswa25 mahasiswa25;
    MataKuliah25 matakuliah25;
    double tugas25, uts25, uas25, nilaiAkhir25;

    public Penilaian25(Mahasiswa25 mahasiswa25, MataKuliah25 matakuliah25, double tugas25, double uts25, double uas25) {
        this.mahasiswa25 = mahasiswa25;
        this.matakuliah25 = matakuliah25;
        this.tugas25 = tugas25;
        this.uts25 = uts25;
        this.uas25 = uas25;
        this.nilaiAkhir25 = (tugas25 * 0.3) + (uts25 * 0.3) + (uas25 * 0.4);
    }

    public void tampilPenilaian25() {
        System.out.println("Mahasiswa: " + mahasiswa25.nama25);
        System.out.println("NIM: " + mahasiswa25.nim25);
        System.out.println("Mata Kuliah: " + matakuliah25.namaMK25);
        System.out.println("Tugas: " + tugas25 + ", UTS: " + uts25 + ", UAS: " + uas25 + ", Nilai Akhir: " + nilaiAkhir25);
    }
}
