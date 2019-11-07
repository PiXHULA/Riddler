package Riddler;

public class Protocol {

    private static final int BEGIN = 0;
    private static final int QUESTION = 1;
    private static final int VALIDATION = 2;
    private static final int QUIT = 3;

    private static final int NUMRIDDLES = 5;

    private int state = BEGIN;
    private int currentRiddle = 0;

    private String[] riddles = {
            "I am not alive, but I grow; I don't have lungs, but I need air; I don't have a mouth, but water kills me. What am I?",
            "The more you take, the more you leave behind. What am I?",
            "What room do ghosts avoid?",
            "What belongs to you, but other people use it more than you?",
            "My life can be measured in hours, I serve by being devoured. Thin, I am quick. Fat, I am slow. Wind is my foe. What am I?"
    };
    private String[] answers = {
            "Fire",
            "Footsteps",
            "The living room",
            "Your name",
            "A candle"
    };
    public String processInput(String theInput) {
        String theOutput = null;
        if (state == BEGIN){
            System.out.println("WAITING");
            theOutput = "Welcome to the riddleFactory, do you want to begin?";
            state = QUESTION;
        }
        else if (state == QUESTION){
            if(theInput.equalsIgnoreCase("Yes")
                    || theInput.equalsIgnoreCase("Y")){
                theOutput = riddles[currentRiddle];
                state = VALIDATION;
            }else if (theInput.equalsIgnoreCase("No")
                    || theInput.equalsIgnoreCase("N")){
                theOutput = "Bye";
                state = QUIT;
            }
        }
        else if (state == VALIDATION){
            if(theInput.equalsIgnoreCase(answers[currentRiddle])){
                System.out.println("CORRECT ANSWER");
                theOutput = answers[currentRiddle]
                        + " was the correct answer! Want another? (Yes/No)";
            currentRiddle++;
            }else {
                theOutput = "Wrong answer, try again? (Yes/No)";
                System.out.println("WRONG ANSWER");
            }
            state = QUESTION;
        }
        return theOutput;
    }
}
/*
    public String processInput(String theInput) {

        if (state == WAITING) {
            System.out.println("WAITING");
            theOutput = "Welcome to the riddleFactory, do you want to begin?";
            state = STARTING;
        } else if (state == STARTING) {
            System.out.println("STARTING");
            if (theInput.equalsIgnoreCase("Yes")
                    || theInput.equalsIgnoreCase("Y")) {
                theOutput = riddles[currentRiddle];
                state = SENTANSWER;
            } else {
                theOutput = "You're supposed to say \"Yes\" or \"Y\"!"
                        + " Please try again";
                System.out.println("YESorNO");
            }
        } else if (state == SENTANSWER) {
            System.out.println("SENT ANSWER");

            if (theInput.equalsIgnoreCase(answers[currentRiddle])) {
                System.out.println("CORRECT ANSWER");
                theOutput = answers[currentRiddle]
                        + " was the correct answer! Want another? (Yes/No)";
            }
            if (theInput.equalsIgnoreCase("Yes")) {
                if (currentRiddle == NUMRIDDLES - 1) {
                    System.out.println("Y-5 Another");
                    currentRiddle = 0;
                    state = ANOTHER;
                } else {
                    System.out.println("Y Another");
                    currentRiddle++;
                    state = ANOTHER;
                    return theOutput;
                }
            }
            if (state == ANOTHER) {
                System.out.println("Another");
                if (theInput.equalsIgnoreCase("Yes")
                        || theInput.equalsIgnoreCase("Y")) {
                    if (currentRiddle == NUMRIDDLES - 1) {
                        System.out.println("Y-5 Another");
                        System.out.println("Current riddle " + currentRiddle);
                        currentRiddle = 0;
                    } else {
                        System.out.println("Y Another");
                        currentRiddle++;
                        System.out.println("Current riddle " + currentRiddle);
                    }
                    theOutput = riddles[currentRiddle];
                    state = STARTING;
                }
            } else if (theInput.equalsIgnoreCase("No"))
                theOutput = "Bye";
        }
        return theOutput;
    }
}


                   /* if (!theInput.equalsIgnoreCase(answers[currentRiddle])) {
                theOutput = "Wrong answer, try again!";
                state = STARTING;
                System.out.println("WRONG ANSWER");
            }*/

/*
            } else
                } else {
                    System.out.println("BYE");
                    theOutput = "Bye.";
                    state = WAITING;

 */



