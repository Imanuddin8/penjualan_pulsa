/**
 *
 * @author LENOVO
 */
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Pulsa {
    ArrayList<Pembeli> listPenjualanPulsa;
    
        public Pulsa() {
            this.listPenjualanPulsa = new ArrayList<>();
        }

    Pulsa(String namaProvider, String nomorPonsel, String nominalPulsa) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    /**
     * Cek apakah provider yang diinput ada dalam program.
     * @param provider Nama provider yang akan dicek
     * @return     Bernilai true apabila ada nama yang sama di list.
     */
    boolean cekProvider(String provider) {
        String[] providerKartu = {
                "Telkomsel",
                "XL",
                "Axis",
                "Indosat",
                "IM3"};
        for (int i = 0; i < providerKartu.length; i++) {
            if (providerKartu[i].toUpperCase().equals(provider.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
    
    /**
     * Mengecek format nomor ponsel
     * @param nomor Nomor ponsel yang akan dicek
     * @return  Nilai true apabila format benar dan false apabila salah
     */
    boolean cekNomorPonsel(String nomor) {
        return Pattern.matches("(\62|0)8[1-9][0-9]{6,9}$", nomor);
        //return Pattern.matches("[+]?[0-9]{6,19}", nomor);
    }
    
    /**
     * Cek apakah nomimal yang diinputkan ada dalam list program.
     * @param nominal Nilai nominal yang akan dicek
     * @return     Bernilai true apabila ada nama yang sama di list.
     */
    final boolean cekNominal(String nominal) {
        String[] nominalPulsa = {
                "5000",
                "10000",
                "25000",
                "50000",
                "100000"};
        for (int i = 0; i < nominalPulsa.length; i++) {
            if (nominalPulsa[i].toUpperCase().equals(nominal.toUpperCase())) {
                return true;
            }
        }
        return false;
    }
}
