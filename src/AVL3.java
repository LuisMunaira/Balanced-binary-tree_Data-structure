package avl3;

/**
 *
 * @author Munaira
 */
public class AVL3 {

    public static void main(String[] args) {

        Arvore_Balanceada<Integer> AVL = new Arvore_Balanceada<>();
        AVL.inserir(100);
        AVL.inserir(200);
        AVL.inserir(50);
//       // AVL.remover(39);
       // AVL.Contem(400);
        AVL.inserir(51);
        AVL.remover(100);
//        AVL.inserir(7);
//        AVL.inserir(51);
//        AVL.inserir(2);
//        AVL.inserir(9);
       // AVL.inserir(39);
//        AVL.inserir(7);
//        AVL.inserir(43);
//        AVL.inserir(8);
//        AVL.inserir(9);
//        AVL.inserir(72);
//        AVL.inserir(51);
//        AVL.inserir(20);
//        AVL.inserir(94);
//        AVL.inserir(73);
//        AVL.inserir(37);
//        AVL.remover(43);
//        AVL.remover(150);
//        System.out.println("========EM emORDEM========");
//        AVL.emOrdem(AVL.raiz);
//        System.out.println("=======POS posORDEM========");
//        AVL.posOrdem(AVL.raiz);
//        System.out.println("=======PEM preORDEM========");
//        AVL.preOrdem(AVL.raiz);

       // System.out.println("==========ARVORE AVL============");
        AVL.imprimir(AVL.raiz);
    }

}
