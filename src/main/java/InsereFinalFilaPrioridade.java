import java.util.ArrayList;

public class InsereFinalFilaPrioridade implements FilaPrioridade {

	private ArrayList<Pair> fila;
	private int index;

	public InsereFinalFilaPrioridade(int capacidade) {
		this.fila = new ArrayList<Pair>(capacidade);
		this.index = -1;
	}
	
	// criar um Pair e adicionar no fim da fila
	public void add(String elemento, int prioridade) {
		Pair novo = new Pair(elemento, prioridade);
		index ++;
		fila.add(index, novo);
	}


	// buscar pelo elemento de maior prioridade na fila.
	public String removeNext() {
		Pair maiorPrioridade = fila.get(0);
		for(int i = 1; i <= index; i++) {
			if(fila.get(i).getPrioridade() > maiorPrioridade.getPrioridade()) {
				maiorPrioridade = fila.get(i);
			}
		}
		fila.remove(maiorPrioridade);
		index--;

		return maiorPrioridade.getElemento();
	}

}
