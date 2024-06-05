package tree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

//Classe principal que contém o método main
public class Main {
	public static void main(String[] args) {
		Arvore tree = new Arvore(); // Cria uma nova árvore binária
		Scanner scanner = new Scanner(System.in); // Cria um scanner para ler a entrada do usuário
		boolean running = true; // Variável para manter o programa em execução

		while (running) {
			// Apresenta o menu de opções ao usuário
			System.out.println("\nEscolha uma operação:");
			System.out.println("1. Indexar arquivo de texto");
			System.out.println("2. Buscar palavra");
			System.out.println("3. Buscar por substring");
			System.out.println("4. Calcular o tempo gasto na recuperação de uma palavra");
			System.out.println("5. Calcular a quantidade de palavras armazenadas");
			System.out.println("6. Adicionar palavra");
			System.out.println("7. Remover palavra");
			System.out.println("8. Sair");
			System.out.print("Escolha uma opção: ");
			
			// Lê a escolha do usuário
			int escolha = scanner.nextInt();
			scanner.nextLine(); // Consumir a nova linha deixada pelo nextInt()

			// Executa a ação correspondente à escolha do usuário
			switch (escolha) {
			case 1:
				indexFile(tree, scanner);
				break;
			case 2:
				searchValor(tree, scanner);
				break;
			case 3:
				searchSubstring(tree, scanner);
				break;
			case 4:
				calculateSearchTime(tree, scanner);
				break;
			case 5:
				calculateValorCount(tree);
				break;
			case 6:
				addValor(tree, scanner);
				break;
			case 7:
				removeValor(tree, scanner);
				break;
			case 8:
				running = false; // Encerra o programa
				System.out.println("\nEncerrando o programa...");
				break;
			default:
				System.out.println("\nEscolha inválida."); // Mensagem para escolha inválida
				break;
			}
		}

		scanner.close(); // Fecha o scanner
	}

	// Método para indexar palavras de um arquivo de texto
	private static void indexFile(Arvore tree, Scanner scanner) {
		System.out.println("Por favor, insira o caminho completo do arquivo de texto.");
		System.out.println("Exemplo para Windows: C:\\Users\\NomeUsuario\\Documentos\\palavras.txt");
		System.out.println("Exemplo para Linux/Mac: /home/nomeusuario/documentos/palavras.txt");
		System.out.print("Digite o caminho do arquivo de texto: ");
		String filePath = scanner.nextLine();

		// Lê o arquivo e insere palavras na árvore
		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String line;
			while ((line = br.readLine()) != null) {
				String[] words = line.split("\\s+");
				for (String word : words) {
					word = Utils.normalizeAndClean(word); // Normaliza e limpa a palavra
					if (!word.isEmpty()) {
						tree.insert(word); // Insere a palavra na árvore
					}
				}
			}
			System.out.println("\nIndexação concluída.");
		} catch (IOException e) {
			e.printStackTrace(); // Imprime erro se a leitura falhar
		}
	}

	// Método para buscar uma palavra na árvore
	private static void searchValor(Arvore tree, Scanner scanner) {
		System.out.print("\nDigite a palavra para buscar: ");
		String searchWord = Utils.normalizeAndClean(scanner.nextLine()); // Normaliza e limpa a palavra
		if (tree.search(searchWord))
			System.out.println("\n" + searchWord + " encontrada na árvore."); // Palavra encontrada
		else
			System.out.println("\n" + searchWord + " não encontrada na árvore."); // Palavra não encontrada
	}

	// Método para buscar palavras que contêm uma substring
	private static void searchSubstring(Arvore tree, Scanner scanner) {
		System.out.print("\nDigite a substring para buscar palavras: ");
		String substring = Utils.normalizeAndClean(scanner.nextLine()); // Normaliza e limpa a substring
		System.out.println("\nPalavras contendo a substring '" + substring + "':");
		tree.searchSubstring(tree.root, substring); // Busca palavras que contêm a substring
	}

	// Método para calcular o tempo gasto na recuperação de uma palavra
	private static void calculateSearchTime(Arvore tree, Scanner scanner) {
		System.out.print("\nDigite a palavra para calcular o tempo de busca: ");
		String timeValor = Utils.normalizeAndClean(scanner.nextLine()); // Normaliza e limpa a palavra
		if (tree.search(timeValor)) {
			long searchTime = tree.searchTime(timeValor); // Calcula o tempo de busca
			System.out.println("\nTempo levado para buscar '" + timeValor + "': " + searchTime + " nanosegundos");
		} else {
            System.out.println("\n" + timeValor + " não encontrada na árvore."); // Palavra não encontrada
        }
	}

	// Método para calcular a quantidade de palavras armazenadas na árvore
	private static void calculateValorCount(Arvore tree) {
		int valorCount = tree.valorCount(tree.root); // Conta as palavras na árvore
		System.out.println("\nNúmero de palavras armazenadas na árvore: " + valorCount);
	}
	// Método para adicionar uma palavra à árvore
	private static void addValor(Arvore tree, Scanner scanner) {
		System.out.print("\nDigite a palavra para adicionar: ");
		String newValor = Utils.normalizeAndClean(scanner.nextLine()); // Normaliza e limpa a palavra
		if (!newValor.isEmpty()) {
			tree.insert(newValor); // Insere a nova palavra na árvore
			System.out.println(newValor + " adicionada à árvore.");
		}
	}

	// Método para remover uma palavra da árvore
	private static void removeValor(Arvore tree, Scanner scanner) {
		System.out.print("Digite a palavra para remover: ");
		String removeValor = Utils.normalizeAndClean(scanner.nextLine()); // Normaliza e limpa a palavra
		if (tree.search(removeValor)) {
			tree.remove(removeValor); // Remove a palavra se ela estiver presente
			System.out.println("\n" +removeValor + " removida da árvore.\n");
		} else {
            System.out.println("\n" +removeValor + " não encontrada na árvore."); // Palavra não encontrada
        }
	}
}