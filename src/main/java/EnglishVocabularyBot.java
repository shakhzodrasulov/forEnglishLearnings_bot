import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class EnglishVocabularyBot extends TelegramLongPollingBot {
    public String getBotUsername() {
        return "forEnglishLearnings_bot";
    }

    public String getBotToken() {
        return "1657686801:AAHNJHsQiOmWPetc1bJfl2Ws4JKD3A4s7Co";
    }

    public void onUpdateReceived(Update update) {
        String command = update.getMessage().getText();
        SendMessage message = new SendMessage();
        message.enableMarkdown(true);
        message.setChatId(update.getMessage().getChatId().toString());


        if (EssentialEnglishWords.onProcess.equals("")){
            if (command.equals("/essential_english_words")) {
                message.setText(Emojiz.GRAY_CHECK.getValue()+" Select what do you want do:\n\n/learn - *Learn new words*\n\n/test - *Test yourself*");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            if(command.equals("/test")){
                message.setText(Emojiz.GRAY_CHECK.getValue()+" Select Unit for test yourself:\n\n" +
                        "/test1 - *Unit 1*\n\n" +
                        "/test2 - *Unit 2*\n\n" +
                        "/test3 - *Unit 3*\n\n" +
                        "/test4 - *Unit 4*\n\n" +
                        "/test5 - *Unit 5*\n\n" +
                        "/test6 - *Unit 6*\n\n"
                );
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

            if (command.equals("/test6")) {
                EssentialEnglishWords.onProcess = "unit6";
                EssentialEnglishWords.doRandom();
                message.setText(Emojiz.NEXT.getValue()+(EssentialEnglishWords.counter+1)+"/20:\n_"+
                        EssentialEnglishWords.unitSixKey[EssentialEnglishWords.randomNumbers[EssentialEnglishWords.counter]]+"_\n\n"+
                        Emojiz.STOP.getValue()+"/stop and return to main menu");
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }



            if(command.equals("/learn_new_words_essw4000")){
                System.out.println("");
            }
            if (command.equals("/irregular_verbs")) {
                message.setText(update.getMessage().getText());
            }
            if (command.equals("/grammar")) {
                message.setText(update.getMessage().getText());
            }
        }


        else {
            if (command.equals("/stop")){
                EssentialEnglishWords.clearAll();
            } else {
                if (command.equals(EssentialEnglishWords.unitSixValues[EssentialEnglishWords.randomNumbers[EssentialEnglishWords.counter]])) {
                    message.setText(Emojiz.RIGHT.getValue() + " RIGHT!");
                    EssentialEnglishWords.rightAnswers++;
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else {
                    message.setText(Emojiz.WRONG.getValue() + "WRONG!\nRight answer is: *" + EssentialEnglishWords.unitSixValues[EssentialEnglishWords.counter] + "*");
                    EssentialEnglishWords.wrongAnswers++;
                    EssentialEnglishWords.wrongAnswersValue.add(EssentialEnglishWords.unitSixValues[EssentialEnglishWords.randomNumbers[EssentialEnglishWords.counter]]);
                    EssentialEnglishWords.wrongAnswersKey.add(EssentialEnglishWords.unitSixKey[EssentialEnglishWords.randomNumbers[EssentialEnglishWords.counter]]);
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }
                if (EssentialEnglishWords.counter < 19) {
                    EssentialEnglishWords.counter++;

                    message.setText(
                            Emojiz.NEXT.getValue() + " next word " + "(" + (EssentialEnglishWords.counter + 1) + "/20):\n_" +
                                    EssentialEnglishWords.unitSixKey[EssentialEnglishWords.randomNumbers[EssentialEnglishWords.counter]] + "_\n\n" +
                                    Emojiz.STOP.getValue() + "/stop and return to main menu");
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else {
                    if (EssentialEnglishWords.wrongAnswers > 0) {
                        StringBuilder finishText = new StringBuilder();
                        finishText.append(Emojiz.FINISH.getValue()).append(" FINISH ").append(Emojiz.FINISH.getValue()).append("\n\n").append(Emojiz.RIGHT.getValue()).append(" *RIGHT ANSWERS: ").append(EssentialEnglishWords.rightAnswers).append("*\n").append(Emojiz.WRONG.getValue()).append(" *WRONG ANSWERS: ").append(EssentialEnglishWords.wrongAnswers).append("*\n\n").append("Learn this words again for successfully finishing test:\n");

                        for (int i = 0; i < EssentialEnglishWords.wrongAnswers; i++) {
                            finishText.append(Emojiz.BLUE_CHECK.getValue()).append(" _").append(EssentialEnglishWords.wrongAnswersValue.get(i)).append(" - ")
                                    .append(EssentialEnglishWords.wrongAnswersKey.get(i)).append("_\n");
                        }
                        message.setText(finishText.toString());
                    } else {
                        message.setText(Emojiz.FINISH.getValue() + " FINISH " + Emojiz.FINISH.getValue() + "\n\n" +
                                Emojiz.RIGHT.getValue() + " *RIGHT ANSWERS: 20/20*\n\nYou are amazing!)");
                    }
                    try {
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                    EssentialEnglishWords.clearAll();
                }
            }

        }



        /*message.setChatId(update.getMessage().getChatId().toString());

        try {
            execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }*/
    }
}
