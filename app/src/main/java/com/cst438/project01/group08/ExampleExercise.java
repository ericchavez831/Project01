package com.cst438.project01.group08;

public class ExampleExercise {
    private String bodyPart;
    private String equipment;
    private String gifUrl;
    private String id;
    private String name;
    private String target;

    public ExampleExercise (String mName, String mEquipment, String mTarget, String mBodyPart){
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