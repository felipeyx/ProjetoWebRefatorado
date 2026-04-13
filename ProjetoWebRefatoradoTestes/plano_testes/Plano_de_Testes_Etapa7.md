# Plano de Testes - Etapa 7

## 1. Objetivo
Definir testes basicos para validar as principais funcionalidades do sistema refatorado, com foco em regras de negocio e comportamentos esperados.

## 2. Escopo
Este plano cobre o modulo de produtos e clientes do sistema Java desenvolvido nas etapas anteriores, alem do projeto de testes JUnit criado para a Etapa 7.

## 3. Estrategia de testes
- Testes unitarios com JUnit 5 para regras isoladas.
- Testes manuais para fluxo funcional principal.
- Validacao de mensagens de erro para entradas invalidas.

## 4. Ambiente de testes
- IDE: Apache NetBeans
- Linguagem: Java 17
- Framework de testes: JUnit 5
- Controle de versao: Git e GitHub

## 5. Casos de teste unitario
### CTU-01 - Calcular valor total do estoque
- Objetivo: validar o calculo `precoUnitario * quantidade`.
- Entrada: precoUnitario = 100.0, quantidade = 3.
- Resultado esperado: 300.0.
- Status esperado: aprovado.

### CTU-02 - Bloquear preco negativo no calculo
- Objetivo: garantir erro para preco invalido.
- Entrada: precoUnitario = -10.0, quantidade = 3.
- Resultado esperado: lancar `NegocioException`.
- Status esperado: aprovado.

### CTU-03 - Cadastrar produto valido
- Objetivo: validar o cadastro com dados corretos.
- Entrada: nome = Mouse, preco = 120.0, quantidade = 5.
- Resultado esperado: objeto Produto criado com os valores informados.
- Status esperado: aprovado.

### CTU-04 - Bloquear cadastro com preco negativo
- Objetivo: impedir cadastro invalido.
- Entrada: nome = Teclado, preco = -1.0, quantidade = 2.
- Resultado esperado: lancar `NegocioException`.
- Status esperado: aprovado.

## 6. Casos de teste manual
### CTM-01 - Cadastro de produto
- Passos: executar o sistema e cadastrar um produto com dados validos.
- Resultado esperado: mensagem de sucesso e produto listado.

### CTM-02 - Remocao de produto
- Passos: cadastrar produto e depois remover pelo id.
- Resultado esperado: produto removido da listagem.

### CTM-03 - Validacao de nome vazio
- Passos: tentar cadastrar produto sem nome.
- Resultado esperado: mensagem de erro informando que o nome nao pode ser vazio.

### CTM-04 - Cadastro de cliente valido
- Passos: cadastrar cliente com nome, e-mail e CPF validos.
- Resultado esperado: cliente cadastrado com sucesso.

### CTM-05 - Validacao de e-mail invalido
- Passos: tentar cadastrar cliente sem o caractere @.
- Resultado esperado: mensagem de erro informando e-mail invalido.

## 7. Criterios de aprovacao
- Todos os testes unitarios devem passar.
- Os fluxos manuais principais devem funcionar sem excecao nao tratada.
- As mensagens de validacao devem aparecer quando houver entrada invalida.

## 8. Conclusao
O plano de testes garante uma verificacao inicial do sistema e prepara a base para ampliacao futura dos testes da aplicacao web.
