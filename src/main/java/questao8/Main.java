package questao8;

import java.util.Random;

import questao5.FabricaVeiculoConcreta;
import questao6.FilaVeiculo;
import questao7.Sinal;

public class Main {
	public static void log(int tempo, int tamanhoFila, int qtdFila, int solicitParada, Sinal sinal) {
		System.out.println((tempo/60)+"min ("+tempo+")");
		System.out.print(" - Sinaleira: "+sinal.getMensagem());
		System.out.print(" - Tamanho da fila: "+tamanhoFila);
		System.out.print(" - Quantidade de veiculos na fila: "+qtdFila);
		System.out.print(" - Solicitacoes de parada: "+solicitParada);
		System.out.println(" - Parada: "+sinal.hasParadaSolicitada());
		
		
	}
	public static void main(String[] args) {
		Random rand = new java.util.Random();
		Sinal sinal = new Sinal();
		FabricaVeiculoConcreta fabrica = new FabricaVeiculoConcreta();
		// chance
		double veiculoPorSegundo = 0.5;
		int tempoMaxSinalFechado = 20;
		int tempoMaxSinalAberto = 30;
		FilaVeiculo fila = new FilaVeiculo(veiculoPorSegundo, fabrica);
		
		int tempoSinalAberto = 0, tempoSinalFechado = 0, solicitacoesParada = 0;
		
		int DURACAO = 600;
		int duracaoAtual = 0;
		double chance;
		
		while(duracaoAtual <= DURACAO) {
			log(
					duracaoAtual,
					fila.tamanhoFila(), 
					fila.numVeiculosFila(), 
					solicitacoesParada, 
					sinal
				);
			
			chance = rand.nextDouble();
			
			// 10% de chance de solicitar parada
			if (chance < 0.1 ) {
				sinal.solicitaParadaFila();
				solicitacoesParada ++;
			}
			
			// 50% de chance de entrar na fila	
			fila.entraNaFila();
			
			//se o sinal estiver fechado
			if (sinal.getEstado() == 0 ) {
				solicitacoesParada = 0;
				sinal.concluiParada();
				tempoSinalAberto = 0;
				tempoSinalFechado++;					
				// se o tempo maximo de sinal fechado tiver alcancado o maximo
				if (tempoSinalFechado >= tempoMaxSinalFechado) {
					// se tiver alcancado o maximo, muda estado
					sinal.mudaEstado();
				}
			}
			// se o sinal estiver aberto
			else if (sinal.getEstado() != 0) {
				tempoSinalFechado = 0;
				tempoSinalAberto++;	
				// veiculos saem 3x mais rapido que entram
				for (int i =0; i<(veiculoPorSegundo*3);i++ ) {
					if(fila.numVeiculosFila()>0) {
						fila.saiDaFilaPrimeiro();
						
					}
				}
				//se o tempo maximo de sinal aberto alcancou o maximo
				if (tempoSinalAberto >= tempoMaxSinalAberto) {
					// verifica se uma parada foi solicitada
					if (sinal.hasParadaSolicitada()) {
						sinal.mudaEstado();
						
					}
				}
			}
			
			duracaoAtual++;	
		}
	}
	

}
