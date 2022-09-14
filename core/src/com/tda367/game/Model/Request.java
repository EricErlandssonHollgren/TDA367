package com.tda367.game.Model;

public class Request {
    private int m_value;
    private Enum m_description;

    public Request(Enum description, int value)
    {
        m_description = description;
        m_value = value;
    }

    public int getValue()
    {
        return m_value;
    }

    public Enum getDescription()
    {
        return m_description;
    }
}
