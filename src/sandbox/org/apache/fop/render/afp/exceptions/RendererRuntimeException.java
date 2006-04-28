/*
 * Copyright 2006 The Apache Software Foundation.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/* $Id$ */

package org.apache.fop.render.afp.exceptions;

/**
 * A runtime exception for handling fatal errors in rendering.
 * <p/>
 */
public class RendererRuntimeException extends NestedRuntimeException {
    
    /**
     * Constructs a RendererRuntimeException with the specified message.
     * @param msg the exception mesaage
     */
    public RendererRuntimeException(String msg) {
        super(msg);
    }
    
    /**
     * Constructs a RendererRuntimeException with the specified message
     * wrapping the underlying exception.
     * @param msg the exception mesaage
     * @param t the underlying exception
     */
    public RendererRuntimeException(String msg, Throwable t) {
        super(msg, t);
    }
    
}
