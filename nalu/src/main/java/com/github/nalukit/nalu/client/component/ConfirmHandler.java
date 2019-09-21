package com.github.nalukit.nalu.client.component;

import com.github.nalukit.nalu.client.plugin.IsNaluProcessorPlugin;

/**
 * This interface is used in case a routing occurs and the current visible
 * controllers get asked, if the routing can continue or not.
 * <p>
 * Call
 * <ul>
 *   <li>the <code>abortLoading()</code> in case you want to abort routing.</li>
 *   <li>the <code>continueLoading()</code> in case you want to continue routing.</li>
 * </ul>
 */
public abstract class ConfirmHandler {

  private IsNaluProcessorPlugin plugin;
  private String                lastExecutedHash;

  public ConfirmHandler(IsNaluProcessorPlugin plugin,
                        String lastExecutedHash) {
    this.plugin = plugin;
    this.lastExecutedHash = lastExecutedHash;
  }

  /**
   * call this method in case you want to
   * abort routing.
   */
  public abstract void abortRouting();

  /**
   * call this method in case you want to
   * continue routing.
   */
  public abstract void continueRouting();

}
