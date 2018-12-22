package com.derrick.park.assignment3_contacts.models;

import com.derrick.park.assignment3_contacts.Adapter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Contact {
    public Contact(String names, String cell, String fname) {
        name = new Name(names, fname);
        this.cell = cell;
    }
    public boolean has_title = true;

//    Adapter.ContactViewHolder holder = null;
//
//    public Adapter.ContactViewHolder getHolder() {
//        return holder;
//    }
//
//    public void setHolder(Adapter.ContactViewHolder holder) {
//        this.holder = holder;
//    }
//
//    public boolean isHas_title() {
//        return has_title;
//    }
//
//    public void setHas_title(boolean has_title) {
//        this.has_title = has_title;
//    }

    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("name")
    @Expose
    private Name name;
    @SerializedName("location")
    @Expose
    private Location location;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("cell")
    @Expose
    private String cell;

    public String getGender() {
        return gender;
    }

    public Name getName() {
        return name;
    }

    public Location getLocation() {
        return location;
    }

    public String getEmail() {
        return email;
    }

    public String getCell() {
        return cell;
    }

    @Override
    public String toString() {
        return String.format("%n%s%n%s%n%s%n%s", name, location, email, cell);
    }

    /**
     * Name {first: , last: }
     */
    public class Name {

        public Name(String ln, String fn) {
            this.first = fn;
            this.last = ln;
        }

        @SerializedName("first")
        @Expose
        private String first;
        @SerializedName("last")
        @Expose
        private String last;

        public void setFirst(String first) {
            this.first = first;
        }

        public String getFirst() {
            String name = first;
            first = name.substring(0,1).toUpperCase() + name.substring(1);
            return first;
        }

        public String getLast() {
            return last;
        }

        @Override
        public String toString() {
            return first + " " + last;
        }
    }

    /**
     * Location {street: , city: , state: , postcode: }
     */
    public class Location {
        @SerializedName("street")
        @Expose
        private String street;
        @SerializedName("city")
        @Expose
        private String city;
        @SerializedName("state")
        @Expose
        private String province;
        @SerializedName("postcode")
        @Expose
        private String postcode;

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getProvince() {
            return province;
        }

        public String getPostcode() {
            return postcode;
        }

        @Override
        public String toString() {
            return street + ", " + city + ", " + province + " Canada " + postcode;
        }
    }
}

