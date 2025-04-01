# 🛡️ Kata de Refactoring - RPG Combat Logic

Bienvenido a esta kata de refactorización. El objetivo es mejorar el código de una clase que contiene lógica de combate en un juego de rol (RPG). El código inicial está plagado de **estructuras anidadas**, **duplicación de lógica**, **poca claridad**, y **números mágicos**.

Tu misión es aplicar principios de **clean code** para que el código sea más **legible**, **mantenible** y **fácil de testear**.

---

## ⚔️ Normas del Combate

- El combate es entre un **Player** y un **Enemy**.
- Ambos tienen:
    - `health`: Puntos de vida.
    - `strength`: Puntos de ataque.
    - `defense`: Capacidad de reducir daño recibido.

### Mecánica del combate

1. **El jugador ataca primero**:
    - El daño se calcula como:  
      `damageToEnemy = player.strength - enemy.defense`
    - Si el daño es positivo, se resta al `enemy.health`.

2. **Si el enemigo sigue vivo**, contraataca:
    - El daño se calcula como:  
      `damageToPlayer = enemy.strength - player.defense`
    - Si el daño es positivo, se resta al `player.health`.

3. Se imprimen mensajes dependiendo del resultado:
    - Si alguien muere (`health <= 0`), se muestra un mensaje.
    - Si nadie muere, se indica que la batalla continúa.
    - Si el daño es 0 o negativo, se indica que no hubo daño.

---

## 🎯 Objetivos del ejercicio

### Refactorizar `BattleService` aplicando:

- **Early return**: Salidas tempranas para mejorar legibilidad.
- **Fail fast**: Validar primero los casos límites o errores.
- **Evitar estructuras anidadas innecesarias**.
- **Eliminar números mágicos**: Definir constantes con significado.
- **Extraer métodos privados para mejorar legibilidad**.
- **Usar nombres de variables expresivos**.

---

## ✅ Criterios de éxito

- El código **debe compilar y funcionar exactamente igual** después de la refactorización.
- No se deben añadir cambios de comportamiento.
- Puedes dividir el método en otros métodos privados si mejora la claridad.
- No necesitas test automatizados para esta kata, pero sería ideal incluirlos si quieres practicar TDD.

---

## 🧠 Consejos

- Empieza por identificar los `if` innecesarios o que se podrían simplificar.
- Usa `return` para salir del método si ya no es necesario seguir.
- Declara constantes para los valores como `0`, `100`, etc., si tienen un significado lógico.
- No te precipites a hacer muchos cambios de golpe: ve paso a paso.

---

¡Buena suerte, refactorizador!