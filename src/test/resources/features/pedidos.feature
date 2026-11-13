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