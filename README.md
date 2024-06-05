# Sistema de Indexação de Texto Usando Árvores Binárias de Pesquisa

# Visão Geral
Este sistema é um indexador de texto que utiliza árvores binárias de pesquisa (Binary Search Trees - BST) para armazenar, buscar e gerenciar palavras. O sistema oferece várias funcionalidades, incluindo indexação de arquivos de texto, busca de palavras, cálculo do tempo de busca e mais.

## Funcionalidades
- Indexar arquivo de texto
- Buscar palavra
- Buscar por substring
- Calcular o tempo gasto na recuperação de uma palavra
- Calcular a quantidade de palavras armazenadas
- Adicionar palavra
- Remover palavra
- Sair

## Pré-requisitos
- Java JDK 8 ou superior instalado no sistema.
- Um editor de texto ou IDE para editar e compilar código Java (por exemplo, IntelliJ IDEA, Eclipse, VS Code).

## Passos para Instalação

### Instalar Java JDK:
- Faça o download e instale a versão mais recente do [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html).
- Siga as instruções de instalação específicas para o seu sistema operacional.

### Configurar Variáveis de Ambiente:
- Adicione o caminho do JDK às variáveis de ambiente do seu sistema (JAVA_HOME e PATH).

### Clonar ou Baixar o Código-Fonte:
- Clone o repositório do sistema ou baixe os arquivos de código-fonte.

### Compilar e Executar o Sistema:
1. Abra um terminal ou prompt de comando.
2. Navegue até o diretório onde o código-fonte está localizado.
3. Compile o código com o comando: javac Main.java

## Como Utilizar as Funcionalidades

### Iniciar o Sistema:
- Execute o sistema utilizando o comando `java Main`.
- Um menu será apresentado com diversas opções.

### Escolher uma Operação:
- Digite o número correspondente à operação desejada e pressione Enter.

### Operações Disponíveis:

#### 1. Indexar arquivo de texto:
- Insira o caminho completo do arquivo de texto que deseja indexar. O sistema lerá o arquivo, normalizará e limpará as palavras, e as armazenará na árvore binária.
- Exemplo de caminho no Windows: `C:\Users\NomeUsuario\Documentos\palavras.txt`
- Exemplo de caminho no Linux/Mac: `/home/nomeusuario/documentos/palavras.txt`

#### 2. Buscar palavra:
- Digite a palavra que deseja buscar. O sistema informará se a palavra foi encontrada ou não.

#### 3. Buscar por substring:
- Digite a substring que deseja buscar. O sistema listará todas as palavras que contêm a substring.

#### 4. Calcular o tempo gasto na recuperação de uma palavra:
- Digite a palavra para a qual deseja calcular o tempo de busca. O sistema informará o tempo gasto em nanosegundos. Se a palavra não estiver presente, será informado que a palavra não foi encontrada.

#### 5. Calcular a quantidade de palavras armazenadas:
- O sistema calculará e exibirá o número total de palavras armazenadas na árvore.

#### 6. Adicionar palavra:
- Digite a palavra que deseja adicionar. O sistema adicionará a palavra à árvore se ela não estiver duplicada.

#### 7. Remover palavra:
- Digite a palavra que deseja remover. O sistema removerá a palavra se ela estiver presente na árvore. Se a palavra não estiver presente, será informado que a palavra não foi encontrada.

#### 8. Sair:
- Encerra o programa.
