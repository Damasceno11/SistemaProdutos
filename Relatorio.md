# Relatório do Grupo

**Nomes:** Davi Augusto, Kaio Levi e Pedro Damasceno

---

## Sistema de Cadastro de Bebidas

### O que cada um fez:

- **Davi:**
  - Implementou os métodos de cadastro, listagem, bebida mais cara, média de preços, bebidas acima da média, remoção por nome e litragem, e atualização de preços.
  - Adicionou validações para entradas inválidas.

- **Kaio:**
  - Criou um `HashMap` para associar a litragem à unidade de medida (ex: "500 ML"), garantindo que as medidas estejam sempre corretas.
  - Atualizou os métodos de cadastro, remoção e listagem para considerar essa estrutura.

- **Pedro:**
  - Desenvolveu a função que calcula a soma total dos preços das bebidas cadastradas.
  - Otimizou a estrutura do sistema com princípios de orientação a objetos para melhorar a organização e a confiabilidade.

---

### Principais dificuldades:

- Versionamento de código no Git e GitHub no início.
- A adição de uma variável relacionada ao volume aumentou consideravelmente a complexidade e o tamanho do código.

---

### Como testamos o programa antes de entregar:

- Realizamos **testes manuais** cadastrando diferentes bebidas com nomes, litros e preços variados para verificar se os dados são armazenados corretamente.
- Testamos a **validação dos campos** para garantir que entradas inválidas sejam rejeitadas (ex: texto no campo litro, preço negativo).
- Verificamos a **exibição dos dados cadastrados** para confirmar que os registros aparecem corretamente na lista/relatório.
- Simulamos casos de **atualização e exclusão** para checar se o sistema responde adequadamente sem perda ou corrupção dos dados.
- Realizamos **testes de usabilidade** para garantir que a interface esteja clara e funcional.

---

### Breve explicação de como o programa funciona:

O programa é um sistema simples de cadastro de bebidas. Ele permite que o usuário registre informações básicas de cada bebida: nome, quantidade em litros, a unidade da medida (ml, L) e o preço.

O usuário insere esses dados em um formulário, e o programa **valida as informações** para garantir que estejam corretas e consistentes. Após a validação, o sistema **armazena os dados em uma lista**.

O usuário pode:
- Visualizar todas as bebidas cadastradas;
- Editar registros;
- Excluir registros.

O objetivo é **facilitar o controle e a organização das bebidas disponíveis**, permitindo consultas rápidas e atualizações simples.
