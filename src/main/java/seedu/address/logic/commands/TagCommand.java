package seedu.address.logic.commands;

import seedu.address.model.Model;

import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG_YEAR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG_MAJOR;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG_GENDER;

public class TagCommand extends Command {

    public static final String COMMAND_WORD = "tag";

    public static final String MESSAGE_USGAE = COMMAND_WORD + ":Adds a tag to the resident in the hall ledger"
            + "by the index number used in the displayed resident list."
            + "Existing tags will be overwritten by the input tags.\n"
            + "Parameters: INDEX (must be a positive integer)"
            + "[" + PREFIX_TAG_YEAR + "YEAR]"
            + "[" + PREFIX_TAG_MAJOR + "MAJOR]"
            + "[" + PREFIX_TAG_GENDER + "GENDER]"
            + "Example: " + COMMAND_WORD + "1"
            + PREFIX_TAG_YEAR + "2"
            + PREFIX_TAG_MAJOR + "CS";

    public static final String TAG_SUCCESS = "Added Tag to Resident: %1$s";
    public static final String TAG_NOT_ADDED = "At least one tag (year / major / gender) must be provided.";

    public CommandResult execute(Model model) {
        return new CommandResult("Tag added to resident in hall ledger");
    }

}
