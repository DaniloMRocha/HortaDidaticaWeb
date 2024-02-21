/* USAR DATABASE */
USE HortaDB;
/* REINICIAR TABELA SE NECESSÁRIO */
DELETE FROM planta;
/* DELETAR POR ID */
DELETE FROM planta WHERE id = 12;
/* SELECIONAR TODOS OS ELEMENTOS DA TABELA PLANTA*/
SELECT * FROM planta;



-- INICIAIS --
-- Inserir Alface
INSERT INTO planta (popular, genero, epiteto, familia, epoca, tempo, irrigacao, iluminacao, didatico, administrador, tag, foto) 
VALUES ('Alface', 'Lactuca', 'sativa', 'Asteraceae', 'Todo ano', 45, 'Média', 'Meia-sombra', 'A alface é uma planta herbácea anual da família Asteraceae, a maior família de angiospermas. É conhecida por suas folhas verdes e crocantes, caracterizadas pelas margens do tipo crespa. Suas folhas, parte comestível da planta, são órgãos laminares fotossintetizantes que capturam a luz solar e convertem-na em energia química.', null, null, null);

-- Inserir Brócolis
INSERT INTO planta (popular, genero, epiteto, familia, epoca, tempo, irrigacao, iluminacao, didatico, administrador, tag, foto) 
VALUES ('Brócolis', 'Brassica', 'oleracea', 'Brassicaceae', 'Outono', 75, 'Pouca', 'Sol', 'O brócolis é uma planta da família Brassicaceae, cultivada por suas cabeças florais comestíveis, chamadas de inflorescências. Suas inflorescências consistem em pequenos botões florais, que são colhidos antes de se abrirem.', null, null, null);

-- Inserir Cebola
INSERT INTO planta (popular, genero, epiteto, familia, epoca, tempo, irrigacao, iluminacao, didatico, administrador, tag, foto) 
VALUES ('Cebola', 'Allium', 'cepa', 'Amaryllidaceae', 'Todo ano', 150, 'Muita', 'Sol', 'A cebola é um bulbo da família Amaryllidaceae, amplamente utilizada na culinária devido ao seu sabor característico e aroma. Folhas modificadas, chamadas catáfilos, partem do seu caule subterrâneo e armazenam água e nutrientes essenciais para a planta. A cebola é uma planta herbácea bienal, que produz flores globosas de coloração branca a roxa.', null, null, null);

-- Inserir Cebolinha
INSERT INTO planta (popular, genero, epiteto, familia, epoca, tempo, irrigacao, iluminacao, didatico, administrador, tag, foto) 
VALUES ('Cebolinha', 'Allium', 'schoenoprasum', 'Amaryllidaceae', 'Outono', 80, 'Muita', 'Sol', 'A cebolinha é uma planta herbácea perene da família Amaryllidaceae, cultivada por suas folhas comestíveis e sabor suave. Suas folhas longas e cilíndricas são frequentemente utilizadas como tempero em saladas, molhos e pratos diversos.', null, null, null);

-- Inserir Cenoura
INSERT INTO planta (popular, genero, epiteto, familia, epoca, tempo, irrigacao, iluminacao, didatico, administrador, tag, foto) 
VALUES ('Cenoura', 'Daucus', 'carota', 'Apiaceae', 'Todo ano', 100, 'Média', 'Sol', 'A cenoura é uma raiz da família Apiaceae, conhecida por sua cor alaranjada e sabor adocicado. Sua raiz tuberosa é a parte comestível da planta, rica em betacaroteno, um antioxidante que se converte em vitamina A no corpo. A cenoura possui um sistema radicular pivotante, que se estende verticalmente no solo em busca de água e nutrientes.', null, null, null);

-- Inserir Couve
INSERT INTO planta (popular, genero, epiteto, familia, epoca, tempo, irrigacao, iluminacao, didatico, administrador, tag, foto) 
VALUES ('Couve', 'Brassica', 'oleracea', 'Brassicaceae', 'Todo ano', 75, 'Pouca', 'Sol', 'A couve é uma planta da família Brassicaceae, conhecida por suas folhas comestíveis, verdes escuras e textura frondosa. Suas folhas são ricas em clorofila, pigmento responsável pela fotossíntese, processo pelo qual as plantas convertem a energia solar em energia química, transformando água e dióxido de carbono em carboidratos e gás oxigênio.', null, null, null);

-- Inserir Limão Taiti
INSERT INTO planta (popular, genero, epiteto, familia, epoca, tempo, irrigacao, iluminacao, didatico, administrador, tag, foto) 
VALUES ('Limão Taiti', 'Citrus', '× latifolia', 'Rutaceae', 'Todo ano', 120, 'Média', 'Sol', 'O limão Taiti é uma árvore frutífera da família Rutaceae, conhecida por seus frutos redondos e suculentos, que são bagas (frutos simples, suculentos, com várias sementes) do tipo hisperídio (caracterizado pelos bolsos de suco). Rico em vitamina C, o limão Taiti é benéfico para o sistema imunológico e a saúde da pele. Suas folhas são coriáceas e apresentam glândulas secretoras de óleos essenciais.', null, null, null);

-- Inserir Mandioca
INSERT INTO planta (popular, genero, epiteto, familia, epoca, tempo, irrigacao, iluminacao, didatico, administrador, tag, foto) 
VALUES ('Mandioca', 'Manihot', 'esculenta', 'Mandioca', 'Todo ano', 360, 'Muita', 'Sol', 'A mandioca é uma planta da família Euphorbiaceae, cultivada por suas raízes tuberosas, conhecidas como mandioca ou aipim. Suas raízes são ricas em amido, um complexo polímero de moléculas de glicose, sendo este carboidrato a fonte de reserva típica de células vegetais e importante de carboidratos na dieta humana e animal.', null, null, null);

-- Inserir Tomate
INSERT INTO planta (popular, genero, epiteto, familia, epoca, tempo, irrigacao, iluminacao, didatico, administrador, tag, foto) 
VALUES ('Tomate', 'Solanum', 'lycopersicum', 'Solanaceae', 'Todo ano', 110, 'Muita', 'Sol', 'O tomate é uma planta da família Solanaceae, conhecida por seus frutos suculentos e variados em cores e tamanhos. O fruto do tomate é uma baga simples, contendo várias sementes dentro de seus lóculos.', null, null, null);
