// Lista de nomes de arquivos de imagens
var imagens = ['imagem1.png', 'imagem2.png', 'imagem3.png']; // Adicione mais imagens conforme necessário

// Seleciona aleatoriamente uma imagem da lista
var imagemAleatoria = imagens[Math.floor(Math.random() * imagens.length)];

// Cria um elemento de imagem e define o atributo src com a imagem selecionada
var img = document.createElement('img');
img.src = 'imagem/inicial/' + imagemAleatoria; // Substitua pelo caminho da sua pasta de imagens

// Adiciona a imagem à div de exibição
document.getElementById('imagemAleatoria').appendChild(img);
