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