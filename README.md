# Baralho
Esta API permite a criação de jogadores, distribuição de cartas e determinação dos vencedores com base na pontuação das cartas.
## ------------------------------TECNOLOGIAS------------------------
* Java 17
* Spring BOOT
* Sprint DATA
* Spring TEST
* Postgresql 
* Gradle
* Lombok
* Jackson Annotations
* Hibernate
* H2
* Feign

## -------------------------------DATABASE------------------------

* # Configurações do Banco de Dados
* spring.datasource.url=jdbc:postgresql://localhost:5432/postgres -> URL padrão
* spring.datasource.username={UserName}
* spring.datasource.password={Senha}
* spring.datasource.driver-class-name=org.postgresql.Driver

## -------------------------------ENDPOINT-------------------------
# /jogador

POST / : Criar jogador.
Body: {name(String)}

GET / : Lista todos os Jogadores registrado.

DEL /{jogadorId}: Deleta um jogador selecionado por Id.

# /deck

POST /{jogadorId}/deck/new: Cria um deck para o Jogador selecionado.

POST /{deck_id}/sort: Sorteia 5 cartas aleatorias para o deck.

DEL /{deckId}: deleta um deck selecionado por Id.

# /partida

GET /decks/comparar: Retorna o(s) jogador(es) com maior pontuação de carta:

