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
     * An enumeration that contains the types of CAN frames.
     * @author  sitec systems GmbH
     * @since 1.0
     */
    public static enum Type
    {
        STANDARD, REMOTE_TRANSMISSION_REQUEST, EXTENDED;
    }
}
