package com.example.spoon.models;

import javax.persistence.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String photo;
    private String authorName;
    private int likes = 0;
    private String name;
    private String ingredients;
    private String cooking;
    private String category;
    private String date = new SimpleDateFormat("dd.MM.yy").format(new Date());

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "likes_user", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Integer> likesUser;



    public String getDate() {
        return date;
    }

    public Recipe() {
    }

    public Recipe(String photo, String name, String ingredients, String cooking, String authorName, String category) {
        this.photo = photo;
        this.name = name;
        this.ingredients = ingredients;
        this.cooking = cooking;
        this.authorName = authorName;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Set<Integer> getLikesUser() {
        return likesUser;
    }

    public void setLikesUser(Set<Integer> likesUser) {
        this.likesUser = likesUser;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCooking() {
        return cooking;
    }

    public void setCooking(String cooking) {
        this.cooking = cooking;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Recipe " +
                "id=" + id +
                ", likes=" + likes +
                ", name='" + name;
    }
}
