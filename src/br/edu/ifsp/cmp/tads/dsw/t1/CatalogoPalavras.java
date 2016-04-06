package br.edu.ifsp.cmp.tads.dsw.t1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CatalogoPalavras {
	private List<String> palavras;
	
	public CatalogoPalavras() {
		palavras = new ArrayList<>();
	}
	
	public String getPalavra() {
		String palavra = palavras.get(new Random().nextInt(palavras.size()));
		
		palavras.remove(palavra);
		
		return palavra; 
	}
	
	public boolean addPalavra(String str) {
		String palavra = str.toString().trim().toLowerCase();
		
		if (palavras.contains(palavra)) return false;
		
		palavras.add(palavra);
		return true;
	}
	
	public void limparCatalogo() {
		palavras.clear();
	}
	
	public int quantidadeDePalavras(){
		return palavras.size();
	}
}
