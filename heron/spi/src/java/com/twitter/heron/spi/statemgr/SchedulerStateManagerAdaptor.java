// Copyright 2016 Twitter. All rights reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.twitter.heron.spi.statemgr;

import com.google.common.util.concurrent.ListenableFuture;

import com.twitter.heron.api.generated.TopologyAPI;
import com.twitter.heron.proto.scheduler.Scheduler;
import com.twitter.heron.proto.system.ExecutionEnvironment;
import com.twitter.heron.proto.system.PhysicalPlans;
import com.twitter.heron.proto.tmaster.TopologyMaster;

/**
 * This file provides a Adaptor for Scheduler.
 * It provides only the methods needed for Scheduler,
 * and provides easier interfaces to invoke in Scheduler.
 */

public class SchedulerStateManagerAdaptor {
  private final IStateManager delegate;

  /**
   * Construct SchedulerStateManagerAdaptor providing only the
   * interfaces used by scheduler.
   *
   * @param delegate, the IStateManager which is already initialized.
   * Noticed that the initialize and close of IStateManager is not in the
   * SchedulerStateManager. Users are restricted from using those interfaces
   * since it is upto the abstract scheduler to decide when to open and close.
   * @param delegate, the instance of IStateManager
   */
  public SchedulerStateManagerAdaptor(IStateManager delegate) {
    this.delegate = delegate;
  }

  /**
   * Is the given topology in RUNNING state?
   *
   * @return Boolean
   */
  public ListenableFuture<Boolean> isTopologyRunning(String topologyName) {
    return delegate.isTopologyRunning(topologyName);
  }

  /**
   * Set the execution state for the given topology
   *
   * @return Boolean - Success or Failure
   */
  public ListenableFuture<Boolean> setExecutionState(
      ExecutionEnvironment.ExecutionState executionState, String topologyName) {
    return delegate.setExecutionState(executionState, topologyName);
  }

  /**
   * Set the topology definition for the given topology
   *
   * @param topologyName, the name of the topology
   * @return Boolean - Success or Failure
   */
  public ListenableFuture<Boolean> setTopology(
      TopologyAPI.Topology topology, String topologyName) {
    return delegate.setTopology(topology, topologyName);
  }

  /**
   * Set the scheduler location for the given topology
   *
   * @return Boolean - Success or Failure
   */
  public ListenableFuture<Boolean> setSchedulerLocation(
      Scheduler.SchedulerLocation location, String topologyName) {
    return delegate.setSchedulerLocation(location, topologyName);
  }

  /**
   * Delete the tmaster location for the given topology
   *
   * @return Boolean - Success or Failure
   */
  public ListenableFuture<Boolean> deleteTMasterLocation(String topologyName) {
    return delegate.deleteTMasterLocation(topologyName);
  }

  /**
   * Delete the execution state for the given topology
   *
   * @return Boolean - Success or Failure
   */
  public ListenableFuture<Boolean> deleteExecutionState(String topologyName) {
    return delegate.deleteExecutionState(topologyName);
  }

  /**
   * Delete the topology definition for the given topology
   *
   * @return Boolean - Success or Failure
   */
  public ListenableFuture<Boolean> deleteTopology(String topologyName) {
    return delegate.deleteTopology(topologyName);
  }

  /**
   * Delete the physical plan for the given topology
   *
   * @return Boolean - Success or Failure
   */
  public ListenableFuture<Boolean> deletePhysicalPlan(String topologyName) {
    return delegate.deletePhysicalPlan(topologyName);
  }

  /**
   * Delete the scheduler location for the given topology
   *
   * @return Boolean - Success or Failure
   */
  public ListenableFuture<Boolean> deleteSchedulerLocation(
      String topologyName) {
    return delegate.deleteSchedulerLocation(topologyName);
  }

  /**
   * Get the tmaster location for the given topology
   *
   * @param watcher @see com.twitter.heron.spi.statemgr.WatchCallback
   * @return TMasterLocation
   */
  public ListenableFuture<TopologyMaster.TMasterLocation> getTMasterLocation(
      WatchCallback watcher, String topologyName) {
    return delegate.getTMasterLocation(watcher, topologyName);
  }

  /**
   * Get the scheduler location for the given topology
   *
   * @param watcher @see com.twitter.heron.spi.statemgr.WatchCallback
   * @return SchedulerLocation
   */
  public ListenableFuture<Scheduler.SchedulerLocation> getSchedulerLocation(
      WatchCallback watcher, String topologyName) {
    return delegate.getSchedulerLocation(watcher, topologyName);
  }

  /**
   * Get the topology definition for the given topology
   *
   * @param watcher @see com.twitter.heron.spi.statemgr.WatchCallback
   * @return Topology
   */
  public ListenableFuture<TopologyAPI.Topology> getTopology(
      WatchCallback watcher, String topologyName) {
    return delegate.getTopology(null, topologyName);
  }

  /**
   * Get the execution state for the given topology
   *
   * @param watcher @see com.twitter.heron.spi.statemgr.WatchCallback
   * @return ExecutionState
   */
  public ListenableFuture<ExecutionEnvironment.ExecutionState> getExecutionState(
      WatchCallback watcher, String topologyName) {
    return delegate.getExecutionState(null, topologyName);
  }

  /**
   * Get the physical plan for the given topology
   *
   * @param watcher @see com.twitter.heron.spi.statemgr.WatchCallback
   * @return PhysicalPlans.PhysicalPlan
   */
  public ListenableFuture<PhysicalPlans.PhysicalPlan> getPhysicalPlan(
      WatchCallback watcher, String topologyName) {
    return delegate.getPhysicalPlan(null, topologyName);
  }
}
