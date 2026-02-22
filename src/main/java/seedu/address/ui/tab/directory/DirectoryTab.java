package seedu.address.ui.tab.directory;

import javafx.fxml.FXML;
import javafx.scene.layout.Region;
import javafx.scene.layout.StackPane;
import javafx.scene.control.TabPane;
import seedu.address.ui.UiPart;

/**
 * A ui for the main tab that is displayed on the main window.
 */
public class DirectoryTab extends UiPart<Region> {

    private static final String FXML = "directory/DirectoryTab.fxml";

    @FXML
    private TabPane detailsTabPane;

    @FXML
    private StackPane profilePlaceholder;

    @FXML
    private StackPane ccaRecordsPlaceholder;

    @FXML
    private StackPane demeritRecordsPlaceholder;

    public DirectoryTab() {
        super(FXML);

        fillInnerParts();
    }

    private void fillInnerParts() {
        StudentProfilePanel studentProfilePanel = new StudentProfilePanel();
        profilePlaceholder.getChildren().add(studentProfilePanel.getRoot());

        CcaRecordsPanel ccaRecordsPanel = new CcaRecordsPanel();
        ccaRecordsPlaceholder.getChildren().add(ccaRecordsPanel.getRoot());

        DemeritRecordsPanel demeritRecordsPanel = new DemeritRecordsPanel();
        demeritRecordsPlaceholder.getChildren().add(demeritRecordsPanel.getRoot());
    }
}
