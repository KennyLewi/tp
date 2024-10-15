package seedu.address.model;

import java.nio.file.Path;
import java.util.function.Predicate;

import javafx.collections.ObservableList;
import seedu.address.commons.core.GuiSettings;
import seedu.address.model.meetup.MeetUp;
import seedu.address.model.person.Person;

/**
 * The API of the Model component.
 */
public interface Model {
    /** {@code Predicate} that always evaluate to true */
    Predicate<Person> PREDICATE_SHOW_ALL_PERSONS = unused -> true;
    Predicate<MeetUp> PREDICATE_SHOW_ALL_MEETUPS = unused -> true;

    /**
     * Replaces user prefs data with the data in {@code userPrefs}.
     */
    void setUserPrefs(ReadOnlyUserPrefs userPrefs);

    /**
     * Returns the user prefs.
     */
    ReadOnlyUserPrefs getUserPrefs();

    /**
     * Returns the user prefs' GUI settings.
     */
    GuiSettings getGuiSettings();

    /**
     * Sets the user prefs' GUI settings.
     */
    void setGuiSettings(GuiSettings guiSettings);

    /**
     * Returns the user prefs' address book file path.
     */
    Path getAddressBookFilePath();

    /**
     * Sets the user prefs' address book file path.
     */
    void setAddressBookFilePath(Path addressBookFilePath);

    /**
     * Replaces address book data with the data in {@code addressBook}.
     */
    void setAddressBook(ReadOnlyAddressBook addressBook);

    /** Returns the AddressBook */
    ReadOnlyAddressBook getAddressBook();

    /**
     * Returns true if a person with the same identity as {@code person} exists in the address book.
     */
    boolean hasPerson(Person person);

    /**
     * Deletes the given person.
     * The person must exist in the address book.
     */
    void deletePerson(Person target);

    /**
     * Adds the given person.
     * {@code person} must not already exist in the address book.
     */
    void addPerson(Person person);

    /**
     * Replaces the given person {@code target} with {@code editedPerson}.
     * {@code target} must exist in the address book.
     * The person identity of {@code editedPerson} must not be the same as another existing person in the address book.
     */
    void setPerson(Person target, Person editedPerson);

    /** Returns an unmodifiable view of the filtered person list */
    ObservableList<Person> getFilteredPersonList();

    /**
     * Updates the filter of the filtered person list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredPersonList(Predicate<Person> predicate);

    // ============================ MeetUp Model - To be refactored ==========================

    /**
     * Returns the user prefs' meet up list file path.
     */
    Path getMeetUpListFilePath();

    /**
     * Sets the user prefs' meet up list file path.
     */
    void setMeetUpListFilePath(Path meetUpListFilePath);

    /**
     * Replaces meet up list data with the data in {@code meetUpList}.
     */
    void setMeetUpList(ReadOnlyMeetUpList meetUpList);

    /** Returns the MeetUpList */
    ReadOnlyMeetUpList getMeetUpList();

    /** Returns an unmodifiable view of the filtered meetup list */
    ObservableList<MeetUp> getFilteredMeetUpList();

    /**
     * Adds the given MeetUp.
     * {@code MeetUp} must not already exist in the address book.
     */
    void addMeetUp(MeetUp meetUp);

    /**
     * Updates the given schedule's meetup in the schedule list.
     * The schedule must exist in the schedule list.
     */
    void setMeetUp(MeetUp target, MeetUp editedMeetUp);

    /**
     * Deletes the given schedule in the schedule list
     */
    void deleteMeetUp(MeetUp target);

    /*
     * Updates the filter of the meetup list to filter by the given {@code predicate}.
     * @throws NullPointerException if {@code predicate} is null.
     */
    void updateFilteredMeetUpList(Predicate<MeetUp> predicate);

    /**
     * Returns true if a MeetUp with the same identity as {@code MeetUp} exists in the MeetUp list.
     */
    boolean hasMeetUp(MeetUp meetUp);
}
