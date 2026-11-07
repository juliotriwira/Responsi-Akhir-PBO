package ResponsiAkhir;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        LampuPintar lampu = new LampuPintar(
                "L001", "Lampu Ruang Tamu", "LP001", 80
        );

        SensorCahaya sensor = new SensorCahaya(
                "S001", "Sensor Cahaya Ruangan", "SC001"
        );

        PerangkatDapatDikendalikan kontrol = lampu;
        PemantauEnergi monitor = lampu;

        int pilihan;

        do {

            System.out.println("\n================================");
            System.out.println("     SMART LIGHTING SYSTEM");
            System.out.println("================================");
            System.out.println("1. Nyalakan Lampu");
            System.out.println("2. Matikan Lampu");
            System.out.println("3. Atur Kecerahan Lampu");
            System.out.println("4. Simulasi Sensor Cahaya");
            System.out.println("5. Tampilkan Informasi Perangkat");
            System.out.println("6. Hitung Konsumsi Energi");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            pilihan = input.nextInt();

            switch (pilihan) {

                case 1:
                    kontrol.nyalakanLampu();
                    break;

                case 2:
                    kontrol.matikanLampu();
                    break;

                case 3:
                    System.out.print("Masukkan kecerahan (0-100): ");
                    int tingkat = input.nextInt();
                    kontrol.aturKecerahan(tingkat);
                    break;

                case 4:
                    System.out.print(
                            "Masukkan intensitas cahaya (lux): "
                    );
                    double intensitas = input.nextDouble();
                    sensor.prosesDataSensor(intensitas);
                    lampu.prosesDataSensor(
                            sensor.getIntensitasCahaya()
                    );
                    break;

                case 5:
                    System.out.println("\n--- INFORMASI LAMPU ---");
                    lampu.tampilkanInfo();

                    System.out.println("\n--- INFORMASI SENSOR ---");
                    sensor.tampilkanInfo();
                    break;

                case 6:
                    System.out.print(
                            "Masukkan durasi penggunaan (jam): "
                    );
                    double durasi = input.nextDouble();
                    lampu.setDurasiPenggunaan(durasi);
                    monitor.tampilkanKonsumsiEnergi();
                    break;

                case 0:
                    System.out.println(
                            "Terima kasih telah menggunakan sistem."
                    );
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        } while (pilihan != 0);
        input.close();
    }
}