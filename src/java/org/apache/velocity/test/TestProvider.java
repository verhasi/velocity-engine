package org.apache.velocity.test;

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

import java.util.*;

/**
 * This class is used by the testbed. Instances of the class
 * are fed into the context that is set before the AST
 * is traversed and dynamic content generated.
 *
 * @author <a href="mailto:jvanzyl@periapt.com">Jason van Zyl</a>
 * @version $Id: TestProvider.java,v 1.1 2000/09/30 17:04:21 jvanzyl Exp $
 */
public class TestProvider
{
    String title = "lunatic";
    boolean state;
    
    public String getName()
    {
        return "jason";
    }
    
    public Hashtable getSearch()
    {
        Hashtable h = new Hashtable();
        h.put("Text", "this is some text");
        h.put("EscText", "this is escaped text");
        h.put("Title", "this is the title");
        h.put("Index", "this is the index");
        h.put("URL", "http://periapt.com");

        ArrayList al = new ArrayList();
        al.add(h);
        
        h.put("RelatedLinks", al);

        return h;
    }        

    public ArrayList getRelSearches()
    {
        ArrayList al = new ArrayList();
        al.add(getSearch());
        
        return al;
    }        

    public TestProvider2 getTestProvider2()
    {
        return new TestProvider2();
    }        

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public ArrayList getCustomers()
    {
        ArrayList list = new ArrayList();

        list.add("ArrayList element 1");
        list.add("ArrayList element 2");
        list.add("ArrayList element 3");
        list.add("ArrayList element 4");

        return list;
    }

    public ArrayList getCustomers2()
    {
        ArrayList list = new ArrayList();

        list.add(new TestProvider());
        list.add(new TestProvider());
        list.add(new TestProvider());
        list.add(new TestProvider());

        return list;
    }

    public Vector getVector()
    {
        Vector list = new Vector();

        list.addElement("vector element 1");
        list.addElement("vector element 2");
        
        return list;
    }

    public Object getArray()
    {
        String[] strings = new String[2];
        strings[0] = "first element";
        strings[1] = "second element";
        return strings;
    }

    public boolean theAPLRules()
    {
        return true;
    }

    public boolean getStateTrue()
    {
        return true;
    }
    
    public boolean getStateFalse()
    {
        return false;
    }        

    public String objectArrayMethod(Object[] o)
    {
        return "result of objectArrayMethod";
    }

    public String concat(Object[] o)
    {
        String result = "";
        
        for (int i = 0; i < o.length; i++)
            result += (String) o[i] + " ";
        
        return result;
    }

    /*
     * This can't have the signature
    
    public void setState(boolean state)
    
    or dynamically invoking the method
    doesn't work ... you would have to
    put a wrapper around a method for a
    real boolean property that takes a 
    Boolean object if you wanted this to
    work. Not really sure how useful it
    is anyway. Who cares about boolean
    values you can just set a variable.
    
    */

    public void setState(Boolean state)
    {
    }        
}
