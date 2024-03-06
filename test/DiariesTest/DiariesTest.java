package DiariesTest;

import bank.InsufficientBalanceException;
import diary.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DiariesTest{
    private Diaries diaries;
    @BeforeEach
    void createNewObject(){

        diaries = new Diaries();
    }
    @Test
    void testDiaryIsAdded_diaryIsAdded(){
        diaries.add("name", "12345678");
        assertEquals(1,diaries.checkNumberOfDiaries());
    }
    @Test
    void testDiaryCanBeFoundByUserName(){
        diaries.add("abbey","23143");
        assertEquals(1,diaries.checkNumberOfDiaries());
        Diary diaryGotten = diaries.findByUserName("abbey");
        assertEquals("abbey", diaryGotten.checkUserName());
    }
    @Test
    void testDiariesNotFoundThrowsException(){
        assertThrows(DiaryNotFoundException.class,()->diaries.findByUserName("abbey"));
        assertThrows(DiaryNotFoundException.class,()->diaries.findByUserName("ayo"));
    }
    @Test
    void testDeleteDairy_diaryIsDeleted(){
        diaries.add("name", "12345678");
        assertEquals(1,diaries.checkNumberOfDiaries());
        diaries.delete("name","12345678");
        assertEquals(0,diaries.checkNumberOfDiaries());
    }
    @Test
    void testDeleteDairyWithCorrectPassword_diaryIsDeleted(){
        diaries.add("name", "12345678");
        assertEquals(1,diaries.checkNumberOfDiaries());
        assertThrows(IncorrectPasswordException.class,()->diaries.delete("name","1234"));
    }
    @Test
    void testTwoDiaryISCreated_OneIsDeleted_RemainsOneDairy(){
        diaries.add("name", "12345678");
        diaries.add("name1", "12345678");
        assertEquals(2,diaries.checkNumberOfDiaries());
        diaries.delete("name","12345678");
        assertEquals(1,diaries.checkNumberOfDiaries());
    }
    @Test
    void diariesOfSameNameAndPasswordNotExist(){
        diaries.add("name", "12345678");
        assertThrows(InsufficientBalanceException.UserExistException.class,()->diaries.add("name", "12345678"));
    }
    @Test
    void testDiaryIsNotLocked_afterCreating(){
        Diary diary = new Diary("name","password");
        assertFalse(diary.isLocked());

    }
    @Test
    void testDiaryCanBeLockedAndUnlocked(){
        Diary diary = new Diary("name","password");
        assertFalse(diary.isLocked());
        diary.lockDiary();
        assertTrue(diary.isLocked());
        diary.unlockDiary("password");
        assertFalse(diary.isLocked());
    }
    @Test
    void testEntryCanBeCreatedInDiary(){
        Diary diary = new Diary("name","password");
        diary.createEntry("name", "password");
    }
    @Test
    void findEntryById_EntryIsGotten(){
        Diary diary = new Diary("name","password");
        diary.createEntry("name", "body");
        String  titleGotten = diary.findEntryById(1).getTitle();
        assertEquals("name",titleGotten);

    }
    @Test
    void testUpdateEntry_entryIsUpdated() {
        Diary diary = new Diary("name","password");
        diary.createEntry("name", "body");
        diary.updateEntry(1,"name","body");
        assertEquals(1,diary.entrySize());
    }
    @Test
    void findInvalidEntry_throwsException(){
        Diary diary = new Diary("name","password");
        diary.createEntry("name", "body");
        diary.updateEntry(1,"name","body");
        assertEquals(1,diary.entrySize());
        assertThrows(InvalidUserException.class,()->diary.findEntryById(32));
    }
    @Test
    void testThatEntryCantBeUpdated_withoutSameId(){
        Diary diary = new Diary("name","password");
        diary.createEntry("name", "body");
        diary.updateEntry(1,"name","body");
        assertEquals(1,diary.entrySize());
        diary.updateEntry(1,"name","body");
       assertThrows(InvalidUserException.class,()->diary.updateEntry(3,"name","body"));
    }
    @Test
    void createDiary_testDiaryIsLocked(){
        Diary diary = new Diary("name","password");
        diary.createEntry("name", "body");
        diary.lockDiary();
        assertTrue(diary.isLocked());
    }
    @Test
    void deleteEntry_testEntryIsDeleted(){
        Diary diary = new Diary("name","password");
        diary.createEntry("name", "body");
        diary.lockDiary();
        assertTrue(diary.isLocked());
        diary.deleteEntry(1);
        assertEquals(0,diary.entrySize());
    }
    @Test
    void deleteEntryThatDoesNotExist_throwException(){
        Diary diary = new Diary("name","password");
        assertThrows(InvalidUserException.class,()->diary.deleteEntry(2));
    }
    @Test
    void testThatAddedEntryCanBeDeletedAfterAddedAndAddedBack(){
        Diary diary = new Diary("name","password");
        diary.createEntry("name", "body");
        diary.lockDiary();
        assertTrue(diary.isLocked());
        diary.deleteEntry(1);
        assertThrows(InvalidUserException.class,()->diary.deleteEntry(2));
        assertEquals(0,diary.entrySize());
        diary.createEntry("name", "body");
        assertEquals(1,diary.entrySize());
    }
}
