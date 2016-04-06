package br.edu.ifsp.cmp.tads.dsw.t1;

import java.util.HashSet;
import java.util.Set;

public class Jogo {
	public static final int MAX_CHUTES_PADRAO = 5;
	
	private String palavra;
	private Set<Character> letras;
	private Set<Character> chutes;
	private int maxChutes = MAX_CHUTES_PADRAO;
	
	public Jogo(String palavra) {
		this.palavra = palavra;
		
		chutes = new HashSet<>();
		letras = new HashSet<Character>();
		for (Character letra : palavra.toCharArray()) { letras.add(letra); }
	}
	
	public Jogo(String palavra, int maxChutes) {
		this(palavra);
		
		this.maxChutes = maxChutes;
	}
	
	public String getPalavra() {
		return palavra;
	}
	
	public Set<Character> getChutes() {
		return chutes;
	}
	
	public boolean chutar(Character letra) {
		if (limiteDeChutesAtingido()) return false;
		
		boolean acertou = false;
		
		acertou = letras.contains(letra);
		letras.remove(letra);
		chutes.add(letra);
		
		return acertou;
	}
	
	public boolean venceu() {
		if (limiteDeChutesAtingido()) return false;
		
		return letras.isEmpty();
	}
	
	private boolean limiteDeChutesAtingido() {
		return chutes.size() >= maxChutes;
	}
}
