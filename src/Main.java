import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Alberto Gutiérrez Morán
 */

public class Main {
    public static int MOD = 81;

    public static void main(String[] args) throws FileNotFoundException {

        //CIFRAMOS EL ALFABETO CON ESTE CÓDIGO
        int a = 64; int b = 5;

        //CIFRAMOS EL ALFABETO
        String alf = "aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";
        ArrayList<Alfabeto> alfabeto = new ArrayList<>();
        for(int i=0; i<alf.length(); i++){
            int cod = modulo((a*i) + b, MOD);
            Alfabeto nuevo = new Alfabeto(alf.charAt(i), i, cod);
            alfabeto.add(nuevo);
        }

        //DESCIFRAMOS EL MENSAJE
        String msg = "ÁeóÍ ebá 5b-CeóÍósUÍCs sÍ2UeÍÚLVVpt)utÍoáÍez2ehÍÍíN1mX-ñjA1E-OmimjX-wOyimj3wPFé13iAimÚj-mj31-OXwÚjF-OwjjbmYf2áUspY7ÍíPomY íYy3KYí ÚoPbbmEYÓ YP:3mbYyÁLÁYY4v6z6(znmsnzh(v:6zW6fW6zvoz(vóp-z6(6MpWÉzxpOFpzzÍ.íÍa3ñcahuiÍa.Í3uV Ía,ua úc.uVáúua3ñca5y(Zj9aa)r7NOFyWOwóyOÁNuukYóRYOKyRYKdRkÁy(OOIiPúGTókCF5yaó95FCyCsaTó)aQAQóiZGZ(";
        String msgDescifrado = descifrar(msg, alfabeto);

        System.out.println(msgDescifrado);
    }

    private static String descifrar(String msg, ArrayList<Alfabeto> lista){
        String out = "";
        int linea = 1;

        for(int i=0; i<msg.length(); i++){
            if(i>1){
                if(out.charAt(i-2)==' ' && out.charAt(i-1)==' '){
                    linea++;
                    out = out.substring(0,i-1)+"\n"+out.substring(i);   //SUSTITUIMOS EL 2º DE LOS DOS ESPACIOS POR UN SALTO DE LÍNEA
                }
            }

            //CODIGO DE DESCIFRADO
            int a; //COMO A ES UNA POTENCIA, SI SE ELEVA A MÁS DEL Nº5 HAY QUE USAR BIGINTEGER
            if(linea>5){
                BigInteger num = new BigInteger("64").pow(linea);
                a = moduloBig(num,MOD);
            }else{
                a = modulo((int) Math.pow(64,linea),MOD);
            }
            int b = modulo(linea*5, MOD);

            int aINV = inverso(a,MOD);
            int bINV = modulo(-aINV*b,MOD);

            int cod = descGetCod(msg.charAt(i),lista);
            int pos = modulo(aINV*cod + bINV, MOD);

            out = out+lista.get(pos).getChar();
        }

        return out;
    }

    private static int inverso(int a, int mod){
        if(mcd(a,mod)!=1){
            return -1;
        }
        ArrayList<Integer> restos = new ArrayList<>();
        restos.add(mod); restos.add(a);
        ArrayList<Integer> mi = new ArrayList<>();
        mi.add(0); mi.add(1);

        int resto = a;
        int pos = 1;

        while(resto!=0){
            pos++;
            int cociente = modulo(restos.get(pos-2) / restos.get(pos-1), mod);
            resto = modulo(restos.get(pos-2) % restos.get(pos-1), mod);
            restos.add(resto);
            mi.add(modulo(mi.get(pos-2) - (cociente*mi.get(pos-1)), mod));
        }

        return mi.get(pos-1);
    }

    private static int descGetCod(char c, ArrayList<Alfabeto> list){
        for(int i=0; i<list.size(); i++){
            if(c==list.get(i).getChar()){
                return i;
            }
        }
        return -1;
    }

    private static int modulo(int x, int mod){
        if(x<0){
            x=-1*x;
            return mod-(x-(mod * (x/mod)));
        }
        return x%mod;
    }

    private static int moduloBig(BigInteger x, int mod){
        BigInteger rem = x.remainder(new BigInteger(String.valueOf(mod)));
        return rem.intValue();
    }

    private static int mcd(int a, int b) {
        int temp;
        while (b != 0) {
            temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

}
