package avl3;

/**
 *
 * @author Munaira
 */
public class Arvore_Balanceada<T extends Comparable<T>> implements AVL_interface<T> {

    public No<T> raiz;

    @Override
    public void inserir(T valor) {
        raiz = inserir(raiz, valor);

    }

    @Override
    public void remover(T valor) {
        raiz = remover(raiz, valor);
    }

    private No inserir(No<T> no, T valor) {
        if (no == null) {
            return new No<T>(valor);
        } else if (valor.equals(no.getValor())) {
            return no;
        }
        if (valor.compareTo(no.getValor()) < 0) {
            no.setNoEsquerdo(inserir(no.getNoEsquerdo(), valor));
        } else {
            no.setNoDireito(inserir(no.getNoDireito(), valor));
        }
        no.setAltura(Math.max(altura(no.getNoEsquerdo()), altura(no.getNoDireito())) + 1);

        no = Validar_balanceamento(valor, no);

        return no;
    }

    private No Validar_balanceamento(T valor, No<T> no) {
        int balance = factor_Balanceamento(no);
        //case 1 left left
        if (balance > 1 && valor.compareTo(no.getNoEsquerdo().getValor()) < 0) {
            return rightRotation(no);

        }//case 1 rigth rigth
        if (balance < -1 && valor.compareTo(no.getNoDireito().getValor()) > 0) {
            return LefttRotation(no);
        }
         //left right situation
        if (balance > 1 && valor.compareTo(no.getNoEsquerdo().getValor()) > 0) {
            System.out.println("Rotacao Esquerda-Direita de No: " + no);
            no = rorataco_Esquerda_Direita(no);
        }
        //right left situation
        if (balance < -1 && valor.compareTo(no.getNoDireito().getValor()) < 0) {
            System.out.println("Rotacao Direita-Esquerda de No: " + no);
            no = rorataco_Direita_Esquerda(no);
        }

        return no;

    }

    @Override
    public int factor_Balanceamento(No<T> no) {
        if (no == null) {
            return 0;
        }
        return altura(no.getNoEsquerdo()) - altura(no.getNoDireito());
    }

    private int altura(No<T> no) {
        if (no == null) {
            return -1;
        }
        return no.getAltura();
    }

    private No rightRotation(No<T> no) {
        System.out.println("Rotacao a direita do No: " + no);
        No<T> LeftNo = no.getNoEsquerdo();
        No<T> t = LeftNo.getNoDireito();

        LeftNo.setNoDireito(no);
        no.setNoEsquerdo(t);

        no.setAltura(Math.max(altura(no.getNoEsquerdo()), altura(no.getNoDireito())) + 1);
        LeftNo.setAltura(Math.max(altura(LeftNo.getNoEsquerdo()), altura(LeftNo.getNoDireito())) + 1);

        return LeftNo;
    }

    private No LefttRotation(No<T> no) {
        System.out.println("Rotacao a esquerda do No: " + no);
        No<T> RigthNo = no.getNoDireito();
        No<T> t = RigthNo.getNoEsquerdo();

        RigthNo.setNoEsquerdo(no);
        no.setNoDireito(t);

        no.setAltura(Math.max(altura(no.getNoEsquerdo()), altura(no.getNoDireito())) + 1);
        RigthNo.setAltura(Math.max(altura(RigthNo.getNoEsquerdo()), altura(RigthNo.getNoDireito())) + 1);

        return RigthNo;
    }

    public No rorataco_Esquerda_Direita(No<T> no) {
        no.setNoEsquerdo(LefttRotation(no.getNoEsquerdo()));
        return rightRotation(no);
    }

    public No rorataco_Direita_Esquerda(No<T> no) {
        no.setNoDireito(rightRotation(no.getNoDireito()));
        return LefttRotation(no);
    }

    private No<T> remover(No<T> no, T valor) {
        if (no == null) {
            return no;
        }

        if (valor.compareTo(no.getValor()) < 0) {
            no.setNoEsquerdo((remover(no.getNoEsquerdo(), valor)));
            
        } else if (valor.compareTo(no.getValor()) > 0) {
            no.setNoDireito(remover(no.getNoDireito(), valor));

        } else {
            if (no.getNoEsquerdo() == null && no.getNoDireito() == null) {

                return null;
            }
            if (no.getNoEsquerdo() == null) {
                No<T> temp_No = no.getNoDireito();
                no = null;
                
                return temp_No;
            } else if (no.getNoDireito() == null) {
                No<T> temp_No = no.getNoEsquerdo();
                no = null;
                return temp_No;
            }

            System.out.println("REMOVENDO ITEN COM 2 FILHOS");
            No<T> tempNode = getpredecessor(no.getNoEsquerdo());
            no.setValor(tempNode.getValor());
            no.setNoEsquerdo(remover(no.getNoEsquerdo(), tempNode.getValor()));
        }
        no.setAltura(Math.max(altura(no.getNoEsquerdo()), altura(no.getNoDireito())) + 1);
        return verificarNo(no);

    }

    private No<T> getpredecessor(No<T> no) {

        No<T> predecessor = no;
        while (predecessor.getNoDireito() != null) {
            predecessor = predecessor.getNoDireito();
        }
        return predecessor;
    }

    private No<T> verificarNo(No<T> no) {
        int balancear = factor_Balanceamento(no);

        if (balancear > 1) {
            if (factor_Balanceamento(no.getNoEsquerdo()) < 0) {
                no.setNoEsquerdo(LefttRotation(no.getNoEsquerdo()));
            }

            return rightRotation(no);
        }
        if (balancear < -1) {
            if (factor_Balanceamento(no.getNoDireito()) > 0) {
                no.setNoDireito(rightRotation(no.getNoDireito()));
            }
            return LefttRotation(no);
        }
        return no;
    }

    @Override
    public boolean Contem(T elemento) {
        if (procurar(elemento, this.raiz) != null) {

            return true;
        } else {
            return false;
        }
    }

    private No<T> procurar(T elemento, No<T> no) {

        if (elemento == null || no == null) {
            return null;
        }
        if (elemento == no || no.getValor().equals(elemento)) {
            return no;
        } else if (no.getValor().compareTo(elemento) < 0) {
            return procurar(elemento, no.getNoEsquerdo());

        } else if ((no.getValor().compareTo(elemento) > 0)) {
            return procurar(elemento, no.getNoDireito());
        } else {
            return no;
        }
    }

    @Override
    public void emOrdem(No<T> actual) {
        if (actual != null) {

            emOrdem(actual.getNoEsquerdo());
            System.out.println("\n\t\t" + actual.getValor());
            emOrdem(actual.getNoDireito());

        }
    }

    @Override
    public void preOrdem(No<T> actual) {
        if (actual != null) {
            System.out.println("\n\t\t" + actual.getValor());
            preOrdem(actual.getNoEsquerdo());
            preOrdem(actual.getNoDireito());
        }
    }

    @Override
    public void posOrdem(No<T> actual) {
        if (actual != null) {

            posOrdem(actual.getNoEsquerdo());
            posOrdem(actual.getNoDireito());
            System.out.println("\n\t\t" + actual.getValor());
        }
    }
//aux imprime
    public void imprimir(No<T> no) {

        if (no != null) {

            imprimir(no.getNoDireito());
            if (no == raiz) {
                System.out.print("Root ---> " + no.getValor() + " ");
                System.out.println(" ");
            } else {
                System.out.print("   ----------> " + no.getValor() + " ");
                System.out.println(" ");
            }
            imprimir(no.getNoEsquerdo());

        }
    }
}
