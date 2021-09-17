package com.cst438.project01.group08;

import java.util.List;

public class Search {
    private List<Exercise> currExercises;

    public List<Exercise> getSearchData(List<Exercise> apiResponse, String userInput) {
        currExercises = apiResponse;

        // Get initial search terms
        String[] searchTerms = getSearchTerms(userInput);
        String type = searchTerms[0].toLowerCase();
        String specification = "";

        if (searchTerms.length == 2) {
            specification = searchTerms[1].toLowerCase();
        }

        // If the second field is empty, we just want to run the function with the initial search term across all the exercises
        if (specification.isEmpty()) {
            searchGeneric(type);
        } else if (type.equals("equipment")) { // search for equipment with the specified term
            searchEquipment(specification);
        } else if (type.equals("target muscle")) { // search for target with the specified term
            searchTargets(specification);
        } else if (type.equals("body part")) { // search for body part with the specified term
            searchBodyPart(specification);
        }

        return currExercises;
    }

    public void searchGeneric(String specification) {
        for (int i = 0; i < currExercises.size(); i++) {
            if (! currExercises.get(i).getName().toLowerCase().contains(specification)) {
                currExercises.remove(i);
            }
        }
    }

    public void searchTargets(String specification) {
        for (int i = 0; i < currExercises.size(); i++) {
            if (! currExercises.get(i).getTarget().equalsIgnoreCase(specification)) {
                currExercises.remove(i);
            }
        }
    }

    public void searchEquipment(String specification) {
        for (int i = 0; i < currExercises.size(); i++) {
            if (! currExercises.get(i).getEquipment().equalsIgnoreCase(specification)) {
                currExercises.remove(i);
            }
        }
    }

    public void searchBodyPart(String specification) {
        for (int i = 0; i < currExercises.size(); i++) {
            if (! currExercises.get(i).getBodyPart().equalsIgnoreCase(specification)) {
                currExercises.remove(i);
            }
        }
    }

    public String[] getSearchTerms(String userInput) {
        return userInput.split(", ");
    }

}
