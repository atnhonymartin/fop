/*-- $Id$ -- 

 ============================================================================
                   The Apache Software License, Version 1.1
 ============================================================================
 
    Copyright (C) 1999 The Apache Software Foundation. All rights reserved.
 
 Redistribution and use in source and binary forms, with or without modifica-
 tion, are permitted provided that the following conditions are met:
 
 1. Redistributions of  source code must  retain the above copyright  notice,
    this list of conditions and the following disclaimer.
 
 2. Redistributions in binary form must reproduce the above copyright notice,
    this list of conditions and the following disclaimer in the documentation
    and/or other materials provided with the distribution.
 
 3. The end-user documentation included with the redistribution, if any, must
    include  the following  acknowledgment:  "This product includes  software
    developed  by the  Apache Software Foundation  (http://www.apache.org/)."
    Alternately, this  acknowledgment may  appear in the software itself,  if
    and wherever such third-party acknowledgments normally appear.
 
 4. The names "FOP" and  "Apache Software Foundation"  must not be used to
    endorse  or promote  products derived  from this  software without  prior
    written permission. For written permission, please contact
    apache@apache.org.
 
 5. Products  derived from this software may not  be called "Apache", nor may
    "Apache" appear  in their name,  without prior written permission  of the
    Apache Software Foundation.
 
 THIS SOFTWARE IS PROVIDED ``AS IS'' AND ANY EXPRESSED OR IMPLIED WARRANTIES,
 INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND
 FITNESS  FOR A PARTICULAR  PURPOSE ARE  DISCLAIMED.  IN NO  EVENT SHALL  THE
 APACHE SOFTWARE  FOUNDATION  OR ITS CONTRIBUTORS  BE LIABLE FOR  ANY DIRECT,
 INDIRECT, INCIDENTAL, SPECIAL,  EXEMPLARY, OR CONSEQUENTIAL  DAMAGES (INCLU-
 DING, BUT NOT LIMITED TO, PROCUREMENT  OF SUBSTITUTE GOODS OR SERVICES; LOSS
 OF USE, DATA, OR  PROFITS; OR BUSINESS  INTERRUPTION)  HOWEVER CAUSED AND ON
 ANY  THEORY OF LIABILITY,  WHETHER  IN CONTRACT,  STRICT LIABILITY,  OR TORT
 (INCLUDING  NEGLIGENCE OR  OTHERWISE) ARISING IN  ANY WAY OUT OF THE  USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 
 This software  consists of voluntary contributions made  by many individuals
 on  behalf of the Apache Software  Foundation and was  originally created by
 James Tauber <jtauber@jtauber.com>. For more  information on the Apache 
 Software Foundation, please see <http://www.apache.org/>.
 
 */

package org.apache.fop.datatypes;

import org.apache.fop.pdf.PDFGoTo;


public class IDNode
{
    private String 
        idValue,
        internalLinkGoToPageReference;

    private PDFGoTo
        internalLinkGoTo;

    private int 
        yPosition=0;  // position on page

    
    /**
     * Constructor for IDNode
     * 
     * @param idValue The value of the id for this node
     */
    protected IDNode(String idValue)
    {
        this.idValue = idValue;        
    }


    /**
     * creates a new GoTo object for an internal link
     * 
     * @param objectNumber
     *               the number to be assigned to the new object
     */
    protected void createInternalLinkGoTo(int objectNumber)
    {
        if(internalLinkGoToPageReference==null)
        {
            internalLinkGoTo = new PDFGoTo(objectNumber,null);
        }
        else
        {        
            internalLinkGoTo = new PDFGoTo(objectNumber,internalLinkGoToPageReference);
        }

        if(yPosition!=0)
        {
            internalLinkGoTo.setYPosition(yPosition);
        }
        
    }        



    /**
     * sets the page reference for the internal link's GoTo.  The GoTo will jump to this page reference.
     * 
     * @param pageReference
     *               the page reference to which the internal link GoTo should jump
     *               ex. 23 0 R
     */
    protected void setInternalLinkGoToPageReference(String pageReference)
    {        
        if(internalLinkGoTo !=null)
        {
            internalLinkGoTo.setPageReference(pageReference);                 
        }
        else
        {
            internalLinkGoToPageReference = pageReference;
        }

    }



    /**
     * Returns the reference to the Internal Link's GoTo object
     * 
     * @return GoTo object reference
     */
    protected String getInternalLinkGoToReference()
    {
        return internalLinkGoTo.referencePDF();
    }



    /**
     * Returns the id value of this node
     * 
     * @return this node's id value
     */
    protected String getIDValue()
    {
        return idValue;
    }



    /**
     * Returns the PDFGoTo object associated with the internal link
     * 
     * @return PDFGoTo object
     */
    protected PDFGoTo getInternalLinkGoTo()
    {
        return internalLinkGoTo;
    }


     /**
      * Determines whether there is an internal link GoTo for this node
      * 
      * @return true if internal link GoTo for this node is set, false otherwise
      */
     protected boolean isThereInternalLinkGoTo()
     {
         return internalLinkGoTo!=null;
     }


     /**
      * Sets the x position of this node
      * 
      * @param x      the x position
      */
     protected void setYPosition(int y)
     {
         if(internalLinkGoTo !=null)
        {            
            internalLinkGoTo.setYPosition(y);
        }
        else
        {
            yPosition=y;
        }         
     }
    
}
