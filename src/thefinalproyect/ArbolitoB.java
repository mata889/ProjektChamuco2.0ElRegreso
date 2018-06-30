package thefinalproyect;

public class ArbolitoB {

    int orden;//orden del arbol 
    NodosB raiz;//raiz del arbol

    public ArbolitoB(int orden) {
        this.orden = orden;
        raiz = new NodosB(orden, null);//empezar a crear la raiz
    }

    public void split(NodosB x, int i, NodosB y) {
        NodosB z = new NodosB(orden, null);
        z.hoja = y.hoja;//si es hoja?
        z.contador = orden - 1;//cantidad de llaves en un nodo
        for (int j = 0; j < orden - 1; j++) {
            z.llave[j] = y.llave[j + orden];
        }
        if (!y.hoja) {//si no es hoja entonces
            for (int j = 0; j < orden; j++) {
                z.hijo[j] = y.hijo[j + orden];//pasandoles los hijos
            }
        }
        y.contador = orden - 1;//nuevo tamaño de y
        for (int j = x.contador; j > i; j--) {
            x.hijo[j + 1] = x.hijo[j];
        }
        x.hijo[i + 1] = z;
        for (int j = x.contador; j > i; j--) {
            x.llave[j + 1] = x.llave[j];
        }
        x.llave[i] = y.llave[orden - 1];
        y.llave[orden - 1] = -1;
        for (int j = 0; j < orden - 1; j++) {
            y.llave[j + orden] = -1;//borrar valores
        }
        x.contador++;
    }

    public void Ninsert(NodosB x, int llave) {
        int i = x.contador;
        if (x.hoja) {
            while (i >= 1 && llave < x.llave[i - 1]) {  //encontrar donde poner la llave
                x.llave[i] = x.llave[i - 1];//moviendolo uno menos para abrir espacio
                i--;
            }
            x.llave[i] = llave;
            x.contador++;//incremetar la cantidad de llaves que tiene
        } else {
            int j = 0;
            while (j < x.contador && llave > x.llave[j]) {  //encontrar espacio para volver en el hijo exacto              
                j++;
            }
            if (x.hijo[j].contador == orden * 2 - 1) {
                split(x, j, x.hijo[j]);
                if (llave > x.llave[j]) {
                    j++;
                }
            }
            Ninsert(x.hijo[j], llave);
        }
    }

    public void insert(ArbolitoB t, int llave) {
        NodosB r = t.raiz;
        if (r.contador == 2 * orden - 1) {
            NodosB s = new NodosB(orden, null);
            t.raiz = s;
            s.hoja = false;
            s.contador = 0;
            s.hijo[0] = r;
            split(s, 0, r);
            Ninsert(s, llave);
        } else {
            Ninsert(r, llave);
        }
    }

    public void print(NodosB n) {
        for (int i = 0; i < n.contador; i++) {
            System.out.print(n.getValor(i) + " ");
        }
        if (!n.hoja) {//si no es hoja
            System.out.print("no hijo");
            for (int i = 0; i <= n.contador; i++) {
                if (n.getHijo(i) != null) {
                    System.out.println();
                    print(n.getHijo(i));
                }
            }
        }
    }

    
    /*
    este metodo de buscar para el nodo recivido donde queremos insertar el valor
    de la llave, para otro metodo
    */
    public NodosB Buscar(NodosB raiz, int llave) {
        int i = 0;//empezar del indice 0 de un nodo
        while (i < raiz.contador && llave > raiz.llave[i]) { //incrementando en el nodo mientra la llave sea > al valor actual     
            i++;
        }
        if (i <= raiz.contador && llave == raiz.llave[i]) {//obviamente si la llave es un node, que vuelva al nodo
            return raiz;
        }
        if (raiz.hoja) {
            return null;
        } else {
            return Buscar(raiz.getHijo(i), llave);
        }
    }
    
    public void Borrar(ArbolitoB t,int llave){
       NodosB temp=new NodosB(orden,null);
       temp=Buscar(t.raiz,llave);
        if (temp.hoja && temp.contador>orden -1) {
            int i=0;
            while(llave>temp.getValor(i)){
             i++;
            }
            for (int j = i; j < 2*orden-2; j++) {
                temp.llave[j]=temp.getValor(j+1);
            }
            temp.contador --;
        }else{
            System.out.println("Este nodo no es una hoja o tiene menos de una llave");
        }
    }
}
