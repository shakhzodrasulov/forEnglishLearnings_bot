import com.vdurmont.emoji.EmojiParser;

public enum Emojiz {
    RIGHT(":white_check_mark:"),
    WRONG(":x:"),
    NEXT(":fast_forward:"),
    FINISH(":checkered_flag:"),
    BLUE_CHECK(":small_blue_diamond:"),
    GRAY_CHECK(":ballot_box_with_check:"),
    STOP(":no_entry:");



    private final String value;

    Emojiz(String value) {
        this.value = value;
    }

    public String getValue() {
        return EmojiParser.parseToUnicode(value);
    }
}
