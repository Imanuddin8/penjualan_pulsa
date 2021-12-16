/**
 *
 * @author LENOVO
 */
import java.util.Scanner;

public class Konsol {
    Pulsa pulsa;
    
    public Konsol() {
        this.pulsa = new Pulsa();
        
        Scanner in = new Scanner(System.in);
        while (true) {
            
            System.out.println("Nama Provider:");
            String namaProvider = in.nextLine();
            if (namaProvider.isEmpty()) {
                System.out.println("Error: Tidak boleh kosong!");
                continue;
            }
            if (!pulsa.cekProvider(namaProvider)) {
                System.out.println("Warning: Nama provider salah!");
                continue;
            }
          
            System.out.println("Nomor Ponsel:");
            String nomorPonsel = in.nextLine();
            if (nomorPonsel.isEmpty()) {
                System.out.println("Error: Tidak boleh kosong!");
                continue;
            }
            if (!pulsa.cekNomorPonsel(nomorPonsel)) {
                System.out.println("Warning: Format nomor ponsel salah!");
                continue;
            }
            
            System.out.println("Nominal Pulsa:");
            String nominalPulsa = in.nextLine();
            if (nominalPulsa.isEmpty()) {
                System.out.println("Error: Tidak boleh kosong!");
                continue;
            }
            if (!pulsa.cekNominal(nominalPulsa)) {
                System.out.println("Warning: Nominal pulsa harus "
                        + "5000,10000,25000,50000,100000");
                continue;
            }

            pulsa.listPenjualanPulsa.add(new Pembeli(namaProvider, nomorPonsel, nominalPulsa));

            cetakDaftarPembeli();
        }
    }

    /**
     * Mencetak semua daftar pembeli dalam bentuk tabel pada konsol.
     * Contoh:
     * +------------------+------------------+----------+
     * | NAMA PROVIDER    | NOMOR PONSEL     | NOMINAL  |
     * +------------------+------------------+----------+
     * | Telkomsel        | 081274839143     | 10000    |
     * | XL               | 087564737253     | 25000    |
     * +------------------+------------------+----------+
     */
    public void cetakDaftarPembeli() {
        String garis = "+------------------+---------------+----------+%n";
        String format = "| %-16s | %-13s | %-8s |%n";
        System.out.format(garis);
        System.out.format(format, "NAMA PROVIDER", "NOMOR PONSEL", "NOMINAL");
        System.out.format(garis);
        for (Pembeli p : pulsa.listPenjualanPulsa) {
            System.out.format(format, p.namaProvider, p.nomorPonsel, p.nominalPulsa);
        }
        System.out.format(garis);
        System.out.println("");
    }
}
