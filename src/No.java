
package avl3;

/**
 *
 * @author Munaira
 */
public class No<T> {
   private T valor;
   private int Altura;
   private No<T> NoDireito;
   private No<T> NoEsquerdo; 
   
    public No(T valor){
   this.valor = valor;
   }

    public T getValor() {
        return valor;
    }

    public void setValor(T valor) {
        this.valor = valor;
    }

    public int getAltura() {
        return Altura;
    }

    public void setAltura(int Altura) {
        this.Altura = Altura;
    }

    public No<T> getNoDireito() {
        return NoDireito;
    }

    public void setNoDireito(No<T> NoDireito) {
        this.NoDireito = NoDireito;
    }

    public No<T> getNoEsquerdo() {
        return NoEsquerdo;
    }

    public void setNoEsquerdo(No<T> NoEsquerdo) {
        this.NoEsquerdo = NoEsquerdo;
    }
     public String toString(){
   return " "+this.valor;
   }
}
