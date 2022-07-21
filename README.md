# Imersão Java - AULA 02 - gerando figurinhas para o WhatsApp
Este projeto é parte das atividades da semana de Imersão em Java, oferecida gratuitamente pela Alura entre os dias 18/07/2022 até 22/07/2022.

## O que este projeto faz?
Este projeto pretende criar imagens .png baseadas nos posters dos filmes reconhecidos da lista do IMDB. A classe **"GeradoraDeFigurinhas"** está responsável por esta função. Cada nova imagem gerada é chamada de "figurinha" já que a proposta é que elas sejam utilizadas como figurinhas em aplicativos como o WhatsApp.

## Mudança na API escolhida para o projeto
Originalmente, este projeto utiliza o seguinte link como referência para os filmes: 

> https://alura-filmes.herokuapp.com/conteudos

Contudo, devido ao grande número de filmes na lista, o número de imagens que era retornado também era muito alto. Portanto, um novo link foi adotado, sem diferenças em relação a estrutura ou funcionamento geral do projeto:

> https://api.mocki.io/v2/549a5d8b/Top250Movies

## Estrutura do projeto
O projeto foi criado com base na prática da aula 1, disponível em:

> https://github.com/Ishik-R/imersao-java-alura-2022-aula-1

E as figurinhas produzidas estão localizadas na pasta "saída":

`saida` : pasta que contém as figurinhas processadas pelo programa.

## Materiais de apoio
Não estarei colocando os vídeos diretamente da semana da Imersão Java já que creio que eles serão tirados do ar em breve. Contudo, alguns links e materiais extras foram consultados durante o acompanhamento desta aula.

### Package javax.imageio (documentação)
* Link: https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/javax/imageio/package-summary.html

### Class BufferedImage (documentação)
* Link: https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/image/BufferedImage.html

### Class Graphics2D (documentação)
* Link: https://docs.oracle.com/en/java/javase/17/docs/api/java.desktop/java/awt/image/BufferedImage.html

### How do I undo 'git add' before commit?
* Link: https://stackoverflow.com/questions/348170/how-do-i-undo-git-add-before-commit

### Basic Syntax (Markdown)
* Link: https://www.markdownguide.org/basic-syntax/

## Desafios da aula:
✅ Ler a documentação da classe abstrata InputStream.

✅ Centralizar o texto na figurinha.

⬜️ Fazer um pacote no Whatsapp e/ou Telegram com as suas próprias figurinhas!
 
✅ Criar diretório de saída das imagens, se ainda não existir.

✅ Colocar outra fonte como a Comic Sans ou a Impact, a fonte usada em memes.

⬜️ Colocar uma imagem de você que está fazendo esse curso sorrindo, fazendo joinha!

⬜️ Colocar contorno (outline) no texto da imagem.

⬜️ Tratar as imagens retornadas pela API do IMDB para pegar uma imagem maior ao invés dos thumbnails. Opções: pegar a URL da imagem e remover o trecho mostrado durante a aula ou consumir o endpoint de posters da API do IMDB (mais trabalhoso), tratando o JSON retornado.

✅ Fazer com que o texto da figurinha seja personalizado de acordo com as classificações do IMDB.

⬜️ Desafio supremo: usar alguma biblioteca de manipulação de imagens como OpenCV pra extrair imagem principal e contorná-la.

⬜️ Desafio pessoal: definir um tamanho padrão de saída para as figurinhas.

⬜️ Desafio pessoal: definir adequadamente a saída das imagens para a pasta "saída"