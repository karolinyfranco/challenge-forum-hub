
# Challenge FórumHub 💬
Projeto desenvolvido como parte do Challenge da Alura, tendo como objetivo a criação de um fórum em Java e Spring.

O Fórum Hub consiste em uma API Rest que permite que o usuário tenha acesso, cadastre, edite e exclua registros de tópicos, salvando os dados em um banco de dados local.

## Funcionalidades

A aplicação oferece as seguintes funcionalidades:

- Cadastro de usuários;
- Cadastro de tópicos;
- Listagem de tópicos salvos;
- Detalhes de tópicos salvos;
- Edição de informações de tópicos;
- Exclusão lógica do registro de tópicos.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação principal do projeto.
- **Spring Boot**: Framework para aplicações Java que facilita a criação de sistemas robustos e de alta performance.
- **Spring Security**: Um módulo do Spring que provê autenticação e controle de acesso para aplicações.
- **Spring Web**: Um módulo do Spring para construir aplicações web e RESTful APIs.
- **Spring Doc**: Uma ferramenta para documentação de APIs RESTful, gerando automaticamente a documentação a partir do código.
- **MySQL**: Sistema de gerenciamento de banco de dados relacional, amplamente utilizado para aplicações web.
- **Lombok**: Biblioteca que reduz o boilerplate code em Java, gerando automaticamente getters, setters, e outros métodos comuns.
- **JPA (Java Persistence API)**: Um framework para mapeamento objeto-relacional que simplifica o acesso a dados em aplicativos Java.
- **Dev Tools**: Ferramentas de desenvolvimento que oferecem funcionalidades como hot-reloading, facilitando o desenvolvimento ágil.
- **Flyway**: Uma ferramenta para migração de banco de dados, que permite versionar e aplicar scripts de mudanças no banco de dados de forma controlada e segura.

## Variáveis de Ambiente

O arquivo "application.properties" requer a configuração das seguintes variáveis de ambiente com chaves que tenham a mesma nomeclatura definida nele, e os valores personalizados de acordo com a sua necessidade:

`DB_USER_MYSQL`

`DB_PASSWORD_MYSQL`

## Execução

- Faça um clone deste repositório para sua máquina local.
- Configure seu banco de dados relacional criando as tabelas "usuarios" e "topicos".
- Atualize o arquivo de configuração 'application.properties' com as informações do seu banco de dados.
- Após a instalação das dependências requeridas, é possível executá-lo.
- É possível verificar a documentação da API enquanto o programa estiver em execução através do caminho: http://localhost:8080/swagger-ui.html
