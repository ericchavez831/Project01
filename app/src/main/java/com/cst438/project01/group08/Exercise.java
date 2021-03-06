package com.cst438.project01.group08;

/**
 *
 * <h2><b>Exercise</b></h2>
 * This is the Exercise data model that is used throughout the application to display the exercises.
 *
 * @authors Angel Gutierrez & Conner Turetkzy
 */

public class Exercise {
    String bodyPart;
    String equipment;
    String gifUrl;
    String id;
    String name;
    String target;

    public Exercise (String mGifUrl, String mName, String mEquipment, String mTarget, String mBodyPart){
        gifUrl = mGifUrl;
        name = mName;
        equipment = mEquipment;
        target = mTarget;
        bodyPart = mBodyPart;
    }

    public String getBodyPart() {
        return bodyPart;
    }

    public String getEquipment() {
        return equipment;
    }

    public String getGifUrl() {
        return gifUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTarget() {
        return target;
    }
}
