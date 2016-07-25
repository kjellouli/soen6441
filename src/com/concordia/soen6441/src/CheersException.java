package com.concordia.soen6441.src;

public class CheersException extends Exception
{
	private static final long serialVersionUID = -3594829237542405847L;

	public CheersException()
    {
    }

    public CheersException(String message)
    {
        super(message);
    }

    public CheersException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public CheersException(Throwable cause)
    {
        super(cause);
    }

    public CheersException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
    {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
