/**
 * jCanInterface is an interface for the communication in Controller Area 
 * Network (CAN) from Java.
 * 
 * Copyright (C) 2015 sitec systems GmbH <http://www.sitec-systems.de>
 * 
 * This file is part of jCanInterface.
 * 
 * jModuleConnect is free software: you can redistribute it and/or modify it 
 * under the terms of the GNU Lesser General Public License as published by the 
 * Free Software Foundation, either version 3 of the License, or (at your option) 
 * any later version.
 * 
 * jModuleConnect is distributed in the hope that it will be useful, but WITHOUT 
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
package de.sitec.jcaninterface;

import java.util.Arrays;
import java.util.Objects;

/**
 * An value object for CAN frame.
 * @author sitec systems GmbH
 * @since 1.0
 */
public class CanFrame
{
    private final int id;
    private final Type type;
    private final byte length;
    private final byte[] data;
    
    private static final short STANDARD_FRAME_MAX_VALUE = 0x7FF;

    /**
     * Constructor.
     * @param id The ID of the CAN frame. Must pass to parameter type
     * @param type The type of the CAN frame
     * @param length The length of the CAN frame
     * @param data The data of the CAN frame
     * @throws IllegalArgumentException If the ID don't pass to the type
     * @since 1.0
     */
    public CanFrame(final int id, final Type type, final byte length
            , final byte[] data)
    {
        if (id > STANDARD_FRAME_MAX_VALUE && type == Type.STANDARD)
        {
            throw new IllegalArgumentException("The ID: '" + id 
                    + "' is no standard ID");
        }
        
        this.id = id;
        this.type = type;
        this.length = length;
        this.data = data;
    }

    /**
     * Gets the ID of the CAN frame.
     * @return The ID of the CAN frame
     * @since 1.0
     */
    public int getId()
    {
        return id;
    }

    /**
     * Gets the type of the CAN frame.
     * @return The type of the CAN frame
     * @since 1.0
     */
    public Type getType()
    {
        return type;
    }

    /**
     * Gets the length of the CAN frame.
     * @return The length of the CAN frame
     * @since 1.0
     */
    public byte getLength()
    {
        return length;
    }

    /**
     * Gets the data of the CAN frame.
     * @return The data of the CAN frame
     * @since 1.0
     */
    public byte[] getData()
    {
        return data;
    }

    /**
     * Gets the CAN frame as <code>String</code>.
     * @return The CAN frame as <code>String</code>
     * @since 1.0
     */
    @Override
    public String toString()
    {
        return "CanFrame{" + "id=0x" + String.format("%08x", id) + ", type=" 
                + type + ", length=" + length + ", data=" + toHexString(data) + '}';
    }
    
    /**
     * Returns a <code>String</code> with unsigned hex representation of the input
     * <code>byte[]</code>.
     * @param array The <code>byte[]</code>
     * @return The <code>byte[]</code> as unsigned hex <code>String</code>
     * @since 1.0
     */
    private static String toHexString(final byte[] values)
    {
        final StringBuilder sb = new StringBuilder();
        
        for(final byte value: values)
        {
            sb.append(String.format("%02x", value));
        }
        
        return sb.toString();
    }

    /**
     * Generates the hash code of a specific CAN frame.
     * 
     * @return Hash code of a CAN frame
     * @since 1.0
     */
    @Override
    public int hashCode()
    {
        int hash = 7;
        hash = 13 * hash + this.id;
        hash = 13 * hash + Objects.hashCode(this.type);
        hash = 13 * hash + this.length;
        hash = 13 * hash + Arrays.hashCode(this.data);
        return hash;
    }

    /**
     * Compares two CAN frames with each other.
     * 
     * If both CAN frames does have the same content (same id, same payload, 
     * same type) then the function returns {@code true}
     * 
     * @return {@code true} if the two CAN frames are exactly equal.
     * @since 1.0
     */
    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
        {
            return false;
        }
        if (getClass() != obj.getClass())
        {
            return false;
        }
        final CanFrame other = (CanFrame) obj;
        if (this.id != other.id)
        {
            return false;
        }
        if (this.type != other.type)
        {
            return false;
        }
        if (this.length != other.length)
        {
            return false;
        }
        if (!Arrays.equals(this.data, other.data))
        {
            return false;
        }
        return true;
    }
    
    /**
     * An enumeration that contains the types of CAN frames.
     * @author  sitec systems GmbH
     * @since 1.0
     */
    public static enum Type
    {
        STANDARD, REMOTE_TRANSMISSION_REQUEST, EXTENDED;
    }
}
