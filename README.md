# 💰 Controle Financeiro Pessoal

API REST desenvolvida com **Spring Boot 3** para controle de finanças pessoais, permitindo o gerenciamento de **usuários, categorias, receitas e despesas**, com filtros por data, tipo e categoria.

---

## 🔧 Tecnologias utilizadas

- Java 17+
- Spring Boot 3.5
- Maven
- Spring Web
- Spring Data JPA
- H2 Database (para testes locais)
- Spring Boot DevTools

---

## 📚 Funcionalidades

- ✅ Cadastro e gerenciamento de **usuários**
- ✅ Registro de **receitas** e **despesas**
- ✅ Filtro de lançamentos por:
  - Categoria
  - Tipo (RECEITA / DESPESA)
  - Período (data de início e fim)
- ✅ Relacionamento entre usuários e seus lançamentos/categorias
- ✅ Validação básica e tratamento de erros (em breve)

---

## 📂 Estrutura do projeto

---

## ▶️ Como executar

1. Clone o repositório:
   ```bash
   git clone https://github.com/seu-usuario/controle-financeiro-pessoal.git
  ```

2. Navegue até a pasta:
  ```bash
   cd controle-financeiro-pessoal
  ```

3. Compile e execute com o Maven:
  ```bash
   ./mvnw spring-boot:run
  ```

4. Acesse o Swagger:
  ```bash
   http://localhost:8080/swagger-ui/index.html
  ```

---

👨‍💻 Autor
Desenvolvido por Alexandre S. Cunha
📎 GitHub: @sc-alexandre

---
