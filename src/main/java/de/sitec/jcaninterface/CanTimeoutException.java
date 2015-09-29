/*
 * Project: 15_0013_CF4J
 * $Header: $
 * Author:  Mattes Standfuss
 * Last Change:
 *    by:   $Author: $
 *    date: $Date:   $
 * Copyright (c): sitec systems GmbH, 2015
 */
package de.sitec.jcaninterface;

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
