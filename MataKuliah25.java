public class MataKuliah25 {
    String kodeMK25;
    String namaMK25;
    int sks25;

    public MataKuliah25(String kodeMK25, String namaMK25, int sks25) {
        this.kodeMK25 = kodeMK25;
        this.namaMK25 = namaMK25;
        this.sks25 = sks25;
    }

    public void tampilMatakuliah25() {
        System.out.println("Kode MK : " + kodeMK25);
        System.out.println("Nama MK : " + namaMK25);
        System.out.println("SKS : " + sks25);
    }
}
