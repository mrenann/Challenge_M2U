# Desafio Mobile2You

<img src="https://is4-ssl.mzstatic.com/image/thumb/Purple114/v4/97/0e/e2/970ee217-13cf-1674-b016-461aca657663/pr_source.png/460x0w.png" align="left"
width="200" hspace="10" vspace="10">

Foi passado um desafio pela Mobile2U um desafio no qual utilizando a API do The Movie DB, implementar uma tela com as informações de algum filme qualquer.
Não sendo necessário mais do que esta tela principal.

O Desafio era replicar o layout da tela de detalhe dos filmes do app TodoMovies4(Foto ao lado)

## Requisitos
- Usar alguma arquitetura: MVP, MVVM, MVI, Clean.
- As informações do filme devem vir do endpoint getMovieDetails.
- Usar o vote_count que retorna da API para representar o número de likes.
- Substituir o “3 of 10 watched” por “<popularity> views”, utilizando o valor retornado da API e
mantendo algum ícone ao lado.
- O ícone de like (coração) deve mudar quando clicado, alternando entre preenchido e vazio.
- Deve haver uma lista de filmes abaixo dos detalhes.
- O app deve ser desenvolvido utilizando a linguagem Kotlin.
- O projeto deve ser disponibilizado em um repositório aberto no GitHub. Envie a URL assim que
possível.


## Instalação

Pelo fato do App utilizar a API do TMDB, que por sua vez necessita de uma Key, foi retirado do código ao subir para o GitHub, antes de rodar coloque a sua chave em:

```
app/main/java/com.mrenann.challengem2u/utils/Constants
```
Vocẽ encontrará ```const val API_AUTH_VALUE = Bearer YOUR_KEY ``` , só substituir YOUR_KEY por sua API KEY

## Features

- Uma SplashScreen simples
- Uma Activity principal no qual tem um filme em destaque com o nome,uma foto,algumas informações e também os filmes similares que podemos navegar entre eles e marcá-los


## Screenshots

<img src="https://i.imgur.com/mGYjMfo.jpg" align="left"
width="200" hspace="10" vspace="10">

<img src="https://i.imgur.com/biUMAkE.jpg" align="left"
width="200" hspace="10" vspace="10">

<img src="https://i.imgur.com/0K7Q1CG.jpg" align="left"
width="200" hspace="10" vspace="10">

<img src="https://i.imgur.com/lbP6iNk.jpg" align="left"
width="200" hspace="10" vspace="10">



