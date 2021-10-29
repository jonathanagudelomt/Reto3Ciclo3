/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.Reto3.Reto3.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author agude
 */

@Entity
@Table(name="audience")
/**
 * 
 */
public class Audience implements Serializable{
    /**
     * 
     */
    @Id
    /**
     * 
     */
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    /**
     * 
     */
    private Integer id;
    /**
     * 
     */
    private String name;
    /**
     * 
     */
    private String owner;
    /**
     * 
     */
    private Integer capacity;
    /**
     * 
     */
    private String description;
    /**
     * 
     */
    @ManyToOne 
    @JoinColumn(name="categoriaid")
    @JsonIgnoreProperties("audiences")
    /**
     * 
     */
    private Categoria category;

    /**
     * 
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="audience")
    @JsonIgnoreProperties({"audience","client"})
    /**
     * 
     */
    private List<Message> messages;  
    /**
     * 
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy="audience")
    @JsonIgnoreProperties({"audience","client"})
    /**
     * 
     */
    private List<Reservation> reservations;
    /**
     * 
     * @return 
     */
    public String getDescription() {
        return description;
    }
    /**
     * 
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }
    /**
     * 
     * @return 
     */
    public List<Message> getMessages() {
        return messages;
    }
    /**
     * 
     * @param messages 
     */
    public void setMessages(List<Message> messages) {
        this.messages = messages;
    }
    /**
     * 
     * @return 
     */
    public List<Reservation> getReservations() {
        return reservations;
    }
    /**
     * 
     * @param reservations 
     */
    public void setReservations(List<Reservation> reservations) {
        this.reservations = reservations;
    }
    /**
     * 
     * @return 
     */
    public Integer getId() {
        return id;
    }
    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
     * 
     * @return 
     */
    public String getOwner() {
        return owner;
    }
    /**
     * 
     * @param owner 
     */
    public void setOwner(String owner) {
        this.owner = owner;
    }
    /**
     * 
     * @return 
     */
    public Integer getCapacity() {
        return capacity;
    }
    /**
     * 
     * @param capacity 
     */
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * 
     * @return 
     */
    public Categoria getCategory() {
        return category;
    }
    /**
     * 
     * @param category 
     */
    public void setCategory(Categoria category) {
        this.category = category;
    }

}
