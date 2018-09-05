package com.github.mvp4g.nalu.client.component;

import com.github.mvp4g.nalu.client.application.IsContext;
import com.github.mvp4g.nalu.client.internal.HandlerRegistrations;

public abstract class AbstractComponentController<C extends IsContext, V extends IsComponent<?, W>, W>
  extends AbstractController<C>
  implements IsController<W>,
             IsComponent.Controller {

  protected V component;

  protected HandlerRegistrations handlerRegistrations;

  public AbstractComponentController() {
    super();
    // create HandlerRegistraions
    this.handlerRegistrations = new HandlerRegistrations();
  }

  @Override
  public W asElement() {
    return this.component.asElement();
  }

  @Override
  public final void onAttach() {
    component.onAttach();
  }

  @Override
  public final void onDetach() {
    component.onDetach();
  }

  @Override
  public String mayStop() {
    return null;
  }

  /**
   * The stop-method will be called at the start of the controller's life cycle.
   *
   * If you have to do something in case controller gets active,
   * that's the right place.
   */
  @Override
  public void start() {
  }

  /**
   * The stop-method will be called at the end of the controller's life cycle.
   *
   * If you have to do something in case controller gets inactive,
   * that's the right place.
   */
  @Override
  public void stop() {
  }

  /**
   * internal framework method! Will be called by the framdework after the
   * stop-method f the controller is called
   *
   * <b>DO NOT CALL THIS METHOD! THIS WILL LEAD TO UNEXPECTED BEHAVIOR!</b>
   */
  @Override
  public void removeHandlers() {
    this.handlerRegistrations.removeHandler();
    this.handlerRegistrations = null;
  }

  public void setComponent(V component) {
    this.component = component;
  }
}
