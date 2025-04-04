
![Refactoring Kata](https://img.shields.io/badge/Kata%20Refactoring-Easy-brightgreen?style=flat-square)
![Kata CI Test](https://img.shields.io/github/actions/workflow/status/IT-Academy-Back/kata-rpg-refactoring/ci.yml?branch=main&label=CI%20Kata%20Test&style=flat-square)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=IT-Academy-Back_kata-rpg-refactoring&metric=coverage)](https://sonarcloud.io/summary/new_code?id=IT-Academy-Back_kata-rpg-refactoring)

> ⚠️ **Nota:** Los badges de CI y Cobertura apunta al repositorio original.
> Si haces un *fork* o usas este proyecto como *template*, cambia las URLs de los badges para que apunten a tu propio repositorio.

---

### 📊 **Cobertura de código con JaCoCo**

Este proyecto genera automáticamente un informe de cobertura tras cada *push* a `main`.  
Puedes consultar el reporte accediendo a:
[Cobertura de código](https://IT-Academy-Back.github.io/kata-rpg-refactoring)

```
https://TU_USUARIO.github.io/TU_REPOSITORIO/
```

> 📝 Si usas este repositorio como template, **recuerda cambiar la URL anterior** reemplazando `TU_USUARIO` y `TU_REPOSITORIO` por los tuyos.

> 📄 GitHub Pages se activará automáticamente tras el primer push a `main`, cuando se genere la rama `gh-pages`.

> ⚠️ Si has hecho un **fork** o un **clone**, ve a `Settings → Pages` y selecciona la rama `gh-pages`, carpeta `/ (root)` para activar GitHub Pages manualmente.


## 📈 Análisis de calidad con SonarCloud

Este proyecto también está conectado con [SonarCloud](https://sonarcloud.io), que analiza automáticamente la calidad del código en cada push.

🔍 SonarCloud evalúa:

- Errores y bugs potenciales
- Vulnerabilidades de seguridad
- Código duplicado
- Calidad del código y mantenibilidad
- Cobertura de tests (a partir de JaCoCo)

🔗 Puedes consultar el análisis de este proyecto en:

👉 [Ver análisis en SonarCloud](https://sonarcloud.io/project/overview?id=IT-Academy-Back_kata-rpg-refactoring)

🛠️ Si usas este repositorio como template:
1. Crea tu propia organización en SonarCloud.
2. Vincula tu nuevo repositorio.
3. Actualiza las variables `sonar.projectKey` y `sonar.organization` en el workflow de GitHub Actions.
4. **Crea un token en SonarCloud y guárdalo como `SONAR_TOKEN` en los Secrets de tu repositorio en GitHub.**

⚠️ Desactiva el análisis automático en la configuración de SonarCloud si estás ejecutando el análisis desde GitHub Actions (para evitar errores por duplicación de análisis).

📛 También puedes añadir este badge al README para mostrar la cobertura directamente desde SonarCloud:

```markdown
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=TU-USUARIO-GITHUB_TU-REPOSITORIO&metric=coverage)](https://sonarcloud.io/summary/new_code?id=TU-USUARIO-GITHUB_TU-REPOSITORIO)
```
---

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

- El combate **solo ocurre si ambos tienen salud mayor a 0**.
- El **jugador ataca primero**:
    - El daño se calcula como `fuerza del jugador - defensa del enemigo`.
    - Si el daño es positivo, se resta a la salud del enemigo.
    - Si no hay daño, se muestra un mensaje y termina el turno.

- Si el enemigo **sobrevive**, contraataca:
    - El daño se calcula como `fuerza del enemigo - defensa del jugador`.
    - Si el daño es positivo, se resta a la salud del jugador.

- Se imprimen mensajes según el estado final de la lucha

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

---

## ✅ Tests

Este proyecto incluye **tests unitarios** para la lógica de combate implementada en `BattleService`, utilizando **JUnit 5**.

### 🧪 Cómo ejecutar los tests

Puedes lanzar todos los tests con Maven:

```bash
mvn test
```

Se recomienda ejecutar los tests antes de empezar a refactorizar, inspeccionando su salida y asegurándote de que:

- ✅ Todos los tests pasan correctamente
- 📊 Se cubren todas las ramas posibles del método `fight(...)` de `BattleService`

### 🧰 Tecnologías

- 🧪 **JUnit 5**
- ☕ **Java 21**
- 🔧 **Maven**

## 🧠 Consejos para Refactorizar

Antes de comenzar el refactoring, sigue estos pasos para trabajar con seguridad y claridad:

1. Ejecuta todos los tests y revisa que pasen correctamente.
2. Analiza qué ramas del método `fight(...)` se ejecutan en cada test (por ejemplo: el jugador ya está muerto, el enemigo no recibe daño, etc.).
3. Asegúrate de que los tests cubren todos los caminos posibles.
4. Tras cada cambio, vuelve a ejecutar los tests y comprueba que todo sigue funcionando como antes.

Este enfoque basado en tests te permitirá refactorizar con confianza aplicando principios como:

- ✅ *Early return* (retorno temprano)
- ✅ *Fail-fast* (fallar pronto ante errores)
- ✅ Reducción de anidamientos innecesarios

---

### ✨ Sugerencias para mejorar el código

- 🔍 Identifica `if` innecesarios o que podrían reescribirse con retornos anticipados.
- 🚪 Usa `return` para salir del método lo antes posible si no tiene sentido seguir.
- 📦 Declara constantes para valores mágicos como `0`, `100`, etc., si tienen un significado lógico.
- 🧩 Refactoriza paso a paso, sin intentar hacer demasiados cambios de golpe.

Recuerda: la claridad es más importante que la complejidad. Un buen código se **entiende fácilmente sin necesidad de comentarios**.


---

¡Buena suerte, refactorizador!