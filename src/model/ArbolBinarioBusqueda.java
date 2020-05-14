package model;

public class ArbolBinarioBusqueda {

	private NodoArbolBinarioBusqueda inicioDeArbol;

	public ArbolBinarioBusqueda() {
		inicioDeArbol = null;
	}

	public void addNodoArbolBinarioBusqueda(long cont) {

		NodoArbolBinarioBusqueda n = new NodoArbolBinarioBusqueda(cont);

		if (inicioDeArbol == null)
			inicioDeArbol = n;
		else
			inicioDeArbol.addBusquedaB(n);
	}

	public boolean searchNodeArbolBinarioBusqueda(long cont) {
		return inicioDeArbol == null ? false : inicioDeArbol.searchBusquedadB(cont);
	}

	public void deleteNodeArbolBinarioBusqueda(long cont) {
		inicioDeArbol = inicioDeArbol.deleteBusquedaB(cont);
	}

	public NodoArbolBinarioBusqueda getInicioDeArbol() {
		return inicioDeArbol;
	}

	public void setInicioDeArbol(NodoArbolBinarioBusqueda in) {
		this.inicioDeArbol = in;
	}

	public void addNodoABBIterative(long content) {

		NodoArbolBinarioBusqueda theNew = new NodoArbolBinarioBusqueda(content);

		if (inicioDeArbol == null) {
			inicioDeArbol = theNew;
		} else {
			NodoArbolBinarioBusqueda aux = inicioDeArbol;
			NodoArbolBinarioBusqueda father;
			while (true) {
				father = aux;

				if (content < aux.getCont()) {
					aux = aux.getIzq();
					if (aux == null) {
						father.setIzq(theNew);

						return;
					}
				} else {
					aux = aux.getDer();
					if (aux == null) {
						father.setDer(theNew);
						return;
					}
				}
			}
		}
	}

	public boolean estaVacio() {
		return inicioDeArbol == null;

	}

	public void imprecionEnOrden(NodoArbolBinarioBusqueda r) {

		if (r != null) {
			imprecionEnOrden(r.getIzq());
			System.out.print(r.getCont() + ", ");
			imprecionEnOrden(r.getDer());
		}
	}

	/**
	 * PreOrden
	 */
	public void imprecieonPreOrden(NodoArbolBinarioBusqueda r) {

		if (r != null) {
			System.out.print(r.getCont() + ", ");
			imprecieonPreOrden(r.getIzq());
			imprecieonPreOrden(r.getDer());
		}
	}

	/**
	 * PostOrden
	 */
	public void imprecionPostOrden(NodoArbolBinarioBusqueda r) {

		if (r != null) {
			imprecionPostOrden(r.getIzq());
			imprecionPostOrden(r.getDer());
			System.out.print(r.getCont() + ", ");
		}
	}

	/**
	 * SEARCH ITERATIVE
	 */
	public boolean searchIterativeABB(long cont) {

		if (inicioDeArbol == null) {
			return false;
		} else {
			NodoArbolBinarioBusqueda aux = inicioDeArbol;

			while (aux.getCont() != cont) {
				if (cont < aux.getCont()) {
					aux = aux.getIzq();
				} else {
					aux = aux.getDer();
				}
				if (aux == null) {
					return false;
				}
			}
			return true;
		}
	}

	/**
	 * DELETE ITERATIVE
	 */
	public void deleteIterativeABB(long number) {

		if (estaVacio()) {
			return;
		} else {
			NodoArbolBinarioBusqueda aux = inicioDeArbol;
			NodoArbolBinarioBusqueda father = inicioDeArbol;
			boolean itsLeft = true;
			while (aux.getCont() != number) {
				father = inicioDeArbol;
				if (number < aux.getCont()) {
					itsLeft = true;
					aux = aux.getIzq();
				} else {
					itsLeft = false;
					aux = aux.getDer();
				}
				if (aux == null) {
					return;
				}
			} // fin del while
			if (aux.getIzq() == null && aux.getDer() == null) { // el nodo es hoja
				if (aux == inicioDeArbol) {
					inicioDeArbol = null;
				} else if (itsLeft) {
					father.setIzq(null);

				} else {
					father.setDer(null);
				}
			} else if (aux.getDer() == null) {
				if (aux == inicioDeArbol) {
					inicioDeArbol = aux.getIzq();
				} else if (itsLeft) {
					father.setIzq(aux.getIzq());

				} else {
					father.setDer(aux.getIzq());
				}
			} else if (aux.getIzq() == null) {
				if (aux == inicioDeArbol) {
					inicioDeArbol = aux.getDer();
				} else if (itsLeft) {
					father.setIzq(aux.getDer());

				} else {
					//
					father.setDer(aux.getDer());
				}
			} else {
				NodoArbolBinarioBusqueda replacement = getRermplazarNode(aux);
				if (aux == inicioDeArbol) {
					inicioDeArbol = replacement;
				} else if (itsLeft) {
					father.setIzq(replacement);

				} else {
					father.setDer(replacement);
				}
				replacement.setIzq(aux.getIzq());
			}
		}

	}

	public NodoArbolBinarioBusqueda getRermplazarNode(NodoArbolBinarioBusqueda nodoRe) {
		NodoArbolBinarioBusqueda replaceFather = nodoRe;
		NodoArbolBinarioBusqueda replace = nodoRe;
		NodoArbolBinarioBusqueda aux = nodoRe.getDer();

		while (aux != null) {
			replaceFather = replace;
			replace = aux;
			aux = aux.getIzq();
		}
		if (replace != nodoRe.getDer()) {
			replaceFather.setIzq(replace.getDer());
			replace.setDer(nodoRe.getDer());
		}

		return replace;
	}
}
