# Atividade Avaliativa SD 2023.2 
**Alunas:** Ladiane Pinhiro Santana;
            Érica Santos Oliveira da Silva;
        
## Descrição do Projeto de Fila de Veículos
<p>O presente projeto implementa uma fila de veículos utilizando tecnologias como Spring Boot, Spring Data JPA e Thymeleaf. Essa atividade avaiativa foi proposta pelo professor da disciplina de Sistemas Distribuídos do Curso de TADS do IFPA.</p>

## Requisitos
<ul>
    <li>Java JDK 17 ou superior</li>
    <li>Maven 3.8.4 ou superior</li>
    <li>Banco de dados H2 (configurado no arquivo application.properties)</li>    
</ul>

## Configuração
<ol>
    <li>Clone o repositório para sua máquina local:</li>
    <p>```<br>
        git clone https://github.com/seu-usuario/veiculofila.git <br>
        ```</p>
    <li>Importe o projeto em sua IDE de preferência (por exemplo, Eclipse ou IntelliJ).</li>
    <li>Certifique-se de que as dependências do Maven estão sendo baixadas corretamente.</li>
    <li>Configure as propriedades do banco de dados no arquivo application.properties:</li>
    <p>```<br>
        spring.datasource.url=jdbc:h2:mem:testdb<br>
        spring.datasource.username=sa<br>
        spring.datasource.password=<br>
        spring.datasource.driver-class-name=org.h2.Driver<br>
        spring.jpa.database-platform=org.hibernate.dialect.H2Dialect<br>
        spring.jpa.show-sql=true<br>
        spring.h2.console.enabled=true<br>
        ```</p>
</ol>

## Executando um Aplicativo
<ol>
    <li>Execute uma classe VeiculofilaApplicationcomo um aplicativo Java;</li>
    <li>A aplicação será iniciada e estará disponível em http://localhost:8081.</li>
</ol>

# API REST
## Incluir veículo na fila
<ul>
    <li>Método: POST</li>
    <li>Ponto final: /veiculos</li>
    <li>Corpo da Requisição: JSON contendo os dados do veículo a ser incluído</li>
    <li>Exemplo:</li>
    <code>
        ```
        {
        "marca": "Ford",
        "modelo": "Fiesta",
        "ano": 2022
        }
        ```    
    </code>
</ul>
## Consultar Veículos na Fila
<ul>    
    <li>Método: GET</li>
    <li>Ponto final: /veiculos</li>
    <li>Retornar uma lista de veículos na fila</li>
</ul>
## Interface Web
<p>A interface web pode ser acessada em http://localhost:8081.
 Ela exibe uma lista de veículos presentes na fila.</p>
