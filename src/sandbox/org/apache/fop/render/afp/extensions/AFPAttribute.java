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

package org.apache.fop.render.afp.extensions;

import org.apache.fop.apps.FOPException;
import org.apache.fop.fo.PropertyList;
import org.apache.fop.fo.properties.Property;
import org.apache.fop.fo.properties.StringProperty;

/**
 * This class extends the org.apache.fop.fo.StringProperty.Maker inner class
 * in order to provide a static property maker. The object faciliates
 * extraction of attributes from formatted objects based on the static list
 * as defined in the AFPElementMapping implementation.
 * <p/>
 */
public class AFPAttribute extends StringProperty.Maker {

    /**
     * The attribute property.
     */
    private Property _property;

    /**
     * Constructor for the AFPAttribute.
     * @param name The attribute name
     */
    protected AFPAttribute(String name) {
        super(0);
        _property = null;
    }

    /**
     * Overide the make method to return the property object
     * @param propertyList the property list from which to make the property
     * @return property The property object.
     */
    public Property make(PropertyList propertyList) {
        if (_property == null) {
            _property = make(propertyList, "", propertyList.getParentFObj());
        }
        return _property;
    }

}