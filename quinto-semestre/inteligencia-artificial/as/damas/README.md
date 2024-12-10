# Damas.js

Este é um projeto desenvolvido como trabalho de fim de semestre da cadeira de fundamento de inteligência artificial do curso análise e desenvolvimento de sistemas. Foi desenvolvido em JavaScript sem a utilização de nenhuma biblioteca externa, mantendo sempre o foco na orientação a objetos e código limpo e legível.

### Nota

Descobri esse jogo de um repositório no github, mas ele estava com diversos problemas de lógica e não funcionava. Também não havia a inteligência para o jogador jogar com a IA. Refatorei todo o códico aplicando POO, resolvendo os bugs e implementando a inteligência necessária para o usuário jogar com a IA.

### Modo de jogo padrão:

- Tabuleiro 8x8 com 12 peças
- Peças comuns só comem para frente
- Ao chegar ao lado oposto do tabuleiro peça comum se torna rainha;
- Rainha pode capturar para trás e para frente;
- Jogo acaba quando todas as peças forem capturadas.

### Funcionalidades Implementadas:

- IA para jogar com usuário
- Modelo independente da interface;
- Highlight nas jogadas possíveis;
- Tornar rainha ao chegar ao lado oposto do tabuleiro;
- Rainha com movimentos exclusivos;
- Conceitos de orientação objeto em javascript com herança e polimorfismo;
- Resetar jogo;
