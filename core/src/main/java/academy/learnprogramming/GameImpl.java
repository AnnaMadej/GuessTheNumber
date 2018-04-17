package academy.learnprogramming;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Slf4j
@Component
public class GameImpl implements Game {

    // == fields ==
    private final NumberGenerator numberGenerator;

    @Getter
    private final int guessCount;


    // == constructor ==
    @Autowired
    public GameImpl(NumberGenerator numberGenerator, @GuessCount int guessCount){
        this.numberGenerator = numberGenerator;
        this.guessCount = guessCount;
    }

    @Getter
    private int number;

    @Getter
    @Setter
    private int guess;

    @Getter
    private int smallest;

    @Getter
    private int biggest;

    @Getter
    private int remainingGuesses;


    private boolean validNumberRange = true;


//    // == constructors ==
//    public GameImpl(NumberGenerator numbergenerator) {
//        this.numbergenerator = numbergenerator;
//    }


//    public void setNumberGenerator(NumberGenerator numberGenerator) {
//        this.numberGenerator = numberGenerator;
//    }


    // == init ==

    @PostConstruct
    @Override
    public void reset() {
        smallest = numberGenerator.getMinNumber();
        guess = 0;
        remainingGuesses = guessCount;
        biggest = numberGenerator.getMaxNumber();
        number = numberGenerator.next();
        log.debug("the number is {}", number);
    }

    @PreDestroy
    public void preDestroy(){
        log.info("in Game preDestroy()");
    }

    // == public methods ==



    @Override
    public void check() {
        checkValidNumerRange();
        if(validNumberRange){
            if(guess > number) {
                biggest = guess -1;
            }
            if(guess < number){
                smallest = guess + 1;
            }
        }
        remainingGuesses--;
    }

    @Override
    public boolean isValidNumberRange() {
        return validNumberRange;
    }

    @Override
    public boolean isGameWon() {
        return guess == number;
    }

    @Override
    public boolean isGameLost() {
        return !isGameWon() && remainingGuesses <= 0;
    }


    // == private methods ==
    private void checkValidNumerRange(){
        validNumberRange = (guess >= smallest) && (guess <= biggest);
    }
}
