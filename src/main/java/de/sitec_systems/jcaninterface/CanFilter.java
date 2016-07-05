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

import de.sitec_systems.jcaninterface.CanFrame.Type;

/**
 * An value object for CAN filter settings.
 * @author sitec systems GmbH
 * @since 1.0
 */
public class CanFilter
{
    private final int id;
    private final int mask;
    private final Type type;

    /**
     * Constructor.
     * @param id The ID for filtering
     * @param mask The mask for the ID for filtering
     * @param type The type of the CAN frames to filter
     * @since 1.0
     */
    public CanFilter(final int id, final int mask, final Type type)
    {
        this.id = id;
        this.mask = mask;
        this.type = type;
    }

    /**
     * Gets the ID for filtering. 
     * @return The ID for filtering
     * @since 1.0
     */
    public int getId()
    {
        return id;
    }

    /**
     * Gets the mask for the ID for filtering.
     * @return The mask for the ID for filtering
     * @since 1.0
     */
    public int getMask()
    {
        return mask;
    }

    /**
     * Gets the type of the CAN frames to filter
     * @return The type of the CAN frames to filter
     * @since 1.0
     */
    public Type getType()
    {
        return type;
    }
}
