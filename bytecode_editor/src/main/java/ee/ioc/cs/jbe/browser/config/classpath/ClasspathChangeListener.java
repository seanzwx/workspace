/*
    This library is free software; you can redistribute it and/or
    modify it under the terms of the GNU General Public
    License as published by the Free Software Foundation; either
    version 2 of the license, or (at your option) any later version.
*/

package ee.ioc.cs.jbe.browser.config.classpath;

import java.util.EventListener;

/**
    Listener that is informed of changes in the classpath.

    @author <a href="mailto:jclasslib@ej-technologies.com">Ingo Kegel</a>
    @version $Revision: 1.2 $ $Date: 2006/09/25 16:00:58 $
*/
public interface ClasspathChangeListener extends EventListener {

    /**
     * Method that will be called when the classpath has changed.
     * @param event the change event with detailed information.
     */
    public void classpathChanged(ClasspathChangeEvent event);
}
