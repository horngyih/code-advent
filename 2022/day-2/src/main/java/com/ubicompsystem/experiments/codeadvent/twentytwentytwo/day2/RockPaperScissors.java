package com.ubicompsystem.experiments.codeadvent.twentytwentytwo.day2;

public enum RockPaperScissors {

    ROCK(1){
        public int match(RockPaperScissors play){
            if( play != null ){
                switch(play) {
                    case ROCK:
                        return 3;
                    case SCISSORS:
                        return 6;
                }
            }
            return 0;
        }
    },
    PAPER(2){
        public int match(RockPaperScissors play){
            if( play != null ){
                switch(play) {
                    case PAPER:
                        return 3;
                    case ROCK:
                        return 6;
                }
            }
            return 0;
        }
    }, SCISSORS(3){
        public int match(RockPaperScissors play){
            if( play != null ){
                switch(play) {
                    case SCISSORS:
                        return 3;
                    case PAPER:
                        return 6;
                }
            }
            return 0;
        }
    };

    public int score;

    RockPaperScissors(int n){
        this.score = n;
    }

    public abstract int match(RockPaperScissors play);

    public static RockPaperScissors translate( String str ){
        if( str != null && !"".equals(str.trim()) ){
            switch(str.trim()){
                case "A":
                case "X":
                    return ROCK;
                case "B":
                case "Y":
                    return PAPER;
                case "C":
                case "Z":
                    return SCISSORS;
            }
        }

        return null;
    }
}
