<img width="425" height="400" alt="Design sem nome" src="https://github.com/user-attachments/assets/726b82a8-dd77-44a8-bbc6-7c8f7855836c" />

# PASSAPORTE-DIGITAL

![Java 21](https://img.shields.io/badge/Java-21-007396?logo=openjdk&logoColor=white)
![Spring Boot 4.1.1](https://img.shields.io/badge/Spring%20Boot-4.1.1-6DB33F?logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/Banco%20de%20dados-PostgreSQL-4479A1?logo=postgresql&logoColor=white)
![Status](https://img.shields.io/badge/Status-Em%20desenvolvimento-orange)

Uma solução digital criada para facilitar e padronizar o processo de solicitação e acompanhamento de manutenção no Centro WEG/SENAI.

O **Passaporte Digital das Máquinas** propõe centralizar em uma única plataforma as solicitações relacionadas a máquinas e equipamentos. Por meio de um QR Code, os usuários poderão acessar o sistema, entrar com suas credenciais e utilizar as funcionalidades de acordo com seu perfil.

O objetivo é que uma ocorrência possa ser registrada, analisada, encaminhada, acompanhada e encerrada no próprio sistema, mantendo um histórico organizado das solicitações e dos atendimentos realizados.

## Objetivo

Facilitar e padronizar a solicitação e o acompanhamento da manutenção das máquinas do Centro WEG/SENAI, reduzindo a dependência de comunicações informais e melhorando a rastreabilidade das ocorrências.

## Problema que o projeto busca resolver

Quando um aluno identifica um problema durante uma atividade prática, a informação pode depender da comunicação com um professor ou outro responsável. Sem um registro centralizado, pode ser difícil acompanhar o chamado, identificar quem é responsável pelo atendimento e consultar ocorrências anteriores.

A proposta é oferecer um fluxo digital que mantenha as informações organizadas desde a abertura da solicitação até sua conclusão.

## Funcionalidades previstas

- **Acesso pelo QR Code:** entrada rápida na plataforma disponibilizada no ambiente do Centro WEG/SENAI.
- **Autenticação e perfis:** apresentação das funcionalidades conforme as permissões do usuário.
- **Solicitações de manutenção:** registro da máquina, tipo de problema, descrição e prioridade, quando aplicável.
- **Anexos e evidências:** possibilidade de associar fotos ou outros arquivos a uma solicitação.
- **Acompanhamento de chamados:** consulta do estado atual das solicitações.
- **Gerenciamento de solicitações:** análise, definição de responsável, encaminhamento e encerramento.
- **Cadastro e situação das máquinas:** consulta da identificação e do estado do equipamento.
- **Atendimentos e pareceres técnicos:** registro dos atendimentos e das ações corretivas e preventivas.
- **Histórico:** consulta de solicitações e atendimentos anteriores.
- **Dashboard:** visão geral de chamados e da disponibilidade das máquinas.

> A lista descreve o escopo planejado do sistema. A disponibilidade de cada recurso depende do estágio de implementação no código.

## Perfis de usuário

### Aluno

O aluno poderá registrar solicitações, descrever o problema, anexar evidências quando disponível e acompanhar os próprios chamados. Não deverá alterar o status dos chamados nem acessar funções administrativas.

### Professor/Coordenador

O professor ou coordenador terá permissões ampliadas para visualizar e analisar solicitações, definir responsáveis, atualizar o andamento, registrar informações de atendimento, encerrar chamados e consultar o histórico. A proposta também prevê a administração dos cadastros de máquinas e usuários conforme as permissões definidas para o sistema.

## Fluxo de uma solicitação

1. O usuário identifica um problema em uma máquina ou equipamento.
2. Acessa a plataforma pelo QR Code e realiza o login.
3. O aluno registra a solicitação e informa os dados necessários.
4. O professor ou coordenador analisa o chamado e define seu encaminhamento.
5. O responsável registra o atendimento realizado.
6. O status da solicitação e, quando necessário, o status da máquina são atualizados.
7. A solicitação é concluída e permanece disponível no histórico.

### Status previstos

**Solicitações:** `EM_ANALISE`, `EM_MANUTENCAO`, `CONCLUIDO` e `CANCELADO`.

**Máquinas:** `DISPONIVEL`, `EM_MANUTENCAO` e `INDISPONIVEL`.

O status da solicitação representa a etapa do chamado; o status da máquina indica se o equipamento está disponível para uso. São informações distintas.

## Tecnologias

### Back-end

- **Java 21** — linguagem utilizada no back-end.
- **Spring Boot 4.1.1** — estrutura principal da aplicação, conforme o `pom.xml`.
- **Spring Web MVC / API REST** — comunicação HTTP com os clientes da aplicação.
- **Spring Data JPA e Hibernate** — persistência e mapeamento objeto-relacional.
- **MySQL** — banco de dados relacional.
- **Spring Security** — dependência prevista para a proteção da aplicação; as regras de autenticação e autorização devem acompanhar a implementação do projeto.
- **Bean Validation** — validação dos dados recebidos pela API.
- **Springdoc OpenAPI** — documentação interativa da API.
- **Maven Wrapper** — execução dos comandos Maven sem exigir uma instalação global do Maven quando o ambiente permitir o download dos componentes necessários.

### Front-end

A arquitetura documentada prevê **React + TypeScript** para a interface. O ZIP usado como referência para este README contém o projeto Java do back-end, mas não inclui os arquivos de um front-end React, como `package.json`. Os comandos de instalação e execução do front-end devem ser acrescentados quando essa parte estiver integrada ao repositório.

## Modelo de dados

A documentação do projeto prevê as seguintes entidades principais:

| Entidade | Finalidade |
|---|---|
| `Usuario` | Guarda os dados dos usuários e seu perfil. |
| `Perfil` | Define os perfis de acesso, inicialmente `ALUNO` e `PROFESSOR`. |
| `Maquina` | Armazena identificação, descrição, foto e status da máquina. |
| `Solicitacao` | Registra o chamado, a máquina, o solicitante, o responsável, a prioridade e o status. |
| `AnexoSolicitacao` | Relaciona arquivos de evidência a uma solicitação, armazenando o endereço do arquivo e seu tamanho em bytes. |
| `Atendimento` | Registra quem realizou o atendimento e seus horários de início e fim. |
| `ParecerTecnico` | Registra o parecer, ações corretivas, ações preventivas e o status definido para a máquina. |

Uma solicitação pode possuir vários anexos e atendimentos. Os arquivos de evidência podem ficar no servidor ou em um serviço de armazenamento; o banco guarda o endereço e os metadados do arquivo, conforme a modelagem documentada.

## Estrutura do repositório

A estrutura do back-end presente no pacote de referência é semelhante a esta:

```text
PASSAPORTE-DIGITAL/
├── README.md
└── Passaporte.digital/
    ├── pom.xml
    ├── mvnw
    ├── mvnw.cmd
    └── src/
        ├── main/
        │   ├── java/Projeto/Passaporte/digital/
        │   │   ├── AnexoSolicitacao/
        │   │   ├── Atendimento/
        │   │   ├── Maquina/
        │   │   ├── ParecerTecnico/
        │   │   ├── Perfil/
        │   │   ├── Solicitacao/
        │   │   ├── Usuario/
        │   │   └── Application.java
        │   └── resources/
        │       └── application.properties
        └── test/
```

Os módulos são organizados por domínio para separar as responsabilidades e facilitar a manutenção do código.

## Como executar o back-end

### Pré-requisitos

- JDK **21** instalado.
- MySQL instalado e em execução.
- Git para obter o código-fonte.
- Acesso à internet na primeira execução do Maven Wrapper, caso ele precise baixar componentes.

### 1. Obtenha o repositório

Clone o repositório pela URL fornecida pela equipe e entre na pasta do back-end. Substitua o exemplo abaixo pela URL real do repositório:

```bash
git clone <URL_DO_REPOSITORIO>
cd PASSAPORTE-DIGITAL/Passaporte.digital
```

Se o nome da pasta criada pelo Git for diferente, ajuste o comando `cd`.

### 2. Configure o banco de dados

Crie um banco de dados local no MySQL. Por exemplo:

```sql
CREATE DATABASE passaporte_digital;
```

Configure a conexão em `src/main/resources/application.properties`. O exemplo abaixo pressupõe que o banco tenha o nome `passaporte_digital`; ajuste host, porta e nome conforme o ambiente de desenvolvimento:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/passaporte_digital
spring.datasource.username=${DB_USERNAME}
spring.datasource.password=${DB_PASSWORD}
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
```

Defina `DB_USERNAME` e `DB_PASSWORD` na configuração de execução local da IDE ou no ambiente do processo antes de iniciar a aplicação. Mantenha credenciais reais fora do Git e não publique senhas, tokens ou outros segredos. Confira com a equipe as demais configurações JPA já utilizadas pelo projeto antes de alterar o comportamento de criação/atualização das tabelas.

### 3. Inicie a aplicação

**Windows (PowerShell ou terminal do IntelliJ):**

```powershell
.\mvnw.cmd spring-boot:run
```

**Linux ou macOS:**

```bash
./mvnw spring-boot:run
```

Se a inicialização terminar corretamente, a aplicação deverá informar no terminal que o servidor foi iniciado. A porta depende da configuração ativa; o padrão do Spring Boot é `8080`.

### 4. Execute os testes

**Windows:**

```powershell
.\mvnw.cmd test
```

**Linux ou macOS:**

```bash
./mvnw test
```

## Documentação da API

O projeto inclui a dependência Springdoc OpenAPI. Com a aplicação em execução, verifique os seguintes endereços locais:

- Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- Especificação OpenAPI: `http://localhost:8080/v3/api-docs`

O acesso a essas páginas pode depender das regras de segurança configuradas na aplicação.


**Passaporte Digital das Máquinas** — *Do problema identificado à manutenção resolvida, tudo em um só lugar.*
