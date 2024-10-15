package seedu.address.testutil;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import seedu.address.model.meetup.*;
import seedu.address.model.person.Address;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.PersonType;
import seedu.address.model.person.Phone;
import seedu.address.model.tag.Tag;
import seedu.address.model.util.SampleDataUtil;

/**
 * A utility class to help with building Person objects.
 */
public class MeetUpBuilder {

    public static final String DEFAULT_NAME = "Meeting with Eswen";
    public static final String DEFAULT_INFO = "To discuss the October project";
    public static final String DEFAULT_FROM = "2020-07-05 15:10";
    public static final String DEFAULT_TO = "2020-07-05 17:30";

    private MeetUpName name;
    private MeetUpInfo info;
    private MeetUpFrom from;
    private MeetUpTo to;

    /**
     * Creates a {@code MeetUpBuilder} with the default details.
     */
    public MeetUpBuilder() {
        name = new MeetUpName(DEFAULT_NAME);
        info = new MeetUpInfo(DEFAULT_INFO);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        from = new MeetUpFrom(LocalDateTime.parse(DEFAULT_FROM, formatter));
        to = new MeetUpTo(LocalDateTime.parse(DEFAULT_TO, formatter));
    }

    /**
     * Initializes the PersonBuilder with the data of {@code personToCopy}.
     */
    public MeetUpBuilder(MeetUp meetUpToCopy) {
        name = meetUpToCopy.getName();
        info = meetUpToCopy.getInfo();
        from = meetUpToCopy.getFrom();
        to = meetUpToCopy.getTo();
    }

    /**
     * Sets the {@code MeetUpName} of the {@code MeetUp} that we are building.
     */
    public MeetUpBuilder withName(String name) {
        this.name = new MeetUpName(name);
        return this;
    }

    /**
     * Sets the {@code MeetUpInfo} of the {@code MeetUp} that we are building.
     */
    public MeetUpBuilder withInfo(String info) {
        this.info = new MeetUpInfo(info);
        return this;
    }

    /**
     * Sets the {@code MeetUpFrom} of the {@code MeetUp} that we are building.
     */
    public MeetUpBuilder withFrom(String from) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.from = new MeetUpFrom(LocalDateTime.parse(DEFAULT_FROM, formatter));
        return this;
    }

    /**
     * Sets the {@code MeetUpTo} of the {@code MeetUp} that we are building.
     */
    public MeetUpBuilder withTo(String to) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        this.from = new MeetUpFrom(LocalDateTime.parse(DEFAULT_FROM, formatter));
        return this;
    }

    public MeetUp build() {
        return new MeetUp(name, info, from, to);
    }

}
