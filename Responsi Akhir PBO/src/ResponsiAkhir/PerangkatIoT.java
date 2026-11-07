package ResponsiAkhir;

public abstract class PerangkatIoT {

    private String id;
    private String nama;
    private final String nomorSeri;
    private boolean aktif;

    public PerangkatIoT(String id, String nama, String nomorSeri) {
        this(id, nama, nomorSeri, true);
    }

    public PerangkatIoT(String id, String nama, String nomorSeri,
                        boolean aktif) {
        this.id = id;
        this.nama = nama;
        this.nomorSeri = nomorSeri;
        this.aktif = aktif;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNomorSeri() {
        return nomorSeri;
    }

    public boolean isAktif() {
        return aktif;
    }

    public void setAktif(boolean aktif) {
        this.aktif = aktif;
    }

    public void tampilkanInfo() {
        System.out.println("ID Perangkat : " + this.id);
        System.out.println("Nama         : " + this.nama);
        System.out.println("Nomor Seri   : " + this.nomorSeri);
        System.out.println("Status       : " +
                (this.aktif ? "Aktif" : "Nonaktif"));
    }

    public abstract void prosesDataSensor(double intensitasCahaya);

}