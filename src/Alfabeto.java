public class Alfabeto {
    private char caracter;
    private int pos;
    private int cod;

    Alfabeto(char c){
        this.caracter = c;
    }

    Alfabeto(char c, int pos){
        this.caracter = c;
        this.pos = pos;
    }

    Alfabeto(char c, int pos, int cod){
        this.caracter = c;
        this.pos = pos;
        this.cod = cod;
    }

    ///GETTERS AND SETTERS///
    public char getChar(){ return this.caracter; }
    public int getPos(){ return this.pos; }
    public void setCod(int cod){this.cod = cod;}
    public int getCod(){ return this.cod; }


}
