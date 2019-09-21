package com.github.nalukit.nalu.client.internal.route;

public class RoutingConfirmationHandler {

  /* we expect a successful roting */
  private boolean confirmed;
  /* number of controllers (ComponentController & CompisteController) */
  private int numberOfConfirmations;

  public RoutingConfirmationHandler(int numberOfConfirmations) {
    this.confirmed = true;
    this.numberOfConfirmations = numberOfConfirmations;
  }

  public void avoidConfirmation() {
    this.confirmed = false;
  }

  public int getNumberOfConfirmations() {
    return numberOfConfirmations;
  }

  public boolean isConfirmed() {
    return confirmed;
  }

  public void updateNumberOfConfirmations() {
    numberOfConfirmations--;
  }

}
