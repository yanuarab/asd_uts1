public class Penilaian25 {
    Mahasiswa25 mahasiswa25;
    MataKuliah25 mataKuliah25;
    double nilaiTugas25;
    double nilaiUTS25;
    double nilaiUAS25;
    double nilaiAkhir25;

    public Penilaian25(Mahasiswa25 mahasiswa25, MataKuliah25 mataKuliah25, double tugas25, double uts25, double uas25) {
        this.mahasiswa25 = mahasiswa25;
        this.mataKuliah25 = mataKuliah25;
        this.nilaiTugas25 = tugas25;
        this.nilaiUTS25 = uts25;
        this.nilaiUAS25 = uas25;
        hitungNilaiAkhir25();
    }

    public void hitungNilaiAkhir25() {
        this.nilaiAkhir25 = (nilaiTugas25 * 0.3) + (nilaiUTS25 * 0.3) + (nilaiUAS25 * 0.4);
    }

    public void tampilPenilaian25() {
        mahasiswa25.tampilMahasiswa25();
        mataKuliah25.tampilMatakuliah25();
        System.out.println("Nilai Tugas : " + nilaiTugas25);
        System.out.println("Nilai UTS   : " + nilaiUTS25);
        System.out.println("Nilai UAS   : " + nilaiUAS25);
        System.out.println("Nilai Akhir : " + nilaiAkhir25);
    }
}
