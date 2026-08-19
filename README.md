# Persistent Bugger Kata — Detect Pangram

Projeto individual da disciplina, com o objetivo de automatizar testes de um
programa simples usando **JUnit 6** e **Maven**.

# Um pangrama é uma frase que usa todas as letras do alfabeto de uma língua. Ele serve para testar teclados e máquinas de escrever, mostrar fontes de letras em computadores, treinar a caligrafia ou avaliar equipamentos de comunicação.

## Enunciado escolhido

- **Plataforma:** [CodeWars](https://www.codewars.com)
- **Kata:** [Detect Pangram](https://www.codewars.com/kata/545cedaa9943f7fe7b000048) (6 kyu)
- **Descrição resumida:** dada uma string, verificar se ela é um *pangram*
  — ou seja, se contém todas as letras do alfabeto inglês (A–Z) pelo menos
  uma vez, ignorando maiúsculas/minúsculas.

## Estrutura do projeto

```
.
├── pom.xml
├── src
│   ├── main
│   │   └── java
│   │       └── com
│   │           └── exercicio
│   │               ├── Main.java              # ponto de entrada (lê a entrada e imprime o resultado)
│   │               └── PangramChecker.java     # classe auxiliar com a lógica do kata
│   └── test
│       └── java
│           └── com
│               └── exercicio
│                   └── PangramCheckerTest.java # testes automatizados com JUnit
└── README.md
```

## Tecnologias

- **Java 17+**
- **Maven** (gerenciador de dependências e build)
- **JUnit 6** (`junit-jupiter`, via `junit-bom`)

## Como rodar os testes

Com o Maven instalado, na raiz do projeto:

```bash
mvn test
```

O Maven baixa as dependências automaticamente na primeira execução e roda
todos os testes da classe `PangramCheckerTest`.

## Como rodar o programa

```bash
mvn compile exec:java -Dexec.mainClass="com.exercicio.Main"
```

Ou, após compilar manualmente, execute `Main.java` e digite a frase que
deseja verificar. O programa imprime `true` se for um pangram, ou `false`
caso contrário.

## O que foi testado

A classe `PangramCheckerTest` cobre:

- **Caso positivo:** o pangram clássico em inglês (`"The quick brown fox..."`);
- **Caso negativo:** frase que não contém todas as letras;
- **Case-insensitive:** o mesmo pangram em maiúsculas;
- **Caso de erro:** entrada `null` deve lançar `IllegalArgumentException`;
- **Casos parametrizados (`@ParameterizedTest` + `@CsvSource`):** vários
  pares de entrada/saída rodados de uma só vez, incluindo string vazia,
  o alfabeto puro e outro pangram famoso ("Pack my box...").

Também são usados:

- `@DisplayName` — para nomear os testes de forma legível nos relatórios;
- `@BeforeEach` — recriando a instância de `PangramChecker` antes de cada teste,
  garantindo isolamento entre os casos.

## Confirmação na plataforma

A solução foi submetida e aceita (`Submit`) no CodeWars, no kata
[Detect Pangram](https://www.codewars.com/kata/545cedaa9943f7fe7b000048).

> Observação: no editor do CodeWars, o método usado é `check(String sentence)`,
> conforme a assinatura exigida pelo kata na plataforma. A mesma lógica foi
> mantida neste repositório, com a classe `PangramChecker` e o método `check`.

## Autor

Eduardo Hoffmann
