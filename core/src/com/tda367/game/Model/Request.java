package Model;

public class Request {
    private int m_value;
    private Enum m_description;

    /**
     * Constructor for Request
     * @param description HandlerItemDefiners
     * @param value value that we want to handle
     */
    public Request(Enum description, int value)
    {
        m_description = description;
        m_value = value;
    }

    /**
     * Getter for the value
     * @return value we want to handle
     */
    public int getValue()
    {
        return m_value;
    }

    /**
     * Getter for the description
     * @return the description of the handler
     */
    public Enum getDescription()
    {
        return m_description;
    }
}
