package seedu.address.model.util;

import java.util.HashSet;
import java.util.Set;

import seedu.address.model.AddressBook;
import seedu.address.model.ReadOnlyAddressBook;
import seedu.address.model.person.Email;
import seedu.address.model.person.EmergencyContact;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.RoomNumber;
import seedu.address.model.person.StudentId;
import seedu.address.model.tag.Tag;
import seedu.address.model.tag.TagType;


/**
 * Contains utility methods for populating {@code AddressBook} with sample data.
 */
public class SampleDataUtil {
    public static Person[] getSamplePersons() {
        return new Person[] {
            new Person(new Name("Alex Yeoh"), new Phone("87438807"), new Email("alexyeoh@example.com"),
                    new StudentId("Blk 30 Geylang Street 29, #06-40"), new RoomNumber("4-A"),
                    new EmergencyContact("98765432"), new HashSet<>()),
            new Person(new Name("Bernice Yu"), new Phone("99272758"), new Email("berniceyu@example.com"),
                    new StudentId("Blk 30 Lorong 3 Serangoon Gardens, #07-18"), new RoomNumber("15-R"),
                    new EmergencyContact("91234567"), new HashSet<>()),
            new Person(new Name("Charlotte Oliveiro"), new Phone("93210283"), new Email("charlotte@example.com"),
                    new StudentId("Blk 11 Ang Mo Kio Street 74, #11-04"), new RoomNumber("3-D"),
                    new EmergencyContact("87654321"), new HashSet<>()),
            new Person(new Name("David Li"), new Phone("91031282"), new Email("lidavid@example.com"),
                    new StudentId("Blk 436 Serangoon Gardens Street 26, #16-43"), new RoomNumber("10-C"),
                    new EmergencyContact("12345678"), new HashSet<>()),
            new Person(new Name("Irfan Ibrahim"), new Phone("92492021"), new Email("irfan@example.com"),
                    new StudentId("Blk 47 Tampines Street 20, #17-35"), new RoomNumber("5-B"),
                    new EmergencyContact("56789012"), new HashSet<>()),
            new Person(new Name("Roy Balakrishnan"), new Phone("92624417"), new Email("royb@example.com"),
                    new StudentId("Blk 45 Aljunied Street 85, #11-31"), new RoomNumber("12-D"),
                    new EmergencyContact("23456789"), new HashSet<>())
        };
    }

    public static ReadOnlyAddressBook getSampleAddressBook() {
        AddressBook sampleAb = new AddressBook();
        for (Person samplePerson : getSamplePersons()) {
            sampleAb.addPerson(samplePerson);
        }
        return sampleAb;
    }

    /**
     * Returns a tag set containing the list of strings given.
     */
    public static Set<Tag> getTagSet(Object[]... tags) {
        Set<Tag> tagSet = new HashSet<>();
        for (Object[] pair: tags) {
            TagType type = TagType.valueOf(pair[0].toString());
            String tagName = pair[1].toString();
            tagSet.add(new Tag(type, tagName));
        }
        return tagSet;
    }
}
