# Vilas Fantásticas — roteiro de desenvolvimento

Alvo: Minecraft Java 1.21.1, Fabric, Java 21. Desenvolvimento e compilação pelo GitHub Actions, com testes no Zalith Launcher para Android.

## Visão do projeto
Misturar a identidade visual do Minecraft com fantasia medieval, mantendo os aldeões originais e adicionando novos tipos gradualmente.

## Plano por etapas
1. **Fundação e compatibilidade** — manter o mod carregando no Fabric 1.21.1 e validar cada compilação.
2. **Primeira estrutura personalizada** — criar uma construção fantástica e integrar seus arquivos de estrutura ao sistema de geração do mundo.
3. **Variações por bioma** — desenvolver construções e conjuntos de estruturas para planícies, desertos, savanas, taigas e regiões nevadas.
4. **Reformular as vilas existentes** — substituir/adicionar peças aos conjuntos de estruturas de vila por bioma, preservando a geração vanilla sempre que possível.
5. **Novos habitantes** — adicionar personagens e profissões sem remover os aldeões vanilla.
6. **Testes e desempenho** — testar em mundo novo, verificar logs, frequência de geração e compatibilidade.

## Regras de desenvolvimento
- Não afirmar que uma funcionalidade existe até estar implementada e testada no jogo.
- Cada etapa deve compilar antes de avançar.
- Testar a geração em um mundo novo: estruturas não aparecem retroativamente em chunks já gerados.
- Fazer backups dos mundos antes de testar builds de desenvolvimento.

## Estado atual
A estrutura inicial do mod compila. Ainda não foram implementadas estruturas novas, alterações às vilas ou novos habitantes.
