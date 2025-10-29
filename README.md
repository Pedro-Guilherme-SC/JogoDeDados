# Jogo de Dados

*Trabalho de **POO***
https://github.com/Pedro-Guilherme-SC/JogoDeDados
---

O sistema consiste em dois dados e uma quantidade X de jogadores, informada no início do jogo.  
Cada jogador escolhe um valor para apostar.  
Após todos os jogadores informarem suas apostas, os dados são lançados.  

- Se a soma das faces dos dados for igual à aposta de algum jogador, o sistema informa um vencedor.  
- Caso contrário, o sistema informa que o computador venceu.

---

##  Estrutura de Dados

![diagrama_de_classes](/diagrama_de_classes.png)

* FK = Foreign Key (Chave Estrangeira);

### USER
| Campo | Tipo | Descrição |
|--------|------|------------|
| `id` | INT | Identificador único do usuário |
| `name` | STRING | Nome do usuário |
| `email` | STRING | E-mail do usuário |
| `password` | STRING | Senha do usuário |

---

###  BET (Rodada)
| Campo | Tipo | Descrição |
|--------|------|------------|
| `id` | INT | Identificador da rodada |
| `user_id` | INT (FK → USER) | ID do usuário criador da rodada |
| `name` | STRING | Nome da rodada |
| `max_users` | INT | Número máximo de usuários permitidos (11) |
| `max_gamble` | INT | Número máximo de apostas |

---

###  GAMBLE (Ato de Apostar)
| Campo | Tipo | Descrição |
|--------|------|------------|
| `id` | INT | Identificador da aposta |
| `bet_id` | INT (FK → BET) | ID da rodada em que a aposta foi feita |
| `user_id` | INT (FK → USER) | ID do usuário que realizou a aposta |
| `value` | FLOAT | Valor apostado |
| `user_guess` | INT | Número escolhido pelo jogador (entre 2 e 12) |

### Relações

| Relação | Descrição | Cardinalidade |
|----------|------------|----------------|
| USER → BET | Um usuário pode criar várias rodadas | 1:N |
| BET → GAMBLE | Uma rodada pode conter várias apostas | 1:N |
| USER → GAMBLE | Um usuário pode realizar várias apostas | 1:N |

---

## Requisitos Funcionais

- Inserir Jogadores
   - O sistema pede a quantidade de jogadores (de 1 a 11).  
   - Cada jogador informa um email e senha.

- Escolher Valor para Apostar  
   - O sistema solicita o valor da aposta de cada jogador.  
   - Cada jogador escolhe um valor entre 2 e 12.

- Lançar Dados  
   - O sistema gera aleatoriamente os valores dos dois dados.  

- Apresentar Resultado
   - O sistema exibe os valores das faces dos dados e a soma total.  

- Informar Jogador Vencedor  
   - Se o resultado for igual à aposta de algum jogador, o sistema exibe o vencedor.  
   - Caso contrário, o sistema informa que o computador venceu.  

---

##  Regras de Negócio

1. O número máximo de jogadores por rodada é definido em `max_users`. 
2. O valor da aposta (`value`) deve ser maior que zero.  
3. O palpite (`user_guess`) deve estar entre **2 e 12**.  
4. Um mesmo número pode ser escolhido por mais de um jogador.  
5. Vence o jogador cujo palpite coincidir com a soma das faces dos dados.

---

## Funcionamento

1. **Cadastro de Usuário** → Criação de conta (USER).  
2. **Criação de Rodada** → Usuário define nome e limite de apostas (BET). 
3. **Apostar** → Usuários apostam valores e informam seus palpites (GAMBLE).
4. **Lançamento dos Dados** → Sistema gera dois valores aleatórios (1–6).
5. **Cálculo do Resultado** → Soma das faces comparada aos palpites.
6. **Exibição do Vencedor** → Se alguém acertar, exibir o nome. Caso contrário, o computador vence.

