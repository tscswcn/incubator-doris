// Licensed to the Apache Software Foundation (ASF) under one
// or more contributor license agreements.  See the NOTICE file
// distributed with this work for additional information
// regarding copyright ownership.  The ASF licenses this file
// to you under the Apache License, Version 2.0 (the
// "License"); you may not use this file except in compliance
// with the License.  You may obtain a copy of the License at
//
//   http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing,
// software distributed under the License is distributed on an
// "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
// KIND, either express or implied.  See the License for the
// specific language governing permissions and limitations
// under the License.

package org.apache.doris.load.routineload;

import com.google.common.collect.Lists;
import org.apache.doris.thrift.TResourceInfo;
import org.apache.doris.thrift.TTaskType;

import java.util.List;

public class KafkaRoutineLoadTask extends RoutineLoadTask {

    private List<Integer> kafkaPartitions;

    public KafkaRoutineLoadTask(TResourceInfo resourceInfo, long backendId, TTaskType taskType,
                                long dbId, long tableId, long partitionId, long indexId, long tabletId, long signature) {
        super(resourceInfo, backendId, taskType, dbId, tableId, partitionId, indexId, tabletId, signature);
        this.kafkaPartitions = Lists.newArrayList();
    }

    public void addKafkaPartition(int partition) {
        kafkaPartitions.add(partition);
    }

    public List<Integer> getKafkaPartitions() {
        return kafkaPartitions;
    }
}
