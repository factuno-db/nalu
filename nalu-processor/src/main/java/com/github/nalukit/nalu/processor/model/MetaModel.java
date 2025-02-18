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

package com.github.nalukit.nalu.processor.model;

import com.github.nalukit.nalu.processor.model.intern.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MetaModel {

  private String generateToPackage;

  private ClassNameModel application;

  private ClassNameModel loader;

  private List<ClassNameModel> plugins;

  private boolean usingHash;

  private boolean usingColonForParametersInUrl;

  private boolean stayOnSide;

  /* this model represents the plugin interface */
  /* is the model not null, we have to deal     */
  /* with a a plugin and not with a pplication  */
  private PluginModel pluginModel;

  private List<ShellModel> shells;

  private ClassNameModel context;

  private String startRoute;

  private String routeError;

  private boolean hasPluginsAnnotation;

  private boolean hasDebugAnnotation;

  private boolean hasTrackerAnnotation;

  private ClassNameModel tracker;

  private String debugLogLevel;

  private ClassNameModel debugLogger;

  private List<ControllerModel> controllers;

  private List<PopUpControllerModel> popUpControllers;

  private List<ClassNameModel> filters;

  private List<ClassNameModel> handlers;

  private ClassNameModel componentType;

  private List<CompositeModel> compositeModels;

  /* flag, that indicates, if a Nalu application */
  /* uses a history token or not.                */
  private boolean history;

  public MetaModel() {
    this.plugins = new ArrayList<>();
    this.shells = new ArrayList<>();
    this.controllers = new ArrayList<>();
    this.popUpControllers = new ArrayList<>();
    this.filters = new ArrayList<>();
    this.handlers = new ArrayList<>();
    this.compositeModels = new ArrayList<>();
  }

  public PluginModel getPluginModel() {
    return pluginModel;
  }

  public void setPluginModel(PluginModel pluginModel) {
    this.pluginModel = pluginModel;
  }

  public ClassNameModel getApplication() {
    return application;
  }

  public void setApplication(ClassNameModel application) {
    this.application = application;
  }

  public ClassNameModel getLoader() {
    return loader;
  }

  public void setLoader(ClassNameModel loader) {
    this.loader = loader;
  }

  public boolean isHasDebugAnnotation() {
    return hasDebugAnnotation;
  }

  public void setHasDebugAnnotation(boolean hasDebugAnnotation) {
    this.hasDebugAnnotation = hasDebugAnnotation;
  }

  public String getDebugLogLevel() {
    if (debugLogLevel == null || "".equals(debugLogLevel)) {
      return "SIMPLE";
    }
    return debugLogLevel;
  }

  public void setDebugLogLevel(String debugLogLevel) {
    this.debugLogLevel = debugLogLevel;
  }

  public String getGenerateToPackage() {
    return generateToPackage;
  }

  public void setGenerateToPackage(String generateToPackage) {
    this.generateToPackage = generateToPackage;
  }

  public ClassNameModel getContext() {
    return context;
  }

  public void setContext(ClassNameModel context) {
    this.context = context;
  }

  public String getStartRoute() {
    return startRoute;
  }

  public void setStartRoute(String startRoute) {
    this.startRoute = startRoute;
  }

  public ClassNameModel getDebugLogger() {
    return debugLogger;
  }

  public void setDebugLogger(ClassNameModel debugLogger) {
    this.debugLogger = debugLogger;
  }

  public List<ControllerModel> getControllers() {
    return controllers;
  }

  public void setControllers(List<ControllerModel> controllers) {
    this.controllers = controllers;
  }

  public List<PopUpControllerModel> getPopUpControllers() {
    return popUpControllers;
  }

  public void setPopUpControllers(List<PopUpControllerModel> popUpControllers) {
    this.popUpControllers = popUpControllers;
  }
  //  public String getHasFiltersAnnotation() {
  //    return hasFiltersAnnotation;
  //  }
  //
  //  public void setHasFiltersAnnotation(String hasFiltersAnnotation) {
  //    this.hasFiltersAnnotation = hasFiltersAnnotation;
  //  }

  public List<ClassNameModel> getFilters() {
    return filters;
  }

  public void setFilters(List<ClassNameModel> filters) {
    this.filters = filters;
  }

  public List<ClassNameModel> getHandlers() {
    return handlers;
  }

  public void setHandlers(List<ClassNameModel> handlers) {
    this.handlers = handlers;
  }

  public ClassNameModel getComponentType() {
    return componentType;
  }

  public void setComponentType(ClassNameModel componentType) {
    this.componentType = componentType;
  }

  public String getRouteError() {
    return routeError;
  }

  public void setRouteError(String routeError) {
    this.routeError = routeError;
  }

  public List<CompositeModel> getCompositeModels() {
    return compositeModels;
  }

  public List<ShellModel> getShells() {
    return shells;
  }

  public boolean hasPluginsAnnotation() {
    return hasPluginsAnnotation;
  }

  public void setHasPluginsAnnotation(boolean hasPluginsAnnotation) {
    this.hasPluginsAnnotation = hasPluginsAnnotation;
  }

  public List<ClassNameModel> getPlugins() {
    return plugins;
  }

  public void setPlugins(List<ClassNameModel> plugins) {
    this.plugins = plugins;
  }

  public boolean isUsingHash() {
    return usingHash;
  }

  public void setUsingHash(boolean usingHash) {
    this.usingHash = usingHash;
  }

  public boolean isUsingColonForParametersInUrl() {
    return usingColonForParametersInUrl;
  }

  public void setUsingColonForParametersInUrl(boolean usingColonForParametersInUrl) {
    this.usingColonForParametersInUrl = usingColonForParametersInUrl;
  }

  public boolean isStayOnSide() {
    return stayOnSide;
  }

  public void setStayOnSide(boolean stayOnSide) {
    this.stayOnSide = stayOnSide;
  }

  public String getShellOfStartRoute() {
    if (Objects.isNull(this.startRoute)) {
      return "";
    }
    return getShellFromRoute(this.startRoute);
  }

  public String getShellOfErrorRoute() {
    if (Objects.isNull(this.routeError)) {
      return "";
    }
    return getShellFromRoute(this.routeError);
  }

  private String getShellFromRoute(String route) {
    String shellFromRoute = route;
    if (shellFromRoute.startsWith("/")) {
      shellFromRoute = shellFromRoute.substring(1);
    }
    if (shellFromRoute.contains("/")) {
      shellFromRoute = shellFromRoute.substring(0,
                                                shellFromRoute.indexOf("/"));
    }
    return shellFromRoute;
  }

  public boolean hasHistory() {
    return history;
  }

  public void setHistory(boolean history) {
    this.history = history;
  }

  public boolean hasTrackerAnnotation() {
    return hasTrackerAnnotation;
  }

  public void setHasTrackerAnnotation(boolean hasTrackerAnnotation) {
    this.hasTrackerAnnotation = hasTrackerAnnotation;
  }

  public ClassNameModel getTracker() {
    return tracker;
  }

  public void setTracker(ClassNameModel tracker) {
    this.tracker = tracker;
  }

}
