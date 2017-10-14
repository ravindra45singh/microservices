package de.telekom.microservices.utils;

public class MicroBean {

    private int id;
    private String date;
    private String host;
    private String serviceId;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost( String host ) {
        this.host = host;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId( String serviceId ) {
        this.serviceId = serviceId;
    }

    public int getPort() {
        return port;
    }

    public void setPort( int port ) {
        this.port = port;
    }

    public int getId() {
        return id;
    }

    public void setId( int id ) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate( String date ) {
        this.date = date;
    }

}
