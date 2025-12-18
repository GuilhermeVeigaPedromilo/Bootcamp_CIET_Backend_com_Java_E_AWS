# Entendendo a Configuração do Ambiente Java

### Neste conteúdo você vai aprender:
- O que é o ambiente Java e por que configurá-lo corretamente
- Quais são as principais distribuições do JDK disponíveis
- Como instalar o JDK no seu sistema
- Como configurar a variável de ambiente PATH para usar os comandos Java
- Como verificar se a instalação foi realizada com sucesso
- Quais ferramentas facilitam a gestão e troca de versões do Java

## O que é o ambiente Java?
O ambiente Java é o conjunto de ferramentas e configurações necessárias para você escrever, compilar e executar programas Java no seu computador. Ele inclui o JDK (Java Development Kit) e a configuração correta do sistema para usar os comandos do Java.

## Por que configurar o ambiente Java?
Sem o JDK e o PATH configurados, seu computador não reconhecerá os comandos Java, impedindo que você compile e rode seus programas. Um ambiente configurado corretamente é a base para programar e desenvolver em Java com sucesso.

## Principais distribuições do JDK
### Oracle JDK
A versão oficial da Oracle, usada comercialmente, com suporte e atualizações. Recentemente, requer licença para uso empresarial em algumas versões.

### OpenJDK
Versão open source e gratuita do JDK, base para várias outras distribuições. Muito usada pela comunidade.

#### Distribuições baseadas em OpenJDK
Existem várias opções feitas a partir do OpenJDK, como:

- Amazon Corretto (gratuita e com suporte da Amazon)

- Adoptium, Azul Zulu, BellSoft Liberica, entre outras.

Todas são compatíveis para desenvolver e executar programas Java.

## Passos básicos da configuração:
1. **Instalar o JDK:** 
    - Escolha e baixe uma distribuição adequada para seu sistema (Oracle JDK ou alguma distribuição derivada do OpenJDK).

2. **Configurar a variável de ambiente PATH:** 
    - Permite usar os comandos java e javac no terminal de qualquer pasta.
    - Fundamental para rodar, compilar e testar seus programas Java sem complicação.

3. **Verificar a instalação:**
Teste com os comandos no terminal:
    - java -version
    - javac -version
        
    Eles devem mostrar a versão correta do Java.

## Ferramentas para facilitar a gestão do Java SDKMAN! (Linux e macOS)
É uma ferramenta que ajuda a instalar, atualizar e trocar versões diferentes do Java (e outras SDKs) facilmente, sem precisar configurar tudo manualmente.

    ⚠️ Windows não possui SDKMAN! oficialmente, mas pode usar gerenciadores como o Chocolatey para facilitar instalações.
