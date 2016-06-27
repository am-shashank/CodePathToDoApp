package com.codepath.simpletodo;

/**
 * nameInfo class contains information about name.
 * This can be easily extended to contain more info
 * about the name like deadline etc.
 * Object oriented way of doing things
 *
 * Created by shashank on 6/23/16.
 */


public class ItemInfo {
    private String name;
    private int id;

    public ItemInfo(int id, String name){
        this.name = name;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getId(){
        return id;
    }
}
