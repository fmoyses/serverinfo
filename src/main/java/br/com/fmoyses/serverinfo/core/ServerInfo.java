package br.com.fmoyses.serverinfo.core;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.validator.constraints.NotEmpty;
import org.mongojack.ObjectId;

/**
 * Created by Fernando on 21/09/2014.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ServerInfo {

    private String _id;
    @NotEmpty
    private String customer;
    private String service;
    @NotEmpty
    private String server;
    private String collectionDate;
    private String sendDate;
    private String info;

    public ServerInfo() {
    }

    public ServerInfo(String _id, String customer, String service, String server, String collectionDate, String sendDate, String info) {
        this._id = _id;
        this.customer = customer;
        this.service = service;
        this.server = server;
        this.collectionDate = collectionDate;
        this.sendDate = sendDate;
        this.info = info;
    }

    @ObjectId
    public String get_id() {
        return _id;
    }

    @ObjectId
    public void set_id(String _id) {
        this._id = _id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public String getService() {
        return service;
    }

    public void setService(String service) {
        this.service = service;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getCollectionDate() {
        return collectionDate;
    }

    public void setCollectionDate(String collectionDate) {
        this.collectionDate = collectionDate;
    }

    public String getSendDate() {
        return sendDate;
    }

    public void setSendDate(String sendDate) {
        this.sendDate = sendDate;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
