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