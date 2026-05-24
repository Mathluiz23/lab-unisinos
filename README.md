# Desafio de Laboratório II — Estruturas de Dados

Este projeto é composto por 4 etapas, cada uma abordando um conceito fundamental de estruturas de dados em Java. O objetivo é implementar as soluções conforme o enunciado, utilizando apenas as estruturas permitidas em cada etapa.

## Estrutura do Projeto

```
src/
  PrincipalProjeto.java
  Etapa1/
    Labirinto.java
    PrincipalLabirinto.java
    ValidadorEtapa1EstudanteMRK.java
    labirinto.txt
  Etapa2/
    Candidato.java
    OrdenarCandidatos.java
    PrincipalCandidatos.java
    ValidadorEtapa2EstudanteMRK.java
    nomes.txt
    partidos.txt
  Etapa3/
    Etapa3.java
    PrincipalEtapa3.java
    StaticList.java
    StaticStack.java
    Stack.java
    List.java
    ValidadorEtapa3EstudanteMRK.java
  Etapa4/
    LinkedQueue.java
    LinkedStack.java
    Node.java
    PrincipalEtapa4.java
    Queue.java
    Stack.java
    ValidadorEtapa4MRK.java
bin/
  arquivos .class gerados pela compilacao
```

## Etapas

### Etapa 1 — Labirinto Recursivo
- Implementação de um algoritmo recursivo para encontrar o caminho em um labirinto representado por uma matriz de caracteres.
- 'X' = parede, ' ' = caminho livre, 'D' = destino.

### Etapa 2 — Pesquisa e Ordenação
- Implementação de métodos de pesquisa e ordenação estáveis em uma classe definida pelo estudante.

### Etapa 3 — Estruturas Estáticas
- Implementação de métodos utilizando listas e pilhas estáticas.

### Etapa 4 — Estruturas Dinâmicas
- Implementação de pilha e fila dinâmicas (listas encadeadas).

## Como Executar

1. Compile o projeto completo:
   ```sh
   javac -d bin src/PrincipalProjeto.java src/Etapa1/*.java src/Etapa2/*.java src/Etapa3/*.java src/Etapa4/*.java
   ```
2. Execute todas as etapas em sequência:
   ```sh
   java -cp bin PrincipalProjeto
   ```
3. Execute os validadores:
   ```sh
   java -cp bin Etapa1.ValidadorEtapa1EstudanteMRK
   java -cp bin Etapa2.ValidadorEtapa2EstudanteMRK
   java -cp bin Etapa3.ValidadorEtapa3EstudanteMRK
   java -cp bin Etapa4.ValidadorEtapa4MRK
   ```

## Entrega
- Envie um arquivo .zip contendo **todas as pastas e arquivos do projeto**.
- Grave um vídeo de até 4 minutos mostrando:
  - Compilação e execução do programa
  - Demonstração das funcionalidades de cada etapa
  - Execução do validador e nota atribuída

## Observações
- Siga rigorosamente as estruturas de dados solicitadas em cada etapa.
- Não copie códigos da internet ou de colegas.
- O vídeo é obrigatório para avaliação.

---

**Bons estudos e boa sorte!**
