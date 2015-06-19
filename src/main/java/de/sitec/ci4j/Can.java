/*
 * Project: 15_0013_CF4J
 * $Header: $
 * Author:  Mattes Standfuss
 * Last Change:
 *    by:   $Author: $
 *    date: $Date:   $
 * Copyright (c): sitec systems GmbH, 2015
 */
package de.sitec.ci4j;

import java.io.Closeable;
import java.io.IOException;

/**
 * An interface for the raw communication in CAN.
 * @author sitec systems GmbH
 * @since 1.0
 */
public interface Can extends Closeable
{
    /**
     * Sends an CAN Frame.
     * @param canFrame The frame to send
     * @throws IOException If the sending has failed
     * @since 1.0
     */
    void send(final CanFrame canFrame) throws IOException;
    
    /**
     * Receives an CAN Frame.
     * @return Received frame
     * @throws IOException If the receiving has failed
     * @since 1.0
     */
    CanFrame receive() throws IOException;
    
    /**
     * Sets the filters for receiving CAN frames.
     * @param filter The filter
     * @throws IOException If setting of filter has failed
     * @since 1.0
     */
    void setFilter (final CanFilter filter) throws IOException;
    
    /**
     * Sets the timeout for the receiving ({@link #receive() }). With value 
     * <code>0</code> disables the timeout.
     * @param timeout The timeout in milliseconds
     * @throws IOException Setting of timeout has failed
     * @since 1.0
     */
    void setTimeout (final int timeout) throws IOException;
    
    /**
     * Gets the timeout for the receiving ({@link #receive() }). The value 
     * <code>0</code> means the timeout is disabled.
     * @return The timeout in milliseconds
     * @throws IOException Setting of timeout has failed
     * @since 1.0
     */
    int getTimeout () throws IOException;
}
