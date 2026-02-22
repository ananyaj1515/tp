package seedu.address.ui.tab.directory;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;
import seedu.address.ui.UiPart;

/**
 * An editable panel that displays the detailed profile of a student.
 */
public class StudentProfilePanel extends UiPart<Region> {
    private static final String FXML = "directory/StudentProfilePanel.fxml";

    @FXML
    private TextField nameField;
    @FXML
    private TextField genderField;
    @FXML
    private TextField blockField;
    @FXML
    private TextField floorField;
    @FXML
    private TextField addressField;
    @FXML
    private TextField tagsField;

    public StudentProfilePanel() {
        super(FXML);
        // Will map Person properties to these fields later during Phase 4 integration
    }
}
