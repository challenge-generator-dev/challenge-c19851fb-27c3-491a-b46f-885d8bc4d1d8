# AGENTS.md

Instrucciones para el agente de IA que abra este repositorio (Claude Code, Cursor, Codex, Copilot, Gemini). Se cargan solas: no hay que pegar nada en ningun chat.

## Que es este repositorio

Es el codigo base de un reto de aprendizaje de Pragma: **Automatización de Pruebas de Integración para Pedidos en DynamoDB**.

| | |
|---|---|
| Tema | automatizacion-de-pruebas-de-integracion-contra-dynamodb |
| Nivel | advanced-l2 |
| Chapter | Calidad de Software |
| Especialidad | Automatizador |
| Stack | Java / Serenity BDD 4.0 |
| Patron arquitectonico | Screenplay con Page Object Model para pruebas de integración |
| Tiempo estimado | 10 horas |

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `app` | (raiz) | practice, chapter | testing | Automatizador | - |
| `infra-local` | (raiz) | support | infra | Compose local | DynamoDB |

## Orden de arranque

1. `docker compose up -d` (en la raiz) — levanta la infraestructura local.
2. `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `app` (practice, chapter).

## Receta del stack

Esqueleto obligatorio:

- `pom.xml en la raiz con el runner y el plugin de reportes`
- `src/test/resources/features con los .feature en Gherkin`
- `src/test/java/.../runners con el runner`
- `src/test/java/.../pages o /tasks con Page Objects o Screenplay`
- `src/test/java/.../steps con los step definitions`
- `serenity.conf o config del entorno`

Trampas conocidas:

- Sin parent POM que gestione versiones, TODA dependencia lleva su `<version>` completa de tres segmentos.
- El groupId de Serenity es `net.serenity-bdd`, NO `org.serenity-bdd`. Con el groupId equivocado el artefacto no existe y el build muere resolviendo dependencias.
- Coordenadas exactas de lo mas usado: Selenium `org.seleniumhq.selenium:selenium-java`, Rest Assured `io.rest-assured:rest-assured`, Karate `com.intuit.karate:karate-junit5`, Cucumber `io.cucumber:cucumber-java`.
- JUnit 5 se declara con `junit-jupiter` (agregador) y necesita `maven-surefire-plugin` reciente para ejecutarse.
- Serenity y Cucumber tienen que ser de lineas compatibles entre si; mezclarlas rompe el runner.

Dependencias:

- org.springframework.boot:spring-boot-starter-web
- org.springframework.boot:spring-boot-starter-test
- io.cucumber:cucumber-java 8.0.4
- io.cucumber:cucumber-junit-platform-engine 8.0.4
- net.serenity-bdd:serenity-core 4.3.4
- net.serenity-bdd:serenity-cucumber 4.3.4
- net.serenity-bdd:serenity-screenplay 4.3.4
- net.serenity-bdd:serenity-screenplay-webdriver 4.3.4
- org.junit.jupiter:junit-jupiter
- org.seleniumhq.selenium:selenium-java
- software.amazon.awssdk:aws-core 2.59.1
- software.amazon.awssdk:dynamodb 2.59.1

## Tu tarea

Dejar este proyecto en estado **verificable**: que el comando de verificacion corra sin errores. Escribi los archivos en disco, en este repositorio. No generes ZIPs ni archivos adjuntos.

En orden:

1. Segui el orden de arranque del mapa de componentes (infraestructura local primero) y corre `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q` desde la raiz: mira que falla.
2. Completa lo que falte de la lista de abajo: manifiesto de dependencias, punto de entrada, capa de interfaz y las capas del patron declarado.
3. Arregla SOLO los errores que impiden compilar o arrancar.
4. Volve a correr `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q` hasta que pase.
5. Pará ahí.

## Regla dura: las fases son trabajo del humano

**PROHIBIDO implementar los entregables de las fases.** El valor del reto esta en que la persona los resuelva. Tu trabajo es que tenga un proyecto que arranca; el hueco pedagogico se queda como esta.

No resuelvas nada de esto:

- **Fase 1 — Configuración del Entorno de Prueba**: Entorno de pruebas configurado y listo para ejecutar pruebas automatizadas.
- **Fase 2 — Desarrollo de Pruebas de Integración**: Conjunto de pruebas automatizadas que cubren las operaciones de lectura y escritura en DynamoDB.
- **Fase 3 — Ejecución y Validación de Pruebas**: Reporte de ejecución de pruebas que muestra que el flujo de persistencia de pedidos funciona correctamente.

Distincion operativa:

- **Arreglar** (si): import faltante, tipo que no existe, dependencia sin declarar, error de sintaxis, archivo referenciado que no existe.
- **No tocar** (no): logica de negocio incompleta, validaciones ausentes, secretos hardcodeados, APIs deprecadas que funcionan, concurrencia insegura, patrones mejorables. Eso es lo que la persona tiene que encontrar.

## Superficie de practica (NO completes)

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs. No toques la logica que el reto pide completar.

- [ ] `src/test/java/com/pragma/integration/utils/DynamoDBClient.java` — La fase "Configuración del Entorno de Prueba" se implementa aqui: este archivo es el ejercicio.
- [ ] `src/test/java/com/pragma/integration/questions/PedidoCreadoQuestion.java` — La fase "Desarrollo de Pruebas de Integración" se implementa aqui: este archivo es el ejercicio.

## Lo que falta y tenes que completar

No se detectaron huecos: estan los archivos declarados, el boilerplate del stack y ninguna referencia quedo colgando. Igual corre el comando de verificacion — que los archivos existan no garantiza que compilen.

### Presentes (13)

- `pom.xml`
- `src/test/resources/features/pedidos.feature`
- `src/main/java/RunCucumberTest.java`
- `src/test/java/com/pragma/integration/runners/RunIntegrationTests.java`
- `src/test/java/com/pragma/integration/steps/PedidosSteps.java`
- `src/test/java/com/pragma/integration/tasks/LeerPedidoTask.java`
- `src/test/java/com/pragma/integration/questions/PedidoCreadoQuestion.java`
- `src/test/java/com/pragma/integration/models/Pedido.java`
- `src/test/java/com/pragma/integration/utils/DynamoDBClient.java`
- `src/test/java/resources/features/pedidos.feature`
- `docker-compose.yml`
- `infra-local/README.md`
- `infra-local/dynamodb/create-tables.sh`

### Capas del patron declarado

Son las capas que la propuesta arquitectonica plantea, marcadas segun existan hoy en el repo. Orientan donde poner el codigo nuevo; no son una condicion para compilar.

- `src/test/java/com/pragma/integration` (presente)
- `src/test/java/com/pragma/integration/tasks` (presente)
- `src/test/java/com/pragma/integration/questions` (presente)
- `src/test/java/com/pragma/integration/models` (presente)
- `src/test/java/com/pragma/integration/utils` (presente)
- `src/test/resources/features` (presente)
- `src/test/resources/serenity.conf` (ausente)

## Verificacion

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q
```

