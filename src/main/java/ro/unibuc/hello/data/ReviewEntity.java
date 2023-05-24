package ro.unibuc.hello.data;

import org.springframework.data.annotation.Id;

import java.util.Random;

public class ReviewEntity {
    @Id
    private long id = new Random().nextLong();
    private String name;
    private int mark;
    private String description;

    public ReviewEntity() {
    }

    public ReviewEntity(long id, String name, int mark, String description) {
        this.id = id;
        this.name = name;
        this.mark = mark;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMark() {
        return mark;
    }

    public void setMark(int mark) {
        this.mark = mark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
