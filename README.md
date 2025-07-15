# CRUD Java com SQLite

## 📄 Descrição

Este projeto é um sistema básico de gerenciamento de clientes desenvolvido em **Java**, utilizando **SQLite** como banco de dados e **JDBC** para conexão. Implementa as operações CRUD (Criar, Ler, Atualizar e Deletar) em uma aplicação console simples.

O objetivo é demonstrar o uso prático de Java para manipulação de banco de dados, incluindo:

- 🔌 Conexão com banco SQLite  
- 🗃️ Criação automática da tabela cliente (caso não exista)  
- 📝 Inserção de novos clientes  
- 📋 Listagem de clientes cadastrados  
- ✏️ Atualização de dados de clientes  
- ❌ Exclusão de clientes pelo ID  

---

## 🛠 Tecnologias Utilizadas

- Java 17 (ou versão compatível)
- JDBC (Java Database Connectivity)
- SQLite (arquivo `clientes.db`)

---

## 📁 Estrutura do Projeto

- `Main.java` — Classe principal com menu interativo via console  
- `Cliente.java` — Classe modelo que representa os clientes  
- `ClienteDAO.java` — Classe responsável pela conexão com o banco e operações CRUD  

---

## 🚀 Melhorias Futuras

- Adicionar interface gráfica (Java Swing/JavaFX)  
- Implementar testes automatizados para os métodos CRUD  
- Melhorar tratamento de exceções e mensagens ao usuário  
- Usar um gerenciador de dependências (Maven/Gradle)  
- Adicionar documentação com JavaDoc
