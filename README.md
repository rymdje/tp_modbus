# TP Modbus – CRC16 en Java

## Contexte

Projet réalisé en BTS CIEL pour comprendre le fonctionnement du protocole Modbus RTU et le calcul du CRC16.

L’objectif était d’implémenter manuellement l’algorithme CRC16 utilisé dans Modbus afin de comprendre :

- le traitement bit à bit
- le rôle du polynôme 0xA001
- l’initialisation à 0xFFFF
- la vérification d’intégrité d’une trame


## Fonctionnement

Le programme :

1. Lit une trame hexadécimale entrée par l’utilisateur
2. Convertit la chaîne en tableau de bytes
3. Applique l’algorithme CRC16 Modbus
4. Affiche le CRC en :
   - décimal
   - hexadécimal


## Ce que j’ai compris

- Le CRC est un mécanisme de détection d’erreur
- Le calcul se fait bit par bit avec décalage et XOR
- Le polynôme 0xA001 est spécifique à Modbus
- Le CRC final est envoyé en little-endian dans une trame Modbus


## Technologies

- Java sdk17
- Intellij
