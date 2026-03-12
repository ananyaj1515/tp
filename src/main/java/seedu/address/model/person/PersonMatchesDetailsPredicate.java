package seedu.address.model.person;

import java.util.Locale;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;

import seedu.address.commons.util.StringUtil;
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
        return matchesName(person)
                || matchesSimpleField(person.getEmail().value, filterDetails.getEmailKeywords())
                || matchesSimpleField(person.getPhone().value, filterDetails.getPhoneNumberKeywords())
                || matchesSimpleField(person.getRoomNumber().value, filterDetails.getRoomNumberKeywords())
                || matchesSimpleField(person.getStudentId().value, filterDetails.getStudentIdKeywords())
                || matchesSimpleField(person.getEmergencyContact().value,
                        filterDetails.getEmergencyContactKeywords())
                || matchesFuzzyTags(person, filterDetails.getTagKeywords())
                || matchesExactTags(person, filterDetails.getTagYearKeywords())
                || matchesFuzzyTags(person, filterDetails.getTagMajorKeywords())
                || matchesExactTags(person, filterDetails.getTagGenderKeywords());
    }

    // === Name matching (special: uses containsWordIgnoreCase on split words) ===
    private boolean matchesName(Person person) {
        Set<String> nameKeywords = filterDetails.getNameKeywords();
        assert nameKeywords != null : "nameKeywords should be non-null";
        if (nameKeywords.isEmpty()) {
            return false;
        }
        String fullName = person.getName().fullName;
        return nameKeywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(fullName, keyword));
    }

    // === Shared pipeline for simple string fields (email, phone, room, studentId, emergencyContact) ===
    private boolean matchesSimpleField(String fieldValue, Set<String> keywords) {
        assert keywords != null : "keywords set should be non-null";
        if (keywords.isEmpty()) {
            return false;
        }
        String lowerField = fieldValue.toLowerCase(Locale.ROOT);
        return keywords.stream()
                .map(k -> k.toLowerCase(Locale.ROOT))
                .anyMatch(lowerField::contains);
    }

    // === Tag helpers without BiPredicate ===
    private boolean matchesFuzzyTags(Person person, Set<String> keywords) {
        assert keywords != null : "tag keyword set should be non-null";
        if (keywords.isEmpty()) {
            return false;
        }
        return person.getTags().stream().anyMatch(tag -> {
            String lowerTag = tag.tagName.toLowerCase(Locale.ROOT);
            return keywords.stream()
                    .map(k -> k.toLowerCase(Locale.ROOT))
                    .anyMatch(lowerTag::contains);
        });
    }

    private boolean matchesExactTags(Person person, Set<String> keywords) {
        assert keywords != null : "tag keyword set should be non-null";
        if (keywords.isEmpty()) {
            return false;
        }
        return person.getTags().stream().anyMatch(tag ->
                keywords.stream().anyMatch(keyword -> tag.tagName.equalsIgnoreCase(keyword)));
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
