package tree;

//Classe que representa um nó na árvore binária de pesquisa
public class Node {
	String valor; // O valor armazena um nó
	Node left; // Filho à esquerda
	Node right; // Filho à direita

	// Construtor que inicializa o nó com uma palavra
	public Node(String valor) {
		this.valor = valor;
		this.left = null;
		this.right = null; // Inicialmente, os filhos são nulos
	}

}
