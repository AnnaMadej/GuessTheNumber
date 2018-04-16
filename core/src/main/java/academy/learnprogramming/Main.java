package academy.learnprogramming;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    private static final Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        // log.info("guess the number game!");

        // create the context
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        NumberGenerator numberGenerator = context.getBean(NumberGenerator.class);

        int number = numberGenerator.next();
        log.info("number = {}", number);


        // get game bean from context (container)
        Game game = context.getBean(Game.class);

        // get message generator from context (container)
        MessageGenerator generator = context.getBean(MessageGenerator.class);

        log.info("getMainMessage= {}", generator.getMainMessage());

        log.info("getResultMessage= {}", generator.getResultMessage());

        // call reset method
//         game.reset();

        // close context (container)
        context.close();
    }
}
