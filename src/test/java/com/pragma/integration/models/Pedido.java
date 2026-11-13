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