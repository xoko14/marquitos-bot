package com.xoko14.markov_bot;

import static org.telegram.abilitybots.api.objects.Locality.ALL;
import static org.telegram.abilitybots.api.objects.Privacy.PUBLIC;

import org.telegram.abilitybots.api.bot.AbilityBot;
import org.telegram.abilitybots.api.objects.Ability;


public class MarkBot extends AbilityBot{
    private MarkovChain hp, ecdlr, empezar, bee, shrek;
    
    public MarkBot(String token, String username) {
        super(token, username);
        System.out.println("Training...");
        hp = new MarkovChain("./trainData/azkaban.txt");
        ecdlr = new MarkovChain("./trainData/archreyes.txt");
        empezar = new MarkovChain("./trainData/empezarAgain.txt");
        bee = new MarkovChain("./trainData/bee.txt");
        shrek = new MarkovChain("./trainData/shrek.txt");
        System.out.println("Done training!");

      }

    @Override
    public long creatorId() {
        return 46452817;
    }

    public Ability getAzkaban() {
        return Ability
                  .builder()
                  .name("azkaban")
                  .info("Frase a partir de HP y el prisionero de Azkaban")
                  .locality(ALL)
                  .privacy(PUBLIC)
                  .action(ctx -> silent.send(hp.generate(100), ctx.chatId()))
                  .build();
    }

    public Ability getEcdlr() {
        return Ability
                  .builder()
                  .name("caminoreyes")
                  .info("Frase a partir de El Camino de los Reyes")
                  .locality(ALL)
                  .privacy(PUBLIC)
                  .action(ctx -> silent.send(ecdlr.generate(100), ctx.chatId()))
                  .build();
    }

    public Ability getEmpezar() {
        return Ability
                  .builder()
                  .name("empezagain")
                  .info("Frase a partir de Empezar (serie Again)")
                  .locality(ALL)
                  .privacy(PUBLIC)
                  .action(ctx -> silent.send(empezar.generate(100), ctx.chatId()))
                  .build();
    }

    public Ability getBee() {
        return Ability
                  .builder()
                  .name("beemovie")
                  .info("Frase a partir de Bee Movie")
                  .locality(ALL)
                  .privacy(PUBLIC)
                  .action(ctx -> silent.send(bee.generate(100), ctx.chatId()))
                  .build();
    }

    public Ability getShrek() {
        return Ability
                  .builder()
                  .name("shrek")
                  .info("Frase a partir de Shrek")
                  .locality(ALL)
                  .privacy(PUBLIC)
                  .action(ctx -> silent.send(shrek.generate(100), ctx.chatId()))
                  .build();
    }
}
