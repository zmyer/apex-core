/**
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.datatorrent.bufferserver.packet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * <p>Abstract RequestTuple class.</p>
 *
 * @since 0.3.2
 */
public abstract class RequestTuple extends Tuple
{
  private static final Logger logger = LoggerFactory.getLogger(RequestTuple.class);

  protected boolean valid;
  protected boolean parsed;

  protected RequestTuple(byte[] buffer, int offset, int length)
  {
    super(buffer, offset, length);
    parse();
    if (!isValid()) {
      logger.error("Invalid Request Tuple of type {} received!", getType());
    }
  }

  public boolean isValid()
  {
    return valid;
  }

  protected abstract void parse();

  public abstract String getVersion();

  public abstract String getIdentifier();

}
