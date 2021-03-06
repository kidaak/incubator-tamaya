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
package org.apache.tamaya.server;

import org.apache.tamaya.spi.ServiceContextManager;

/**
 * Simple Server singleton for starting the built-in simple configuration server.
 */
public final class ConfigServer {
    /**
     * Utility class constructor.
     */
    private ConfigServer(){}

    /**
     * Creates a new server instance.
     * @return a new server instance.
     */
    public static Server createServer(){
        return ServiceContextManager.getServiceContext().getService(Server.class);
    }

    /**
     * Main method to start the simple config server as a main method.
     * @param args the args provided.
     */
    public static void main(String... args){
        String portVal = System.getProperty("port");
        int port = portVal==null?8888:Integer.parseInt(portVal);
        createServer().start(port);
    }

}
