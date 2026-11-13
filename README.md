# Automatización de Pruebas de Integración para Pedidos en DynamoDB

El sistema de procesamiento de pedidos utiliza una tabla DynamoDB para persistir información crítica. Necesitas automatizar las pruebas de integración que validen las operaciones de lectura y escritura en esta tabla. El objetivo es asegurar que el flujo de persistencia de pedidos funcione correctamente en un entorno de prueba de extremo a extremo.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | automatizacion-de-pruebas-de-integracion-contra-dynamodb |
| **Nivel** | advanced-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 10 horas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y entregará cada archivo con su ruta.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y entregará cada archivo con su ruta. Guárdalos en la carpeta donde quieras trabajar, respetando las rutas.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no entrega todos los archivos al terminar el análisis, escríbele: "entrégame todos los archivos con su ruta".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Configuración del Entorno de Prueba

**Objetivo:** Preparar el entorno de pruebas para ejecutar pruebas automatizadas contra DynamoDB.

**Tiempo estimado:** 2 horas

**Instrucciones:**

- Configura un entorno de pruebas que incluya una instancia de DynamoDB local o en la nube.
- Asegúrate de que el entorno esté correctamente configurado para ejecutar pruebas automatizadas.

**Entregable:** Entorno de pruebas configurado y listo para ejecutar pruebas automatizadas.

<details>
<summary>Pistas de conocimiento</summary>

- Conceptos básicos de DynamoDB y su API.
- Herramientas y frameworks para automatización de pruebas en Java.

</details>

### Fase 2: Desarrollo de Pruebas de Integración

**Objetivo:** Crear y ejecutar pruebas de integración que validen las operaciones de lectura y escritura en DynamoDB.

**Tiempo estimado:** 5 horas

**Instrucciones:**

- Desarrolla pruebas automatizadas que cubran las operaciones básicas de lectura y escritura en DynamoDB.
- Asegúrate de que las pruebas validen correctamente el flujo de persistencia de pedidos.

**Entregable:** Conjunto de pruebas automatizadas que cubren las operaciones de lectura y escritura en DynamoDB.

<details>
<summary>Pistas de conocimiento</summary>

- Patrones de diseño para pruebas automatizadas.
- Manejo de excepciones y errores en pruebas.

</details>

### Fase 3: Ejecución y Validación de Pruebas

**Objetivo:** Ejecutar las pruebas automatizadas y validar los resultados.

**Tiempo estimado:** 3 horas

**Instrucciones:**

- Ejecuta las pruebas automatizadas desarrolladas en la fase anterior.
- Valida que los resultados de las pruebas sean los esperados y que el flujo de persistencia de pedidos funcione correctamente.

**Entregable:** Reporte de ejecución de pruebas que muestra que el flujo de persistencia de pedidos funciona correctamente.

<details>
<summary>Pistas de conocimiento</summary>

- Herramientas para la ejecución y reporte de pruebas.
- Análisis de resultados y toma de decisiones basada en los resultados de las pruebas.

</details>

## Dimensiones Evaluadas

- **queEs**: ¿Qué son las pruebas de integración y por qué son importantes en este contexto?
- **paraQueSirve**: ¿Para qué sirven las pruebas de integración en el flujo de persistencia de pedidos?
- **comoSeUsa**: ¿Cómo se usan las pruebas de integración para validar las operaciones en DynamoDB?
- **erroresComunes**: ¿Qué errores comunes pueden ocurrir al desarrollar pruebas de integración para DynamoDB?
- **queDecisionesImplica**: ¿Qué decisiones implica el desarrollo y ejecución de pruebas de integración en este contexto?

## Criterios de Evaluacion

- Configuración correcta del entorno de pruebas.
- Desarrollo de pruebas de integración que cubren las operaciones básicas de lectura y escritura en DynamoDB.
- Ejecución y validación exitosa de las pruebas automatizadas.
- Manejo correcto de errores y excepciones en las pruebas.
- Toma de decisiones basada en los resultados de las pruebas.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT) si no tenes un agente en el IDE. Declara lo mismo que AGENTS.md; los archivos que te devuelva el chat los guardas en esta carpeta respetando las rutas.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `app` | (raiz) | practice, chapter | testing | Automatizador | - |
| `infra-local` | (raiz) | support | infra | Compose local | DynamoDB |

## Orden de arranque

1. `docker compose up -d` (en la raiz) — levanta la infraestructura local.
2. `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `app` (practice, chapter).

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
