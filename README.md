#Teste BANCO BTG

*******
 1. [Introdução](#introdução)
 2. [Regras de negócio](#regras-de-negócio)
 3. [Pré-requisitos](#pré-requisitos)
 4. [Como executar?](#como-executar)
 5. [Como testar](#como-testar)
 6. [Tech/Framework utilizado](#techframework-utilizado)
 
 *******
 
  ## Introdução
  
  Projeto tem por finalizadade realizar a transferência entre duas contas (conta de origem e conta de destino).
  O projeto é um projeto **console** que realiza a transferência do volor diminuindo o saldo da conta da origem e soma o
  valor na conta do destinatário.
  
  ## Regras de negócio 
  - Valide se conta de origem tenha saldo antes de ser retirado o dinheiro
  
  ## Pré-requisitos
   Necessário Java versão 8 ou superior.
   
  ## Como executar?
  
  Baixe o projeto e abra na IDE e execute a rode a classe Main.
  
  ## Como testar?
  Como testes foram criados 3 contas sendo elas da seguinte maneira:
  - (ID: 1 - Saldo: R$ 20,00)
  - (ID: 2 - Saldo: R$ 100,00)
  - (ID: 3 - Saldo: R$ 300,00)
  - (ID: 4 - Saldo: R$ 0,00)
  
  Ao executar a aplicação será exibido um menu de opções para seleção do que o usuário deseja realizar. Esse menu será
  exibido até que o usuário digite a opção de sair.
  
  - *Menu*
  - 0 - Sair
  - 1 - Transferir
  - 2 - Consultar Saldo
  
  ## Tech/Framework utilizado
  - Java 8
  - Maven
  - JUnit 5
  - Log4j