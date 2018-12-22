package com.derrick.park.assignment3_contacts;

import com.derrick.park.assignment3_contacts.models.Contact;

public class Item {
    public Item(Contact contact) {
        this.contact = contact;
    }

    Adapter.ContactViewHolder holder;
    Contact contact;

    public Adapter.ContactViewHolder getHolder() {
        return holder;
    }

    public void setHolder(Adapter.ContactViewHolder holder) {
        this.holder = holder;
    }

    public Contact getContact() {
        return contact;
    }

    public void setContact(Contact contact) {
        this.contact = contact;
    }

    public boolean isHas_title() {
        return has_title;
    }

    public void setHas_title(boolean has_title) {
        this.has_title = has_title;
    }

    boolean has_title = true;
}
