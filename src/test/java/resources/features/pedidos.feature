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