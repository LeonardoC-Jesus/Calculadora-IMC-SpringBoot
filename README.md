# Calculadora de IMC com Histórico

Aplicação web simples desenvolvida com Spring MVC para calcular o Índice de Massa Corporal (IMC), classificar o resultado e manter um histórico dos cálculos realizados durante a execução da aplicação.

<!-- Se quiser, adicione badges aqui depois, ex: build, versão do Java, licença -->

## Sobre o projeto

Este projeto foi desenvolvido como parte de uma trilha de estudos progressiva em Spring Boot, com foco exclusivo em **Spring MVC** — sem uso de banco de dados ou persistência real. O objetivo é consolidar o ciclo `Controller → Service → View`, aplicando boas práticas de separação de responsabilidades, validação de dados e tratamento de erros desde o início, antes de avançar para tópicos como Spring Data e Spring Security.

## Funcionalidades

- Cálculo do IMC a partir de peso e altura informados pelo usuário
- Classificação automática do resultado (abaixo do peso, normal, sobrepeso, obesidade)
- Validação de dados de entrada (peso e altura devem ser maiores que zero)
- Histórico dos cálculos realizados durante a sessão da aplicação, exibido do mais recente para o mais antigo
- Tratamento de erros de validação sem quebra da aplicação, mantendo os dados preenchidos no formulário

## Tecnologias utilizadas

- Java
- Spring Boot
- Spring Web (MVC)
- Thymeleaf
- Lombok
- Spring Boot DevTools

## Como rodar o projeto localmente

Pré-requisitos: Java 17+ e Maven instalados (ou use o wrapper `./mvnw` incluído no projeto).

```bash
# Clonar o repositório
git clone <url-do-seu-repositorio>
cd calculadora-imc

# Rodar a aplicação
./mvnw spring-boot:run
```

A aplicação estará disponível em `http://localhost:8080/v1/imc`.

## Como usar

| Método | Rota | Descrição |
|---|---|---|
| GET | `/v1/imc` | Exibe o formulário e o histórico de cálculos |
| POST | `/v1/imc` | Envia peso e altura, calcula o IMC e adiciona ao histórico |

<!-- Adicione aqui um print ou GIF da tela quando o projeto estiver pronto -->

## Decisões técnicas

- **Sem banco de dados neste degrau:** o objetivo do projeto é focar exclusivamente no funcionamento do Spring MVC (Controller → Service → View). Persistência real é tratada em um projeto posterior da trilha, com Spring Data.
- **Histórico em memória (singleton do Service):** como todo `@Service` no Spring é, por padrão, singleton, o histórico é mantido como um atributo da própria classe de serviço, sobrevivendo entre requisições enquanto a aplicação está no ar (mas sendo perdido ao reiniciar).
- **Separação de responsabilidades:** toda lógica de cálculo e validação está no `ImcRegistroService`; o `ImcRegistroController` é responsável apenas por orquestrar a requisição e devolver a view correta.
- **Tratamento de erros centralizado:** validações inválidas são tratadas via `@ControllerAdvice`, evitando erros 500 e mantendo os dados do formulário para correção pelo usuário.

## Estrutura do projeto

```
com.seuprojeto.imc
├── controller
├── service
├── model
├── exception
└── handler
```

## Autor

Leonardo Cruz de Jesus
