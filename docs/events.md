# Fluxo de Eventos
## Cadastrar usuário
Este caso de uso é responsável por cadastrar um usuário ao sistema.

**Pré condição**: nenhuma.

**Pós condição**: um usuário é cadastrado no sistema.

### Fluxo de eventos principal:
1. O cliente informa os dados cadastrais;
    * Nome de usuário;
    * Senha;
    * Email;
    * Data de nascimento;
2. O sistema verifica se o nome de usuário ou email já existem no sistema;
3. O sistema cadastra o usuário e envia um email de confirmação.

### Fluxo de eventos secundário:
1. No passo (2), se o nome do usuário já existir no sistema, o sistema informa e requisita que outro nome de usuário seja escolhido;
2. No passo (2), se o email já existir no sistema, o sistema informa e requisita que o usuário tente logar ou recuperar sua conta caso tenha esquecido sua senha.

## Efetuar login do usuário
Este caso de uso é responsável por autenticar um usuário do sistema.

**Pré condição**: nenhuma.

**Pós condição**: um usuário válido é logado e sua sessão é registrada no sistema.

### Fluxo de eventos principal:
1. O cliente informa email e senha;
2. O sistema verifica se o e-mail está cadastrado no sistema e foi confirmado, e se a senha informada está correta;
3. O sistema registra o início da sessão de uso.

### Fluxo de eventos secundário:
No passo (2), se o e-mail não está cadastrado no sistema ou a senha está incorreta, o sistema informa que o email ou senha estão incorretos;
No passo (2), se o e-mail não foi confirmado, o sistema informa e requisita que o email seja confirmado.

## Buscar conteúdo
Este caso de uso permite que o usuário pesquise e localize conteúdo específico no sistema, como filmes, séries, livros, animes, mangás, etc. O usuário insere os critérios de pesquisa relevantes e o sistema retorna os resultados correspondentes.

**Pré condição**: O usuário deve estar logado no sistema.

**Pós condição**: Os resultados da pesquisa solicitada são exibidos ao usuário, apresentando uma lista de conteúdos correspondentes com base nos critérios de pesquisa fornecidos.

### Fluxo de eventos principal:
1. O usuário acessa a funcionalidade de busca de conteúdo no sistema;
2. O sistema exibe uma interface de busca, onde o usuário pode inserir os critérios de pesquisa, como palavras-chave, título, autor, gênero, etc;
3. O usuário insere os critérios de pesquisa desejados;
4. O sistema valida e processa os critérios de pesquisa;
5. O sistema realiza a busca usando o caso de uso de "Buscar conteúdos", com base nos critérios fornecidos;
6. O sistema exibe os resultados da busca, apresentando uma lista de conteúdos correspondentes, visualizando títulos, imagens e informações básicas dos conteúdos.

### Fluxo de eventos secundário:
1. No passo (6) caso o sistema não encontre nenhum resultado correspondente aos critérios de pesquisa fornecidos, o sistema exibe uma mensagem ao usuário informando que nenhum resultado foi encontrado.

## Visualizar conteúdo
Este caso de uso permite que o usuário visualize informações detalhadas de um conteúdo selecionado, como um filme, série, livro, etc., a partir da busca ou exploração do catálogo. O usuário pode obter detalhes, como sinopse, elenco, avaliações, duração, entre outros, para tomar decisões informadas sobre o conteúdo.

**Pré condição**: O usuário deve estar logado no sistema e ter realizado uma busca ou exploração do catálogo para encontrar o conteúdo a ser visualizado.

**Pós condição**: O usuário visualiza as informações detalhadas do conteúdo selecionado, incluindo sinopse, elenco, avaliações, duração e outros detalhes relevantes.

### Fluxo de eventos principal:
1. O sistema exibe uma página ou visualização detalhada do conteúdo selecionado, como sinopse, elenco, avaliações, duração (quando aplicável) e outros detalhes relevantes do conteúdo;
2. Além disso, o usuário pode marcar o conteúdo como consumido, interessante, gostei ou desgostei. Além de poder adicionar a uma lista personalizada; 
Logo após o sistema exibe uma sessão de reviews, onde o usuário pode ler críticas de outros usuários sobre o conteúdo. O usuário ainda pode iniciar sua própria crítica.
3. Ao fim o sistema exibe uma lista de conteúdos relacionados (recomendados para quem gosta do conteúdo que está sendo visualizado), visualizando títulos, imagens e informações básicas dos conteúdos;
4. Ao selecionar um conteúdo o fluxo atual reinicia para o conteúdo selecionado; 
O usuário pode retornar à página anterior, no estado em que havia deixado.

## Explorar catálogo de conteúdos
Este caso de uso permite que o usuário explore o conteúdo com base em recomendações personalizadas para o usuário.

**Pré condição**: O usuário deve estar logado no sistema e estar na página de exploração.

**Pós condição**: O usuário explora o conteúdo recomendado.

### Fluxo de eventos principal:
1. O sistema exibe uma página com recomendações personalizadas para o usuário, obtendo recomendações através do caso de uso "Recomendar conteúdos" e buscando os conteúdos das recomendações através do caso de uso "Obter conteúdos";
2. O usuário navega pelas recomendações, visualizando títulos, imagens e informações básicas dos conteúdos recomendados;
3. O usuário seleciona um conteúdo recomendado para visualizar suas informações detalhadas;
4. O caso de uso de visualização de conteúdo é iniciado para o conteúdo selecionado.

## Recomendar conteúdos
Este caso de uso é responsável por gerar recomendações personalizadas para o usuário, com base nas interações anteriores e preferências de conteúdo.

**Pré condição**: O usuário deve estar logado no sistema e ter iniciado o caso de uso de exploração de conteúdos.

**Pós condição**: O sistema gera as recomendações personalizadas para o usuário.

### Fluxo de eventos principal:
1. O sistema analisa as interações anteriores do usuário, como conteúdos marcados como consumidos, gostei, desgostei ou interessante;
2. O sistema utiliza algoritmos de recomendação para processar os dados das interações anteriores e identificar padrões e preferências do usuário;
3. O sistema gera as recomendações personalizadas com base nas preferências identificadas, levando em consideração os conteúdos mais relevantes para o usuário.

### Fluxo de eventos secundário:
1. No passo 3 do fluxo de eventos principal, caso o sistema identifique que não há recomendações disponíveis com base nas interações anteriores do usuário:
2. O sistema verifica as informações de idade e localidade do usuário.
Com base nessas informações, o sistema gera recomendações iniciais com conteúdos relevantes para a faixa etária e região do usuário.

## Obter conteúdos
Este caso de uso permite que o sistema obtenha informações detalhadas de conteúdos recomendados pelo sistema de recomendação, incluindo filmes, séries, livros, animes e mangás, por meio da integração com sistemas externos, como TMDB, Goodreads e MyAnimeList.

**Pré condição**: O usuário deve estar logado no sistema e ter iniciado o caso de uso de visualização de conteúdo.

**Pós condição**: O sistema obtém informações atualizadas sobre o conteúdo a partir dos sistemas externos.

### Fluxo de eventos principal:
1. O sistema recebe informações básicas dos conteúdos;
2. O sistema solicita informações detalhadas dos conteúdo às API do TMDB, Goodread e MyAnimeList
6. O sistema retorna as informações detalhadas do conteúdo.

### Fluxo de eventos secundário:
1. No passo (3), (4) e (5), caso o conteúdo não seja encontrado nas APIs externas, o sistema retorna um erro.
