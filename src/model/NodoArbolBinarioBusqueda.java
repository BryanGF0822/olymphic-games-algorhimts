package model;

public class NodoArbolBinarioBusqueda {

	private long cont;

	private NodoArbolBinarioBusqueda izq;
	private NodoArbolBinarioBusqueda der;

	public NodoArbolBinarioBusqueda(long cont) {
		this.cont = cont;
		izq = null;
		der = null;
	}

	public long getCont() {
		return cont;
	}

	public void setCont(long cont) {
		this.cont = cont;
	}

	public NodoArbolBinarioBusqueda getIzq() {
		return izq;
	}

	public void setIzq(NodoArbolBinarioBusqueda izq) {
		this.izq = izq;
	}

	public NodoArbolBinarioBusqueda getDer() {
		return der;
	}

	public void setDer(NodoArbolBinarioBusqueda der) {
		this.der = der;
	}

	public boolean unaHoja() {

		return izq == null && der == null;
	}

	public NodoArbolBinarioBusqueda getMenor() {
		return (izq == null) ? this : izq.getMenor();
	}

	public NodoArbolBinarioBusqueda getMayor() {
		return (der == null) ? this : der.getMayor();
	}

	public void addBusquedaB(NodoArbolBinarioBusqueda n) {
		if (this.getCont() > n.getCont()) {
			if (izq == null)
				izq = n;
			else
				izq.addBusquedaB(n);
		} else {
			if (der == null)
				der = n;
			else
				der.addBusquedaB(n);
		}
	}

	public boolean searchBusquedadB(long numero) {
		if (getCont() == numero)
			return true;
		else if (getCont() > numero)
			return (izq == null) ? false : izq.searchBusquedadB(numero);
		else
			return (der == null) ? false : der.searchBusquedadB(numero);
	}

	public NodoArbolBinarioBusqueda deleteBusquedaB(long numero) {

		if (unaHoja())
			return null;
		if (cont == numero) {
			if (izq == null)
				return der;
			if (der == null)
				return izq;
			NodoArbolBinarioBusqueda aux = der.getMenor();
			der = der.deleteBusquedaB(aux.getCont());

			aux.izq = izq;
			aux.der = der;
			return aux;

		} else if (cont > numero)
			izq = izq.deleteBusquedaB(numero);
		else
			der = der.deleteBusquedaB(numero);
		return this;
	}
}
