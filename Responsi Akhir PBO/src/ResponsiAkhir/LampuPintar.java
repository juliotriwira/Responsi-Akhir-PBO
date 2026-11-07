package ResponsiAkhir;

public class LampuPintar extends PerangkatIoT
        implements PerangkatDapatDikendalikan, PemantauEnergi {

    private boolean menyala;
    private int kecerahan;
    private double durasiPenggunaan;

    public LampuPintar(String id, String nama, String nomorSeri) {
        super(id, nama, nomorSeri);
        this.menyala = false;
        this.kecerahan = 0;
        this.durasiPenggunaan = 0;
    }

    public LampuPintar(String id, String nama, String nomorSeri,
                       int kecerahan) {
        super(id, nama, nomorSeri, true);
        this.menyala = false;
        this.kecerahan = kecerahan;
        this.durasiPenggunaan = 0;
    }

    public boolean isMenyala() {
        return menyala;
    }

    public void setMenyala(boolean menyala) {
        this.menyala = menyala;
    }

    public int getKecerahan() {
        return kecerahan;
    }

    public void setKecerahan(int kecerahan) {
        if (kecerahan >= 0 && kecerahan <= 100) {
            this.kecerahan = kecerahan;
        } else {
            System.out.println("Kecerahan harus 0-100%!");
        }
    }

    public double getDurasiPenggunaan() {
        return durasiPenggunaan;
    }

    public void setDurasiPenggunaan(double durasiPenggunaan) {
        if (durasiPenggunaan >= 0) {
            this.durasiPenggunaan = durasiPenggunaan;
        }
    }

    @Override
    public void nyalakanLampu() {
        if (isAktif()) {
            this.menyala = true;

            if (this.kecerahan == 0) {
                this.kecerahan = 100;
            }

            System.out.println("Lampu berhasil dinyalakan.");
        } else {
            System.out.println("Perangkat sedang nonaktif.");
        }
    }

    @Override
    public void matikanLampu() {
        this.menyala = false;
        System.out.println("Lampu berhasil dimatikan.");
    }

    @Override
    public void aturKecerahan(int kecerahan) {
        if (kecerahan >= 0 && kecerahan <= 100) {
            this.kecerahan = kecerahan;

            if (kecerahan == 0) {
                this.menyala = false;
            } else {
                this.menyala = true;
            }

            System.out.println("Kecerahan lampu diatur menjadi "
                    + kecerahan + "%.");
        } else {
            System.out.println("Kecerahan harus antara 0-100%.");
        }
    }

    @Override
    public double hitungKonsumsiEnergi() {
        if (!this.menyala) {
            return 0;
        }

        return (KonfigurasiIoT.DAYA_MAKSIMAL
                * this.kecerahan / 100.0)
                * this.durasiPenggunaan;
    }

    @Override
    public void tampilkanKonsumsiEnergi() {
        System.out.println("Konsumsi Energi : "
                + hitungKonsumsiEnergi() + " Wh");
    }

    @Override
    public void prosesDataSensor(double intensitasCahaya) {

        System.out.println("\nMemproses data sensor cahaya...");

        if (isAktif()
                && intensitasCahaya < KonfigurasiIoT.BATAS_CAHAYA) {

            System.out.println("Ruangan gelap. Lampu otomatis menyala.");
            nyalakanLampu();

        } else {

            System.out.println("Ruangan terang atau perangkat nonaktif.");
            matikanLampu();

        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();

        System.out.println("Kondisi Lampu : "
                + (this.menyala ? "Menyala" : "Mati"));

        System.out.println("Kecerahan     : "
                + this.kecerahan + "%");
    }

}