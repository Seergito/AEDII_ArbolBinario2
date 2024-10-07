/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aedii_t1;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sergio
 */
public class SolActividad2 {
    
    public static <E> boolean completo(ArbolBinario<E> arbol1){
        
        if(arbol1.esVacio()){
            return true;
        }
        else try {
            if(arbol1.hijoDer().esVacio() && !arbol1.hijoIzq().esVacio() || !arbol1.hijoDer().esVacio() && arbol1.hijoIzq().esVacio()){
                return false;
            }else{
                return (completo(arbol1.hijoIzq()) ) && (completo(arbol1.hijoDer()));
            }
        } catch (ArbolVacioExcepcion ex) {
            Logger.getLogger(SolActividad2.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    public static <E> boolean identicos(ArbolBinario<E> arbolA,ArbolBinario<E> arbolB){
        
        if(arbolA.esVacio() && arbolB.esVacio()){
            return true;
        }
        
        if(arbolA.esVacio() || arbolB.esVacio()){
            return false;
        }
        
        try {
            if(!arbolA.raiz().equals(arbolB.raiz())) {
                return false;
            }else{
                return identicos(arbolA.hijoDer(), arbolB.hijoDer());
            }
        } catch (ArbolVacioExcepcion ex) {
            Logger.getLogger(SolActividad2.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return false;
        
    }
    
    public static <E> int contarNivel(ArbolBinario <E> arbol, int n){
        if (arbol.esVacio()){
            return 0;
        }else if(n== 0){
            return 1;
        }else{
            try {
                return contarNivel(arbol.hijoIzq(), n-1)+contarNivel(arbol.hijoDer(), n-1);
            } catch (ArbolVacioExcepcion ex) {
                Logger.getLogger(SolActividad2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return 0;
    }
    
////////    public static <E> ArbolBinario<E> copia(ArbolBinario arbol){
////////        
////////    }
////////    
    public static <E> ArbolBinario<E> eliminar_hojas(ArbolBinario<E> arbol) throws ArbolVacioExcepcion{
        
        if(arbol.esVacio()){
            return new EnlazadoArbolBinario<>();
        }else if(arbol.hijoIzq().esVacio() && arbol.hijoDer().esVacio()){
            return new EnlazadoArbolBinario<>();
        }else{
            return new EnlazadoArbolBinario<E>(arbol.raiz(), eliminar_hojas(arbol.hijoIzq()),eliminar_hojas(arbol.hijoDer()));
        }
    }
    
    
    
}
