/**
 * Copyright (C) 2011 Twitter, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this
 * file except in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed
 * under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.cloudhopper.jetty.demo;

import com.cloudhopper.jetty.HttpConnectorConfiguration;
import com.cloudhopper.jetty.HttpServerConfiguration;
import com.cloudhopper.jetty.JettyHttpServer;
import com.cloudhopper.jetty.JettyHttpServerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author joelauer
 */
public class HttpServerMain {
    static private final Logger logger = LoggerFactory.getLogger(HttpServerMain.class);
    
    static public void main(String args[]) throws Exception {
        
        HttpServerConfiguration config = new HttpServerConfiguration();
        HttpConnectorConfiguration connConfig = new HttpConnectorConfiguration();
        connConfig.setPort(9080);
        config.addConnector(connConfig);
        
        JettyHttpServer server = JettyHttpServerFactory.create(config);
        
        logger.info("adding demo Hello servlet");
        HelloServlet helloServlet = new HelloServlet();
        server.addServlet(helloServlet, "/hello");
        
        logger.info("starting server...");
        server.start();
        server.join();
    }
    
}
