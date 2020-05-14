package model;

import java.util.Random;

public class Carrera {

	private ArbolBinarioBusqueda arbolBB;
	private ArrayListt arrays;
	private ListaEnlazadaa listas;

	private long numero;
	private int forma;

	public Carrera(long numero, int forma) {
		this.numero = numero;
		this.forma = forma;
		this.arbolBB = new ArbolBinarioBusqueda();
		this.arrays = new ArrayListt();
		this.listas = new ListaEnlazadaa();
	}

	public ArbolBinarioBusqueda getArbolBB() {
		return arbolBB;
	}

	public void setArbolBB(ArbolBinarioBusqueda arbolBB) {
		this.arbolBB = arbolBB;
	}

	public ArrayListt getArrays() {
		return arrays;
	}

	public void setArrays(ArrayListt arrays) {
		this.arrays = arrays;
	}

	public ListaEnlazadaa getListas() {
		return listas;
	}

	public void setListas(ListaEnlazadaa listas) {
		this.listas = listas;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public int getForma() {
		return forma;
	}

	public void setForma(int forma) {
		this.forma = forma;
	}

	public long cantidadNumeros(long n) {

		Random nc = new Random(n);
		return nc.nextLong();
	}

}
