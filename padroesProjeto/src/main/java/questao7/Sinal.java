package questao7;

public class Sinal {
	private static final int VERMELHO = 0;
	private static final int AMARELO = 1;
	private static final int VERDE = 1;
	private boolean paraFila = false;
	private int estado = VERMELHO;
	
	public void mudaEstado() {
		if(this.estado == VERMELHO) {
			this.estado = VERDE;
		}
		else if(this.estado == VERDE) {
			this.estado = AMARELO;
		}
		else {
			this.estado = VERMELHO;
		}
	}
	public int getEstado() {
		return this.estado;
	}
	public void solicitaParadaFila() {
		this.paraFila = true;
	}
	public void concluiParada() {
		this.paraFila = false;
	}
	public String getMensagem() {
		if(this.estado == VERMELHO) {
			return "Vermelho";
		}
		else if(this.estado == VERDE) {
			return "Verde";
		}
		else {
			return "Amarelo";
		}
	}
}
