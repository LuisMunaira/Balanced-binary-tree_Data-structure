package avl3;

/**
 *
 * @author Munaira
 */
public interface AVL_interface<T> {

    public void inserir(T valor);

    public void remover(T valor);

    public void posOrdem(No<T> no);

    public boolean Contem(T elemento);

    public void preOrdem(No<T> no);

    public int factor_Balanceamento(No<T> no);

    public void emOrdem(No<T> actual);

}
