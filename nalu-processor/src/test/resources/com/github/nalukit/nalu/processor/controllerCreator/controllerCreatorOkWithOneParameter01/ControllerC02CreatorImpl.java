package com.github.nalukit.nalu.processor.controllerCreator.controllerCreatorOkWithOneParameter01;

import com.github.nalukit.nalu.client.Router;
import com.github.nalukit.nalu.client.component.AbstractComponentController;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import com.github.nalukit.nalu.client.internal.AbstractControllerCreator;
import com.github.nalukit.nalu.client.internal.ClientLogger;
import com.github.nalukit.nalu.client.internal.application.ControllerFactory;
import com.github.nalukit.nalu.client.internal.application.ControllerInstance;
import com.github.nalukit.nalu.client.internal.application.IsControllerCreator;
import com.github.nalukit.nalu.processor.common.MockContext;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.StringBuilder;
import org.gwtproject.event.shared.SimpleEventBus;

public final class ControllerC02CreatorImpl extends AbstractControllerCreator<MockContext> implements IsControllerCreator {
  public ControllerC02CreatorImpl(Router router, MockContext context, SimpleEventBus eventBus) {
    super(router, context, eventBus);
  }

  @Override
  public ControllerInstance create() {
    StringBuilder sb01 = new StringBuilder();
    ControllerInstance controllerInstance = new ControllerInstance();
    controllerInstance.setControllerClassName("com.github.nalukit.nalu.processor.controllerCreator.controllerCreatorOkWithOneParameter01.ControllerC02");
    AbstractComponentController<?, ?, ?> storedController = ControllerFactory.get().getControllerFormStore("com.github.nalukit.nalu.processor.controllerCreator.controllerCreatorOkWithOneParameter01.ControllerC02");
    if (storedController == null) {
      sb01.append("controller >>com.github.nalukit.nalu.processor.controllerCreator.controllerCreatorOkWithOneParameter01.ControllerC02<< --> will be created");
      ClientLogger.get().logSimple(sb01.toString(), 3);
      ControllerC02 controller = new ControllerC02();
      controllerInstance.setController(controller);
      controllerInstance.setChached(false);
      controller.setContext(context);
      controller.setEventBus(eventBus);
      controller.setRouter(router);
      controller.setCached(false);
      sb01 = new StringBuilder();
      sb01.append("controller >>").append(controller.getClass().getCanonicalName()).append("<< --> created and data injected");
      ClientLogger.get().logDetailed(sb01.toString(), 4);
    } else {
      sb01.append("controller >>").append(storedController.getClass().getCanonicalName()).append("<< --> found in cache -> REUSE!");
      ClientLogger.get().logDetailed(sb01.toString(), 4);
      controllerInstance.setController(storedController);
      controllerInstance.setChached(true);
      controllerInstance.getController().setCached(true);
    }
    return controllerInstance;
  }

  @Override
  public void onFinishCreating(Object object) throws RoutingInterceptionException {
    ControllerC02 controller = (ControllerC02) object;
    StringBuilder sb01 = new StringBuilder();
    IComponent02 component = new Component02();
    sb01 = new StringBuilder();
    sb01.append("component >>com.github.nalukit.nalu.processor.controllerCreator.controllerCreatorOkWithOneParameter01.Component02<< --> created using new");
    ClientLogger.get().logDetailed(sb01.toString(), 4);
    component.setController(controller);
    sb01 = new StringBuilder();
    sb01.append("component >>").append(component.getClass().getCanonicalName()).append("<< --> created and controller instance injected");
    ClientLogger.get().logDetailed(sb01.toString(), 4);
    controller.setComponent(component);
    sb01 = new StringBuilder();
    sb01.append("controller >>").append(controller.getClass().getCanonicalName()).append("<< --> instance of >>").append(component.getClass().getCanonicalName()).append("<< injected");
    ClientLogger.get().logDetailed(sb01.toString(), 4);
    component.render();
    sb01 = new StringBuilder();
    sb01.append("component >>").append(component.getClass().getCanonicalName()).append("<< --> rendered");
    ClientLogger.get().logDetailed(sb01.toString(), 4);
    component.bind();
    sb01 = new StringBuilder();
    sb01.append("component >>").append(component.getClass().getCanonicalName()).append("<< --> bound");
    ClientLogger.get().logDetailed(sb01.toString(), 4);
    ClientLogger.get().logSimple("controller >>com.github.nalukit.nalu.processor.controllerCreator.controllerCreatorOkWithOneParameter01.Component02<< created for route >>/mockShell/route01/*<<", 3);
  }

  @Override
  public void setParameter(Object object, String... parms) throws RoutingInterceptionException {
    ControllerC02 controller = (ControllerC02) object;
    StringBuilder sb01 = new StringBuilder();
    if (parms != null) {
      if (parms.length >= 1) {
        sb01 = new StringBuilder();
        sb01.append("controller >>").append(controller.getClass().getCanonicalName()).append("<< --> using method >>setParameter01<< to set value >>").append(parms[0]).append("<<");
        ClientLogger.get().logDetailed(sb01.toString(), 4);
        controller.setParameter01(parms[0]);
      }
    }
  }
}
