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

import de.sitec.jcaninterface.CanFrame.Type;

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
