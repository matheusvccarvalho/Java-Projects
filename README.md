# 🛒 Sistema de Gestão de Estoque e Produtos  
### Operação Supermercadista (Shibata)

---

## 📖 Descrição do Projeto
Este projeto consiste em um sistema web para gerenciamento de produtos e controle de estoque, inspirado em operações reais do varejo supermercadista, com base no contexto do **Shibata Supermercados**.

A aplicação permite o controle eficiente de itens, movimentações de estoque e organização de produtos, com foco em **redução de perdas, controle operacional e agilidade no dia a dia**.

---

## 🎯 Objetivo
Criar uma solução prática para:

- Controlar entrada e saída de produtos  
- Monitorar níveis de estoque  
- Evitar rupturas (falta de produto)  
- Reduzir perdas operacionais  
- Servir como base para análises futuras (BI / relatórios)  

---

## 🏗️ Arquitetura do Sistema

O projeto segue o padrão **MVC**:

- **Model** → Entidades (Produto, Estoque, Movimentação)  
- **DAO** → Persistência de dados (JDBC)  
- **Controller (Servlets)** → Regras de negócio  
- **View (JSP)** → Interface do usuário  

💡 Utilização do padrão DAO para desacoplamento do banco de dados.

---

## ⚙️ Tecnologias Utilizadas

- Java (JDK 8)  
- Servlets (Java EE)  
- JSP (Java Server Pages)  
- JDBC  
- MySQL  
- Apache Tomcat  
- XAMPP  

---


### 📦 Funcionalidades

#### 🏷️ Produtos
- Cadastro de produtos  
- Edição e exclusão  
- Consulta por nome ou código  

#### 📦 Controle de Estoque
- Registro de entrada de mercadorias  
- Registro de saída (vendas/perdas)  
- Atualização automática de saldo  

#### 🔄 Movimentações
- Histórico de movimentações  
- Tipos:
  - Entrada  
  - Saída  
  - Ajustes  

---

### 🧠 Regras de Negócio

- Produto não pode ter estoque negativo  
- Campos obrigatórios validados  
- Atualização automática do estoque a cada movimentação  
- Identificação única por código de produto  

---

### 🗄️ Banco de Dados

**Estrutura:**
- PRODUTO  
- ESTOQUE  
- MOVIMENTACAO  

**Relacionamentos:**
- 1 Produto → 1 Estoque  
- 1 Produto → N Movimentações  

---
---

### File Tree

 

---

### ▶️ Como Executar

#### 🔧 1. Banco de Dados

CREATE DATABASE SUPERMERCADO_GESTAO;

---

#### 🔧 2. Configurar Conexão

Arquivo:  
util/ConexaoBD.java  

Exemplo:

String URL = "jdbc:mysql://localhost:3306/SUPERMERCADO_GESTAO";  
String USER = "root";  
String PASSWORD = "";  

---

#### 🔧 3. Servidor

- Apache Tomcat (8.5+)  
- Deploy via NetBeans  

---

#### ▶️ 4. Acesso

http://localhost:8080/supermercado-gestao  

---

### 📊 Diferenciais do Projeto

- 💡 Inspirado em operação real de supermercado  
- 💡 Controle de estoque com regras de negócio aplicadas  
- 💡 Arquitetura organizada (MVC + DAO)  
- 💡 Base pronta para evolução com BI  
- 💡 Aplicável a diversos tipos de varejo  

---

### 🚀 Próximos Passos

- [ ] Dashboard de estoque (Power BI)  
- [ ] Alertas de estoque mínimo  
- [ ] Controle de validade de produtos  
- [ ] Relatórios de giro de estoque  
- [ ] Integração com sistema de vendas  
- [ ] API REST com Spring Boot  

---

### 🤖 Uso de Inteligência Artificial

A IA foi utilizada como suporte para:

- Correção de erros (Servlets, JDBC, HTTP)  
- Organização da arquitetura  
- Sugestões de melhorias  
- Documentação do projeto  

**Impacto:**
- Aumento de produtividade  
- Redução de erros  
- Melhor qualidade de código  

---

### 📌 Observações

Este projeto simula um cenário real do varejo, com foco em controle de estoque e eficiência operacional — um dos principais desafios de supermercados.

---

### 👨‍💻 Autor

Matheus Carvalho  
Engenharia de Software | Foco em Agro + Tecnologia  
