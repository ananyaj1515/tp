package seedu.address.model.person;

import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.FilterDetails;

/**
 * Tests whether a {@code Person} matches the details specified in a {@link FilterDetails}.
 */
public class PersonMatchesDetailsPredicate implements Predicate<Person> {

    private final FilterDetails filterDetails;

    public PersonMatchesDetailsPredicate(FilterDetails filterDetails) {
        this.filterDetails = Objects.requireNonNull(filterDetails);
    }

    @Override
    public boolean test(Person person) {
        // OR-based across criteria: if any criterion matches, the person is included.
        // Each individual criterion is itself OR over its own keyword set.

        boolean matchesName = matchesName(person);
        boolean matchesEmail = matchesEmail(person);
        boolean matchesPhone = matchesPhone(person);
        boolean matchesRoom = matchesRoom(person);
        boolean matchesStudentId = matchesStudentId(person);
        boolean matchesEmergencyContact = matchesEmergencyContact(person);
        boolean matchesTag = matchesGeneralTags(person);
        boolean matchesTagYear = matchesYearTags(person);
        boolean matchesTagMajor = matchesMajorTags(person);
        boolean matchesTagGender = matchesGenderTags(person);

        return matchesName
                || matchesEmail
                || matchesPhone
                || matchesRoom
                || matchesStudentId
                || matchesEmergencyContact
                || matchesTag
                || matchesTagYear
                || matchesTagMajor
                || matchesTagGender;
    }

    private boolean matchesName(Person person) {
        Set<String> keywords = filterDetails.getNameKeywords();
        if (keywords == null || keywords.isEmpty()) {
            return false;
        }
        String fullName = person.getName().fullName;
        return keywords.stream()
                .anyMatch(keyword -> seedu.address.commons.util.StringUtil
                        .containsWordIgnoreCase(fullName, keyword));
    }

    private boolean matchesEmail(Person person) {
        Set<String> keywords = filterDetails.getEmailKeywords();
        if (keywords == null || keywords.isEmpty()) {
            return false;
        }
        String email = person.getEmail().value;
        // Email is taken as whole: containsIgnoreCase is enough as a simple fuzzy match
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsIgnoreCase(email, keyword));
    }

    private boolean matchesPhone(Person person) {
        Set<String> keywords = filterDetails.getPhoneNumberKeywords();
        if (keywords == null || keywords.isEmpty()) {
            return false;
        }
        String phone = person.getPhone().value;
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsIgnoreCase(phone, keyword));
    }

    private boolean matchesRoom(Person person) {
        Set<String> keywords = filterDetails.getRoomNumberKeywords();
        if (keywords == null || keywords.isEmpty()) {
            return false;
        }
        String room = person.getRoomNumber().value;
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsIgnoreCase(room, keyword));
    }

    private boolean matchesStudentId(Person person) {
        Set<String> keywords = filterDetails.getStudentIdKeywords();
        if (keywords == null || keywords.isEmpty()) {
            return false;
        }
        String studentId = person.getStudentId().value;
        // Student ID: treat as whole string, simple containsIgnoreCase
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsIgnoreCase(studentId, keyword));
    }

    private boolean matchesEmergencyContact(Person person) {
        Set<String> keywords = filterDetails.getEmergencyContactKeywords();
        if (keywords == null || keywords.isEmpty()) {
            return false;
        }
        String emergencyContact = person.getEmergencyContact().value;
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsIgnoreCase(emergencyContact, keyword));
    }

    private boolean matchesGeneralTags(Person person) {
        Set<String> keywords = filterDetails.getTagKeywords();
        if (keywords == null || keywords.isEmpty()) {
            return false;
        }
        // General tags: OR if any keyword matches any tag name (case-insensitive contains)
        return person.getTags().stream().anyMatch(tag ->
                keywords.stream().anyMatch(keyword ->
                        StringUtil.containsIgnoreCase(tag.tagName, keyword)));
    }

    private boolean matchesYearTags(Person person) {
        Set<String> keywords = filterDetails.getTagYearKeywords();
        if (keywords == null || keywords.isEmpty()) {
            return false;
        }
        // Year tags: exact (case-insensitive) match
        return person.getTags().stream().anyMatch(tag ->
                keywords.stream().anyMatch(keyword ->
                        tag.tagName.equalsIgnoreCase(keyword)));
    }

    private boolean matchesMajorTags(Person person) {
        Set<String> keywords = filterDetails.getTagMajorKeywords();
        if (keywords == null || keywords.isEmpty()) {
            return false;
        }
        // Major tags: fuzzy/contains match
        return person.getTags().stream().anyMatch(tag ->
                keywords.stream().anyMatch(keyword ->
                        StringUtil.containsIgnoreCase(tag.tagName, keyword)));
    }

    private boolean matchesGenderTags(Person person) {
        Set<String> keywords = filterDetails.getTagGenderKeywords();
        if (keywords == null || keywords.isEmpty()) {
            return false;
        }
        // Gender tags: exact (case-insensitive) match
        return person.getTags().stream().anyMatch(tag ->
                keywords.stream().anyMatch(keyword ->
                        tag.tagName.equalsIgnoreCase(keyword)));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        if (!(other instanceof PersonMatchesDetailsPredicate)) {
            return false;
        }

        PersonMatchesDetailsPredicate otherPredicate = (PersonMatchesDetailsPredicate) other;
        return Objects.equals(this.filterDetails, otherPredicate.filterDetails);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("filterDetails", filterDetails)
                .toString();
    }
}
