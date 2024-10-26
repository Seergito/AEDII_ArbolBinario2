/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aedii_t1;

/**
 *
 * @author estudante
 */
public class EnlazadoArbolBinario<E> implements ArbolBinario<E> {

    private NodoBinario<E> r;

    public EnlazadoArbolBinario() {
        r = null;
    }

    public EnlazadoArbolBinario(E raiz, ArbolBinario<E> hi, ArbolBinario<E> hd) {
        if (raiz == null || hi == null || hd == null) {
            r = null;
        }

        r = new NodoBinario<E>(raiz, ((EnlazadoArbolBinario<E>) hi).r, ((EnlazadoArbolBinario<E>) hi).r);

    }
    
     private EnlazadoArbolBinario(NodoBinario<E> raiz) {
        r = raiz;
    }

    @Override
    public boolean esVacio() {
        if (r == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public E raiz() throws ArbolVacioExcepcion {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArbolBinario<E> hijoIzq() throws ArbolVacioExcepcion {
        
        //CREAR UN CONSTRUCTOR PRIVADO EN EL QUE CREAMOS UN ARBOL_ENLAZADO_BINARIO CUYA RAIZ ES UN PARÁMETRO
        if(this.esVacio()){
            throw new ArbolVacioExcepcion();
        }
        return new EnlazadoArbolBinario<>(r.getIzq());
    }
    
    
    

    @Override
    public ArbolBinario<E> hijoDer() throws ArbolVacioExcepcion {
        if(this.esVacio()){
            throw new ArbolVacioExcepcion();
        }
        return new EnlazadoArbolBinario<>(r.getDer());
    }

    @Override
    public boolean esta(E elemento) {
        return esta(r,elemento);
    }
    
    private boolean esta(NodoBinario<E> raiz, E elemento){
  /*
              if(raiz.getElemento().equals(elemento)){
            return true;
        }else if(raiz.equals(null)){
            return false;
        }else if(esta(raiz.getIzq(),elemento)){
           return true;
        }else{
            return esta(raiz.getDer(), elemento);
        }
        */
        
        // METODO 2
        
        return (esta(raiz.getIzq(),elemento) || esta(raiz.getDer(),elemento));
        
    }
    

    @Override
    public void setRaiz(E elemRaiz) throws ArbolVacioExcepcion, NullPointerException {
        if (r != null && r.getElemento() != null) {
            r.setElemento(elemRaiz);
        } else {
            throw new ArbolVacioExcepcion();
        }

    }

    @Override
    public void setHijoIzq(ArbolBinario<E> hi) throws ArbolVacioExcepcion, NullPointerException {

        if (r != null && hi != null) {
            r.setIzq(((EnlazadoArbolBinario<E>) hi).r);
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void setHijoDer(ArbolBinario<E> hd) throws ArbolVacioExcepcion, NullPointerException {

        if (r != null && hd != null) {
            r.setIzq(((EnlazadoArbolBinario<E>) hd).r);
        }
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void suprimir() {
        r=null;
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    //EJERCICIO A
    public static ArbolBinario<Character> construir(String preor,String inord){
   
     //Primer elemento es el preorden
     if(preor.length()== 0 && inord.length() == 0){
        return new EnlazadoArbolBinario<>();
     }
     else{
         Character r= preor.charAt(0);
         int p = inord.indexOf(r);
         return new EnlazadoArbolBinario<>(r, construir(preor.substring(1,p+1), inord.substring(0,p)), construir(preor.substring(p+1), inord.substring(p+1)));
     }
     //INORDER HD,HI EN FUNCION DEL 1: EJEMPLO INORDEN: 3,5,2,4,1,6
                                                      //HI-------  --HD
    }
    
    //EJERCICIO B
    
    public static boolean esCamino(ArbolBinario<Character> arbol,String camino) throws ArbolVacioExcepcion{

        if(arbol.esVacio() == true){
            return false;
        }
         if(camino.length()==0){
            return false;
        }
        
        // !!Condición de finalización: si el camino tiene solo un carácter y coincide con la raíz
        if(camino.length()==1 && arbol.raiz().equals(camino.charAt(0))){
            return true;
                }

         // Si el primer carácter de 'camino' no coincide con la raíz actual, no hay camino
    if (!arbol.raiz().equals(camino.charAt(0))) {
        return false;
    }
        
       String subCamino = camino.substring(1);

    return (arbol.hijoIzq() != null && esCamino(arbol.hijoIzq(), subCamino)) || arbol.hijoDer() != null && esCamino(arbol.hijoDer(),subCamino);


        
        return false;
    }
    
    //EJERCICIO C
    
    public static <E> E getPadre(ArbolBinario<E> a,E elemento) throws ArbolVacioExcepcion{
        
        E r= a.raiz();
        if(a.esVacio()){
            return null;
        }else if(!a.esta(elemento) || r.equals(elemento)){
            return null;
        }else{
            ArbolBinario hi=a.hijoIzq();
            ArbolBinario hd=a.hijoDer();
            
            if(!hi.esVacio() && hi.raiz().equals(elemento) || !hd.esVacio() && hd.equals(elemento)){
                return a.raiz();
            }else{
                E padre = (E) getPadre(hi,elemento);
                    if(padre==null){
                        return (E) getPadre(hd, elemento);
                    }else{
                        return padre;
                    }
            }
        }
        
    }
    
    
    
    }

