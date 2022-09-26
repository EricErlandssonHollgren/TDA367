package Model;

public class Request {
    private int m_value;
    private Enum m_description;

    // sets the request
    public Request(Enum description, int value)
    {
        m_description = description;
        m_value = value;
    }

    // Returns the given value
    public int getValue()
    {
        return m_value;
    }

    // Returns the description of the request
    public Enum getDescription()
    {
        return m_description;
    }
}
