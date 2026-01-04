# Transaction Statistics ⚡

**Projeto:** Serviço simples em Spring Boot que registra transações (valor + timestamp) e calcula estatísticas (soma, média, máximo, mínimo e quantidade) para um intervalo de tempo configurável (padrão: últimos 60 segundos).

**Contexto:** Este repositório faz parte de um *desafio semanal* em Java Spring Boot — exercício para praticar conceitos de API.  
**Desafio:** Primeira semana.

---

## 🧩 Tecnologias

- Java 17+
- Spring Boot
- Maven (inclui wrapper `mvnw` / `mvnw.cmd`) 

---

## ⚙️ Requisitos

- Java 17+ (JDK 17 ou superior)
- Spring Boot
- API REST
- Não usar banco de dados — armazenamento em memória
- Validações implementadas:
  - transações no futuro → rejeitar
  - valores negativos → rejeitar
- Porta padrão: 8080

---

## ▶️ Como executar

No Windows (usando o wrapper):

```powershell
.\mvnw.cmd spring-boot:run
```

No macOS / Linux:

```bash
./mvnw spring-boot:run
```

Ou construir e executar o JAR:

```bash
./mvnw package
java -jar target/*.jar
```

---

## 🔌 Endpoints

Base URL: `http://localhost:8080/transactions`

- POST `/transactions`  
  - Descrição: cria uma nova transação com o valor informado e timestamp atual.  
  - Requisição (JSON): `{ "value": 10.50 }`  
  - Validação: `value` é obrigatório e deve ser positivo.  
  - Resposta: `201 Created` com o objeto `Transaction` (atributos: `value`, `dateTime`).  

- GET `/transactions`  
  - Descrição: retorna todas as transações armazenadas em memória.  

- GET `/transactions/statistics?seconds={n}`  
  - Descrição: retorna as estatísticas das transações nos últimos `n` segundos (padrão `60`).  
  - Resposta (JSON): `{ "sum": ..., "average": ..., "max": ..., "min": ..., "count": ... }`

---

## 🎯 O que você aprende

- Controllers REST
- DTOs
- Validações
- Trabalhar com datas (Instant, LocalDateTime)
- Streams e cálculos estatísticos
- Organização básica de projeto
