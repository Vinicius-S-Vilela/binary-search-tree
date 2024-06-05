package tree;

import java.text.Normalizer;

//Classe que contém utilidades para normalizar e limpar palavras
public class Utils {
	// Função para normalizar e limpar palavras
	public static String normalizeAndClean(String valor) {
		// Converte para letras minúsculas
		valor = valor.toLowerCase();
		// Remove acentuação
		valor = Normalizer.normalize(valor, Normalizer.Form.NFD);
		valor = valor.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
		// Remove caracteres especiais e espaços
		valor = valor.replaceAll("[^a-zA-Z0-9]", "");
		return valor; // Retorna a palavra normalizada e limpa
	}
}