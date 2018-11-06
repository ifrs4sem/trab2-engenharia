package questao4;

import questao3.Veiculo;

public abstract class FabricaVeiculo {
	private double chanceCarro;
	private double chanceOnibus;
	private double chanceCaminhao;
	
	public FabricaVeiculo() {
		this.chanceCaminhao = 0.08;
		this.chanceCarro = 0.8;
		this.chanceOnibus = 0.12;
		
	}
	public FabricaVeiculo(double chanceCarro, double chanceOnibus, double chanceCaminhao) {
		super();
		if(chanceCarro + chanceOnibus + chanceCaminhao <=1 && chanceCarro >0 && chanceOnibus > 0 && chanceCaminhao > 0) {
			this.chanceCarro = chanceCarro;
			this.chanceOnibus = chanceOnibus;
			this.chanceCaminhao = chanceCaminhao;
		}
	}

	public double getChanceCarro() {
		return chanceCarro;
	}
	public double getChanceOnibus() {
		return chanceOnibus;
	}
	public double getChanceCaminhao() {
		return chanceCaminhao;
	}
	
	public abstract Veiculo criaVeiculo();
	
}
