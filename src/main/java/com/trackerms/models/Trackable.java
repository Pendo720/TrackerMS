package com.trackerms.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import javax.persistence.*;

@Entity
@Table(name = "trackables")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Trackable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long _id;
    Long _count;
    String _item;
    public Trackable(String _item) {
        this._item = _item;
        this._count = 1L;
    }

    public JSONObject asJon(){
        return new JSONObject().put("_id", _id).put("_item", _item).put("_count", _count);
    }
    @Override
    public String toString(){
        return asJon().toString();
    }
}