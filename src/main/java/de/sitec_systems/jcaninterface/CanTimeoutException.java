/**
 * jCanInterface is an interface for the communication in Controller Area 
 * Network (CAN) from Java.
 * 
 * Copyright (C) 2015 sitec systems GmbH <http://www.sitec-systems.de>
 * 
 * This file is part of jCanInterface.
 * 
 * jCanInterface is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by the 
 * Free Software Foundation, either version 3 of the License, or (at your option) 
 * any later version.
 * 
 * jCanInterface is distributed in the hope that it will be useful, but WITHOUT 
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS 
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more 
 * details.
 * 
 * You should have received a copy of the GNU Lesser General Public License
 * along with jCanInterface. If not, see <http://www.gnu.org/licenses/>.
 */
/*
 * Author: Mattes Standfuss
 * Copyright (c): sitec systems GmbH, 2015
 */
package de.sitec_systems.jcaninterface;

import java.io.IOException;

/**
 * Indicates an timeout is occured at receiving from CAN.
 * @author sitec systems GmbH
 * @since 1.0
 */
public class CanTimeoutException extends IOException
{
    /**
     * Constructs an <code>CanTimeoutException</code> with no
     * detail message.
     * @since 1.0
     */
    public CanTimeoutException(){};

    /**
     * Constructs an <code>CanTimeoutException</code> with the
     * specified detail message.
     * @param s the detail message.
     * @since 1.0
     */
    public CanTimeoutException(final String s)
    {
        super(s);
    }
}
