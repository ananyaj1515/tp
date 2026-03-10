package seedu.address.testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;
import seedu.address.model.tag.TagType;

import static seedu.address.logic.commands.CommandTestUtil.*;

public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder().withName("Alice Pauline")
            .withStudentId("A1234567X").withEmail("alice@example.com")
            .withPhone("94351253")
            .withRoomNumber("R123").withEmergencyContact("91234567")
            .withTags(new Object[]{TagType.GENDER, "she"}).build();

    public static final Person BENSON = new PersonBuilder().withName("Benson Meier")
            .withStudentId("A87654321").withEmail("johnd@example.com").withPhone("98765432")
            .withRoomNumber("R123").withEmergencyContact("91234567")
            .withTags(new Object[]{TagType.MAJOR, "CS"}, new Object[]{TagType.YEAR, "Y2"}).build();

    public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withPhone("95352563")
            .withEmail("heinz@example.com").withStudentId("A1111111X").withRoomNumber("R123")
            .withEmergencyContact("91234567").build();

    public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withPhone("87652533")
            .withEmail("cornelia@example.com").withStudentId("A2222222X").withRoomNumber("R123")
            .withEmergencyContact("91234567")
            .withTags(new Object[]{TagType.YEAR, "Y2"}).build();

    public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withPhone("9482224")
            .withEmail("werner@example.com").withStudentId("A3333333X").withRoomNumber("R123")
            .withEmergencyContact("91234567").build();

    public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withPhone("9482427")
            .withEmail("lydia@example.com").withStudentId("A4444444X").withRoomNumber("R123")
            .withEmergencyContact("91234567").build();

    public static final Person GEORGE = new PersonBuilder().withName("George Best").withPhone("9482442")
            .withEmail("anna@example.com").withStudentId("A5555555X").withRoomNumber("R123")
            .withEmergencyContact("91234567").build();

    // Manually added
    public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withPhone("8482424")
            .withEmail("stefan@example.com").withStudentId("A6666666X").build();
    public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withPhone("8482131")
            .withEmail("hans@example.com").withStudentId("A7777777X").build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY).withStudentId(VALID_STUDENTID_AMY).withRoomNumber(VALID_ROOM_NUMBER_AMY)
            .withEmergencyContact(VALID_EMERGENCY_CONTACT_AMY).withTags(VALID_TAG_YEAR).build();

    public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB).withStudentId(VALID_STUDENTID_BOB).withRoomNumber(VALID_ROOM_NUMBER_BOB)
            .withEmergencyContact(VALID_EMERGENCY_CONTACT_BOB).withTags(VALID_TAG_MAJOR, VALID_TAG_YEAR).build();


    public static final String KEYWORD_MATCHING_MEIER = "Meier";

    private TypicalPersons() {}

    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}