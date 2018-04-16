package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public class MessageGeneratorImpl implements MessageGenerator {

    // == constants ==
    private static final Logger log = LoggerFactory.getLogger(MessageGeneratorImpl.class);

    // == fields ==
    @Autowired
    private Game game;

    private int guessCount = 10;

    // == init methods ==
    @PostConstruct
    public void postConstructMethod(){
            log.info("Game = {}", game);
    }

    // == public methods ==
    @Override
    public String getMainMessage() {
        return "This is main message";
    }

    @Override
    public String getResultMessage() {
        return "This is result message";
    }


}
