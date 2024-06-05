package tree;

//Classe que representa a árvore binária de pesquisa
public class Arvore {
	Node root; // Raiz da árvore

	// Construtor que inicializa a árvore com a raiz nula
	public Arvore() {
		this.root = null;
	}

	// Método para inserir uma palavra na árvore
	public void insert(String valor) {
		// Verifica se a palavra já está presente
		if (!search(valor)) {  
			root = insertArvore(root, valor); // Insere a palavra se ela não estiver presente
		}
	}

	// Método recursivo para inserir uma palavra na árvore
	Node insertArvore(Node root, String valor) {
		// Se a raiz é nula, cria um novo nó com a palavra
		if (root == null) {
			root = new Node(valor);
			return root;
		}
		
		// Comparação Lexicográfica
		// Se a palavra é menor que a palavra do nó atual, insere na subárvore esquerda
		if (valor.compareTo(root.valor) < 0)
			root.left = insertArvore(root.left, valor);
		// Se a palavra é maior que a palavra do nó atual, insere na subárvore direita
		else if (valor.compareTo(root.valor) > 0)
			root.right = insertArvore(root.right, valor);

		return root; // Retorna a raiz da árvore
	}

	// Método para buscar uma palavra na árvore
	boolean search(String valor) {
		return searchArvore(root, valor); // Chama o método recursivo para buscar a palavra
	}
	
	// Método recursivo para buscar uma palavra na árvore
	boolean searchArvore(Node root, String valor) {
		// Se a raiz é nula, a palavra não está presente
		if (root == null)
			return false;
		
		// Se a palavra é igual à palavra do nó atual, a palavra está presente
		if (valor.equals(root.valor))
			return true;

		// Se a palavra é menor, busca na subárvore esquerda
		if (valor.compareTo(root.valor) < 0)
			return searchArvore(root.left, valor);
		// Se a palavra é maior, busca na subárvore direita
		else
			return searchArvore(root.right, valor);
	}

	// Método para buscar palavras a partir de uma substring
	void searchSubstring(Node root, String substring) {
		if (root == null)
			return; // Se a raiz é nula, não há palavras para buscar

		// Se a palavra contém a substring, imprime a palavra
		if (root.valor.contains(substring))
			System.out.println(root.valor);

		// Busca recursivamente nas subárvores esquerda e direita
		searchSubstring(root.left, substring);
		searchSubstring(root.right, substring);
	}

	// Método para calcular o tempo gasto na recuperação de uma palavra
	long searchTime(String valor) {
		long startTime = System.nanoTime(); // Inicia a contagem do tempo
		search(valor); // Realiza a busca pela palavra
		long endTime = System.nanoTime(); // Finaliza a contagem do tempo
		return endTime - startTime; // Retorna o tempo gasto em nanosegundos
	}

	// Método para calcular a quantidade de palavras armazenadas
	int valorCount(Node root) {
		// Se a raiz é nula, não há palavras
		if (root == null)
			return 0;
		// Conta a palavra atual e as palavras nas subárvores esquerda e direita
		return 1 + valorCount(root.left) + valorCount(root.right);
	}

	// Método para remover uma palavra do banco de dados
	void remove(String valor) {
		root = removeArvore(root, valor); // Chama o método recursivo para remover a palavra
	}

	// Método recursivo para remover uma palavra da árvore
	Node removeArvore(Node root, String valor) {
		// Se a raiz é nula, a palavra não está presente
		if (root == null)
			return root;

		// Se a palavra é menor que a palavra do nó atual, remove da subárvore esquerda
		if (valor.compareTo(root.valor) < 0)
			root.left = removeArvore(root.left, valor);
		// Se a palavra é maior que a palavra do nó atual, remove da subárvore direita
		else if (valor.compareTo(root.valor) > 0)
			root.right = removeArvore(root.right, valor);
		// Se a palavra é igual à palavra do nó atual, este nó deve ser removido
		else {
			// Nó com apenas um filho ou nenhum filho
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			
			// Nó com dois filhos: pega o menor valor da subárvore direita
			root.valor = minValue(root.right);
			
			// Remove o menor valor da subárvore direita
			root.right = removeArvore(root.right, root.valor);
		}
		return root; // Retorna a raiz da árvore
	}

	// Método para encontrar o valor mínimo em uma árvore
	String minValue(Node root) {
		String minv = root.valor; // Inicializa o valor mínimo com a palavra do nó atual
		while (root.left != null) {
			minv = root.left.valor; // Atualiza o valor mínimo
			root = root.left; // Move-se para a subárvore esquerda
		}
		return minv; // Retorna o valor mínimo
	}
}
