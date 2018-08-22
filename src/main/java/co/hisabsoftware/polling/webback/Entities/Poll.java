package co.hisabsoftware.polling.webback.Entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Poll {
    @Id
    @GeneratedValue
    private int id;

    private String title;

    private String description;

    private boolean active;

    private boolean shared;

    protected Poll() {  }

    @Override
    public String toString() {
        return "Poll{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", active=" + active +
                ", shared=" + shared +
                '}';
    }

    public Poll(int id, String title, String description, boolean active, boolean shared) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.active = active;
        this.shared = shared;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public boolean isShared() {
        return shared;
    }

    public void setShared(boolean shared) {
        this.shared = shared;
    }
}
