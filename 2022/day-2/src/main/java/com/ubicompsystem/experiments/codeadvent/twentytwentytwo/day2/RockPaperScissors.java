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

        public RockPaperScissors win(){
            return PAPER;
        }

        public RockPaperScissors lose(){
            return SCISSORS;
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

        public RockPaperScissors win(){
            return SCISSORS;
        }

        public RockPaperScissors lose(){
            return ROCK;
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

        public RockPaperScissors win(){
            return ROCK;
        }

        public RockPaperScissors lose(){
            return PAPER;
        }
    };

    public int score;

    RockPaperScissors(int n){
        this.score = n;
    }

    public abstract int match(RockPaperScissors play);
    public abstract RockPaperScissors win();
    public abstract RockPaperScissors lose();
    public RockPaperScissors draw(){
        return this;
    }

    public String toString(){
        return this.name();
    }

    public static RockPaperScissors translate( String str ){
        if( str != null && !"".equals(str.trim()) ){
            switch(str.trim()){
                case "A":
                    return ROCK;
                case "B":
                    return PAPER;
                case "C":
                    return SCISSORS;
            }
        }

        return null;
    }

    public static RockPaperScissors translateStrategy( RockPaperScissors play, String str ){
        if( play!= null && str != null && !"".equals(str.trim()) ){
            switch(str.trim()){
                case "X":
                    return play.lose();
                case "Y":
                    return play.draw();
                case "Z":
                    return play.win();
            }
        }
        return null;
    }
}
