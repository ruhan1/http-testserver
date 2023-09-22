/**
 * Copyright (C) 2011-2022 Red Hat, Inc. (https://github.com/Commonjava/http-testserver)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.commonjava.test.http.junit4.stream;

import org.commonjava.test.http.stream.StreamResolver;
import org.commonjava.test.http.stream.StreamServer;
import org.junit.rules.ExternalResource;

public class StreamServerRule
        extends ExternalResource
{

    private final StreamServer server;

    public StreamServerRule( final StreamResolver resolver )
    {
        server = new StreamServer( resolver );
    }

    public StreamServerRule( final String resourceBase )
    {
        server = new StreamServer( resourceBase );
    }

    public StreamServer getServer()
    {
        return server;
    }

    @Override
    public void after()
    {
        server.stop();
    }

    @Override
    public void before()
            throws Exception
    {
        server.start();
    }

}
