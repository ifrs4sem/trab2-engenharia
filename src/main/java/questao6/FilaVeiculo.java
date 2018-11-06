package questao6;

import java.util.ArrayList;
import java.util.Random;

import questao3.Veiculo;
import questao4.FabricaVeiculo;

public class FilaVeiculo {
	private ArrayList<Veiculo> fila = new ArrayList<Veiculo>();
	private int tamanhoFila = 0;
	private double veiculosPorSegundo;
	private FabricaVeiculo fabrica;
	
	public FilaVeiculo(double veiculosPorSegundo, FabricaVeiculo fabrica) {
		super();
		this.veiculosPorSegundo = veiculosPorSegundo;
		this.fabrica = fabrica;
	}
	
	public void entraNaFila() {
		int chance = new Random().nextInt(100);
		if (veiculosPorSegundo * 100 <= chance) {
			Veiculo novoVeiculo = fabrica.criaVeiculo();
			fila.add(novoVeiculo);
		}
	}
	public void saiDaFila(Veiculo veiculo) {
		fila.remove(veiculo);
	}
	public void saiDaFilaPrimeiro() {
		fila.remove(0);
	}
	public int tamanhoFila() {
		int tamanho = 0;
		for (Veiculo veiculo : fila) {
			tamanho += veiculo.getTamanho();
		}
		return tamanho;
	}
	public int numVeiculosFila() {
		return fila.size();
	}
	public void listaVeiculos() {
		for (int i=0;i<fila.size();i++) {
			System.out.println("Veiculo " + i+1 + ":" + fila.get(i).toString());
		}
	}
	
	
}
