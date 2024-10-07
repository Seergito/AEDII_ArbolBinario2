/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.aedii_t1;

/**
 *
 * @author estudante
 */
public class NodoBinario<E> {
    
    private E elemento;
    private NodoBinario<E> izq;
    private NodoBinario<E> der;
    
    public NodoBinario(E e,NodoBinario<E> hi,NodoBinario<E> hd){
        elemento=e;
        izq=hi;
        der=hd;
    }

    public E getElemento() {
        return elemento;
    }

    public NodoBinario<E> getIzq() {
        return izq;
    }

    public NodoBinario<E> getDer() {
        return der;
    }

    public void setElemento(E elemento) {
        this.elemento = elemento;
    }

    public void setIzq(NodoBinario<E> izq) {
        this.izq = izq;
    }

    public void setDer(NodoBinario<E> der) {
        this.der = der;
    }
    
    
}