El comando tiene que pasar SIN implementar los archivos de la superficie de practica: solo andamiaje.

Ese comando pasando es la definicion de "terminado" para vos.

## Convenciones que tenes que respetar

- Un solo ecosistema: no declares librerias de otro lenguaje ni mezcles gestores de paquetes.
- Toda libreria que uses tiene que estar declarada en el manifiesto de dependencias.
- Todo import declarado tiene que usarse; todo tipo usado tiene que existir o venir de una dependencia declarada.
- Cada componente vive en su carpeta: instala y compila dentro de ella, y no muevas archivos entre componentes.
- Respeta los contratos entre componentes (endpoints, topics) tal como estan declarados en el mapa de componentes.
- El patron es **Screenplay con Page Object Model para pruebas de integración**: los contratos (interfaces, puertos) los define la capa interna y los implementa la externa, nunca al revés.
- Los archivos que crees llevan implementacion real, no stubs: sin `TODO`, sin cuerpos vacios, sin `// getters y setters`.

## Contexto del candidato

Sirve para calibrar el nivel del codigo, no para resolver las fases.

- Perfil: Chapter Calidad de Software, Especialidad Automatizador, Tecnología Java Selenium, Advanced L2
- Brecha que el reto ataca: Automatizar pruebas de integracion sobre una tabla DynamoDB, Automatiza pruebas de integracion que validan lecturas y escrituras en una tabla DynamoDB
- Mision: Cubrir el flujo de persistencia de pedidos

---

*Generado por Challenge Generator — Pragma. `README.md` tiene el enunciado completo del reto para la persona. `PROMPT_MEJORA.md` es la variante para pegar en un chat, si se prefiere ese flujo.*
