package ResponsiAkhir;

public class SensorCahaya extends PerangkatIoT {

    private double intensitasCahaya;
    private boolean kondisiGelap;

    public SensorCahaya(String id, String nama, String nomorSeri) {
        super(id, nama, nomorSeri);
        this.intensitasCahaya = 0;
        this.kondisiGelap = false;
    }

    public double getIntensitasCahaya() {
        return intensitasCahaya;
    }

    public void setIntensitasCahaya(double intensitasCahaya) {
        if (intensitasCahaya >= 0) {
            this.intensitasCahaya = intensitasCahaya;
        }
    }

    public boolean isKondisiGelap() {
        return kondisiGelap;
    }

    public void setKondisiGelap(boolean kondisiGelap) {
        this.kondisiGelap = kondisiGelap;
    }

    @Override
    public void prosesDataSensor(double intensitasCahaya) {
        this.intensitasCahaya = intensitasCahaya;
        if (intensitasCahaya < KonfigurasiIoT.BATAS_CAHAYA) {
            this.kondisiGelap = true;
            System.out.println("Sensor mendeteksi kondisi GELAP.");
        } else {
            this.kondisiGelap = false;
            System.out.println("Sensor mendeteksi kondisi TERANG.");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Intensitas Cahaya : "
                + this.intensitasCahaya + " lux");

        System.out.println("Kondisi Ruangan   : "
                + (this.kondisiGelap ? "Gelap" : "Terang"));
    }

}