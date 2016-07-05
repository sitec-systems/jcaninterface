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
     * @throws CanTimeoutException No frame received from CAN before timeout occured
     * @throws IOException If the receiving has failed
     * @since 1.0
     */
    CanFrame receive() throws CanTimeoutException, IOException;
    
    /**
     * Adds filters for receiving CAN frames.
     * @param filters The filters
     * @throws IOException If setting of filters has failed
     * @since 1.0
     */
    void addFilters (final CanFilter... filters) throws IOException;
    
    /**
     * Removes all added filters from CAN receiving.
     * @throws IOException If setting of filters has failed
     * @see #addFilters(de.sitec_systems.jcaninterface.CanFilter...)  
     * @since 1.0
     */
    void removeFilters () throws IOException;
    
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
