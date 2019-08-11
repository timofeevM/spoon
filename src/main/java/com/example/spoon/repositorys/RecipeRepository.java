package com.example.spoon.repositorys;

import com.example.spoon.models.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {
    public List<Recipe> findByAuthorName(String author);
    public List<Recipe> findByCategory(String category);
    public Recipe findById(int id);
    public void deleteById(int id);
}
