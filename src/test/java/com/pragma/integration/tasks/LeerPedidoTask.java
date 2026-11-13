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