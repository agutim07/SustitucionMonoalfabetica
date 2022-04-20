import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author Alberto Gutiérrez Morán
 */

public class Main {

    public static int DECIMALS = 128;

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("D:\\ULE\\3º\\SI\\examen_v3.txt");

        String alf = "aábcdeéfghiíjklmnñoópqrstuúvwxyzAÁBCDEÉFGHIÍJKLMNÑOÓPQRSTUÚVWXYZ0123456789 ,.:-()";
        for(int i=0; i<alf.length(); i++){
            int cod = (64*i) + 5;
            cod = cod%81;
            System.out.println(i + " , "+cod + " - " + alf.charAt(i));
        }
        //System.out.println(alf.charAt(67));

        /** INFO DE LA FUENTE EXTRA */
        /*for(int i=0; i<lista.size(); i++){
            System.out.print(lista.get(i).getChar() + " - ");
            System.out.println(lista.get(i).getL() + " , " + lista.get(i).getH());
        }*/

        /*for(int i=0; i<lista.size(); i++){
            System.out.print(i+1 + " - ");
            System.out.println(lista.get(i).imprimir());
        }*/
    }

    private static void generarLista(File file) throws FileNotFoundException {
        /*Scanner sc = new Scanner(file);
        ArrayList<Alfabeto> lista = new ArrayList<Alfabeto>();
        int total=0;

        while (true) {
            String nxt = sc.nextLine();
            for(int i=0; i<nxt.length(); i++){
                char c = nxt.charAt(i);
                if(c==' '){c='⎵';}
                int x = checkExist(lista, c);
                if(x==-1){
                    Alfabeto newletter = new Alfabeto(c);
                    lista.add(newletter);
                }else{
                    lista.get(x).aumentarFrecuencia();
                }
                total++;
            }

            if(sc.hasNextLine()){
                cambioDeLinea(lista);
                total+=2;
            }else{
                break;
            }
        }

        for(int i=0; i<lista.size(); i++){
            lista.get(i).setProbabilidad(total);
        }

        return lista;*/
    }

    private static double redondearDecimal(double x, int dec){
        double resultado = x;
        double parteEntera = Math.floor(resultado);
        resultado=(resultado-parteEntera)*Math.pow(10, dec);
        resultado=Math.round(resultado);
        resultado=(resultado/Math.pow(10, dec))+parteEntera;
        return resultado;
    }

}
