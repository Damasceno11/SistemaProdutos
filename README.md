# Sistema de Gerenciamento de Bebidas (Java)

Este projeto é um sistema simples em Java para gerenciamento de bebidas. Através de um menu interativo no console, o usuário pode cadastrar, listar, remover e atualizar bebidas, além de visualizar estatísticas como média de preços e o valor total cadastrado.

## Funcionalidades

- **Cadastrar bebida**  
  Permite adicionar uma nova bebida com nome, litragem, unidade de medida (ML ou L) e preço. O sistema valida os dados e evita duplicatas.

- **Listar bebidas**  
  Mostra todas as bebidas cadastradas com suas informações completas.

- **Bebida mais cara**  
  Exibe qual é a bebida de maior valor entre as cadastradas.

- **Média de preços**  
  Calcula e mostra a média dos preços de todas as bebidas.

- **Bebidas acima da média**  
  Lista apenas as bebidas que possuem preço acima da média calculada.

- **Remover bebida**  
  Remove uma bebida com base no nome e na litragem informada.

- **Atualizar preço**  
  Atualiza o preço de uma bebida específica. O sistema não permite repetir o mesmo preço.

- **Soma total**  
  Calcula o valor total de todas as bebidas cadastradas.

## Estrutura de dados utilizada

- `ArrayList<String> nomes` — Armazena os nomes das bebidas  
- `ArrayList<Double> valores` — Armazena os preços  
- `ArrayList<Double> litros` — Armazena a litragem  
- `HashMap<Double, String> medidaDaLitragem` — Associa a litragem com a unidade (ex: 500 → "ML")
