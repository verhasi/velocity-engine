package org.apache.velocity;

/*
 * The Apache Software License, Version 1.1
 *
 * Copyright (c) 2000 The Apache Software Foundation.  All rights
 * reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *    notice, this list of conditions and the following disclaimer.
 *
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 *
 * 3. The end-user documentation included with the redistribution, if
 *    any, must include the following acknowlegement:
 *       "This product includes software developed by the
 *        Apache Software Foundation (http://www.apache.org/)."
 *    Alternately, this acknowlegement may appear in the software itself,
 *    if and wherever such third-party acknowlegements normally appear.
 *
 * 4. The names "The Jakarta Project", "Velocity", and "Apache Software
 *    Foundation" must not be used to endorse or promote products derived
 *    from this software without prior written permission. For written
 *    permission, please contact apache@apache.org.
 *
 * 5. Products derived from this software may not be called "Apache"
 *    nor may "Apache" appear in their names without prior written
 *    permission of the Apache Group.
 *
 * THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED
 * WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED.  IN NO EVENT SHALL THE APACHE SOFTWARE FOUNDATION OR
 * ITS CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 * ====================================================================
 *
 * This software consists of voluntary contributions made by many
 * individuals on behalf of the Apache Software Foundation.  For more
 * information on the Apache Software Foundation, please see
 * <http://www.apache.org/>.
 */

import java.util.Hashtable;

/**
 * This class is used as the storage place for all dynamic
 * information that is used to create a document. A final
 * document is created by processing a template against
 * the contents of the context. The context may include
 * an valid object derived from Object. These objects
 * are stored in a Hashtable. The context also stores
 * parameters. These are meant to be points of instruction
 * for back end programmers. If a particular parameters
 * has a value of "a" do "b", if "x" do "y" type behaviour.
 *
 * @author <a href="mailto:jvanzyl@periapt.com">Jason van Zyl</a>
 * @version $Id: Context.java,v 1.1 2000/09/30 17:04:21 jvanzyl Exp $
 */
public class Context
{
    /**
     * Random access storage for context data.
     */
    protected Hashtable context;

    /**
     * TODO
     */
    protected Hashtable params;

    /**
     * Constructs the context under which to execute the templating engine.
     */
    public Context()
    {
        context = new Hashtable();
        params = new Hashtable();
    }        

    /**
     * Adds a name/value pair to the context.
     *
     * @param key   The name to key the provided value with.
     * @param value The corresponding value.
     */
    public void put(String key, Object value)
    {
        context.put(key, value);
    }

    /**
     * Gets the value corresponding to the provided key from the context.
     *
     * @param key The name of the desired value.
     * @return    The value corresponding to the provided key.
     */
    public Object get(String key)
    {
        return context.get(key);
    }        

    /**
     * Indicates whether the specified key is in the context.
     *
     * @param key The key to look for.
     * @return    Whether the key is in the context.
     */
    public boolean containsKey(Object key)
    {
        return context.containsKey(key);
    }        

    /**
     * Removes the specified key from the context.
     *
     * @param key The key to remove.
     * @return    TODO
     */
    public Object remove(Object key)
    {
        return context.remove(key);
    }        

    /**
     * TODO
     *
     * @param key   TODO
     * @param value TODO
     * @return      TODO
     */
    public void putParam(String key, String value)
    {
        params.put(key, value);
    }        

    /**
     * Returns the context parameters.
     *
     * @return The context parameters.
     */
    public Hashtable getParams()
    {
        return params;
    }        
}
