package com.cdfi.group.model;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@Table(name = "circular_queue_pointer")
public class CircularQueuePointerEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;
    @Column(name = "front")
    private BigInteger front;
    @Column(name = "rear")
    private BigInteger rear;
    @Column(name = "capacity")
    private BigInteger capacity;

    public static BigInteger defaultId = new BigInteger("1");

    public Integer getId() {
        return id;
    }

    public void setId(final Integer id) {
        this.id = id;
    }

    public BigInteger getFront() {
        return front;
    }

    public void setFront(final BigInteger front) {
        this.front = front;
    }

    public BigInteger getRear() {
        return rear;
    }

    public void setRear(final BigInteger rear) {
        this.rear = rear;
    }

    public BigInteger getCapacity() {
        return capacity;
    }

    public void setCapacity(final BigInteger capacity) {
        this.capacity = capacity;
    }
}
