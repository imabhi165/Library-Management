package library.models;

import java.time.LocalDateTime;

public abstract class BaseEntity {
    private String id;
    private LocalDateTime createAt;


    //Constructor
    public BaseEntity(String id) {
        this.id = id;
        this.createAt=LocalDateTime.now();
    }
    //getter
    public String getId(){
        return id;
    }

    public LocalDateTime getCreateAt() {
        return createAt;
    }

    //Abstract method - all child classes must implement this
    public abstract void displayInfo();

    @Override
    public String toString() {
        return "ID: " +id+ ", Created at "+createAt;
    }
}

