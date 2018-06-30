
package thefinalproyect;

public class NodosB {
    int orden;//orden del arbol 
    int contador;//numero de llaves en un nodo
    int llave[];//array de valores de las llaves
    NodosB hijo[];
    boolean hoja;//si el nodo es hoja o no
    NodosB padre;//padre del nodo, si es que tiene

    public NodosB() {
    }

    public NodosB(int orden, NodosB padre) {
        this.orden = orden;
        //this.contador = contador;
        this.padre=padre;
        llave = new int[2*orden-1];
        hijo = new NodosB[2*orden];
        hoja = true;//true porque todo nodo al principio de un arbol es un hijo
        contador=0;//numero de llaves en un node
    }
    
    public int getValor(int index){
        return llave[index];
    }
    
    public NodosB getHijo(int index){//regresar el hijo del nodo
        return hijo[index];
    }
}
