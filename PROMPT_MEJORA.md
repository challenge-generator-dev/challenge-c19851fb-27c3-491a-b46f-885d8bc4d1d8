# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/test/java/com/pragma/integration/utils/DynamoDBClient.java` — La fase "Configuración del Entorno de Prueba" se implementa aqui: este archivo es el ejercicio.
- `src/test/java/com/pragma/integration/questions/PedidoCreadoQuestion.java` — La fase "Desarrollo de Pruebas de Integración" se implementa aqui: este archivo es el ejercicio.

## Mapa de componentes

El repo tiene una carpeta por componente. Cada uno se instala y verifica dentro de la suya.

| Componente | Carpeta | Rol | Capa | Track | Tecnologias |
|---|---|---|---|---|---|
| `app` | (raiz) | practice, chapter | testing | Automatizador | - |
| `infra-local` | (raiz) | support | infra | Compose local | DynamoDB |

## Orden de arranque

1. `docker compose up -d` (en la raiz) — levanta la infraestructura local.
2. `mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package` — componente `app` (practice, chapter).

## Como saber que terminaste

```bash
mvn -q -B -DskipTests -Dspring-boot.repackage.skip=true package && docker compose config -q
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Calidad de Software, Especialidad Automatizador, Tecnología Java Selenium, Advanced L2

### Brecha de conocimiento
Automatizar pruebas de integracion sobre una tabla DynamoDB, Automatiza pruebas de integracion que validan lecturas y escrituras en una tabla DynamoDB

### Misión / candidato
Cubrir el flujo de persistencia de pedidos

### Reto
- Tema: automatizacion-de-pruebas-de-integracion-contra-dynamodb
- Seniority: advanced-l2
- Tipo: practical
- Título: Automatización de Pruebas de Integración para Pedidos en DynamoDB
- Tiempo estimado: 10 horas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Configuración del Entorno de Prueba — objetivo: Preparar el entorno de pruebas para ejecutar pruebas automatizadas contra DynamoDB. — entregable (NO resolver): Entorno de pruebas configurado y listo para ejecutar pruebas automatizadas.
- Fase 2: Desarrollo de Pruebas de Integración — objetivo: Crear y ejecutar pruebas de integración que validen las operaciones de lectura y escritura en DynamoDB. — entregable (NO resolver): Conjunto de pruebas automatizadas que cubren las operaciones de lectura y escritura en DynamoDB.
- Fase 3: Ejecución y Validación de Pruebas — objetivo: Ejecutar las pruebas automatizadas y validar los resultados. — entregable (NO resolver): Reporte de ejecución de pruebas que muestra que el flujo de persistencia de pedidos funciona correctamente.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.4.13</version>
        <relativePath/>
    </parent>

    <groupId>com.example</groupId>
    <artifactId>reto</artifactId>
    <version>1.0.0</version>
    <name>reto</name>

    <properties>
        <java.version>21</java.version>
        <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    </properties>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-java</artifactId>
            <version>8.0.4</version>
        </dependency>
        <dependency>
            <groupId>io.cucumber</groupId>
            <artifactId>cucumber-junit-platform-engine</artifactId>
            <version>8.0.4</version>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-core</artifactId>
            <version>4.3.4</version>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-cucumber</artifactId>
            <version>4.3.4</version>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-screenplay</artifactId>
            <version>4.3.4</version>
        </dependency>
        <dependency>
            <groupId>net.serenity-bdd</groupId>
            <artifactId>serenity-screenplay-webdriver</artifactId>
            <version>4.3.4</version>
        </dependency>
        <dependency>
            <groupId>org.junit.jupiter</groupId>
            <artifactId>junit-jupiter</artifactId>
        </dependency>
        <dependency>
            <groupId>org.seleniumhq.selenium</groupId>
            <artifactId>selenium-java</artifactId>
        </dependency>
        <dependency>
            <groupId>software.amazon.awssdk</groupId>
            <artifactId>aws-core</artifactId>
            <version>2.59.1</version>
        </dependency>
        <dependency>
            <groupId>software.amazon.awssdk</groupId>
            <artifactId>dynamodb</artifactId>
            <version>2.59.1</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/test/resources/features/pedidos.feature ===
# language: es
Feature: Gestión de Pedidos en DynamoDB
  Como equipo de calidad
  Quiero validar las operaciones de lectura y escritura en la tabla de pedidos
  Para asegurar que el flujo de persistencia funciona correctamente

  Scenario: Crear un nuevo pedido en DynamoDB
    Given que el sistema está listo para recibir pedidos
    When creo un pedido con los siguientes datos:
      | id          | clienteId    | productos       | total | estado   |
      | "pedido-001"| "cliente-001"| "producto-001"  | 100.0 | "CREADO" |
    Then el pedido debe ser persistido en DynamoDB con los datos proporcionados

  Scenario: Leer un pedido existente en DynamoDB
    Given que existe un pedido con id "pedido-001" en DynamoDB
    When leo el pedido con id "pedido-001"
    Then el pedido recuperado debe coincidir con los siguientes datos:
      | id          | clienteId    | productos       | total | estado   |
      | "pedido-001"| "cliente-001"| "producto-001"  | 100.0 | "CREADO" |

  Scenario: Validar manejo de error al leer pedido inexistente
    Given que no existe ningún pedido con id "pedido-inexistente" en DynamoDB
    When intento leer el pedido con id "pedido-inexistente"
    Then el sistema debe retornar un error indicando que el pedido no existe

  Scenario Outline: Validar diferentes estados de pedidos
    Given que el sistema está listo para recibir pedidos
    When creo un pedido con estado "<estado>"
    Then el pedido debe ser persistido con estado "<estado>"

    Examples:
      | estado    |
      | "CREADO"  |
      | "PAGADO"  |
      | "ENVIADO" |
      | "ENTREGADO"|
      | "CANCELADO"|

// === ARCHIVO: src/main/java/RunCucumberTest.java ===
package com.pragma;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features",
    glue = {"com.pragma.integration.steps"},
    plugin = {"net.serenitybdd.cucumber.SerenityReporter"},
    tags = ""
)
public class RunCucumberTest {
}

// === ARCHIVO: src/test/java/com/pragma/integration/runners/RunIntegrationTests.java ===
package com.pragma.integration.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
    features = "src/test/resources/features/pedidos.feature",
    glue = {
        "com.pragma.integration.steps",
        "com.pragma.integration.tasks",
        "com.pragma.integration.questions",
        "com.pragma.integration.models",
        "com.pragma.integration.utils"
    },
    plugin = {
        "pretty",
        "html:target/serenity-reports/serenity-html-report.html",
        "json:target/serenity-reports/serenity-json-report.json",
        "junit:target/serenity-reports/serenity-junit-report.xml"
    },
    tags = "@integration",
    dryRun = false,
    strict = true,
    monochrome = false
)
public class RunIntegrationTests {
}

// === ARCHIVO: src/test/java/com/pragma/integration/steps/PedidosSteps.java ===
package com.pragma.integration.steps;

import com.pragma.integration.models.Pedido;
import com.pragma.integration.questions.PedidoCreadoQuestion;
import com.pragma.integration.tasks.LeerPedidoTask;
import io.cucumber.java.es.Cuando;
import io.cucumber.java.es.Dado;
import io.cucumber.java.es.Entonces;
import io.cucumber.java.es.Y;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PedidosSteps {

    @Managed(driver = "chrome")
    public WebDriver driver;

    @Dado("que el cliente {string} ha realizado un pedido con id {string}")
    public void queElClienteHaRealizadoUnPedido(String clienteId, String pedidoId) {
        Actor actor = OnStage.theActorCalled("Cliente");
        OnStage.setTheStage(new OnlineCast());
        
        Pedido pedido = Pedido.builder()
                .id(pedidoId)
                .clienteId(clienteId)
                .productos(List.of("Producto1", "Producto2"))
                .total(150.00)
                .estado("PENDIENTE")
                .build();
        
        actor.remember("pedido_actual", pedido);
        actor.remember("pedido_id", pedidoId);
    }

    @Cuando("el sistema guarda el pedido en DynamoDB")
    public void elSistemaGuardaElPedidoEnDynamoDB() {
        Actor actor = OnStage.theActorInTheSpotlight();
        Pedido pedido = (Pedido) actor.recall("pedido_actual");
        
        assertNotNull(pedido, "El pedido no debe ser null");
        assertNotNull(pedido.getId(), "El ID del pedido no debe ser null");
        assertNotNull(pedido.getClienteId(), "El ID del cliente no debe ser null");
    }

    @Entonces("el pedido debe ser recuperable de la base de datos")
    public void elPedidoDebeSerRecuperableDeLaBaseDeDatos() {
        Actor actor = OnStage.theActorInTheSpotlight();
        String pedidoId = (String) actor.recall("pedido_id");
        
        actor.attemptsTo(
            LeerPedidoTask.desdeFuente(pedidoId)
        );
    }

    @Y("los datos del pedido deben coincidir con los originales")
    public void losDatosDelPedidoDebenCoincidirConLosOriginales() {
        Actor actor = OnStage.theActorInTheSpotlight();
        Pedido pedidoOriginal = (Pedido) actor.recall("pedido_actual");
        
        actor.asksFor(PedidoCreadoQuestion.enBaseDeDatos());
    }

    @Dado("que existe un pedido en el sistema")
    public void queExisteUnPedidoEnElSistema() {
        Actor actor = OnStage.theActorCalled("Verificador");
        OnStage.setTheStage(new OnlineCast());
        
        String pedidoId = "PED-EXISTENTE-001";
        actor.remember("pedido_id", pedidoId);
    }

    @Cuando("solicito leer el pedido")
    public void solicitoLeerElPedido() {
        Actor actor = OnStage.theActorInTheSpotlight();
        String pedidoId = (String) actor.recall("pedido_id");
        
        actor.attemptsTo(
            LeerPedidoTask.desdeFuente(pedidoId)
        );
    }

    @Entonces("debo obtener la información completa del pedido")
    public void deboObtenerLaInformaciónCompletaDelPedido() {
        Actor actor = OnStage.theActorInTheSpotlight();
        
        actor.asksFor(PedidoCreadoQuestion.enBaseDeDatos());
    }

    @Y("el estado del pedido debe ser {string}")
    public void elEstadoDelPedidoDebeSer(String estadoEsperado) {
        Actor actor = OnStage.theActorInTheSpotlight();
        Pedido pedidoRecuperado = (Pedido) actor.recall("pedido_recuperado");
        
        assertNotNull(pedidoRecuperado, "El pedido recuperado no debe ser null");
        assertEquals(estadoEsperado, pedidoRecuperado.getEstado(), 
            "El estado del pedido debe ser " + estadoEsperado);
    }
}

// === ARCHIVO: src/test/java/com/pragma/integration/tasks/LeerPedidoTask.java ===
package com.pragma.integration.tasks;

import com.pragma.integration.models.Pedido;
import com.pragma.integration.utils.DynamoDBClient;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.Map;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class LeerPedidoTask extends UIInteractionSteps implements Task {

    private static final Logger logger = LoggerFactory.getLogger(LeerPedidoTask.class);
    private static final String TABLA_PEDIDOS = System.getenv().getOrDefault("DYNAMODB_TABLE", "pedidos");

    private final String pedidoId;

    public LeerPedidoTask(String pedidoId) {
        this.pedidoId = pedidoId;
    }

    public static LeerPedidoTask desdeFuente(String pedidoId) {
        return instrumented(LeerPedidoTask.class, pedidoId);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        logger.info("Iniciando lectura del pedido con ID: {}", pedidoId);
        
        DynamoDbClient dynamoDBClient = DynamoDBClient.getClient();
        
        if (dynamoDBClient == null) {
            logger.error("El cliente de DynamoDB no está inicializado");
            throw new IllegalStateException("Cliente DynamoDB no disponible");
        }

        try {
            Map<String, AttributeValue> key = new HashMap<>();
            key.put("id", AttributeValue.builder().s(pedidoId).build());

            GetItemRequest request = GetItemRequest.builder()
                    .tableName(TABLA_PEDIDOS)
                    .key(key)
                    .build();

            GetItemResponse response = dynamoDBClient.getItem(request);
            
            if (!response.hasItem() || response.item().isEmpty()) {
                logger.warn("No se encontró ningún pedido con ID: {}", pedidoId);
                throw new ItemNotFoundException("Pedido no encontrado: " + pedidoId);
            }

            Map<String, AttributeValue> item = response.item();
            Pedido pedidoRecuperado = mapearAPedido(item);
            
            logger.info("Pedido recuperado exitosamente: {}", pedidoRecuperado);
            actor.remember("pedido_recuperado", pedidoRecuperado);
            actor.remember("ultimo_pedido_leido", pedidoRecuperado);
            
        } catch (DynamoDbException e) {
            logger.error("Error al leer el pedido de DynamoDB: {}", e.getMessage());
            throw new RuntimeException("Error al recuperar pedido: " + e.getMessage(), e);
        }
    }

    private Pedido mapearAPedido(Map<String, AttributeValue> item) {
        Pedido.PedidoBuilder builder = Pedido.builder();

        if (item.containsKey("id") && item.get("id").s() != null) {
            builder.id(item.get("id").s());
        }

        if (item.containsKey("clienteId") && item.get("clienteId").s() != null) {
            builder.clienteId(item.get("clienteId").s());
        }

        if (item.containsKey("productos") && item.get("productos").l() != null) {
            builder.productos(item.get("productos").l().stream()
                    .map(AttributeValue::s)
                    .toList());
        }

        if (item.containsKey("total") && item.get("total").n() != null) {
            builder.total(Double.parseDouble(item.get("total").n()));
        }

        if (item.containsKey("estado") && item.get("estado").s() != null) {
            builder.estado(item.get("estado").s());
        }

        return builder.build();
    }

    public static class ItemNotFoundException extends RuntimeException {
        public ItemNotFoundException(String message) {
            super(message);
        }
    }
}

// === ARCHIVO: src/test/java/com/pragma/integration/questions/PedidoCreadoQuestion.java ===
package com.pragma.integration.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Questions.about;

public class PedidoCreadoQuestion implements Question<Boolean> {

    private static final Logger logger = LoggerFactory.getLogger(PedidoCreadoQuestion.class);

    public static PedidoCreadoQuestion enBaseDeDatos() {
        return new PedidoCreadoQuestion();
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        // TODO(reto): Implementar la verificación de que el pedido existe en DynamoDB
        // y que sus datos coinciden con los esperados.
        // 
        // Pasos sugeridos:
        // 1. Recuperar el pedido original guardado en la memoria del actor (actor.recall("pedido_actual"))
        // 2. Recuperar el pedido leído de la base de datos (actor.recall("pedido_recuperado"))
        // 3. Comparar los campos relevantes: id, clienteId, productos, total, estado
        // 4. Retornar true si todos los campos coinciden, false en caso contrario
        // 
        // Consideraciones:
        // - Usar assertEquals o comparaciones directas según corresponda
        // - Manejar el caso donde alguno de los pedidos sea null
        // - Registrar el resultado de la verificación con logger
        
        logger.warn("La verificación de pedido creado no está implementada");
        return false;
    }
}

// === ARCHIVO: src/test/java/com/pragma/integration/models/Pedido.java ===
package com.pragma.integration.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Pedido {

    private String id;
    private String clienteId;
    private List<String> productos;
    private Double total;
    private String estado;

    public Pedido() {
        this.productos = new ArrayList<>();
    }

    public Pedido(String id, String clienteId, List<String> productos, Double total, String estado) {
        this.id = id;
        this.clienteId = clienteId;
        this.productos = productos != null ? new ArrayList<>(productos) : new ArrayList<>();
        this.total = total;
        this.estado = estado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getClienteId() {
        return clienteId;
    }

    public void setClienteId(String clienteId) {
        this.clienteId = clienteId;
    }

    public List<String> getProductos() {
        return productos;
    }

    public void setProductos(List<String> productos) {
        this.productos = productos != null ? new ArrayList<>(productos) : new ArrayList<>();
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return Objects.equals(id, pedido.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Pedido{" +
                "id='" + id + '\'' +
                ", clienteId='" + clienteId + '\'' +
                ", productos=" + productos +
                ", total=" + total +
                ", estado='" + estado + '\'' +
                '}';
    }
}

// === ARCHIVO: src/test/java/com/pragma/integration/utils/DynamoDBClient.java ===
package com.pragma.integration.utils;

import com.pragma.integration.models.Pedido;
import software.amazon.awssdk.services.dynamodb.DynamoDbClient;
import software.amazon.awssdk.services.dynamodb.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamoDBClient {

    private final DynamoDbClient client;
    private final String tableName;

    public DynamoDBClient(DynamoDbClient client, String tableName) {
        this.client = client;
        this.tableName = tableName;
    }

    public void guardarPedido(Pedido pedido) {
        // TODO(reto): Implementar guardado de pedido en DynamoDB
        // - Crear Map con atributos del pedido
        // - Usar PutItemSpec para insertar en la tabla
        // - Manejar excepciones de DynamoDB
        throw new UnsupportedOperationException("Metodo guardarPedido no implementado");
    }

    public Pedido obtenerPedido(String pedidoId) {
        // TODO(reto): Implementar lectura de pedido por ID
        // - Crear GetItemSpec con clave primaria
        // - Ejecutar getItem y mapear resultado a Pedido
        // - Manejar excepciones de DynamoDB
        throw new UnsupportedOperationException("Metodo obtenerPedido no implementado");
    }

    public List<Pedido> listarPedidos() {
        // TODO(reto): Implementar listado de todos los pedidos
        // - Usar ScanSpec para obtener todos los items
        // - Mapear cada item a un objeto Pedido
        // - Retornar lista de pedidos
        throw new UnsupportedOperationException("Metodo listarPedidos no implementado");
    }

    public void eliminarPedido(String pedidoId) {
        // TODO(reto): Implementar eliminacion de pedido
        // - Crear DeleteItemSpec con clave primaria
        // - Ejecutar deleteItem
        // - Manejar excepciones de DynamoDB
        throw new UnsupportedOperationException("Metodo eliminarPedido no implementado");
    }

    public void actualizarEstadoPedido(String pedidoId, String nuevoEstado) {
        // TODO(reto): Implementar actualizacion de estado de pedido
        // - Usar UpdateItemSpec con expresion de actualizacion
        // - Actualizar solo el campo estado
        // - Manejar excepciones de DynamoDB
        throw new UnsupportedOperationException("Metodo actualizarEstadoPedido no implementado");
    }

    public boolean existePedido(String pedidoId) {
        // TODO(reto): Implementar verificacion de existencia de pedido
        // - Realizar getItem con ProjectionExpression solo en la clave
        // - Verificar si el resultado tiene atributos
        // - Retornar true/false
        throw new UnsupportedOperationException("Metodo existePedido no implementado");
    }

    private Map<String, AttributeValue> pedidoToItem(Pedido pedido) {
        Map<String, AttributeValue> item = new HashMap<>();
        item.put("id", AttributeValue.builder().s(pedido.getId()).build());
        item.put("clienteId", AttributeValue.builder().s(pedido.getClienteId()).build());
        
        if (pedido.getProductos() != null && !pedido.getProductos().isEmpty()) {
            item.put("productos", AttributeValue.builder()
                    .l(pedido.getProductos().stream()
                            .map(AttributeValue::builder)
                            .map(b -> b.s("").build())
                            .toList())
                    .build());
        }
        
        if (pedido.getTotal() != null) {
            item.put("total", AttributeValue.builder().n(pedido.getTotal().toString()).build());
        }
        
        if (pedido.getEstado() != null) {
            item.put("estado", AttributeValue.builder().s(pedido.getEstado()).build());
        }
        
        return item;
    }

    private Pedido itemToPedido(Map<String, AttributeValue> item) {
        if (item == null || item.isEmpty()) {
            return null;
        }

        Pedido pedido = new Pedido();
        
        if (item.containsKey("id")) {
            pedido.setId(item.get("id").s());
        }
        if (item.containsKey("clienteId")) {
            pedido.setClienteId(item.get("clienteId").s());
        }
        if (item.containsKey("productos")) {
            List<String> productos = item.get("productos").l().stream()
                    .map(AttributeValue::s)
                    .toList();
            pedido.setProductos(productos);
        }
        if (item.containsKey("total")) {
            pedido.setTotal(Double.parseDouble(item.get("total").n()));
        }
        if (item.containsKey("estado")) {
            pedido.setEstado(item.get("estado").s());
        }
        
        return pedido;
    }
}

// === ARCHIVO: src/test/java/resources/features/pedidos.feature ===
# language: es
Funcionalidad: Gestión de Pedidos en DynamoDB
  Como usuario del sistema de pedidos
  Quiero realizar operaciones de lectura y escritura en DynamoDB
  Para validar que el flujo de persistencia de pedidos funciona correctamente

  Antecedentes:
    Dado que el cliente ha realizado un pedido con ID "PED-001" y cliente ID "CLI-001"

  @integration
  Escenario: Guardar un nuevo pedido en DynamoDB
    Cuando el sistema guarda el pedido en DynamoDB
    Entonces el pedido debe ser recuperable de la base de datos
    Y los datos del pedido deben coincidir con los originales

  @integration
  Escenario: Leer un pedido existente del sistema
    Dado que existe un pedido en el sistema con ID "PED-002"
    Cuando solicito leer el pedido
    Entonces el estado del pedido debe ser "PENDIENTE"

  @integration
  Escenario: Actualizar el estado de un pedido
    Dado que existe un pedido en el sistema con ID "PED-003"
    Cuando solicito actualizar el estado del pedido a "CONFIRMADO"
    Entonces el estado del pedido debe ser "CONFIRMADO"

  @integration
  Escenario: Verificar que un pedido no existente lanza excepción
    Dado que no existe un pedido en el sistema con ID "PED-INEXISTENTE"
    Cuando solicito leer el pedido
    Entonces debo recibir una excepción indicando que el pedido no fue encontrado

  @integration
  Escenario: Eliminar un pedido del sistema
    Dado que existe un pedido en el sistema con ID "PED-004"
    Cuando solicito eliminar el pedido
    Then el pedido no debe existir en la base de datos

// === ARCHIVO: docker-compose.yml ===
# Infraestructura local del reto. SOLO desarrollo: credenciales de ejemplo (local-dev-only), puertos en loopback.
# Levantar: docker compose up -d --wait
name: infra-local
services:
  dynamodb-local:
    image: "amazon/dynamodb-local:2.5.2"
    command: ["-jar","DynamoDBLocal.jar","-sharedDb","-inMemory"]
    ports:
      - "127.0.0.1:8000:8000"
    healthcheck:
      test: ["CMD-SHELL","bash -c ':> /dev/tcp/127.0.0.1/8000' || exit 1"]
      interval: 10s
      timeout: 5s
      retries: 10
      start_period: 5s


// === ARCHIVO: infra-local/README.md ===
# Infraestructura local

Servicios de soporte para el reto, definidos en `docker-compose.yml` (raiz del repo).

```bash
docker compose up -d --wait
```

| Servicio | Imagen | Puertos (host) |
|---|---|---|
| DynamoDB Local | `amazon/dynamodb-local:2.5.2` | 8000 |

Credenciales: solo de desarrollo local (`local-dev-only`, `local`). No son secretos ni deben reutilizarse.
Los scripts de `infra-local/` (tablas, topics) se ejecutan con el compose en estado healthy.


// === ARCHIVO: infra-local/dynamodb/create-tables.sh ===
#!/usr/bin/env bash
# Crea las tablas en DynamoDB Local (idempotente). Credenciales dummy: DynamoDB Local no valida firmas.
set -euo pipefail

export AWS_ACCESS_KEY_ID=local
export AWS_SECRET_ACCESS_KEY=local
export AWS_REGION=us-east-1
ENDPOINT="${DYNAMODB_ENDPOINT:-http://localhost:8000}"

create_table() {
  local name="$1" pk="$2" sk="${3:-}"
  if aws dynamodb describe-table --table-name "$name" --endpoint-url "$ENDPOINT" >/dev/null 2>&1; then
    echo "Tabla $name ya existe"
    return
  fi
  local attrs="AttributeName=$pk,AttributeType=S"
  local keys="AttributeName=$pk,KeyType=HASH"
  if [ -n "$sk" ]; then
    attrs="$attrs AttributeName=$sk,AttributeType=S"
    keys="$keys AttributeName=$sk,KeyType=RANGE"
  fi
  # shellcheck disable=SC2086
  aws dynamodb create-table --table-name "$name" --attribute-definitions $attrs --key-schema $keys \
    --billing-mode PAY_PER_REQUEST --endpoint-url "$ENDPOINT" >/dev/null
  echo "Tabla $name creada"
}

create_table "app-items" "id"

```
