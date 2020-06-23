package com.example.demo.models;

import javax.persistence.*;

@Entity
@Table(name = "OutBox")
public class OutBox {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String AggregateType;

    private int AggregateId;

    private String Type;

    private String Payload;

    public OutBox() {
    }

    public OutBox(String aggregateType, int aggregateId, String type, String payload) {
        AggregateType = aggregateType;
        AggregateId = aggregateId;
        Type = type;
        Payload = payload;
    }

    public int getId() {
        return id;
    }

    public String getAggregateType() {
        return AggregateType;
    }

    public OutBox setAggregateType(String aggregateType) {
        AggregateType = aggregateType;
        return this;
    }

    public int getAggregateId() {
        return AggregateId;
    }

    public OutBox setAggregateId(int aggregateId) {
        AggregateId = aggregateId;
        return this;
    }

    public String getType() {
        return Type;
    }

    public OutBox setType(String type) {
        Type = type;
        return this;
    }

    public String getPayload() {
        return Payload;
    }

    public OutBox setPayload(String payload) {
        Payload = payload;
        return this;
    }
}
