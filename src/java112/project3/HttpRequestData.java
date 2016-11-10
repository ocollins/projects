package java112.project3;

/**
 *  This is a JavaBean class for Project 3.
 *  @author  O Collins
 */
public class HttpRequestData extends java.lang.Object {

    private String remoteComputerName;
    private String remoteComputerAddress;
    private String httpMethod;
    private String requestURI;
	private String requestURL;
	private String protocol;
    private String serverName;
    private String serverPort;
    private String currLocale;
	private String queryString;
	private String queryParam;
	private String userAgent;

    /**
     *  Constructor for the HttpRequestData class
     */
    public HttpRequestData() {

    }

    /**
     *  Sets the remote computer attribute
     *  @param  remoteComputer name of remote computer
     */
    public void  setRemoteComputerName(String remoteComputerName) {

		this.remoteComputerName = remoteComputerName;
    }

    /**
     *  Gets the remote computer name attribute
     *@return remoteCompute value
     */
    public String getRemoteComputerName() {

		return remoteComputerName;
    }

    /**
     *  Sets the remote computer address attribute
     *  @param  remoteComputerAddress address of remote computer
     */
    public void setRemoteComputerAddress(String remoteComputerAddress) {
        this.remoteComputerAddress = remoteComputerAddress;
    }

    /**
     *  Gets the remote computer address attribute
     *  @return remoteComputerAddress value
     */
    public String getRemoteComputerAddress() {

		return remoteComputerAddress;
    }

    /**
     *  Sets the HTTP method attribute
     *  @param  httpMethod HTTP method
     */
    public void setHttpMethod(String httpMethod) {

		this.httpMethod = httpMethod;
    }

    /**
     *  Gets the HTTP method attribute
     *@return httpMethod value
     */
    public String getHttpMethod() {

		return httpMethod;
    }

    /**
	 * Returns the value of requestURI.
	 */
	public String getRequestURI() {

		return requestURI;
	}

	/**
	 * Sets the value of requestURI.
	 * @param requestURI The value to assign requestURI.
	 */
	public void setRequestURI(String requestURI) {

		this.requestURI = requestURI;
	}

    /**
	 * Returns the value of requestURL.
	 */
	public String getRequestURL() {

		return requestURL;
	}

	/**
	 * Sets the value of requestURL.
	 * @param requestURL The value to assign requestURL.
	 */
	public void setRequestURL(String requestURL) {

		this.requestURL = requestURL;
	}
    
    /**
	 * Returns the value of protocol.
	 */
	public String getProtocol() {

		return protocol;
	}


	/**
	 * Sets the value of protocol.
	 * @param protocol The value to assign protocol.
	 */
	public void setProtocol(String protocol) {

		this.protocol = protocol;
	}

    /**
	 * Returns the value of serverName.
	 */
	public String getServerName() {

		return serverName;
	}

	/**
	 * Sets the value of serverName.
	 * @param serverName The value to assign serverName.
	 */
	public void setServerName(String serverName) {

		this.serverName = serverName;
	}

    /**
	 * Returns the value of serverPort.
	 */
	public String getServerPort() {

		return serverPort;
	}

	/**
	 * Sets the value of serverPort.
	 * @param serverPort The value to assign serverPort.
	 */
	public void setServerPort(String serverPort) {

		this.serverPort = serverPort;
	}

    /**
	 * Returns the value of currLocale.
	 */
	public String getCurrLocale() {

		return currLocale;
	}

	/**
	 * Sets the value of currLocale.
	 * @param currLocale The value to assign currLocale.
	 */
	public void setCurrLocale(String currLocale) {

		this.currLocale = currLocale;
	}

	/**
	 * Returns the value of queryString.
	 */
	public String getQueryString() {

		return queryString;
	}


	/**
	 * Sets the value of queryString.
	 * @param queryString The value to assign queryString.
	 */
	public void setQueryString(String queryString) {

		this.queryString = queryString;
	}

	/**
	 * Returns the value of queryParam.
	 */
	public String getQueryParam() {

		return queryParam;
	}


	/**
	 * Sets the value of queryParam.
	 * @param queryParam The value to assign queryParam.
	 */
	public void setQueryParam(String queryParam) {

		this.queryParam = queryParam;
	}

	/**
	 * Returns the value of userAgent.
	 */
	public String getUserAgent() {

		return userAgent;
	}

	/**
	 * Sets the value of userAgent.
	 * @param userAgent The value to assign userAgent.
	 */
	public void setUserAgent(String userAgent) {

		this.userAgent = userAgent;
	}



}