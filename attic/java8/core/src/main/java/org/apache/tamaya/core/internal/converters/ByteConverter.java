/*
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
package org.apache.tamaya.core.internal.converters;

import org.apache.tamaya.spi.PropertyConverter;

import java.util.Locale;
import java.util.Objects;
import java.util.logging.Logger;

/**
 * Converter, converting from String to Byte, the supported format is one of the following:
 * <ul>
 * <li>0xFF</li>
 * <li>0XFF</li>
 * <li>45</li>
 * <li>-34</li>
 * <li>0D1</li>
 * </ul>
 */
public class ByteConverter implements PropertyConverter<Byte> {

    private Logger LOG = Logger.getLogger(getClass().getName());

    @Override
    public Byte convert(String value) {
        String trimmed = Objects.requireNonNull(value).trim();
        switch (trimmed.toUpperCase(Locale.ENGLISH)) {
            case "MIN_VALUE":
            case "MIN":
                return Byte.MIN_VALUE;
            case "MAX_VALUE":
            case "MAX":
                return Byte.MAX_VALUE;
            default:
                try {
                    return Byte.decode(trimmed);
                } catch (Exception e) {
                    LOG.finest("Failed to parse Byte value: " + value);
                    return null;
                }
        }
    }
}
