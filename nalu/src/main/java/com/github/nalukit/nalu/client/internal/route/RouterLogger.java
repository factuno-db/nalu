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

package com.github.nalukit.nalu.client.internal.route;

import com.github.nalukit.nalu.client.internal.ClientLogger;

import java.util.Arrays;
import java.util.stream.Stream;

class RouterLogger {

  RouterLogger() {
  }

  static void logHandleHash(String hash) {
    String sb = "Router: handleRouting for hash ->>" + hash + "<<";
    logDetailed(sb,
                0);
  }

  private static void logDetailed(String message,
                                  int depth) {
    ClientLogger.get()
                .logDetailed(message,
                             depth);
  }

  static String logNoMatchingRoute(String route,
                                   String routeError) {
    String sb = "no matching controller for route >>" + route + "<< found --> use configurated route: >" + routeError + "<<";
    logSimple(sb,
              3);
    return sb;
  }

  static void logSimple(String message,
                        int depth) {
    ClientLogger.get()
                .logSimple(message,
                           depth);
  }

  static void logFilterInterceptsRouting(String canonicalName,
                                         String redirectTo,
                                         String[] parameters) {
    StringBuilder sb = new StringBuilder();
    sb.append("Router: filter >>")
      .append(canonicalName)
      .append("<< intercepts routing! New route: >>")
      .append(redirectTo)
      .append("<<");
    if (Arrays.asList(parameters)
              .size() > 0) {
      sb.append(" with parameters: ");
      Stream.of(parameters)
            .forEach(p -> sb.append(">>")
                            .append(p)
                            .append("<< "));
    }
    logSimple(sb.toString(),
              3);
  }

  static void logControllerInterceptsRouting(String controllerClassName,
                                             String route,
                                             String[] parameter) {
    StringBuilder sb = new StringBuilder();
    sb.append("Router: create controller >>")
      .append(controllerClassName)
      .append("<< intercepts routing! New route: >>")
      .append(route)
      .append("<<");
    if (Arrays.asList(parameter)
              .size() > 0) {
      sb.append(" with parameters: ");
      Stream.of(parameter)
            .forEach(p -> sb.append(">>")
                            .append(p)
                            .append("<< "));
    }
    logSimple(sb.toString(),
              0);
  }

  static String logNoControllerFoundForHash(String hash) {
    String sb = "no controller found for hash >>" + hash + "<<";
    logSimple(sb,
              3);
    return sb;
  }

  static void logUseErrorRoute(String routeError) {
    String sb = "use configurated default route >>" + routeError + "<<";
    logSimple(sb,
              3);
  }

  static void logControllerOnAttachedMethodCalled(String canonicalName) {
    String sb = "Router: create controller >>" + canonicalName + "<< - calls method onAttached()";
    logDetailed(sb,
                4);
  }

  static void logControllerActivateMethodCalled(String canonicalName) {
    String sb = "Router: create controller >>" + canonicalName + "<< - calls method activate()";
    logDetailed(sb,
                4);
  }

  static void logControllerStartMethodCalled(String canonicalName) {
    String sb = "Router: create controller >>" + canonicalName + "<< - calls method start()";
    logDetailed(sb,
                4);
  }

  static void logShellOnAttachedComponentMethodCalled(String canonicalName) {
    String sb = "Router: create controller >>" + canonicalName + "<< - calls shellCreator.onAttachedComponent()";
    logDetailed(sb,
                4);
  }

  static void logControllerdeactivateMethodWillBeCalled(String canonicalName) {
    String sb = "controller >>" + canonicalName + "<< --> will be deactivated";
    logSimple(sb,
              3);
  }

  static void logControllerStopMethodWillBeCalled(String canonicalName) {
    String sb = "controller >>" + canonicalName + "<< --> will be stopped";
    logSimple(sb,
              3);
  }

