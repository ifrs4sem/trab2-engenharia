package questao5;

import java.util.ArrayList;
import java.util.Random;

import questao3.Caminhao;
import questao3.Carro;
import questao3.Onibus;
import questao3.Veiculo;
import questao4.FabricaVeiculo;

public class FabricaVeiculoConcreta extends FabricaVeiculo {
	private ArrayList<String> arrayChance = new ArrayList<String>();
	public FabricaVeiculoConcreta() {
		for(int i=0;i<this.getChanceCaminhao();i++) {
			arrayChance.add("cm");
		}
		for(int i=0;i<this.getChanceOnibus();i++) {
			arrayChance.add("on");
		}
		for(int i=0;i<this.getChanceCarro();i++) {
			arrayChance.add("cr");
		}
	}
	@Override
	public Veiculo criaVeiculo() {
		int chance = new Random().nextInt(100);
		String veiculo = arrayChance.get(chance);
		if (veiculo == "cm") {
			Caminhao novoCaminhao = new Caminhao();
			return novoCaminhao;
		}
		else if (veiculo == "on") {
			Onibus novoOnibus = new Onibus();
			return novoOnibus;
		}
		else {
			Carro novoCarro = new Carro(); 
			return novoCarro;
		}
	}
	
}
