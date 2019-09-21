/*
 * Copyright (c) 2018 - 2019 - Frank Hossfeld
 *
 *  Licensed under the Apache License, Version 2.0 (the "License"); you may not
 *  use this file except in compliance with the License. You may obtain a copy of
 *  the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 *  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 *  License for the specific language governing permissions and limitations under
 *  the License.
 */

package com.github.nalukit.nalu.client.component;

import com.github.nalukit.nalu.client.context.IsContext;
import com.github.nalukit.nalu.client.exception.RoutingInterceptionException;
import com.github.nalukit.nalu.client.internal.HandlerRegistrations;
import com.github.nalukit.nalu.client.internal.annotation.NaluInternalUse;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractComponentController<C extends IsContext, V extends IsComponent<?, W>, W>
    extends AbstractController<C>
    implements IsController<V, W>,
               IsComponent.Controller {

  /* component of the controller */
  protected V                                                 component;
  /* list of registered handlers */
  protected HandlerRegistrations                              handlerRegistrations = new HandlerRegistrations();
  /* list fo compsite controllers */
  private   Map<String, AbstractCompositeController<?, ?, ?>> compositeControllers;
  /* the route the controller is related to */
  private   String                                            relatedRoute;
  /* flag, if the controller is cached or not */
  private   boolean                                           cached;

  public AbstractComponentController() {
    super();
    this.compositeControllers = new HashMap<>();
  }

  /**
   * Returns the elment of the component. Will be used by Nalu
   * to add it to the DOM.
   *
   * @return the element of the component
   */
  @Override
  public W asElement() {
    return this.component.asElement();
  }

  /**
   * Method will be called in case the element is attached to the DOM.
   * <p>
   * The method is used by the framework!
   * <p>
   * <b>DO NOT CALL THIS METHOD! THIS WILL LEAD TO UNEXPECTED BEHAVIOR!</b>
   */
  @NaluInternalUse
  @Override
  public final void onAttach() {
    component.onAttach();
  }

  /**
   * Method will be called in case the element is removed from the DOM
   * <p>
   * The method is used by the framework!
   * <p>
   * <b>DO NOT CALL THIS METHOD! THIS WILL LEAD TO UNEXPECTED BEHAVIOR!</b>
   */
  @NaluInternalUse
  @Override
  public final void onDetach() {
    component.onDetach();
  }

  /**
   * This method will be called in case a routing occurs and this instance is
   * a currently attached controller
   *
   * @param confirmHandler call the <code>continueRouting()</code> to continue routing or <code>abortRouting()</code> to abort routing
   */
  @Override
  public void mayStop(ConfirmHandler confirmHandler) {
    confirmHandler.continueRouting();
  }

  /**
   * internal framework method! Will be called by the framdework after the
   * stop-method f the controller is called
   * <p>
   * The method is used by the framework!
   * <p>
   * <b>DO NOT CALL THIS METHOD! THIS WILL LEAD TO UNEXPECTED BEHAVIOR!</b>
   */
  @NaluInternalUse
  @Override
  public void removeHandlers() {
    this.handlerRegistrations.removeHandler();
    this.handlerRegistrations = new HandlerRegistrations();
  }

  /**
   * The activate-method will be called instead of the start-method
   * in case the controller is cached.
   * <p>
   * If you have to do something in case controller gets active,
   * that's the right place.
   */
  @Override
  public void activate() {
  }

  /**
   * The deactivate-method will be called instead of the stop-method
   * in case the controller is cached.
   * <p>
   * If you have to do something in case controller gets deactivated,
   * that's the right place.
   */
  @Override
  public void deactivate() {
  }

  /**
   * The stop-method will be called at the start of the controller's life cycle.
   * <p>
   * If you have to do something in case controller gets active,
   * that's the right place.
   */
  @Override
  public void start() {
  }

  /**
   * The stop-method will be called at the end of the controller's life cycle.
   * <p>
   * If you have to do something in case controller gets inactive,
   * that's the right place.
   */
  @Override
  public void stop() {
  }

  /**
   * The map of the depending composites of the controller
   *
   * @return Map of depending composites
   */
  public Map<String, AbstractCompositeController<?, ?, ?>> getComposites() {
    return compositeControllers;
  }

  /**
   * Returns the composite stored under the composite name.
   *
   * @param name the name of the composite
   * @param <S>  type of the composite
   * @return instance of the composite
   */
  @SuppressWarnings("unchecked")
  public <S extends AbstractCompositeController<?, ?, ?>> S getComposite(String name) {
    return (S) this.getComposites()
                   .get(name);
  }

  /**
   * The route the controller is related to.
   *
   * @return related route
   */
  public String getRelatedRoute() {
    return relatedRoute;
  }

  /**
   * Sets the related route of the controller. (Will be used by the framework!)
   * <b>Do not use this method. This will lead to unexpected results</b>
   *
   * @param relatedRoute related route of the controller
   */
  public void setRelatedRoute(String relatedRoute) {
    this.relatedRoute = relatedRoute;
  }

  /**
   * Indicates, if the controller is newly created or not
   *
   * @return true: the controller is reused, false: the controller is newly created
   */
  public boolean isCached() {
    return cached;
  }

  /**
   * Sets the value, if the controller is newly created or cached!
   * <b>This field is used by Nalu! Setting the value can lead to unexpected behavior!</b>
   *
   * @param cached true: the controller is reused, false: the controller is newly created
   */
  public void setCached(boolean cached) {
    this.cached = cached;
  }

  /**
   * Get the component
   *
   * @return the compoment of the controller
   */
  public V getComponent() {
    return this.component;
  }

  /**
   * Sets the component inside the controller
   * <b>Do not use this method. This will lead to unexpected results</b>
   *
   * @param component instance fo the component
   */
  @Override
  public void setComponent(V component) {
    this.component = component;
  }

  /**
   * The bind-method will be called before the component of the
   * controller is created.
   * <p>
   * This method runs before the component and composites are
   * created. This is f.e.: a got place to do some
   * authentification checks.
   * <p>
   * Keep in mind, that the method is asynchron. Once you have
   * done your work, you have to call <b>loader.continueLoading()</b>.
   * Otherwise Nalu will stop working!
   * <p>
   * The method will not be called in case a controller is cached!
   * <p>
   * Attention:
   * Do not call super.bind(loader)! Cause this will tell Nalu to
   * continue laoding!
   *
   * @param loader loader to tell Nalu to continue loading the controller
   * @throws RoutingInterceptionException in case the bind controller
   *                                      process should be interrupted
   */
  @Override
  public void bind(ControllerLoader loader)
      throws RoutingInterceptionException {
    loader.continueLoading();
  }

}