  static void logCompositeControllerStopMethodWillBeCalled(String canonicalName) {
    String sb = "composite controller >>" + canonicalName + "<< --> will be stopped";
    logSimple(sb,
              5);
  }

  static void logControllerDeactivateMethodCalled(String canonicalName) {
    String sb = "controller >>" + canonicalName + "<< --> deactivated";
    logDetailed(sb,
                4);
  }

  static void logControllerStopMethodCalled(String canonicalName) {
    String sb = "controller >>" + canonicalName + "<< --> stopped";
    logDetailed(sb,
                4);
  }

  static void logCompositeControllerDeactivateMethodWillBeCalled(String canonicalName) {
    String sb = "composite controller >>" + canonicalName + "<< --> deactivate";
    logDetailed(sb,
                6);
  }

  static void logCompositeControllerDeactivateMethodCalled(String canonicalName) {
    String sb = "composite controller >>" + canonicalName + "<< --> deactivated";
    logDetailed(sb,
                6);
  }

  static void logCompositeControllerRemoveMethodCalled(String canonicalName) {
    String sb = "composite controller >>" + canonicalName + "<< --> remove";
    logDetailed(sb,
                6);
  }

  static void logCompositeControllerStopMethodCalled(String canonicalName) {
    String sb = "composite controller >>" + canonicalName + "<< --> stopped";
    logDetailed(sb,
                6);
  }

  static void logComponentDetached(String canonicalName) {
    String sb = "composite component >>" + canonicalName + "<< --> detached";
    logDetailed(sb,
                4);
  }

  static void logCompositeComponentDetached(String canonicalName) {
    String sb = "component >>" + canonicalName + "<< --> detached";
    logDetailed(sb,
                6);
  }

  static void logControllerDetached(String canonicalName) {
    String sb = "controller >>" + canonicalName + "<< --> detached";
    logDetailed(sb,
                4);
  }

  static void logCompositeControllerDetached(String canonicalName) {
    String sb = "composite controller >>" + canonicalName + "<< --> detached";
    logDetailed(sb,
                6);
  }

  static void logComponentRemoveHandlersMethodCalled(String canonicalName) {
    String sb = "component >>" + canonicalName + "<< --> removed handlers";
    logDetailed(sb,
                4);
  }

  static void logCompositeComponentRemoveHandlersMethodCalled(String canonicalName) {
    String sb = "composite component >>" + canonicalName + "<< --> removed handlers";
    logDetailed(sb,
                6);
  }

  static void logControllerRemoveHandlersMethodCalled(String canonicalName) {
    String sb = "controller >>" + canonicalName + "<< --> removed handlers";
    logDetailed(sb,
                4);
  }

  static void logCompositeControllerRemoveHandlersMethodCalled(String canonicalName) {
    String sb = "composite controller >>" + canonicalName + "<< --> removed handlers";
    logDetailed(sb,
                6);
  }

  static void logControllerDeactivated(String canonicalName) {
    String sb = "controller >>" + canonicalName + "<< --> deactivated";
    logSimple(sb,
              3);
  }

  static void logControllerStopped(String canonicalName) {
    String sb = "controller >>" + canonicalName + "<< --> stopped";
    logSimple(sb,
              3);
  }

  static void logControllerHandlingStop(String canonicalName) {
    String sb = "controller >>" + canonicalName + "<< --> handling stop request";
    logSimple(sb,
              3);
  }

  static void logControllerHandlingStopComposites(String canonicalName) {
    String sb = "controller >>" + canonicalName + "<< --> stopping composites";
    logSimple(sb,
              4);
  }

  static void logControllerCompositesStopped(String canonicalName) {
    String sb = "controller >>" + canonicalName + "<< --> composites stopped";
    logSimple(sb,
              4);
  }

  static void logCompositeControllerDeactivated(String canonicalName) {
    String sb = "composite controller >>" + canonicalName + "<< --> deactivated";
    logSimple(sb,
              5);
  }

