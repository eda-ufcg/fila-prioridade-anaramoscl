public class InsereOrdenadoFilaPrioridade implements FilaPrioridade {

	private Pair[] fila;
	private int head;
	private int last;
	private int capacidade;

	public InsereOrdenadoFilaPrioridade(int capacidade) {
		this.fila = new Pair[capacidade];
		this.capacidade = capacidade;
		this.last = -1;
		this.head = -1;
	}

	public boolean isEmpty() {
		return this.head == -1 && this.last == -1;
	}
	
	// criar um Pair e inserir de forma ordenada decrescente no array.
	public void add(String elemento, int prioridade) {
		this.last = (this.last + 1) % this.capacidade;
		Pair novo = new Pair(elemento, prioridade);
		this.last = (this.last + 1) % this.capacidade;

		if(isEmpty()) {
			this.head = (this.head + 1) % this.capacidade;
			fila[this.head] = novo;
		} else {
			int aux = this.head;
			for(int i = 0;i < this.capacidade; i++) {
				if(fila[aux] != null && fila[(aux+1)%this.capacidade] != null) {
					if(fila[aux].getPrioridade() < fila[(aux+1)%this.capacidade].getPrioridade()) {
						Pair auxiliar = fila[aux];
						fila[aux] = fila[aux + 1 %this.capacidade];
						fila[aux + 1 %this.capacidade] = auxiliar;

					}
				}
				aux = (aux + 1) % capacidade;
			}
		}
	}


	// remover e retornar o primeiro elemento do array, que é o de maior prioridade. lembrar manipular head e tail
	// para ser uma fila circular. assim a remoção fica O(1)
	public String removeNext() {
		String retorno = fila[head].getElemento();
		head = (head + 1) % capacidade; 
		return retorno;
	}

}
