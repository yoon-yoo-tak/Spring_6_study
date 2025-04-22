package com.spring6_study.section02_concept_and_implementation_of_di.di.exercise.dice_game;

import java.util.Random;

public class SixFaceDice implements Dice{
    private final Random random = new Random();
    @Override
    public int roll() {
        return random.nextInt(6) + 1;
    }
}