  static void logCompositeControllerStopped(String canonicalName) {
    String sb = "composite controller >>" + canonicalName + "<< --> stopped";
    logSimple(sb,
              5);
  }

  //  static String logWrongNumberOfParameters(String hash,
  //                                           String route,
  //                                           int sizeParameterConfig,
  //                                           int sizeParameterRoute) {
  //    StringBuilder sb = new StringBuilder();
  //    sb.append("hash >>")
  //      .append(hash)
  //      .append("<< --> found routing >>")
  //      .append(route)
  //      .append("<< -> too much parameters! Expected >>")
  //      .append(sizeParameterConfig)
  //      .append("<< - found >>")
  //      .append(sizeParameterRoute)
  //      .append("<<");
  //    logSimple(sb.toString(),
  //              3);
  //    return sb.toString();
  //  }

  static String logNoMatchingRoute(String hash) {
    StringBuilder sb = new StringBuilder();
    sb.append("no matching route for hash >>")
      .append(hash)
      .append("<< --> Routing aborted!");
    logSimple(sb.toString(),
              3);
    return sb.toString();
  }

  static void logControllerLookForCompositeController(String controller) {
    String sb = "controller >>" + controller + "<< --> looking for composite";
    logDetailed(sb,
                4);
  }

  static void logControllerNoCompositeControllerFound(String controller) {
    String sb = "controller >>" + controller + "<< --> no composite found";
    logDetailed(sb,
                5);
  }

  static void logControllerCompositeControllerFound(String controller,
                                                    int numberofCompositeControllerFound) {
    String sb = "controller >>" + controller + "<< --> composites found >>" + numberofCompositeControllerFound + "<<";
    logDetailed(sb,
                5);
  }

  static void logCompositeControllerInjectedInController(String controller,
                                                         String compositeController) {
    String sb = "controller >>" + controller + "<< --> compositeController >>" + compositeController + "<< injected";
    logDetailed(sb,
                5);
  }

  static void logControllerOnAttachedCompositeController(String controller,
                                                         String compositeController) {
    String sb = "controller >>" + controller + "<< --> compositeController >>" + compositeController + "<< attached";
    logDetailed(sb,
                5);
  }

  static void logCachedControllerOnAttachedGlobalCompositeController(String controller,
                                                                     String compositeController) {
    String sb = "cached controller >>" + controller + "<< --> attach global cached compositeController >>" + compositeController + "<<";
    logDetailed(sb,
                5);
  }

  static void logCompositeComntrollerActivateMethodCalled(String compositeController) {
    String sb = "Router: create compositeController >>" + compositeController + "<< - calls method activate()";
    logDetailed(sb,
                5);
  }

  static void logCompositeComntrollerStartMethodCalled(String compositeController) {
    String sb = "Router: create compositeController >>" + compositeController + "<< - calls method start()";
    logDetailed(sb,
                5);
  }

  static void logCompositeNotFound(String controller,
                                   String compositeController) {
    String sb = "controller >>" + controller + "<< --> compositeController >>" + compositeController + "<< not found";
    logDetailed(sb,
                5);
  }

  //  static void logFilterStopMethodWillBeCalled(String controller,
  //                                              String compositeController) {
  //    String sb = "controller >>" + controller + "<< --> compositeController >>" + compositeController + "<< stop method will be called";
  //    logDetailed(sb,
  //                5);
  //  }
  //
  //  static void logFilterStopMethodCalled(String controller,
  //                                        String compositeController) {
  //    String sb = "controller >>" + controller + "<< --> compositeController >>" + compositeController + "<< stop called";
  //    logDetailed(sb,
  //                5);
  //  }

  static String logLoopDetected(String hash) {
    StringBuilder sb = new StringBuilder();
    sb.append("loop detected for hash >>")
      .append(hash)
      .append("<< --> Routing aborted!");
    logSimple(sb.toString(),
              0);
    return sb.toString();
  }

}
